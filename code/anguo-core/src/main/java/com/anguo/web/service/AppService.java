package com.anguo.web.service;

import org.springframework.stereotype.Service;

import com.anguo.web.db.domain.TreeNode;


@Service
public class AppService {
	
	
	public String login(TreeNode name)
	{
		System.out.println("新参数为："+name);
		
		return "hello world";
	}

}
