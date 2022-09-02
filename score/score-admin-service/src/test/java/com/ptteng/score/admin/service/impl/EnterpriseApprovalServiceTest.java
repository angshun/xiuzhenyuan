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

import com.ptteng.score.admin.model.EnterpriseApproval;
import com.ptteng.score.admin.service.EnterpriseApprovalService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class EnterpriseApprovalServiceTest {

	private static final Log log = LogFactory.getLog(EnterpriseApprovalServiceTest.class);
	
	private EnterpriseApprovalService enterpriseApprovalService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        enterpriseApprovalService = (EnterpriseApprovalService) context.getBean("enterpriseApprovalService");
			//local server
			/**
			enterpriseApprovalService = (EnterpriseApprovalService)  Naming.lookup("//localhost:10952/EnterpriseApprovalRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 enterpriseApprovalService = (EnterpriseApprovalService) context.getBean("enterpriseApprovalService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  EnterpriseApproval enterpriseApproval  = new EnterpriseApproval();	   
	   					 
			   					                enterpriseApproval.setTitle("标签");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.enterpriseApprovalService.insert(enterpriseApproval);

      enterpriseApproval = this.enterpriseApprovalService.getObjectById(id);

	  EnterpriseApproval enterpriseApproval2=this.enterpriseApprovalService.getObjectById(id);
	    Assert.assertNotNull(enterpriseApproval2);
	  
		// 2. 更改 
				 		 				 				   enterpriseApproval.setTitle("标签");
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.enterpriseApprovalService.update(enterpriseApproval);		
		Assert.assertEquals(true, success);
		 EnterpriseApproval enterpriseApproval3=this.enterpriseApprovalService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.enterpriseApprovalService.delete(id);	
		Assert.assertEquals(true, success);
		EnterpriseApproval enterpriseApproval4=this.enterpriseApprovalService.getObjectById(id);
		Assert.assertNull(enterpriseApproval4);
		
		//4.batchInsert
		 List<EnterpriseApproval> list=new ArrayList<EnterpriseApproval>();
	  	  EnterpriseApproval enterpriseApproval5  = new EnterpriseApproval();	   
	   					 
			   					                enterpriseApproval5.setTitle("标签");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(enterpriseApproval5);	   
	  	  EnterpriseApproval enterpriseApproval6  = new EnterpriseApproval();	   
	   					 
			   					                enterpriseApproval6.setTitle("标签");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(enterpriseApproval6);
	   List<EnterpriseApproval> insertResults= this.enterpriseApprovalService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(EnterpriseApproval o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<EnterpriseApproval> getResults= this.enterpriseApprovalService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(EnterpriseApproval o :insertResults){
//			this.enterpriseApprovalService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

