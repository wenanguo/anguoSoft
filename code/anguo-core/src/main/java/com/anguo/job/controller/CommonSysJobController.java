package com.anguo.job.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.job.db.domain.CommonSysJob;
import com.anguo.job.service.CommonSysJobService;
import com.anguo.job.service.QuartzManager;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoStatusUtil;

/**
 * 作业控制器类
 * @ClassName: CommonSysJob
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysJobController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysJobController.class);
	@Autowired
	private CommonSysJobService commonSysJobService;
	
	@Autowired
	private QuartzManager qmanager;

	@RequestMapping("/commonSysJob/list.htm")
	@ResponseBody
	public PageResult<List<CommonSysJob>> queryCommonSysJobList(CommonSysJob commonSysJob) {
	
		PageResult<List<CommonSysJob>> result=new PageResult<List<CommonSysJob>>();
		
		try {
			result= commonSysJobService.getPageData(commonSysJob);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/commonSysJob/listAll.htm")
	@ResponseBody
	public List<CommonSysJob> queryCommonSysJobAllList(CommonSysJob commonSysJob) {
		try {
			return commonSysJobService.getAllData(commonSysJob);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得计划队列表
	 * @return
	 */
	@RequestMapping("/commonSysJob/listPlan.htm")
	@ResponseBody
	public List<CommonSysJob> getPlanJob() {
		try {
			
			return this.qmanager.getPlanJob();
			
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得正在执行中的队列
	 * @return
	 */
	@RequestMapping("/commonSysJob/listExecute.htm")
	@ResponseBody
	public List<CommonSysJob> getExecuteJob() {
		try {
			
			return this.qmanager.getExecuteJob();
			
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping("/commonSysJob/create.htm")
	@ResponseBody
	public PageResult saveCommonSysJob(HttpServletRequest request,HttpServletResponse response, CommonSysJob commonSysJob) {
		
		PageResult resutl=new PageResult();
		
		try {
			int i = commonSysJobService.insertData(commonSysJob);
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

	@RequestMapping("/commonSysJob/update.htm")
	@ResponseBody
	public PageResult updateCommonSysJob(HttpServletRequest request,HttpServletResponse response,CommonSysJob commonSysJob) {
		
		PageResult resutl=new PageResult();
		try {
			
			int i = commonSysJobService.updateData(commonSysJob);
			//this.qmanager.rescheduleJob(commonSysJob);
			//int i=1;
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
	
	/**
	 * 启动任务
	 * @param job
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/commonSysJob/startJob.htm")
	@ResponseBody
	public PageResult startJob(CommonSysJob job) throws SchedulerException {
		PageResult result=new PageResult();
		
		try {
			
			//修改数据库
			CommonSysJob commonSysJob=new CommonSysJob();
			commonSysJob.setId(job.getId());
			commonSysJob.setStatus(AnguoStatusUtil.BASE_START);		
			this.commonSysJobService.updateData(commonSysJob);
			
			//添加进入队列
			this.qmanager.createJob(job);
			
		} catch (ClassNotFoundException e) {
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 暂停任务
	 * @param job
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/commonSysJob/pauseJob.htm")
	@ResponseBody
	public PageResult pauseJob(CommonSysJob job) throws SchedulerException {
		PageResult result=new PageResult();
		
		//修改数据库
		CommonSysJob commonSysJob=new CommonSysJob();
		commonSysJob.setId(job.getId());
		commonSysJob.setStatus(AnguoStatusUtil.BASE_PAUSE);		
		this.commonSysJobService.updateData(commonSysJob);
		
		//暂停任务
		this.qmanager.pauseJob(job);
		
		return result;
	}
	
	
	/**
	 * 恢复任务
	 * @param job
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/commonSysJob/resumeJob.htm")
	@ResponseBody
	public PageResult resumeJob(CommonSysJob job) throws SchedulerException {
		PageResult result=new PageResult();
		
		//修改数据库
		CommonSysJob commonSysJob=new CommonSysJob();
		commonSysJob.setId(job.getId());
		commonSysJob.setStatus(AnguoStatusUtil.BASE_START);		
		this.commonSysJobService.updateData(commonSysJob);
		
		//恢复运行
		this.qmanager.resumeJob(job);
		
		return result;
	}
	
	
	/**
	 * 立即触发一次任务
	 * @param job
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/commonSysJob/triggerJob.htm")
	@ResponseBody
	public PageResult triggerJob(CommonSysJob job) throws SchedulerException {
		PageResult result=new PageResult();
		
		
				
		this.qmanager.triggerJob(job);
		
		return result;
	}
	
	
	/**
	 * 停止任务
	 * @param job
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/commonSysJob/stopJob.htm")
	@ResponseBody
	public PageResult stopJob(CommonSysJob job) throws SchedulerException {
		PageResult result=new PageResult();
		
		//修改数据库
		CommonSysJob commonSysJob=new CommonSysJob();
		commonSysJob.setId(job.getId());
		commonSysJob.setStatus(AnguoStatusUtil.BASE_STOP);		
		this.commonSysJobService.updateData(commonSysJob);
				
		//队列中删除任务
		this.qmanager.deleteJob(job);
		
		return result;
	}
	

	@RequestMapping("/commonSysJob/delete.htm")
	@ResponseBody
	public PageResult deleteCommonSysJob(HttpServletRequest request,CommonSysJob commonSysJob) {
		PageResult resutl=new PageResult();
		try {
			
			int i =commonSysJobService.deleteData(commonSysJob);
			
			
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
	
	@RequestMapping("/commonSysJob/load.htm")
	@ResponseBody
	public Object loadCommonSysJob(CommonSysJob commonSysJob) {
		
		return commonSysJobService.getData(commonSysJob);
	}
}
