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

import com.ptteng.score.admin.model.ApproveLog;
import com.ptteng.score.admin.service.ApproveLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ApproveLogServiceTest {

	private static final Log log = LogFactory.getLog(ApproveLogServiceTest.class);
	
	private ApproveLogService approveLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        approveLogService = (ApproveLogService) context.getBean("approveLogService");
			//local server
			/**
			approveLogService = (ApproveLogService)  Naming.lookup("//localhost:10952/ApproveLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 approveLogService = (ApproveLogService) context.getBean("approveLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ApproveLog approveLog  = new ApproveLog();	   
	   					 
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.approveLogService.insert(approveLog);

      approveLog = this.approveLogService.getObjectById(id);

	  ApproveLog approveLog2=this.approveLogService.getObjectById(id);
	    Assert.assertNotNull(approveLog2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.approveLogService.update(approveLog);		
		Assert.assertEquals(true, success);
		 ApproveLog approveLog3=this.approveLogService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.approveLogService.delete(id);	
		Assert.assertEquals(true, success);
		ApproveLog approveLog4=this.approveLogService.getObjectById(id);
		Assert.assertNull(approveLog4);
		
		//4.batchInsert
		 List<ApproveLog> list=new ArrayList<ApproveLog>();
	  	  ApproveLog approveLog5  = new ApproveLog();	   
	   					 
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(approveLog5);	   
	  	  ApproveLog approveLog6  = new ApproveLog();	   
	   					 
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(approveLog6);
	   List<ApproveLog> insertResults= this.approveLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ApproveLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ApproveLog> getResults= this.approveLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ApproveLog o :insertResults){
//			this.approveLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

