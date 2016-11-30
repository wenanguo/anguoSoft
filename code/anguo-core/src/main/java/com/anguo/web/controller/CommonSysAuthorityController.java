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
import com.anguo.web.db.domain.CommonRoleAuthority;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.service.CommonRoleAuthorityService;
import com.anguo.web.service.CommonSysAuthorityService;
import com.anguo.web.service.CommonUserRoleService;

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
	
	@Autowired
	private CommonRoleAuthorityService commonRoleAuthorityService;
	
	
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
	public Object loadroleTree(CommonSysRole role) {
		
		
		
		List<CommonSysAuthority> list =this.commonSysAuthorityService.getAuthorityByRoleId(role);
		
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(coverTreeNode(list));
		
		return list3;
	}
	
	/**
	 * 修改权限
	 * @param role 修改角色
	 * @param authorityStr 权限列表，用逗号分隔
	 * @return
	 */
	@RequestMapping("/commonSysAuthority/update.htm")
	@ResponseBody
	public Object update(CommonSysRole role,String authorityStr) {
		
		Map messages = new HashMap();
		try {
			//删除原有权限
			int i =this.commonRoleAuthorityService.deleteDataByRole(role);
			
			//插入权限
			String[] authArray=authorityStr.split(",");
			
			for(int z=0;z<authArray.length;z++){
				CommonRoleAuthority temp=new CommonRoleAuthority();
				temp.setCommonSysRoleId(role.getId());
				temp.setCommonSysAuthorityId(Integer.valueOf(authArray[z]));
				this.commonRoleAuthorityService.insertData(temp);
			}
			
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "添加成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "添加失败!");
			e.printStackTrace();
		}
		
		return messages;
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
