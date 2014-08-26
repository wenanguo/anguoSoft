package com.anguo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.mybatis.db.controller.BaseController;

/**
 * 后台菜单控制器
 * @author Andrew.Wen
 *
 */
@Controller
public class AdminMenuController extends BaseController {
	
	
	
	@RequestMapping("/admin/menu.htm")
	@ResponseBody
	public List index() {
		
		List<Map> listMap=new ArrayList<Map>();
		
		Map map=new HashMap();
		map.put("id", "1");
		map.put("text", "跟节点");
		map.put("children", map);
		listMap.add(map);
		
		
		return listMap;
	}
	
}
