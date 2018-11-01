package com.anguo.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoStatusUtil;
import com.anguo.web.db.domain.CommonRoleInfo;
import com.anguo.web.service.CommonRoleInfoService;

/**
 * 角色表-控制器类
 * @ClassName: CommonRoleInfo
 * @author Andrew.Wen
 */
@Api(value="/commonRoleInfo", tags="角色表")
@RequestMapping("/commonRoleInfo")
@Controller
public class CommonRoleInfoController extends BaseController {


    private static final Logger logger = LoggerFactory.getLogger(CommonRoleInfoController.class);


    @Autowired
    private CommonRoleInfoService commonRoleInfoService;

    @ApiOperation(value="展现角色表信息", notes = "展现角色表信息")
    @ApiImplicitParam(name="commonRoleInfo", value="CommonRoleInfo", dataType = "CommonRoleInfo")
    @GetMapping("/list.htm")
    @ResponseBody
    public PageResult<List<CommonRoleInfo>> queryCommonRoleInfoList( CommonRoleInfo commonRoleInfo) {

        PageResult<List<CommonRoleInfo>> result=new PageResult<List<CommonRoleInfo>>();

        try {

            result= commonRoleInfoService.getPageData(commonRoleInfo);

        } catch (Exception e) {

            logger.error("发生错误，因为：" + e.getMessage());
            e.printStackTrace();
            result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
            result.setMsg(result.getMsg()+":"+e.getMessage());

        }
        return result;
    }

    @GetMapping("/listAll.htm")
    @ResponseBody
    public List<CommonRoleInfo> queryCommonRoleInfoAllList(CommonRoleInfo commonRoleInfo) {
        try {
            return commonRoleInfoService.getAllData(commonRoleInfo);
        } catch (Exception e) {
            logger.error("查询列表发生错误，因为：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/create.htm")
    @ResponseBody
    public PageResult saveCommonRoleInfo(HttpServletRequest request,HttpServletResponse response, CommonRoleInfo commonRoleInfo) {

        PageResult resutl=new PageResult();

        try {
            int i = commonRoleInfoService.insertData(commonRoleInfo);
            if (i > 0) {
                resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
            } else {
                resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
            }
        } catch (Exception e) {
            resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
            e.printStackTrace();
        }

        return resutl;
    }


    @PutMapping("/update.htm")
    @ResponseBody
    public PageResult updateCommonRoleInfo(HttpServletRequest request,HttpServletResponse response,CommonRoleInfo commonRoleInfo) {

        PageResult resutl=new PageResult();
        try {
            int i = commonRoleInfoService.updateData(commonRoleInfo);
            if (i > 0) {
                resutl.setCode(AnguoStatusUtil.OPT_UPDATE_SUCCESS);
            } else {
                resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
            }
        } catch (Exception e) {
            resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
            e.printStackTrace();
        }
        return resutl;

    }


    @DeleteMapping("/delete.htm")
    @ResponseBody
    public PageResult deleteCommonRoleInfo(HttpServletRequest request,CommonRoleInfo commonRoleInfo) {
        PageResult resutl=new PageResult();
        try {

            int i =commonRoleInfoService.deleteData(commonRoleInfo);


            if (i > 0) {
                resutl.setCode(AnguoStatusUtil.OPT_DELETE_SUCCESS);
            } else {
                resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
            }
        } catch (Exception e) {
            resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
            e.printStackTrace();
        }
        return resutl;
    }


    @GetMapping("/load.htm")
    @ResponseBody
    public Object loadCommonRoleInfo(CommonRoleInfo commonRoleInfo) {

        return commonRoleInfoService.getData(commonRoleInfo);
    }

}
