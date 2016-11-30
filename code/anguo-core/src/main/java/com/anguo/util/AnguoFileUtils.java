package com.anguo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * 
 * 文件操作工具类
 * 
 * @author   AndrewWen
 * @version  1.0
 * @since    v1.0
 * @Date	 2013-3-29 下午6:01:38 
 */
public class AnguoFileUtils {
	
	/**
	 * 获得文件扩展名
	 * 
	 * @param filename 文件名
	 *           
	 * @return 文件扩展类型
	 */
	public static String getFileExt(String filename) {

		String extFileName = filename.substring(filename.lastIndexOf(".") + 1);

		return extFileName;

	}

	/**
	 * 获得随机文件名
	 * 
	 * @Title: getRandomFileName
	 * @return
	 */
	public static String getRandomFileName() {
		String fileName = "";
		java.util.Date dt = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		fileName = fmt.format(dt);

		return fileName;
	}
	
	
	/**
	   * 写文件到本地
	   * @param in
	   * @param fileName
	   * @throws IOException
	   */
	  public static void SaveFileFromInputStream(InputStream in,String fileName,String path) {
		  try {
		  FileOutputStream fs = new FileOutputStream(path+ fileName);
			byte[] buffer = new byte[1024 * 1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = in.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
			in.close();
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
	 
	  
	    /** 
	     * 复制单个文件 
	     * @param oldPath String 原文件路径 如：c:/fqf.txt 
	     * @param newPath String 复制后路径 如：f:/fqf.txt 
	     * @return boolean 
	     */ 
	   public static void copyFile(String oldPath, String newPath) { 
	       try { 
	           int bytesum = 0; 
	           int byteread = 0; 
	           File oldfile = new File(oldPath); 
	           if (oldfile.exists()) { //文件存在时 
	               InputStream inStream = new FileInputStream(oldPath); //读入原文件 
	               FileOutputStream fs = new FileOutputStream(newPath); 
	               byte[] buffer = new byte[1444]; 
	               int length; 
	               while ( (byteread = inStream.read(buffer)) != -1) { 
	                   bytesum += byteread; //字节数 文件大小 
	                   //System.out.println(bytesum); 
	                   fs.write(buffer, 0, byteread); 
	               } 
	               inStream.close(); 
	           } 
	       } 
	       catch (Exception e) { 
	           System.out.println("复制单个文件操作出错"); 
	           e.printStackTrace(); 

	       } 

	   } 

	   /** 
	     * 复制整个文件夹内容 
	     * @param oldPath String 原文件路径 如：c:/fqf 
	     * @param newPath String 复制后路径 如：f:/fqf/ff 
	     * @return boolean 
	     */ 
	   public static void copyFolder(String oldPath, String newPath) { 

	       try { 
	           (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
	           File a=new File(oldPath); 
	           String[] file=a.list(); 
	           File temp=null; 
	           for (int i = 0; i < file.length; i++) { 
	               if(oldPath.endsWith(File.separator)){ 
	                   temp=new File(oldPath+file[i]); 
	               } 
	               else{ 
	                   temp=new File(oldPath+File.separator+file[i]); 
	               } 

	               if(temp.isFile()){ 
	                   FileInputStream input = new FileInputStream(temp); 
	                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
	                           (temp.getName()).toString()); 
	                   byte[] b = new byte[1024 * 5]; 
	                   int len; 
	                   while ( (len = input.read(b)) != -1) { 
	                       output.write(b, 0, len); 
	                   } 
	                   output.flush(); 
	                   output.close(); 
	                   input.close(); 
	               } 
	               if(temp.isDirectory()){//如果是子文件夹 
	                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
	               } 
	           } 
	       } 
	       catch (Exception e) { 
	           System.out.println("复制整个文件夹内容操作出错"); 
	           e.printStackTrace(); 

	       } 

	   }
	   
	   public static String getText(String htmlStr) {
		   if(htmlStr==null || "".equals(htmlStr)) return "";
		         String textStr ="";    
		         java.util.regex.Pattern pattern;    
		         java.util.regex.Matcher matcher;    
		        
		        try {
		         String regEx_remark = "<!--.+?-->";
		         String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }    
		         String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }    
		             String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式    
		             String regEx_html1 = "<[^>]+";
		             htmlStr = htmlStr.replaceAll("\n","");
		             htmlStr = htmlStr.replaceAll("\t","");
		             pattern=Pattern.compile(regEx_remark);//过滤注释标签
		             matcher=pattern.matcher(htmlStr);
		         htmlStr=matcher.replaceAll("")    ;
		          
		         pattern = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);    
		         matcher = pattern.matcher(htmlStr);    
		             htmlStr = matcher.replaceAll(""); //过滤script标签    




		             pattern = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);    
		             matcher = pattern.matcher(htmlStr);    
		             htmlStr = matcher.replaceAll(""); //过滤style标签    
		           
		             pattern = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);    
		             matcher = pattern.matcher(htmlStr);    
		             htmlStr = matcher.replaceAll(""); //过滤html标签    
		               
		             pattern = Pattern.compile(regEx_html1,Pattern.CASE_INSENSITIVE);    
		             matcher = pattern.matcher(htmlStr);    
		             htmlStr = matcher.replaceAll(""); //过滤html标签    
		             
		           
		          textStr = htmlStr.trim();    
		          
		      }catch(Exception e) {
		      System.out.println("获取HTML中的text出错:");
		      e.printStackTrace();
		       }    
		       
		     return textStr;//返回文本字符串
		   }

}

