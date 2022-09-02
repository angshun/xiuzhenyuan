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

import com.ptteng.score.admin.model.AttendanceLog;
import com.ptteng.score.admin.service.AttendanceLogService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class AttendanceLogServiceTest {

	private static final Log log = LogFactory.getLog(AttendanceLogServiceTest.class);
	
	private AttendanceLogService attendanceLogService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        attendanceLogService = (AttendanceLogService) context.getBean("attendanceLogService");
			//local server
			/**
			attendanceLogService = (AttendanceLogService)  Naming.lookup("//localhost:10952/AttendanceLogRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 attendanceLogService = (AttendanceLogService) context.getBean("attendanceLogService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  AttendanceLog attendanceLog  = new AttendanceLog();	   
	   					 
			   					
			   					
			   					                attendanceLog.setAttendanceAddress("北京");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.attendanceLogService.insert(attendanceLog);

      attendanceLog = this.attendanceLogService.getObjectById(id);

	  AttendanceLog attendanceLog2=this.attendanceLogService.getObjectById(id);
	    Assert.assertNotNull(attendanceLog2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 				   attendanceLog.setAttendanceAddress("上海");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.attendanceLogService.update(attendanceLog);		
		Assert.assertEquals(true, success);
		 AttendanceLog attendanceLog3=this.attendanceLogService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.attendanceLogService.delete(id);	
		Assert.assertEquals(true, success);
		AttendanceLog attendanceLog4=this.attendanceLogService.getObjectById(id);
		Assert.assertNull(attendanceLog4);
		
		//4.batchInsert
		 List<AttendanceLog> list=new ArrayList<AttendanceLog>();
	  	  AttendanceLog attendanceLog5  = new AttendanceLog();	   
	   					 
			   					
			   					
			   					                attendanceLog5.setAttendanceAddress("北京");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(attendanceLog5);	   
	  	  AttendanceLog attendanceLog6  = new AttendanceLog();	   
	   					 
			   					
			   					
			   					                attendanceLog6.setAttendanceAddress("上海");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(attendanceLog6);
	   List<AttendanceLog> insertResults= this.attendanceLogService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(AttendanceLog o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<AttendanceLog> getResults= this.attendanceLogService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(AttendanceLog o :insertResults){
//			this.attendanceLogService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

