package com.anguo.util.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.util.AnguoTreeUtils;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.TreeNode;
import com.anguo.web.service.CommonSysAuthorityService;


@ContextConfiguration(locations = {"file:src/main/resources/project-*.xml" })
public class TreeUtilsTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	CommonSysAuthorityService commonSysAuthorityService;
	
	@Test
	public void test1()
	{
		
		
		
		TreeNode root=new TreeNode();
		root.setId(1);
		root.setParentId(0);
		
		List<CommonSysAuthority> list =this.commonSysAuthorityService.getAllData(null);
		
		
		List<TreeNode> list3=AnguoTreeUtils.buildTree(AnguoTreeUtils.coverTreeNode(list));
		//TreeNode result=AnguoTreeUtil.findChildNode(root,list2);
		
		System.out.println(list3);
		
	}

}
