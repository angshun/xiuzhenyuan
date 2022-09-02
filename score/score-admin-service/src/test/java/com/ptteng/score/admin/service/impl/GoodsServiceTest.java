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

import com.ptteng.score.admin.model.Goods;
import com.ptteng.score.admin.service.GoodsService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class GoodsServiceTest {

	private static final Log log = LogFactory.getLog(GoodsServiceTest.class);
	
	private GoodsService goodsService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        goodsService = (GoodsService) context.getBean("goodsService");
			//local server
			/**
			goodsService = (GoodsService)  Naming.lookup("//localhost:10952/GoodsRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 goodsService = (GoodsService) context.getBean("goodsService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Goods goods  = new Goods();	   
	   					 
			   					                goods.setName("洗手液");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.goodsService.insert(goods);

      goods = this.goodsService.getObjectById(id);

	  Goods goods2=this.goodsService.getObjectById(id);
	    Assert.assertNotNull(goods2);
	  
		// 2. 更改 
				 		 				 				   goods.setName("爽肤水");
		    		 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.goodsService.update(goods);		
		Assert.assertEquals(true, success);
		 Goods goods3=this.goodsService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.goodsService.delete(id);	
		Assert.assertEquals(true, success);
		Goods goods4=this.goodsService.getObjectById(id);
		Assert.assertNull(goods4);
		
		//4.batchInsert
		 List<Goods> list=new ArrayList<Goods>();
	  	  Goods goods5  = new Goods();	   
	   					 
			   					                goods5.setName("洗手液");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(goods5);	   
	  	  Goods goods6  = new Goods();	   
	   					 
			   					                goods6.setName("爽肤水");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(goods6);
	   List<Goods> insertResults= this.goodsService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Goods o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Goods> getResults= this.goodsService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Goods o :insertResults){
//			this.goodsService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

