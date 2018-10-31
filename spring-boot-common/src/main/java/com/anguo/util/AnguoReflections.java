package com.anguo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import com.anguo.mybatis.db.core.CodeComments;

/**
 * <p>
 * 参考 Springside中的反射工具.
 * </p>
 *
 * @author AndrewWen
 *
 */
public class AnguoReflections {

    /*
    * An instance of Log to use for logging in this class.
    */
    private static final Log log = LogFactory.getLog(AnguoReflections.class);

    public static final String CGLIB_CLASS_SEPARATOR = "$$";

    private AnguoReflections() {
    }

    /**
     * 调用Getter方法.
     */
    public static Object invokeGetter(Object obj, String propertyName) {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[]{}, new Object[]{});
    }

    /**
     * 调用Setter方法.使用value的Class来查找Setter方法.
     */
    public static void invokeSetter(Object obj, String propertyName, Object value) {
        invokeSetter(obj, propertyName, value, null);
    }

    /**
     * 调用Setter方法.
     *
     * @param propertyType 用于查找Setter方法,为空时使用value的Class替代.
     */
    public static void invokeSetter(Object obj, String propertyName, Object value, Class<?> propertyType) {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(obj, setterMethodName, new Class[]{type}, new Object[]{value});
    }

    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     */
    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            log.error("不可能抛出的异常!", e);
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            log.error("不可能抛出的异常!", e);
        }
    }

    /**
     * 对于被cglib AOP过的对象, 取得真实的Class类型.
     */
    public static Class<?> getUserClass(Class<?> clazz) {
        if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null && !Object.class.equals(superClass)) {
                return superClass;
            }
        }
        return clazz;
    }


    /**
     * 检查是否含有分页或本来就是分页类
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object isPage(Object obj, String fieldName) {

        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map)obj;
            return map.get(fieldName);

        } else {
            for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                try {
                    return superClass.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                }
            }
            return null;
        }

    }


    /**
     * 直接调用对象方法, 无视private/protected修饰符.
     * 用于一次性调用的情况.
     */
    public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
                                      final Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField,	 并强制设置为可访问.
     * <p/>
     * 如向上转型到Object仍无法找到, 返回null.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(fieldName, "fieldName can't be blank");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {//NOSONAR
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
     * 如向上转型到Object仍无法找到, 返回null.
     * <p/>
     * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName,
                                             final Class<?>... parameterTypes) {
        Validate.notNull(obj, "object can't be null");

        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Method method = superClass.getDeclaredMethod(methodName, parameterTypes);

                method.setAccessible(true);

                return method;

            } catch (NoSuchMethodException e) {//NOSONAR
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     * eg.
     * public UserDao extends HibernateDao<User>
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or Object.class if cannot be determined
     */
    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     * <p/>
     * 如public UserDao extends HibernateDao<User,Long>
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be determined
     */
    public static Class getSuperClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType.getClass().isAssignableFrom(ParameterizedType.class))) {
            log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index].getClass().isAssignableFrom(Class.class))) {
            log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }


    /**
     * 执行反射执行
     *
     * @param className 类型
     * @return 类的实例
     */
    public static Object instance(String className) {
        try {
            Class dialectCls = Class.forName(className);
            return dialectCls.newInstance();
        } catch (ClassNotFoundException e) {
            log.error("无法找到方言类", e);
            return null;
        } catch (InstantiationException e) {
            log.error("实例化方言错误", e);
            return null;
        } catch (IllegalAccessException e) {
            log.error("实例化方言错误", e);
            return null;
        }
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException(e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException(((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }
    
    
    
    /**
	 * 根据class获取类注释
	 * @param clazz
	 * @return  有注解返回注解，没有注解返回空字符串
	 */
	public static String getClassAnnotation(Class clazz)
	{
		String name="";
		
		 try {
			 
			 
			 if(clazz==null)return name;
			
			Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
			
			CodeComments CodeComments = (CodeComments) clazz.getAnnotation(CodeComments.class);
			if(CodeComments!=null)name= CodeComments.value();
			        
		} catch (Exception e) {
			System.out.println("=======================");
			System.out.println(clazz);
			System.out.println("=======================");
			e.printStackTrace();
		}
		 
		 return name;
		  
		 
	 }  
	
	
	/**
	 * 获取方法模块注解
	 * @param clazz 类
	 * @param methodName 方法名
	 * @return 有注解返回注解，没有注解返回空字符串
	 */
	public static String getMethodAnnotation(Class clazz,String methodName)
	{
		String name = "";  
		
		
		
		 try {
			 
			
			 if(clazz==null)return name;
			
			Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
			
			//遍历获得类方法注解
		    for(Method method : clazz.getDeclaredMethods()){  
		    	CodeComments CodeComments = method.getAnnotation(CodeComments.class);  
		        
		        if(CodeComments != null&&method.getName().equals(methodName)){  
		           name = CodeComments.value();  
		         
		        }  

		      }
		    
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		  
	
		  
	
		return name;
	}
	
	
	
	
	/**
	 * 利用反射实现对象之间属性复制
	 * @param from
	 * @param to
	 */
	public static void copyProperties(Object from, Object to) {
		
		
			  for (Class<?> superClass = from.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
		           
		        	
	        	  Field[] list = superClass.getDeclaredFields();
	        	  
	        	  for(Field temp:list)
	        	  {
	        		  try{
	        			  Object value=invokeGetter(from,temp.getName());
		        		  if(value!=null)
		        		  {
		        			 
		        			  
			        		  invokeSetter(to,temp.getName(),value);
		        			 
		        		  }
	        		  }catch(Exception e)
      				  {
      					log.warn(e.getMessage());
      				  }
	        	  }
	        }
		
	}
	
//	/**
//	 * 复制对象属性
//	 * @param from
//	 * @param to
//	 * @param excludsArray 排除属性列表
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public static void copyPropertiesExclude(Object from, Object to, String[] excludsArray) throws Exception {
//		List<String> excludesList = null;
//		if(excludsArray != null && excludsArray.length > 0) {
//			excludesList = Arrays.asList(excludsArray);	//构造列表对象
//		}
//		Method[] fromMethods = from.getClass().getDeclaredMethods();
//		Method[] toMethods = to.getClass().getDeclaredMethods();
//		Method fromMethod = null, toMethod = null;
//		String fromMethodName = null, toMethodName = null;
//		for (int i = 0; i < fromMethods.length; i++) {
//			fromMethod = fromMethods[i];
//			fromMethodName = fromMethod.getName();
//			if (!fromMethodName.contains("get"))
//				continue;
//			//排除列表检测
//			if(excludesList != null && excludesList.contains(fromMethodName.substring(3).toLowerCase())) {
//				continue;
//			}
//			toMethodName = "set" + fromMethodName.substring(3);
//			toMethod = findMethodByName(toMethods, toMethodName);
//			if (toMethod == null)
//				continue;
//			Object value = fromMethod.invoke(from, new Object[0]);
//			if(value == null)
//				continue;
//			//集合类判空处理
//			if(value instanceof Collection) {
//				Collection newValue = (Collection)value;
//				if(newValue.size() <= 0)
//					continue;
//			}
//			toMethod.invoke(to, new Object[] {value});
//		}
//	}
//	
//	/**
//	 * 对象属性值复制，仅复制指定名称的属性值
//	 * @param from
//	 * @param to
//	 * @param includsArray
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public static void copyPropertiesInclude(Object from, Object to, String[] includsArray) throws Exception {
//		List<String> includesList = null;
//		if(includsArray != null && includsArray.length > 0) {
//			includesList = Arrays.asList(includsArray);	//构造列表对象
//		} else {
//			return;
//		}
//		Method[] fromMethods = from.getClass().getDeclaredMethods();
//		Method[] toMethods = to.getClass().getDeclaredMethods();
//		Method fromMethod = null, toMethod = null;
//		String fromMethodName = null, toMethodName = null;
//		for (int i = 0; i < fromMethods.length; i++) {
//			fromMethod = fromMethods[i];
//			fromMethodName = fromMethod.getName();
//			if (!fromMethodName.contains("get"))
//				continue;
//			//排除列表检测
//			String str = fromMethodName.substring(3);
//			if(!includesList.contains(str.substring(0,1).toLowerCase() + str.substring(1))) {
//				continue;
//			}
//			toMethodName = "set" + fromMethodName.substring(3);
//			toMethod = findMethodByName(toMethods, toMethodName);
//			if (toMethod == null)
//				continue;
//			Object value = fromMethod.invoke(from, new Object[0]);
//			if(value == null)
//				continue;
//			//集合类判空处理
//			if(value instanceof Collection) {
//				Collection newValue = (Collection)value;
//				if(newValue.size() <= 0)
//					continue;
//			}
//			toMethod.invoke(to, new Object[] {value});
//		}
//	}
//	
//	
//
//	/**
//	 * 从方法数组中获取指定名称的方法
//	 * 
//	 * @param methods
//	 * @param name
//	 * @return
//	 */
//	public static Method findMethodByName(Method[] methods, String name) {
//		for (int j = 0; j < methods.length; j++) {
//			if (methods[j].getName().equals(name))
//				return methods[j];
//		}
//		return null;
//	}
	
}
