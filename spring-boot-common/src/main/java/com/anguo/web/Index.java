package com.anguo.web;

import com.anguo.db.mapper.UserMapper;
import com.anguo.db.domain.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wenanguo on 2017/6/8.
 */
@RestController
public class Index {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<?> list() {


        PageHelper.startPage(2,2);//无法与 注解生成动态sql同步使用

        List<User> list=this.userMapper.selectByPrimaryKey();


        return list;
    }
    
    
    /**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/index")
	public ModelAndView index2(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		ModelAndView mav=new ModelAndView("index");
		
		
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("vfile", "zj");
		
		
		
		mav.addObject("share", share);
		
		
       return mav;
				
	}


    @RequestMapping("/insert")
    public String insert() {




        User user=new User();
        user.setPassword("111");
        user.setName("insertUserXml:"+System.currentTimeMillis());

        int i=this.userMapper.insertUserXml(user);


        return String.valueOf(i);
    }

}
