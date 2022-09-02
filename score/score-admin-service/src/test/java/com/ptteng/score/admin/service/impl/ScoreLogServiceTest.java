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

import com.ptteng.score.admin.model.ScoreLog;
import com.ptteng.score.admin.service.ScoreLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ScoreLogServiceTest {

	private static final Log log = LogFactory.getLog(ScoreLogServiceTest.class);
	
	private ScoreLogService scoreLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        scoreLogService = (ScoreLogService) context.getBean("scoreLogService");
			//local server
			/**
			scoreLogService = (ScoreLogService)  Naming.lookup("//localhost:10952/ScoreLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 scoreLogService = (ScoreLogService) context.getBean("scoreLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ScoreLog scoreLog  = new ScoreLog();	   
	   					 
			   					
			   					
			   					                scoreLog.setScoreChange("加分");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.scoreLogService.insert(scoreLog);

      scoreLog = this.scoreLogService.getObjectById(id);

	  ScoreLog scoreLog2=this.scoreLogService.getObjectById(id);
	    Assert.assertNotNull(scoreLog2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 				   scoreLog.setScoreChange("减分");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.scoreLogService.update(scoreLog);		
		Assert.assertEquals(true, success);
		 ScoreLog scoreLog3=this.scoreLogService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.scoreLogService.delete(id);	
		Assert.assertEquals(true, success);
		ScoreLog scoreLog4=this.scoreLogService.getObjectById(id);
		Assert.assertNull(scoreLog4);
		
		//4.batchInsert
		 List<ScoreLog> list=new ArrayList<ScoreLog>();
	  	  ScoreLog scoreLog5  = new ScoreLog();	   
	   					 
			   					
			   					
			   					                scoreLog5.setScoreChange("加分");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(scoreLog5);	   
	  	  ScoreLog scoreLog6  = new ScoreLog();	   
	   					 
			   					
			   					
			   					                scoreLog6.setScoreChange("减分");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(scoreLog6);
	   List<ScoreLog> insertResults= this.scoreLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ScoreLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ScoreLog> getResults= this.scoreLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ScoreLog o :insertResults){
//			this.scoreLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

