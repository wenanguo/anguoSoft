package com.anguo.web.controller;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoStatusUtil;
import com.anguo.web.db.domain.CommonRoleInfo;
import com.anguo.web.service.CommonRoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表-控制器类
 * @ClassName: CommonRoleInfo
 * @author Andrew.Wen
 */
@RequestMapping("/commonRoleInfo")
@RestController
public class CommonRoleInfoController extends BaseController {


    private static final Logger logger = LoggerFactory.getLogger(CommonRoleInfoController.class);


    @Autowired
    private CommonRoleInfoService commonRoleInfoService;


    @GetMapping("/list.htm")
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
    public List<CommonRoleInfo> queryCommonRoleInfoAllList(CommonRoleInfo commonRoleInfo) {
        List<CommonRoleInfo> list=new ArrayList<CommonRoleInfo>();

        try {
            list = commonRoleInfoService.getAllData(commonRoleInfo);
        } catch (Exception e) {
            logger.error("查询列表发生错误，因为：" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }


    @PostMapping("/create.htm")
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
    public Object loadCommonRoleInfo(CommonRoleInfo commonRoleInfo) {

        return commonRoleInfoService.getData(commonRoleInfo);
    }

}
