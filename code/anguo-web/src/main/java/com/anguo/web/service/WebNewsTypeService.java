package com.anguo.web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.WebNewsType;
import com.anguo.web.db.mapper.WebNewsTypeMapper;

@Service
public class WebNewsTypeService extends BaseService<WebNewsType> {
	@Autowired
	private WebNewsTypeMapper mapper;
	
	public WebNewsTypeMapper getMapper() {
		return mapper;
	}
	
	public List<WebNewsType> getIndexMenu()
	{
		//查询子节点数据
		WebNewsType cam=new WebNewsType();
		cam.setParentId(1);
				
		List<WebNewsType> tempList=this.getMapper().getAllData(cam);
		
		return tempList;
	}
	
	
	
	/**
	 *  根据父节点获取所有子节点
	 * @return
	 */
	/**
	 * 根据父节点编号递归获取所有子节点模块
	 * @param parentId
	 * @return
	 */
	public List<WebNewsType> getListByParentId(List<WebNewsType> list,int parentId)
	{
		//System.out.println("======="+parentId+"=========="+list);
		//加入当前节点数据
		WebNewsType subWebNewsType=new WebNewsType();
		subWebNewsType.setId(parentId);
		subWebNewsType=this.getMapper().getData(subWebNewsType);
		
		list.add(subWebNewsType);
		
		
		
		//查询子节点数据
		WebNewsType cam=new WebNewsType();
		cam.setParentId(parentId);
		
		List<WebNewsType> tempList=this.getMapper().getAllData(cam);
		
		if((tempList==null)||(tempList.size()<1))
		{
			
			return list;
			
			
		}else
		{
			for(WebNewsType temp:tempList)
			{
				getListByParentId(list,temp.getId());
			}
			
			return list;
		}
		
	}
//	public List<WebNewsType> getListDataByParentId(int parentId)
//	{
//		WebNewsType webNewsType=new WebNewsType();
//		webNewsType.setParentId(parentId);
//		
//		List<WebNewsType> list=this.getMapper().getAllData(webNewsType);
//		
//		if((list==null)||list.size()<1)
//		{
//			//如果没有找到下一级节点，加入当前节点数据
//			WebNewsType subWebNewsType=new WebNewsType();
//			subWebNewsType.setId(parentId);
//			subWebNewsType=this.getMapper().getData(subWebNewsType);
//			
//			List<WebNewsType> subWebNewsTypeList=new ArrayList<WebNewsType>();
//			subWebNewsTypeList.add(subWebNewsType);
//			
//			return subWebNewsTypeList;
//		}else
//		{
//			List<WebNewsType> webNewsTypeList=new ArrayList<WebNewsType>();
//			//递归加入子节点数据
//			for(WebNewsType temp : list)
//			{
//				List<WebNewsType> sublist=getListDataByParentId(temp.getId());
//				if(sublist!=null)webNewsTypeList.addAll(sublist);
//				
//			}
//			
//			return webNewsTypeList;
//		}
//		
//	}
}
