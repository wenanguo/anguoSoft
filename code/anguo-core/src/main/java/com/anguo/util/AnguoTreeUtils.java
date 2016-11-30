package com.anguo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.TreeNode;

/**
 * 树工具类
 * @author Andrew.Wen
 *
 */
public class AnguoTreeUtils {
	
	
	private String url="url";
	private String title="title";
	
	
	
	public static List<TreeNode> buildTree(List<TreeNode> list) 
	{
		/**
		 * 存储所有根节点
		 */
		List<TreeNode> rootList =new ArrayList<TreeNode>();
		
		/**
		 * 存储结果节点
		 */
		List<TreeNode> resultList =new ArrayList<TreeNode>();
		
		//找出所有父节点
		for(TreeNode rootNote : list)
		{
			boolean flag=false;
			for(TreeNode temp : list)
			{
				if(rootNote.getParentId()==temp.getId())
				{
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				rootList.add(rootNote);
			}
		}
		
		for(TreeNode rootNote : rootList)
		{
			
			resultList.add(AnguoTreeUtils.findChildNode(rootNote,list));
		}
//		List<Map> listMap=new ArrayList<Map>();
//		
//		for(Object temp : list)
//		{
//			Method  method =ReflectionUtils.findMethod(temp.getClass(), AnguoStringUtils.getGetMethodName(url));
//			
//			Object obj =ReflectionUtils.invokeMethod(method, temp);
//			
//			System.out.println(obj);
//		}
		
		return resultList;
	}
	
	/**
	 * 根据当前节点查找子节点
	 * @param node
	 * @return
	 */
	public static TreeNode findChildNode(TreeNode node,List<TreeNode> list)
	{
		
		List<TreeNode> templist=new ArrayList<TreeNode>();
		//遍历队列查找当前节点子节点
		for(TreeNode obj:list)
		{
			
			if(obj.getParentId()==node.getId())
			{
				templist.add(findChildNode(obj,list));
				
			}
		}
		
		if(templist.size()>0)node.setChildren(templist);
		
		return node;
				
	}
	
	
	
	
	 

}
