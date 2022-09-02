package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.ScoreExchangeApproval;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ScoreExchangeApprovalService extends BaseDaoService {

	



   		   
		
		public Long insert(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreExchangeApproval> insertList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ScoreExchangeApproval getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreExchangeApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getScoreExchangeApprovalIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countScoreExchangeApprovalIds() throws ServiceException, ServiceDaoException;
	

}

