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

import com.ptteng.score.admin.model.StaffPhilosophyRelation;
import com.ptteng.score.admin.service.StaffPhilosophyRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class StaffPhilosophyRelationServiceTest {

	private static final Log log = LogFactory.getLog(StaffPhilosophyRelationServiceTest.class);
	
	private StaffPhilosophyRelationService staffPhilosophyRelationService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        staffPhilosophyRelationService = (StaffPhilosophyRelationService) context.getBean("staffPhilosophyRelationService");
			//local server
			/**
			staffPhilosophyRelationService = (StaffPhilosophyRelationService)  Naming.lookup("//localhost:10952/StaffPhilosophyRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 staffPhilosophyRelationService = (StaffPhilosophyRelationService) context.getBean("staffPhilosophyRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  StaffPhilosophyRelation staffPhilosophyRelation  = new StaffPhilosophyRelation();	   
	   					 
			   					
			   					                staffPhilosophyRelation.setPhilosophyId(1);
            
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.staffPhilosophyRelationService.insert(staffPhilosophyRelation);

      staffPhilosophyRelation = this.staffPhilosophyRelationService.getObjectById(id);

	  StaffPhilosophyRelation staffPhilosophyRelation2=this.staffPhilosophyRelationService.getObjectById(id);
	    Assert.assertNotNull(staffPhilosophyRelation2);
	  
		// 2. 更改 
				 		 				 					 				 				   staffPhilosophyRelation.setPhilosophyId(2);
		    		 				 		 				 		 				 					 				 					 				boolean success=this.staffPhilosophyRelationService.update(staffPhilosophyRelation);		
		Assert.assertEquals(true, success);
		 StaffPhilosophyRelation staffPhilosophyRelation3=this.staffPhilosophyRelationService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.staffPhilosophyRelationService.delete(id);	
		Assert.assertEquals(true, success);
		StaffPhilosophyRelation staffPhilosophyRelation4=this.staffPhilosophyRelationService.getObjectById(id);
		Assert.assertNull(staffPhilosophyRelation4);
		
		//4.batchInsert
		 List<StaffPhilosophyRelation> list=new ArrayList<StaffPhilosophyRelation>();
	  	  StaffPhilosophyRelation staffPhilosophyRelation5  = new StaffPhilosophyRelation();	   
	   					 
			   					
			   					                staffPhilosophyRelation5.setPhilosophyId(1);
            
			   					 
			   					 
			   					
			   					
			   	    list.add(staffPhilosophyRelation5);	   
	  	  StaffPhilosophyRelation staffPhilosophyRelation6  = new StaffPhilosophyRelation();	   
	   					 
			   					
			   					                staffPhilosophyRelation6.setPhilosophyId(2);
            
			   					 
			   					 
			   					
			   					
			   	   list.add(staffPhilosophyRelation6);
	   List<StaffPhilosophyRelation> insertResults= this.staffPhilosophyRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(StaffPhilosophyRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<StaffPhilosophyRelation> getResults= this.staffPhilosophyRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(StaffPhilosophyRelation o :insertResults){
//			this.staffPhilosophyRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

