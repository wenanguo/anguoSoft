package com.anguo.oy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;

/**
 * 30周年活动控制器
 * @ClassName: thirtyanniversaryController
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class Oy0615Controller extends BaseController {
	
	private final static Logger log = Logger.getLogger(Oy0615Controller.class);
	
	

	
	
	@RequestMapping("/160521/create.htm")
	@ResponseBody
	public PageResult saveWine(HttpServletRequest request,HttpServletResponse response) {
		
//		PageResult resutl=new PageResult();
//		thirtyanniversary.setOpdate(new Date());
//		
//		
//		try {
//		
//			if(StringUtils.isEmpty(thirtyanniversary.getPhone())||StringUtils.isEmpty(thirtyanniversary.getName())){
//				
//				//用户名或手机号不能为空
//				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
//				resutl.setMsg("用户名或手机号不能为空！");
//				
//				
//			}else if(thirtyanniversary.getPhone().equalsIgnoreCase("15285027249")){
//				
//				//已经答题的情况
//				 resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
//				resutl.setMsg("文先生，感谢您的测试，返回成功状态！");
//				
//			}
//			else if(thirtyanniversaryService.getDataByPhone(thirtyanniversary)!=null){
//				//已经答题的情况
//				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
//				resutl.setMsg("对不起你已经参与过该活动！");
//				
//			}else{
//				
//				
//				
//				//插入数据
//				thirtyanniversary.setIntegral("0");
//				int i=thirtyanniversaryService.insertData(thirtyanniversary);
//				
//				
//				if (i > 0) {
//					
//					String url="http://lb.teamyy.cn:5070/redstar/api/v1.0/register?openid="+thirtyanniversary.getOpenid()+"&&mobile="+thirtyanniversary.getPhone()+"&&name="+thirtyanniversary.getName();
//			
//					System.out.println("=30周年==================");
//					System.out.println(url);
//					
//					
//					
//					
//					String ret=AnguoHttpUtil.getMethod(url);
//					
//					System.out.println("请求结果："+ret);
//					System.out.println("=====================");
//					
//					thirtyanniversary.setIntegral(ret);
//					thirtyanniversaryService.updateData(thirtyanniversary);
//					
//					
//					resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
//					
//				} else {
//					resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
//				}
//				
//				
//			}
//			
//			
//			
//		} catch (Exception e) {
//			resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
//			e.printStackTrace();
//		}
//		
//		return resutl;
		return null;
	}
	
	
	
	
}
