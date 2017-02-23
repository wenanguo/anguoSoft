package com.anguo.job.db.domain;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 同步作业
 *   加入@DisallowConcurrentExecution注解，则为同步任务。不加入则为异步任务
 * User: liyd
 * Date: 14-1-3
 * Time: 上午10:11
 */
@DisallowConcurrentExecution
public class SyncJobBase implements Job {
 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	
    	
//        CommonSysJob scheduleJob = (CommonSysJob)context.getMergedJobDataMap().get("scheduleJob");
//        //System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]");
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

//            e1.printStackTrace();  
//        } catch (InterruptedException e) {

//			e.printStackTrace();
//		}   
        
    }
}