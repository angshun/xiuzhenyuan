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

import com.ptteng.score.admin.model.Department;
import com.ptteng.score.admin.service.DepartmentService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DepartmentServiceTest {

	private static final Log log = LogFactory.getLog(DepartmentServiceTest.class);
	
	private DepartmentService departmentService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        departmentService = (DepartmentService) context.getBean("departmentService");
			//local server
			/**
			departmentService = (DepartmentService)  Naming.lookup("//localhost:10952/DepartmentRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 departmentService = (DepartmentService) context.getBean("departmentService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Department department  = new Department();	   
	   					 
			   					                department.setName("司法部");
            
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.departmentService.insert(department);

      department = this.departmentService.getObjectById(id);

	  Department department2=this.departmentService.getObjectById(id);
	    Assert.assertNotNull(department2);
	  
		// 2. 更改 
				 		 				 				   department.setName("武警部");
		    		 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.departmentService.update(department);		
		Assert.assertEquals(true, success);
		 Department department3=this.departmentService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.departmentService.delete(id);	
		Assert.assertEquals(true, success);
		Department department4=this.departmentService.getObjectById(id);
		Assert.assertNull(department4);
		
		//4.batchInsert
		 List<Department> list=new ArrayList<Department>();
	  	  Department department5  = new Department();	   
	   					 
			   					                department5.setName("司法部");
            
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(department5);	   
	  	  Department department6  = new Department();	   
	   					 
			   					                department6.setName("武警部");
            
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(department6);
	   List<Department> insertResults= this.departmentService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Department o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Department> getResults= this.departmentService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Department o :insertResults){
//			this.departmentService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

