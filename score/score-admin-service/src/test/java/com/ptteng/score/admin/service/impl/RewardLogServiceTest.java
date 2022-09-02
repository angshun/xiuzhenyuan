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

import com.ptteng.score.admin.model.RewardLog;
import com.ptteng.score.admin.service.RewardLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class RewardLogServiceTest {

	private static final Log log = LogFactory.getLog(RewardLogServiceTest.class);
	
	private RewardLogService rewardLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        rewardLogService = (RewardLogService) context.getBean("rewardLogService");
			//local server
			/**
			rewardLogService = (RewardLogService)  Naming.lookup("//localhost:10952/RewardLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 rewardLogService = (RewardLogService) context.getBean("rewardLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  RewardLog rewardLog  = new RewardLog();	   
	   					 
			   					
			   					                rewardLog.setAdminName("头像");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.rewardLogService.insert(rewardLog);

      rewardLog = this.rewardLogService.getObjectById(id);

	  RewardLog rewardLog2=this.rewardLogService.getObjectById(id);
	    Assert.assertNotNull(rewardLog2);
	  
		// 2. 更改 
				 		 				 					 				 				   rewardLog.setAdminName("头像");
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.rewardLogService.update(rewardLog);		
		Assert.assertEquals(true, success);
		 RewardLog rewardLog3=this.rewardLogService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.rewardLogService.delete(id);	
		Assert.assertEquals(true, success);
		RewardLog rewardLog4=this.rewardLogService.getObjectById(id);
		Assert.assertNull(rewardLog4);
		
		//4.batchInsert
		 List<RewardLog> list=new ArrayList<RewardLog>();
	  	  RewardLog rewardLog5  = new RewardLog();	   
	   					 
			   					
			   					                rewardLog5.setAdminName("头像");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(rewardLog5);	   
	  	  RewardLog rewardLog6  = new RewardLog();	   
	   					 
			   					
			   					                rewardLog6.setAdminName("头像");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(rewardLog6);
	   List<RewardLog> insertResults= this.rewardLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(RewardLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<RewardLog> getResults= this.rewardLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(RewardLog o :insertResults){
//			this.rewardLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

