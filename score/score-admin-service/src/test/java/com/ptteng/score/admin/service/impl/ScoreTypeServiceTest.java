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

import com.ptteng.score.admin.model.ScoreType;
import com.ptteng.score.admin.service.ScoreTypeService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ScoreTypeServiceTest {

	private static final Log log = LogFactory.getLog(ScoreTypeServiceTest.class);
	
	private ScoreTypeService scoreTypeService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        scoreTypeService = (ScoreTypeService) context.getBean("scoreTypeService");
			//local server
			/**
			scoreTypeService = (ScoreTypeService)  Naming.lookup("//localhost:10952/ScoreTypeRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 scoreTypeService = (ScoreTypeService) context.getBean("scoreTypeService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ScoreType scoreType  = new ScoreType();	   
	   					 
			   					                scoreType.setMoral("善心奖");
            
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.scoreTypeService.insert(scoreType);

      scoreType = this.scoreTypeService.getObjectById(id);

	  ScoreType scoreType2=this.scoreTypeService.getObjectById(id);
	    Assert.assertNotNull(scoreType2);
	  
		// 2. 更改 
				 		 				 				   scoreType.setMoral("业绩奖");
		    		 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.scoreTypeService.update(scoreType);		
		Assert.assertEquals(true, success);
		 ScoreType scoreType3=this.scoreTypeService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.scoreTypeService.delete(id);	
		Assert.assertEquals(true, success);
		ScoreType scoreType4=this.scoreTypeService.getObjectById(id);
		Assert.assertNull(scoreType4);
		
		//4.batchInsert
		 List<ScoreType> list=new ArrayList<ScoreType>();
	  	  ScoreType scoreType5  = new ScoreType();	   
	   					 
			   					                scoreType5.setMoral("善心奖");
            
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(scoreType5);	   
	  	  ScoreType scoreType6  = new ScoreType();	   
	   					 
			   					                scoreType6.setMoral("业绩奖");
            
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(scoreType6);
	   List<ScoreType> insertResults= this.scoreTypeService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ScoreType o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ScoreType> getResults= this.scoreTypeService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ScoreType o :insertResults){
//			this.scoreTypeService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

