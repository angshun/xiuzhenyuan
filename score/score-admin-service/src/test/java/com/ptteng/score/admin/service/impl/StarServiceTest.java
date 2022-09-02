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

import com.ptteng.score.admin.model.Star;
import com.ptteng.score.admin.service.StarService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class StarServiceTest {

	private static final Log log = LogFactory.getLog(StarServiceTest.class);
	
	private StarService starService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        starService = (StarService) context.getBean("starService");
			//local server
			/**
			starService = (StarService)  Naming.lookup("//localhost:10952/StarRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 starService = (StarService) context.getBean("starService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Star star  = new Star();	   
	   					 
			   					                star.setGradeType(1);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.starService.insert(star);

      star = this.starService.getObjectById(id);

	  Star star2=this.starService.getObjectById(id);
	    Assert.assertNotNull(star2);
	  
		// 2. 更改 
				 		 				 				   star.setGradeType(0);
		    		 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.starService.update(star);		
		Assert.assertEquals(true, success);
		 Star star3=this.starService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.starService.delete(id);	
		Assert.assertEquals(true, success);
		Star star4=this.starService.getObjectById(id);
		Assert.assertNull(star4);
		
		//4.batchInsert
		 List<Star> list=new ArrayList<Star>();
	  	  Star star5  = new Star();	   
	   					 
			   					                star5.setGradeType(1);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(star5);	   
	  	  Star star6  = new Star();	   
	   					 
			   					                star6.setGradeType(0);
            
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(star6);
	   List<Star> insertResults= this.starService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Star o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Star> getResults= this.starService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Star o :insertResults){
//			this.starService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

