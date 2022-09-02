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

import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.StaffService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class StaffServiceTest {

	private static final Log log = LogFactory.getLog(StaffServiceTest.class);
	
	private StaffService staffService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        staffService = (StaffService) context.getBean("staffService");
			//local server
			/**
			staffService = (StaffService)  Naming.lookup("//localhost:10952/StaffRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 staffService = (StaffService) context.getBean("staffService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Staff staff  = new Staff();	   
	   					 
			   					                staff.setName("范冰冰");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.staffService.insert(staff);

      staff = this.staffService.getObjectById(id);

	  Staff staff2=this.staffService.getObjectById(id);
	    Assert.assertNotNull(staff2);
	  
		// 2. 更改 
				 		 				 				   staff.setName("李晨");
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.staffService.update(staff);		
		Assert.assertEquals(true, success);
		 Staff staff3=this.staffService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.staffService.delete(id);	
		Assert.assertEquals(true, success);
		Staff staff4=this.staffService.getObjectById(id);
		Assert.assertNull(staff4);
		
		//4.batchInsert
		 List<Staff> list=new ArrayList<Staff>();
	  	  Staff staff5  = new Staff();	   
	   					 
			   					                staff5.setName("范冰冰");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(staff5);	   
	  	  Staff staff6  = new Staff();	   
	   					 
			   					                staff6.setName("李晨");
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(staff6);
	   List<Staff> insertResults= this.staffService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Staff o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Staff> getResults= this.staffService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Staff o :insertResults){
//			this.staffService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

