package com.anguo.web.controller;

import java.util.List;
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
		
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(AnguoTreeUtils.coverTreeNode(list));
		
		return list3;
	}
}
