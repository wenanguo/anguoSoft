package com.anguo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoTreeUtils;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysClass;
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.db.mapper.CommonSysClassMapper;
import com.anguo.web.service.CommonSysClassService;

/**
 * 制器类
 * @ClassName: CommonSysClass
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysClassController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysClassController.class);
	@Autowired
	private CommonSysClassService commonSysClassService;

	@RequestMapping("/commonSysClass/list.htm")
	@ResponseBody
	public PageResult<CommonSysClass> queryCommonSysClassList(CommonSysClass commonSysClass) {
		try {
			return commonSysClassService.getPageData(commonSysClass);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysClass/listAll.htm")
	@ResponseBody
	public List<CommonSysClass> queryCommonSysClassAllList(CommonSysClass commonSysClass) {
		try {
			return commonSysClassService.getAllData(commonSysClass);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/commonSysClass/tree.htm")
	@ResponseBody
	public List<TreeNode> queryCommonSysClassTree(CommonSysClass commonSysClass) {
		try {
			List<CommonSysClass> list= commonSysClassService.getAllData(commonSysClass);
			
			List<TreeNode> treeNodeList=new ArrayList<TreeNode>();
			
			for(CommonSysClass obj:list)
			{
				
					TreeNode temp= new TreeNode();
					temp.setId(obj.getId());
					temp.setText(obj.getName());
					//temp.setIconCls(obj.getIcon());
					//temp.setUrl(obj.getUrl());
					temp.setParentId(obj.getParentId());
					temp.setTitle(obj.getName());
					
					Map attributes=new HashMap();
					//attributes.put("url", obj.getUrl());
					attributes.put("title", obj.getName());
					
					temp.setAttributes(attributes);
					treeNodeList.add(temp);
			}
			
			return AnguoTreeUtils.buildTree(treeNodeList);
			
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysClass/create.htm")
	@ResponseBody
	public Map saveCommonSysClass(HttpServletRequest request,
			HttpServletResponse response, CommonSysClass commonSysClass) {
		Map messages = new HashMap();
		try {
			int i = commonSysClassService.insertData(commonSysClass);
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

	@RequestMapping("/commonSysClass/update.htm")
	@ResponseBody
	public Map updateCommonSysClass(HttpServletRequest request,
			HttpServletResponse response,CommonSysClass commonSysClass) {
		Map messages = new HashMap();
		try {
			int i = commonSysClassService.updateData(commonSysClass);
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

	@RequestMapping("/commonSysClass/delete.htm")
	@ResponseBody
	public Map deleteCommonSysClass(HttpServletRequest request,CommonSysClass commonSysClass) {
		Map messages = new HashMap();
		try {
		
			int i=this.commonSysClassService.deleteData(commonSysClass);
			
			
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
	
	@RequestMapping("/commonSysClass/load.htm")
	@ResponseBody
	public Object loadCommonSysClass(CommonSysClass commonSysClass) {
		
		return commonSysClassService.getData(commonSysClass);
	}
}
