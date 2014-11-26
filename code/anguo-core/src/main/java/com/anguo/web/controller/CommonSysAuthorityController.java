package com.anguo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.util.AnguoTreeUtils;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.service.CommonSysAuthorityService;

/**
 * 制器类
 * @ClassName: CommonSysAuthority
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysAuthorityController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysAuthorityController.class);
	
	@Autowired
	private CommonSysAuthorityService commonSysAuthorityService;

	
	
	
	@RequestMapping("/commonSysAuthority/tree.htm")
	@ResponseBody
	public Object loadTree(CommonSysAuthority commonSysAuthority) {
		
		
		CommonSysUser currUser=this.getSecuritySessionUser();
		
		List<CommonSysAuthority> list =this.commonSysAuthorityService.getAuthorityByUserId(currUser);
		
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(coverTreeNode(list));
		
		return list3;
	}
	
	
	@RequestMapping("/commonSysAuthority/roleTree.htm")
	@ResponseBody
	public Object loadroleTree(CommonSysAuthority commonSysAuthority) {
		
		
		CommonSysUser currUser=this.getSecuritySessionUser();
		
		List<CommonSysAuthority> list =this.commonSysAuthorityService.getAuthorityByRoleId(currUser);
		
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(coverTreeNode(list));
		
		return list3;
	}
	
	public static List<TreeNode> coverTreeNode(List<CommonSysAuthority> list)
	{
		List<TreeNode> treeNodeList=new ArrayList<TreeNode>();
		
		for(CommonSysAuthority obj:list)
		{
			//类型为2，即为菜单类型
			if(obj.getType()==2)
			{
				TreeNode temp= new TreeNode();
				temp.setId(obj.getId());
				temp.setText(obj.getName());
				temp.setIconCls(obj.getIcon());
				temp.setUrl(obj.getUrl());
				temp.setParentId(obj.getParentId());
				temp.setTitle(obj.getName());
				temp.setChecked(obj.getChecked());
				
				Map attributes=new HashMap();
				attributes.put("url", obj.getUrl());
				attributes.put("title", obj.getName());
				
				temp.setAttributes(attributes);
				treeNodeList.add(temp);
			}
			
			
			
		}
		
		return treeNodeList;
	}
}
