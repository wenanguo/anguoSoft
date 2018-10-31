package com.anguo.web.controller;

import com.anguo.web.db.domain.CommonRoleInfo;
import com.anguo.web.db.domain.User;
import com.anguo.web.db.mapper.CommonRoleInfoMapper;
import com.anguo.web.db.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by wenanguo on 2017/6/8.
 */
@Api(value="/SystemUser", tags="用户管理模块")
@RequestMapping("/systemuser")
@RestController
public class SysUserController {


    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommonRoleInfoMapper commonRoleInfoMapper;

    @ApiOperation(value="展现用户信息", notes = "展现用户信息")
    @ApiImplicitParam(name="user", value="User", dataType = "User")
    @GetMapping("/list")
    public List<?> list() {


        PageHelper.startPage(2,2);//无法与 注解生成动态sql同步使用

        List<User> list=this.userMapper.selectByPrimaryKey();


        return list;
    }



    @ApiOperation(value="展现用户信息", notes = "展现用户信息")
    @ApiImplicitParam(name="user", value="User", dataType = "User")
    @GetMapping("/rolelist")
    public List<?> rolelist(CommonRoleInfo commonRoleInfo) {

        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        List<CommonRoleInfo> list=this.commonRoleInfoMapper.getPageData(commonRoleInfo);


        return list;
    }



    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name="user", value="User", required = true, dataType = "User")
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user){

        user.setPassword("111");
        user.setName("insertUserXml:"+System.currentTimeMillis());

        int i=this.userMapper.insertUserXml(user);

        return "success";
    }


//    /**
//	 * 微信访问初始入口
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping("/index")
//	public ModelAndView index2(HttpServletRequest request,HttpServletResponse response) {
//
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//
//		ModelAndView mav=new ModelAndView("index");
//
//
//
//
//		Map<String, String> share=new HashMap<String, String>();
//		share.put("vfile", "zj");
//
//
//
//		mav.addObject("share", share);
//
//
//       return mav;
//
//	}
//
//
//    @RequestMapping("/insert")
//    public String insert() {
//
//
//
//
//        User user=new User();
//        user.setPassword("111");
//        user.setName("insertUserXml:"+System.currentTimeMillis());
//
//        int i=this.userMapper.insertUserXml(user);
//
//
//        return String.valueOf(i);
//    }

}
