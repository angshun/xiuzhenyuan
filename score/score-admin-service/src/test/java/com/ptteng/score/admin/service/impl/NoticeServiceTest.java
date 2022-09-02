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

import com.ptteng.score.admin.model.Notice;
import com.ptteng.score.admin.service.NoticeService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class NoticeServiceTest {

	private static final Log log = LogFactory.getLog(NoticeServiceTest.class);
	
	private NoticeService noticeService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        noticeService = (NoticeService) context.getBean("noticeService");
			//local server
			/**
			noticeService = (NoticeService)  Naming.lookup("//localhost:10952/NoticeRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 noticeService = (NoticeService) context.getBean("noticeService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Notice notice  = new Notice();	   
	   					 
			   					                notice.setContent("11");
            
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.noticeService.insert(notice);

      notice = this.noticeService.getObjectById(id);

	  Notice notice2=this.noticeService.getObjectById(id);
	    Assert.assertNotNull(notice2);
	  
		// 2. 更改 
				 		 				 				   notice.setContent("11");
		    		 				 		 				 		 				 					 				 					 				boolean success=this.noticeService.update(notice);		
		Assert.assertEquals(true, success);
		 Notice notice3=this.noticeService.getObjectById(id);
				 		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.noticeService.delete(id);	
		Assert.assertEquals(true, success);
		Notice notice4=this.noticeService.getObjectById(id);
		Assert.assertNull(notice4);
		
		//4.batchInsert
		 List<Notice> list=new ArrayList<Notice>();
	  	  Notice notice5  = new Notice();	   
	   					 
			   					                notice5.setContent("11");
            
			   					 
			   					 
			   					
			   					
			   	    list.add(notice5);	   
	  	  Notice notice6  = new Notice();	   
	   					 
			   					                notice6.setContent("11");
            
			   					 
			   					 
			   					
			   					
			   	   list.add(notice6);
	   List<Notice> insertResults= this.noticeService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Notice o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Notice> getResults= this.noticeService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Notice o :insertResults){
//			this.noticeService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

