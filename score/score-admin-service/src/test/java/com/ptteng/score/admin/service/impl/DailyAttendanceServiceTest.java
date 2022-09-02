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

import com.ptteng.score.admin.model.DailyAttendance;
import com.ptteng.score.admin.service.DailyAttendanceService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DailyAttendanceServiceTest {

	private static final Log log = LogFactory.getLog(DailyAttendanceServiceTest.class);
	
	private DailyAttendanceService dailyAttendanceService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        dailyAttendanceService = (DailyAttendanceService) context.getBean("dailyAttendanceService");
			//local server
			/**
			dailyAttendanceService = (DailyAttendanceService)  Naming.lookup("//localhost:10952/DailyAttendanceRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 dailyAttendanceService = (DailyAttendanceService) context.getBean("dailyAttendanceService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  DailyAttendance dailyAttendance  = new DailyAttendance();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.dailyAttendanceService.insert(dailyAttendance);

      dailyAttendance = this.dailyAttendanceService.getObjectById(id);

	  DailyAttendance dailyAttendance2=this.dailyAttendanceService.getObjectById(id);
	    Assert.assertNotNull(dailyAttendance2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.dailyAttendanceService.update(dailyAttendance);		
		Assert.assertEquals(true, success);
		 DailyAttendance dailyAttendance3=this.dailyAttendanceService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.dailyAttendanceService.delete(id);	
		Assert.assertEquals(true, success);
		DailyAttendance dailyAttendance4=this.dailyAttendanceService.getObjectById(id);
		Assert.assertNull(dailyAttendance4);
		
		//4.batchInsert
		 List<DailyAttendance> list=new ArrayList<DailyAttendance>();
	  	  DailyAttendance dailyAttendance5  = new DailyAttendance();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(dailyAttendance5);	   
	  	  DailyAttendance dailyAttendance6  = new DailyAttendance();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(dailyAttendance6);
	   List<DailyAttendance> insertResults= this.dailyAttendanceService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(DailyAttendance o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<DailyAttendance> getResults= this.dailyAttendanceService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(DailyAttendance o :insertResults){
//			this.dailyAttendanceService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

