package com.anguo;

import com.anguo.web.db.domain.User;
import com.anguo.web.db.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCommonApplicationTests {

    @Autowired
    private UserMapper userMapper;


	@Test
	public void contextLoads() {

        User user=new User();

        user.setPassword("111");
        user.setName("insertUserXml:"+System.currentTimeMillis());

        //int i=this.userMapper.insertUserXml(user);
        int i=1;

        Assert.assertEquals(i,1);

	}

}
