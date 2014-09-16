package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.member.db.domain.GeoMember;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.ConstantClass;
import com.anguo.app.db.domain.ResultMsg;
import com.anguo.app.db.mapper.CommonSysMemberMapper;
import com.anguo.app.service.CommonSysMemberService;

/**
 * 制器类
 * @ClassName: CommonSysMember
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysMemberController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysMemberController.class);
	@Autowired
	private CommonSysMemberService commonSysMemberService;

	@RequestMapping("/commonSysMember/list.htm")
	@ResponseBody
	public PageResult<CommonSysMember> queryCommonSysMemberList(CommonSysMember commonSysMember) {
		try {
			return commonSysMemberService.getPageData(commonSysMember);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysMember/listAll.htm")
	@ResponseBody
	public List<CommonSysMember> queryCommonSysMemberAllList(CommonSysMember commonSysMember) {
		try {
			return commonSysMemberService.getAllData(commonSysMember);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysMember/create.htm")
	@ResponseBody
	public Map saveCommonSysMember(HttpServletRequest request,
			HttpServletResponse response, CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
			int i = commonSysMemberService.insertData(commonSysMember);
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "添加成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "添加失败!");
			e.printStackTrace();
		}
		
		return messages;
	}

	@RequestMapping("/commonSysMember/update.htm")
	@ResponseBody
	public Map updateCommonSysMember(HttpServletRequest request,
			HttpServletResponse response,CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
			int i = commonSysMemberService.updateData(commonSysMember);
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "修改成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "修改失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "修改失败!");
			e.printStackTrace();
		}
		return messages;
		
	}

	@RequestMapping("/commonSysMember/delete.htm")
	@ResponseBody
	public Map deleteCommonSysMember(HttpServletRequest request,CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
		
			
			int i =commonSysMemberService.deleteData(commonSysMember);
			
			
			
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "删除成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "删除失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "删除失败!");
			e.printStackTrace();
		}
		return messages;
	}
	
	@RequestMapping("/commonSysMember/load.htm")
	@ResponseBody
	public Object loadCommonSysMember(CommonSysMember commonSysMember) {
		
		return commonSysMemberService.getData(commonSysMember);
	}
	
	
	
	public ResultMsg<CommonSysMember> login(CommonSysMember geoMember) {
		
		ResultMsg<CommonSysMember> messages = new ResultMsg<CommonSysMember>();
		
		CommonSysMember resultGeoMember=null;
		try {
				resultGeoMember  = this.commonSysMemberService.login(geoMember);
				messages.setObj(resultGeoMember);
			} catch (Exception e) {
				messages.setCode(ConstantClass.INTERFACE_SERVICEERROR);
				messages.setMsg(e.getMessage());
			}
		
		
		return messages;
	}
}
