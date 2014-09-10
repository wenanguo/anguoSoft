package com.anguo.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.anguo.app.db.domain.ResultMsg;
import com.anguo.member.db.domain.GeoMember;
import com.anguo.member.service.GeoMemberService;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;

/**
 * 制器类
 * @ClassName: GeoMember
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class GeoMemberController extends BaseController {
	
	private final static Logger log = Logger.getLogger(GeoMemberController.class);
	@Autowired
	private GeoMemberService geoMemberService;

	@RequestMapping("/geoMember/list.htm")
	@ResponseBody
	public PageResult<GeoMember> queryGeoMemberList(GeoMember geoMember) {
		try {
			return geoMemberService.getPageData(geoMember);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/geoMember/listAll.htm")
	@ResponseBody
	public List<GeoMember> queryGeoMemberAllList(GeoMember geoMember) {
		try {
			return geoMemberService.getAllData(geoMember);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/geoMember/create.htm")
	@ResponseBody
	public Map saveGeoMember(HttpServletRequest request,
			HttpServletResponse response, GeoMember geoMember) {
		Map messages = new HashMap();
		try {
			int i = geoMemberService.insertData(geoMember);
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

	@RequestMapping("/geoMember/update.htm")
	@ResponseBody
	public Map updateGeoMember(HttpServletRequest request,
			HttpServletResponse response,GeoMember geoMember) {
		Map messages = new HashMap();
		try {
			int i = geoMemberService.updateData(geoMember);
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

	@RequestMapping("/geoMember/delete.htm")
	@ResponseBody
	public Map deleteGeoMember(HttpServletRequest request,GeoMember geoMember) {
		Map messages = new HashMap();
		try {
		
			
			int i =geoMemberService.deleteData(geoMember);
			
			
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
	
	
	
	
	@RequestMapping("/geoMember/load.htm")
	@ResponseBody
	public Object loadGeoMember(GeoMember geoMember) {
		
		return geoMemberService.getData(geoMember);
	}
	
	
	@RequestMapping("/geoMember/login.htm")
	@ResponseBody
	public ResultMsg<GeoMember> login(GeoMember geoMember) {
		
		ResultMsg<GeoMember> messages = new ResultMsg<GeoMember>();
		
		GeoMember resultGeoMember=null;
		try {
				resultGeoMember  = geoMemberService.login(geoMember);
				messages.setCode(100);
				messages.setObj(resultGeoMember);
			} catch (Exception e) {
				messages.setCode(101);
				messages.setMsg(e.getMessage());
			}
		
		
		return messages;
	}
}
