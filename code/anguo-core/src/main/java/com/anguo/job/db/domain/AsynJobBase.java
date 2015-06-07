package com.anguo.job.db.domain;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * 异步作业
 * @author Andrew.Wen
 */
public class AsynJobBase implements Job {
 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("开始运行===任务成功运行");
//        CommonSysJob scheduleJob = (CommonSysJob)context.getMergedJobDataMap().get("scheduleJob");
//        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]");
//        
//        
//        //获取JobExecutionContext中的service对象    
//        try {  
//                        //获取JobExecutionContext中的service对象   
//            SchedulerContext schCtx = context.getScheduler().getContext();  
//                        //获取Spring中的上下文    
//            ApplicationContext appCtx = (ApplicationContext)schCtx.get("applicationContext");  
//            GoeAdService goeAdService= (GoeAdService)appCtx.getBean("goeAdService");  
//            
//            List<GoeAd> list=goeAdService.getAllData(new GoeAd());
//            System.out.println(list);
//            
//            for(int i=0;i<999999;i++){
//            	Thread.sleep(1000);
//            	System.out.println(i);
//            }
//        
//        
//        } catch (SchedulerException e1) {  
//            // TODO 尚未处理异常  
//            e1.printStackTrace();  
//        } catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}   
        
    }
}