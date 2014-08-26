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
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.db.domain.WebNewsType;
import com.anguo.web.service.WebNewsTypeService;

/**
 * 制器类
 * @ClassName: CommonSysAuthority
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class WebNewsTypeController extends BaseController {
	
	private final static Logger log = Logger.getLogger(WebNewsTypeController.class);
	
	@Autowired
	private WebNewsTypeService webNewsTypeService;

	
	
	
	@RequestMapping("/webNewsType/tree.htm")
	@ResponseBody
	public Object loadTree(CommonSysAuthority commonSysAuthority) {
		
		List<WebNewsType> list =this.webNewsTypeService.getAllData(null);
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(coverTreeNode(list));
		
		return list3;
	}
	
	
	
	
	/**
	 * 将新闻节点转换为树节点
	 * @param list
	 * @return
	 */
	private List<TreeNode> coverTreeNode(List<WebNewsType> list)
	{
		List<TreeNode> treeNodeList=new ArrayList<TreeNode>();
		
		for(WebNewsType obj:list)
		{
			TreeNode temp= new TreeNode();
			temp.setId(obj.getId());
			temp.setText(obj.getTitle());
			//temp.setIconCls(obj.getIcon());
			//temp.setUrl(obj.getUrl());
			temp.setParentId(obj.getParentId());
			temp.setTitle(obj.getTitle());
			
			Map attributes=new HashMap();
			//attributes.put("url", obj.getUrl());
			attributes.put("title", obj.getTitle());
			
			temp.setAttributes(attributes);
			
			treeNodeList.add(temp);
		}
		
		return treeNodeList;
	}
}
