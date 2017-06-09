package com.anguo.db.web;




import com.anguo.db.mapper.UserMapper;
import com.anguo.db.domain.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wenanguo on 2017/6/8.
 */
@RestController
public class Index {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<?> list() {


        PageHelper.startPage(1,2);//无法与 注解生成动态sql同步使用

        List<User> list=this.userMapper.fingAll();


        return list;
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
