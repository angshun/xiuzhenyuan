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

import com.ptteng.score.admin.model.AllTypeScore;
import com.ptteng.score.admin.service.AllTypeScoreService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Ignore
public class AllTypeScoreServiceTest {

    private static final Log log = LogFactory.getLog(AllTypeScoreServiceTest.class);

    private AllTypeScoreService allTypeScoreService;


    @Before
    public void setUp() throws Exception {


        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
        allTypeScoreService = (AllTypeScoreService) context.getBean("allTypeScoreService");
//			123
        //local server
        /**
         allTypeScoreService = (AllTypeScoreService)  Naming.lookup("//localhost:10952/AllTypeScoreRMIService");
         **/

        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         allTypeScoreService = (AllTypeScoreService) context.getBean("allTypeScoreService");

         **/


    }








	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{

	 // 1.增加

	  	  AllTypeScore allTypeScore  = new AllTypeScore();










	  Long id= this.allTypeScoreService.insert(allTypeScore);

      allTypeScore = this.allTypeScoreService.getObjectById(id);

	  AllTypeScore allTypeScore2=this.allTypeScoreService.getObjectById(id);
	    Assert.assertNotNull(allTypeScore2);

		// 2. 更改
				 		 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.allTypeScoreService.update(allTypeScore);
		Assert.assertEquals(true, success);
		 AllTypeScore allTypeScore3=this.allTypeScoreService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.allTypeScoreService.delete(id);
		Assert.assertEquals(true, success);
		AllTypeScore allTypeScore4=this.allTypeScoreService.getObjectById(id);
		Assert.assertNull(allTypeScore4);

		//4.batchInsert
		 List<AllTypeScore> list=new ArrayList<AllTypeScore>();
	  	  AllTypeScore allTypeScore5  = new AllTypeScore();








			   	    list.add(allTypeScore5);
	  	  AllTypeScore allTypeScore6  = new AllTypeScore();








			   	   list.add(allTypeScore6);
	   List<AllTypeScore> insertResults= this.allTypeScoreService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(AllTypeScore o: insertResults){
		   ids.add(o.getId());
		}

	    List<AllTypeScore> getResults= this.allTypeScoreService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());


		 for(AllTypeScore o :insertResults){
//			this.allTypeScoreService.delete(o.getId());
}

		//6.batchUpdate

		}




		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{



		}


    @Test
    public long timeUtil1() {
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



	@Test
	public void testTimee() {
		int hour = 10;
		int minutes = 10;
		System.out.println(timeUtil1());
	}
}

