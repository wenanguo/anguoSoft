package com.anguo.web.controller;
 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
 
@Api(value="/test", tags="测试接口模块")
@RestController
@RequestMapping("/test")
public class TestSwaggerController {
    @ApiOperation(value="展示首页信息", notes = "展示首页信息")
    @GetMapping("/show")
    public Object showInfo(){
        return "hello world";
    }
 

}
