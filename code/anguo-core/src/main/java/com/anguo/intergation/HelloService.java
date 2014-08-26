package com.anguo.intergation;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Simple POJO to be referenced from a Service Activator.
 *
 * @author Mark Fisher
 */
public class HelloService {

	private static Logger logger = Logger.getLogger(HelloService.class);
	
	
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	public User getUser(User user)
	{
		user.setName("处理后的名字："+user.getName());
		user.setAge(user.getAge()+100);
		return user;
	}
	

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/project-integration.xml", HelloService.class);
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
		
		User user=new User();
		
		user.setAge(26);
		user.setName("文安国");
		inputChannel.send(new GenericMessage<User>(user));
		
		Message<User> mess=(Message<User>) outputChannel.receive(0);
		User user2=mess.getPayload();
		
		logger.info("==> HelloWorldDemo: " +mess.getHeaders().getId() );
		
		logger.info("==> HelloWorldDemo: " +user2.getName() );
		logger.info("==> HelloWorldDemo: " +user2.getAge() );
	}

}
