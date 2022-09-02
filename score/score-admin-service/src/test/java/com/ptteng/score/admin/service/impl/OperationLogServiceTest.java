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

import com.ptteng.score.admin.model.OperationLog;
import com.ptteng.score.admin.service.OperationLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class OperationLogServiceTest {

	private static final Log log = LogFactory.getLog(OperationLogServiceTest.class);
	
	private OperationLogService operationLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        operationLogService = (OperationLogService) context.getBean("operationLogService");
			//local server
			/**
			operationLogService = (OperationLogService)  Naming.lookup("//localhost:10952/OperationLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 operationLogService = (OperationLogService) context.getBean("operationLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  OperationLog operationLog  = new OperationLog();	   
	   					 
			   					                operationLog.setAdmin("home");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.operationLogService.insert(operationLog);

      operationLog = this.operationLogService.getObjectById(id);

	  OperationLog operationLog2=this.operationLogService.getObjectById(id);
	    Assert.assertNotNull(operationLog2);
	  
		// 2. 更改 
				 		 				 				   operationLog.setAdmin("user");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.operationLogService.update(operationLog);		
		Assert.assertEquals(true, success);
		 OperationLog operationLog3=this.operationLogService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.operationLogService.delete(id);	
		Assert.assertEquals(true, success);
		OperationLog operationLog4=this.operationLogService.getObjectById(id);
		Assert.assertNull(operationLog4);
		
		//4.batchInsert
		 List<OperationLog> list=new ArrayList<OperationLog>();
	  	  OperationLog operationLog5  = new OperationLog();	   
	   					 
			   					                operationLog5.setAdmin("home");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(operationLog5);	   
	  	  OperationLog operationLog6  = new OperationLog();	   
	   					 
			   					                operationLog6.setAdmin("user");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(operationLog6);
	   List<OperationLog> insertResults= this.operationLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(OperationLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<OperationLog> getResults= this.operationLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(OperationLog o :insertResults){
//			this.operationLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

