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

import com.ptteng.score.admin.model.Philosophy;
import com.ptteng.score.admin.service.PhilosophyService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class PhilosophyServiceTest {

	private static final Log log = LogFactory.getLog(PhilosophyServiceTest.class);
	
	private PhilosophyService philosophyService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        philosophyService = (PhilosophyService) context.getBean("philosophyService");
			//local server
			/**
			philosophyService = (PhilosophyService)  Naming.lookup("//localhost:10952/PhilosophyRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 philosophyService = (PhilosophyService) context.getBean("philosophyService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Philosophy philosophy  = new Philosophy();	   
	   					 
			   					                philosophy.setTitle("百分之99的人看了会流泪");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.philosophyService.insert(philosophy);

      philosophy = this.philosophyService.getObjectById(id);

	  Philosophy philosophy2=this.philosophyService.getObjectById(id);
	    Assert.assertNotNull(philosophy2);
	  
		// 2. 更改 
				 		 				 				   philosophy.setTitle("就不流泪");
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.philosophyService.update(philosophy);		
		Assert.assertEquals(true, success);
		 Philosophy philosophy3=this.philosophyService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.philosophyService.delete(id);	
		Assert.assertEquals(true, success);
		Philosophy philosophy4=this.philosophyService.getObjectById(id);
		Assert.assertNull(philosophy4);
		
		//4.batchInsert
		 List<Philosophy> list=new ArrayList<Philosophy>();
	  	  Philosophy philosophy5  = new Philosophy();	   
	   					 
			   					                philosophy5.setTitle("百分之99的人看了会流泪");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(philosophy5);	   
	  	  Philosophy philosophy6  = new Philosophy();	   
	   					 
			   					                philosophy6.setTitle("就不流泪");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(philosophy6);
	   List<Philosophy> insertResults= this.philosophyService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Philosophy o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Philosophy> getResults= this.philosophyService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Philosophy o :insertResults){
//			this.philosophyService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

