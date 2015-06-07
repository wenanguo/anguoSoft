package com.anguo.job.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.job.db.domain.CommonSysJob;
import com.anguo.util.AnguoStatusUtil;


/**
 * 作业调度管理器
 * @author Andrew.Wen
 *
 */
@Service
public class QuartzManager {
	
	
	private  final  static Logger log=Logger.getLogger(QuartzManager.class);

	//@Autowired
	//SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	Scheduler scheduler;
	
	//作业数据库业务逻辑类
	@Autowired
	CommonSysJobService commonSysJobService;
	
	/** 计划任务map 
	 * @throws ClassNotFoundException */
	//private static Map<String, CommonSysJob> jobMap = new HashMap<String, CommonSysJob>();
	
	
	
//	/**
//	 * 从数据库获取作业
//	 * @return
//	 */
//	public List<CommonSysJob> getList(){
//		
//		
//		
//		List<CommonSysJob> list=this.commonSysJobService.getAllData(null);;
//		
////		for (String key : jobMap.keySet()) {
////			list.add(jobMap.get(key));
////		}
//		
//		return list;
//		
//	}
	
	
	
	@PostConstruct 
	public void init() throws SchedulerException{
		
	log.debug("**************************");
	log.debug("作业开始启动");
	//schedulerFactoryBean 由spring创建注入
	//Scheduler scheduler = schedulerFactoryBean.getScheduler();
	
	//将暂停状态改为停用
	this.commonSysJobService.updateDataByPause();
	
	
	 
	//获取状态为正常的作业进行启动
	CommonSysJob commonSysJob=new CommonSysJob();
	commonSysJob.setStatus(AnguoStatusUtil.BASE_START);
	List<CommonSysJob> jobList =this.commonSysJobService.getAllData(commonSysJob);
	 
	//初始化遍历作业进行启动
	for (CommonSysJob job : jobList) {
		try {
			createJob(job);
		} catch (ClassNotFoundException e) {
			log.warn("启动作业失败："+job.toString());
			e.printStackTrace();
		}
	}
	
	log.debug("作业启动完成");
	log.debug("**************************");
	}
	
	
	/**
	 * 获得计划任务列表
	 * @throws SchedulerException
	 */
	public List<CommonSysJob> getPlanJob() throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<CommonSysJob> jobList = new ArrayList<CommonSysJob>();
		for (JobKey jobKey : jobKeys) {
		    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
		    for (Trigger trigger : triggers) {
		        CommonSysJob job = new CommonSysJob();
		        job.setJobName(jobKey.getName());
		        job.setJobGroup(jobKey.getGroup());
		        job.setMemo("触发器:" + trigger.getKey());
		        Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
		        job.setMemo(triggerState.name());
		        if (trigger instanceof CronTrigger) {
		            CronTrigger cronTrigger = (CronTrigger) trigger;
		            String cronExpression = cronTrigger.getCronExpression();
		            job.setCronExpression(cronExpression);
		        }
		        jobList.add(job);
		    }
		}
		
		return jobList;
	}
	
	/**
	 * 获得正在执行中的job
	 * @throws SchedulerException 
	 */
	public List<CommonSysJob> getExecuteJob() throws SchedulerException {
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
		List<CommonSysJob> jobList = new ArrayList<CommonSysJob>(executingJobs.size());
		for (JobExecutionContext executingJob : executingJobs) {
		    CommonSysJob job = new CommonSysJob();
		    JobDetail jobDetail = executingJob.getJobDetail();
		    JobKey jobKey = jobDetail.getKey();
		    Trigger trigger = executingJob.getTrigger();
		    job.setJobName(jobKey.getName());
		    job.setJobGroup(jobKey.getGroup());
		    job.setMemo("触发器:" + trigger.getKey());
		    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
		    //job.setJobStatus(triggerState.name());
		    if (trigger instanceof CronTrigger) {
		        CronTrigger cronTrigger = (CronTrigger) trigger;
		        String cronExpression = cronTrigger.getCronExpression();
		        job.setCronExpression(cronExpression);
		    }
		    jobList.add(job);
		}
		
		return jobList;
	}
	
	
	
	/**
	 * 新增job
	 * @param CommonSysJob
	 * @throws SchedulerException
	 * @throws ClassNotFoundException 
	 */
	public void createJob(CommonSysJob job) throws SchedulerException, ClassNotFoundException{
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
		 
		//获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
	 
		//不存在，创建一个
		if (null == trigger) {
			
			Class<? extends Job> c1 = (Class<? extends Job>) Class.forName(job.getJobClass());
			
			JobDetail jobDetail = JobBuilder.newJob(c1)
				.withIdentity(job.getJobName(), job.getJobGroup()).build();
			jobDetail.getJobDataMap().put("scheduleJob", job);
	 
			//表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
				.getCronExpression());
	 
			//按新的cronExpression表达式构建一个新的trigger
			trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
	 
			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			// Trigger已存在，那么更新相应的定时设置
			//表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
				.getCronExpression());
	 
			//按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
				.withSchedule(scheduleBuilder).build();
	 
			//按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
	}
	
	/**
	 * 暂停job
	 * @param CommonSysJob
	 * @throws SchedulerException
	 */
	public void pauseJob(CommonSysJob scheduleJob) throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.pauseJob(jobKey);
	}
	
	/**
	 * 恢复运行
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(CommonSysJob scheduleJob) throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.resumeJob(jobKey);
	}
	
	/**
	 * 删除作业
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void deleteJob(CommonSysJob scheduleJob) throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.deleteJob(jobKey);
	}
	
	
	/**
	 * 立即运行
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void triggerJob(CommonSysJob scheduleJob) throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.triggerJob(jobKey);
	}
	
	
	/**
	 * 修改表达式
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public  void rescheduleJob(CommonSysJob scheduleJob) throws SchedulerException{
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		 
		TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(),
		    scheduleJob.getJobGroup());
		 
		//获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		 
		//表达式调度构建器
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob
		    .getCronExpression());
		 
		//按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
		    .withSchedule(scheduleBuilder).build();
		 
		//按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
	}
	
	
	
	
}
