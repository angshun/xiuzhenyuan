package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;
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
public class ProfessionTagServiceTest {

	private static final Log log = LogFactory.getLog(ProfessionTagServiceTest.class);
	
	private ProfessionTagService professionTagService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-bangbang-admin-service/applicationContext-server.xml");
	        professionTagService = (ProfessionTagService) context.getBean("professionTagService");
			//local server
			/**
			professionTagService = (ProfessionTagService)  Naming.lookup("//localhost:20027/ProfessionTagRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 professionTagService = (ProfessionTagService) context.getBean("professionTagService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ProfessionTag professionTag  = new ProfessionTag();
	   					 
			   					
			   					
			   					                professionTag.setTag("初级工程师");
            
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.professionTagService.insert(professionTag);

      professionTag = this.professionTagService.getObjectById(id);

	  ProfessionTag professionTag2=this.professionTagService.getObjectById(id);
	    Assert.assertNotNull(professionTag2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 				   professionTag.setTag("史诗工程师");
		    		 				 		 				 		 				 					 				 					 				boolean success=this.professionTagService.update(professionTag);		
		Assert.assertEquals(true, success);
		 ProfessionTag professionTag3=this.professionTagService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.professionTagService.delete(id);	
		Assert.assertEquals(true, success);
		ProfessionTag professionTag4=this.professionTagService.getObjectById(id);
		Assert.assertNull(professionTag4);
		
		//4.batchInsert
		 List<ProfessionTag> list=new ArrayList<ProfessionTag>();
	  	  ProfessionTag professionTag5  = new ProfessionTag();
	   					 
			   					
			   					
			   					                professionTag5.setTag("初级工程师");
            
			   					 
			   					 
			   					
			   					
			   	    list.add(professionTag5);	   
	  	  ProfessionTag professionTag6  = new ProfessionTag();
	   					 
			   					
			   					
			   					                professionTag6.setTag("史诗工程师");
            
			   					 
			   					 
			   					
			   					
			   	   list.add(professionTag6);
	   List<ProfessionTag> insertResults= this.professionTagService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ProfessionTag o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ProfessionTag> getResults= this.professionTagService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ProfessionTag o :insertResults){
			this.professionTagService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

