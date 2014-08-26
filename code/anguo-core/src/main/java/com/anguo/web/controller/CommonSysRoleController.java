package com.anguo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.util.AnguoTreeUtils;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.service.CommonSysRoleService;

/**
 * 制器类
 * @ClassName: CommonSysRole
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysRoleController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysRoleController.class);
	@Autowired
	private CommonSysRoleService commonSysRoleService;

	@RequestMapping("/commonSysRole/list.htm")
	@ResponseBody
	public Object queryCommonSysRoleList(CommonSysRole commonSysRole) {
		try {
			return commonSysRoleService.getPageData(commonSysRole);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping("/commonSysRole/roleTree.htm")
	@ResponseBody
	public Object loadTree(CommonSysUser commonSysUser) {
		
		List<CommonSysRole> list =this.commonSysRoleService.getRoleTreeByUser(commonSysUser);
		
		List<TreeNode> treeList=AnguoTreeUtils.buildTree(coverTreeNode(list));
		
		return treeList;
	}
	
	
	public List<TreeNode> coverTreeNode(List<CommonSysRole> list)
	{
		List<TreeNode> treeNodeList=new ArrayList<TreeNode>();
		
		for(CommonSysRole obj:list)
		{
				TreeNode temp= new TreeNode();
				temp.setId(obj.getId());
				temp.setText(obj.getName());
				temp.setIconCls("");
				temp.setUrl("");
				temp.setParentId(0);
				temp.setTitle(obj.getName());
				temp.setChecked(obj.getChecked());
				
				treeNodeList.add(temp);
		}
		
		return treeNodeList;
	}
	

	@RequestMapping("/commonSysRole/listAll.htm")
	@ResponseBody
	public List<CommonSysRole> queryCommonSysRoleAllList(CommonSysRole commonSysRole) {
		try {
			return commonSysRoleService.getAllData(commonSysRole);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysRole/create.htm")
	@ResponseBody
	public Map saveCommonSysRole(HttpServletRequest request,
			HttpServletResponse response, CommonSysRole commonSysRole) {
		Map messages = new HashMap();
		try {
			int i = commonSysRoleService.insertData(commonSysRole);
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

	@RequestMapping("/commonSysRole/update.htm")
	@ResponseBody
	public Map updateCommonSysRole(HttpServletRequest request,
			HttpServletResponse response,CommonSysRole commonSysRole) {
		Map messages = new HashMap();
		try {
			int i = commonSysRoleService.updateData(commonSysRole);
			
			
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "修改成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "修改失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "修改失败!");
			e.printStackTrace();
		}
		
		return messages;
		
	}

	@RequestMapping("/commonSysRole/delete.htm")
	@ResponseBody
	public Map deleteCommonSysRole(HttpServletRequest request,CommonSysRole commonSysRole) {
		Map messages = new HashMap();
		try {
		
			
			int i =this.commonSysRoleService.deleteData(commonSysRole);
			
			
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "删除成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "删除失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "删除失败!");
			e.printStackTrace();
		}
		return messages;
	}
	
	@RequestMapping("/commonSysRole/load.json")
	@ResponseBody
	public Object loadCommonSysRole(CommonSysRole commonSysRole) {
		
		return commonSysRoleService.getData(commonSysRole);
	}
}
