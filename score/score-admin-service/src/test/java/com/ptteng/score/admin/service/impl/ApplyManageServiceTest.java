package com.ptteng.score.admin.service.impl;

import java.util.Calendar;
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

import com.ptteng.score.admin.model.ApplyManage;
import com.ptteng.score.admin.service.ApplyManageService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ApplyManageServiceTest {

	private static final Log log = LogFactory.getLog(ApplyManageServiceTest.class);
	
	private ApplyManageService applyManageService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        applyManageService = (ApplyManageService) context.getBean("applyManageService");
			//local server
			/**
			applyManageService = (ApplyManageService)  Naming.lookup("//localhost:10952/ApplyManageRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 applyManageService = (ApplyManageService) context.getBean("applyManageService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
//	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ApplyManage applyManage  = new ApplyManage();	   
	   					 
			   					                applyManage.setModuleId(1L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.applyManageService.insert(applyManage);

      applyManage = this.applyManageService.getObjectById(id);

	  ApplyManage applyManage2=this.applyManageService.getObjectById(id);
	    Assert.assertNotNull(applyManage2);
	  
		// 2. 更改 
				 		 				 				   applyManage.setModuleId(2L);
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.applyManageService.update(applyManage);		
		Assert.assertEquals(true, success);
		 ApplyManage applyManage3=this.applyManageService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.applyManageService.delete(id);	
		Assert.assertEquals(true, success);
		ApplyManage applyManage4=this.applyManageService.getObjectById(id);
		Assert.assertNull(applyManage4);
		
		//4.batchInsert
		 List<ApplyManage> list=new ArrayList<ApplyManage>();
	  	  ApplyManage applyManage5  = new ApplyManage();	   
	   					 
			   					                applyManage5.setModuleId(1L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(applyManage5);	   
	  	  ApplyManage applyManage6  = new ApplyManage();	   
	   					 
			   					                applyManage6.setModuleId(2L);
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(applyManage6);
	   List<ApplyManage> insertResults= this.applyManageService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ApplyManage o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ApplyManage> getResults= this.applyManageService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ApplyManage o :insertResults){
//			this.applyManageService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
//		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		}


	@Test
	public long timeUtil1(/*int hour,int minutes*/) {
        /*
        时间处理方法
         */
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, -12);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long time = cal.toInstant().toEpochMilli();
		return time;
	}

}

