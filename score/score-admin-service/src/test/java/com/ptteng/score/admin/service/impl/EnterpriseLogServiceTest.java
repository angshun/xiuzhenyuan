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

import com.ptteng.score.admin.model.EnterpriseLog;
import com.ptteng.score.admin.service.EnterpriseLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class EnterpriseLogServiceTest {

	private static final Log log = LogFactory.getLog(EnterpriseLogServiceTest.class);
	
	private EnterpriseLogService enterpriseLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        enterpriseLogService = (EnterpriseLogService) context.getBean("enterpriseLogService");
			//local server
			/**
			enterpriseLogService = (EnterpriseLogService)  Naming.lookup("//localhost:10952/EnterpriseLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 enterpriseLogService = (EnterpriseLogService) context.getBean("enterpriseLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  EnterpriseLog enterpriseLog  = new EnterpriseLog();	   
	   					 
			   					
			   					                enterpriseLog.setLogContent("日志");
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.enterpriseLogService.insert(enterpriseLog);

      enterpriseLog = this.enterpriseLogService.getObjectById(id);

	  EnterpriseLog enterpriseLog2=this.enterpriseLogService.getObjectById(id);
	    Assert.assertNotNull(enterpriseLog2);
	  
		// 2. 更改 
				 		 				 					 				 				   enterpriseLog.setLogContent("日志");
		    		 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.enterpriseLogService.update(enterpriseLog);		
		Assert.assertEquals(true, success);
		 EnterpriseLog enterpriseLog3=this.enterpriseLogService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.enterpriseLogService.delete(id);	
		Assert.assertEquals(true, success);
		EnterpriseLog enterpriseLog4=this.enterpriseLogService.getObjectById(id);
		Assert.assertNull(enterpriseLog4);
		
		//4.batchInsert
		 List<EnterpriseLog> list=new ArrayList<EnterpriseLog>();
	  	  EnterpriseLog enterpriseLog5  = new EnterpriseLog();	   
	   					 
			   					
			   					                enterpriseLog5.setLogContent("日志");
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(enterpriseLog5);	   
	  	  EnterpriseLog enterpriseLog6  = new EnterpriseLog();	   
	   					 
			   					
			   					                enterpriseLog6.setLogContent("日志");
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(enterpriseLog6);
	   List<EnterpriseLog> insertResults= this.enterpriseLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(EnterpriseLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<EnterpriseLog> getResults= this.enterpriseLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(EnterpriseLog o :insertResults){
//			this.enterpriseLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

