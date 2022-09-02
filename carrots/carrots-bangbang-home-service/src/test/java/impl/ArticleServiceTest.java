package impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Article;
import com.ptteng.carrots.bangbang.service.ArticleService;
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
public class ArticleServiceTest {

	private static final Log log = LogFactory.getLog(ArticleServiceTest.class);
	
	private ArticleService articleService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-bangbang-home-service/applicationContext-server.xml");
	        articleService = (ArticleService) context.getBean("articleService");
			//local server
			/**
			articleService = (ArticleService)  Naming.lookup("//localhost:20026/ArticleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 articleService = (ArticleService) context.getBean("articleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Article article  = new Article();
	   					 
			   					
			   					                article.setTitle("百分之99的人看了都会流泪");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   					
			   	 
	 
	  Long id= this.articleService.insert(article);

      article = this.articleService.getObjectById(id);

	  Article article2=this.articleService.getObjectById(id);
	    Assert.assertNotNull(article2);
	  
		// 2. 更改 
				 		 				 					 				 				   article.setTitle("就不流泪");
		    		 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				 					 				boolean success=this.articleService.update(article);		
		Assert.assertEquals(true, success);
		 Article article3=this.articleService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				             		 				//3.删除
		boolean successDelete=this.articleService.delete(id);	
		Assert.assertEquals(true, success);
		Article article4=this.articleService.getObjectById(id);
		Assert.assertNull(article4);
		
		//4.batchInsert
		 List<Article> list=new ArrayList<Article>();
	  	  Article article5  = new Article();
	   					 
			   					
			   					                article5.setTitle("百分之99的人看了都会流泪");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   					
			   	    list.add(article5);	   
	  	  Article article6  = new Article();
	   					 
			   					
			   					                article6.setTitle("就不流泪");
            
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   					
			   	   list.add(article6);
	   List<Article> insertResults= this.articleService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Article o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Article> getResults= this.articleService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Article o :insertResults){
			this.articleService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		}
}

