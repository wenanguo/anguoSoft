package com.anguo.activiti.test;

import java.util.List;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"file:src/main/resources/project-*.xml" })
public class Ch1Test extends AbstractTestNGSpringContextTests {
	
	
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;
	
	@Test
	public void testDeploy()
	{
		//部署
		Deployment deployment = repositoryService.createDeployment()
				  .addClasspathResource("hello.bpmn20.xml")
				  .deploy();
		
		
	}
	
	public void testInstanceStart(){
		//启动流程实例
		//ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
		
		
	    List<Task> tasks =  taskService.createTaskQuery().taskCandidateUser("kermit").list();

	    for (Task task : tasks) {
	      System.out.println("Following task is available for accountancy group: " + task.getName());

	      // claim it
	      taskService.claim(task.getId(), "fozzie");
	    }

	}
	
	
	

}
