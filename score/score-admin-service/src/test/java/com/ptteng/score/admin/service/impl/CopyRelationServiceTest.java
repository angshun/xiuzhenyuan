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

import com.ptteng.score.admin.model.CopyRelation;
import com.ptteng.score.admin.service.CopyRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class CopyRelationServiceTest {

	private static final Log log = LogFactory.getLog(CopyRelationServiceTest.class);
	
	private CopyRelationService copyRelationService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        copyRelationService = (CopyRelationService) context.getBean("copyRelationService");
			//local server
			/**
			copyRelationService = (CopyRelationService)  Naming.lookup("//localhost:10952/CopyRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 copyRelationService = (CopyRelationService) context.getBean("copyRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  CopyRelation copyRelation  = new CopyRelation();	   
	   					 
			   					                copyRelation.setRecordId(1L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.copyRelationService.insert(copyRelation);

      copyRelation = this.copyRelationService.getObjectById(id);

	  CopyRelation copyRelation2=this.copyRelationService.getObjectById(id);
	    Assert.assertNotNull(copyRelation2);
	  
		// 2. 更改 
				 		 				 				   copyRelation.setRecordId(2L);
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.copyRelationService.update(copyRelation);		
		Assert.assertEquals(true, success);
		 CopyRelation copyRelation3=this.copyRelationService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.copyRelationService.delete(id);	
		Assert.assertEquals(true, success);
		CopyRelation copyRelation4=this.copyRelationService.getObjectById(id);
		Assert.assertNull(copyRelation4);
		
		//4.batchInsert
		 List<CopyRelation> list=new ArrayList<CopyRelation>();
	  	  CopyRelation copyRelation5  = new CopyRelation();	   
	   					 
			   					                copyRelation5.setRecordId(1L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(copyRelation5);	   
	  	  CopyRelation copyRelation6  = new CopyRelation();	   
	   					 
			   					                copyRelation6.setRecordId(2L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(copyRelation6);
	   List<CopyRelation> insertResults= this.copyRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(CopyRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<CopyRelation> getResults= this.copyRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(CopyRelation o :insertResults){
//			this.copyRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

