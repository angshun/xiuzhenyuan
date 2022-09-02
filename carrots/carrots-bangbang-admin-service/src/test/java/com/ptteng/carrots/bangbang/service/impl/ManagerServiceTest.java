package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Manager;
import com.ptteng.carrots.bangbang.service.ManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class ManagerServiceTest {

	private static final Log log = LogFactory.getLog(ManagerServiceTest.class);
	
	private ManagerService managerService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-bangbang-admin-service/applicationContext-server.xml");
	        managerService = (ManagerService) context.getBean("managerService");
			//local server
			/**
			managerService = (ManagerService)  Naming.lookup("//localhost:20027/ManagerRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 managerService = (ManagerService) context.getBean("managerService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Manager manager  = new Manager();
	   					 
			   					
			   					
			   					
			   					                manager.setName("孙猴子");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.managerService.insert(manager);

      manager = this.managerService.getObjectById(id);

	  Manager manager2=this.managerService.getObjectById(id);
	    Assert.assertNotNull(manager2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 				   manager.setName("唐僧");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.managerService.update(manager);		
		Assert.assertEquals(true, success);
		 Manager manager3=this.managerService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.managerService.delete(id);	
		Assert.assertEquals(true, success);
		Manager manager4=this.managerService.getObjectById(id);
		Assert.assertNull(manager4);
		
		//4.batchInsert
		 List<Manager> list=new ArrayList<Manager>();
	  	  Manager manager5  = new Manager();
	   					 
			   					
			   					
			   					
			   					                manager5.setName("孙猴子");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(manager5);	   
	  	  Manager manager6  = new Manager();
	   					 
			   					
			   					
			   					
			   					                manager6.setName("唐僧");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(manager6);
	   List<Manager> insertResults= this.managerService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Manager o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Manager> getResults= this.managerService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Manager o :insertResults){
			this.managerService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

