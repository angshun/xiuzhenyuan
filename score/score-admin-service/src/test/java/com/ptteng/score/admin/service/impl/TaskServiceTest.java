package com.ptteng.score.admin.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.service.TaskService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class TaskServiceTest {

	private static final Log log = LogFactory.getLog(TaskServiceTest.class);
	
	private TaskService taskService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        taskService = (TaskService) context.getBean("taskService");
			//local server
			/**
			taskService = (TaskService)  Naming.lookup("//localhost:10952/TaskRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 taskService = (TaskService) context.getBean("taskService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Task task  = new Task();	   
	   					 
			   					                task.setName("二叉树");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.taskService.insert(task);

      task = this.taskService.getObjectById(id);

	  Task task2=this.taskService.getObjectById(id);
	    Assert.assertNotNull(task2);
	  
		// 2. 更改 
				 		 				 				   task.setName("三叉树");
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.taskService.update(task);		
		Assert.assertEquals(true, success);
		 Task task3=this.taskService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.taskService.delete(id);	
		Assert.assertEquals(true, success);
		Task task4=this.taskService.getObjectById(id);
		Assert.assertNull(task4);
		
		//4.batchInsert
		 List<Task> list=new ArrayList<Task>();
	  	  Task task5  = new Task();	   
	   					 
			   					                task5.setName("二叉树");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(task5);	   
	  	  Task task6  = new Task();	   
	   					 
			   					                task6.setName("三叉树");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(task6);
	   List<Task> insertResults= this.taskService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Task o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Task> getResults= this.taskService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Task o :insertResults){
//			this.taskService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

