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

import com.ptteng.score.admin.model.ScoreExchangeApproval;
import com.ptteng.score.admin.service.ScoreExchangeApprovalService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ScoreExchangeApprovalServiceTest {

	private static final Log log = LogFactory.getLog(ScoreExchangeApprovalServiceTest.class);
	
	private ScoreExchangeApprovalService scoreExchangeApprovalService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/score-admin-service/applicationContext-server.xml");
	        scoreExchangeApprovalService = (ScoreExchangeApprovalService) context.getBean("scoreExchangeApprovalService");
			//local server
			/**
			scoreExchangeApprovalService = (ScoreExchangeApprovalService)  Naming.lookup("//localhost:10952/ScoreExchangeApprovalRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 scoreExchangeApprovalService = (ScoreExchangeApprovalService) context.getBean("scoreExchangeApprovalService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	


		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

