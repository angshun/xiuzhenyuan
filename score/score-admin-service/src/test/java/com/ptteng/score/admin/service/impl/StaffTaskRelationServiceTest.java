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

import com.ptteng.score.admin.model.StaffTaskRelation;
import com.ptteng.score.admin.service.StaffTaskRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class StaffTaskRelationServiceTest {

	private static final Log log = LogFactory.getLog(StaffTaskRelationServiceTest.class);
	
	private StaffTaskRelationService staffTaskRelationService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        staffTaskRelationService = (StaffTaskRelationService) context.getBean("staffTaskRelationService");
			//local server
			/**
			staffTaskRelationService = (StaffTaskRelationService)  Naming.lookup("//localhost:10952/StaffTaskRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 staffTaskRelationService = (StaffTaskRelationService) context.getBean("staffTaskRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  StaffTaskRelation staffTaskRelation  = new StaffTaskRelation();	   
	   					 
			   					                staffTaskRelation.setStaffId(1L);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.staffTaskRelationService.insert(staffTaskRelation);

      staffTaskRelation = this.staffTaskRelationService.getObjectById(id);

	  StaffTaskRelation staffTaskRelation2=this.staffTaskRelationService.getObjectById(id);
	    Assert.assertNotNull(staffTaskRelation2);
	  
		// 2. 更改 
				 		 				 				   staffTaskRelation.setStaffId(2L);
		    		 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.staffTaskRelationService.update(staffTaskRelation);		
		Assert.assertEquals(true, success);
		 StaffTaskRelation staffTaskRelation3=this.staffTaskRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.staffTaskRelationService.delete(id);	
		Assert.assertEquals(true, success);
		StaffTaskRelation staffTaskRelation4=this.staffTaskRelationService.getObjectById(id);
		Assert.assertNull(staffTaskRelation4);
		
		//4.batchInsert
		 List<StaffTaskRelation> list=new ArrayList<StaffTaskRelation>();
	  	  StaffTaskRelation staffTaskRelation5  = new StaffTaskRelation();	   
	   					 
			   					                staffTaskRelation5.setStaffId(1L);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(staffTaskRelation5);	   
	  	  StaffTaskRelation staffTaskRelation6  = new StaffTaskRelation();	   
	   					 
			   					                staffTaskRelation6.setStaffId(2L);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(staffTaskRelation6);
	   List<StaffTaskRelation> insertResults= this.staffTaskRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(StaffTaskRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<StaffTaskRelation> getResults= this.staffTaskRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(StaffTaskRelation o :insertResults){
//			this.staffTaskRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

