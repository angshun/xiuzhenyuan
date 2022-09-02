package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.RewardLog;

import java.util.List;

@Remotable
public interface RewardLogService extends BaseDaoService {

	



   		   
		
		public Long insert(RewardLog rewardLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RewardLog> insertList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(RewardLog rewardLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public RewardLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RewardLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getRewardLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countRewardLogIds() throws ServiceException, ServiceDaoException;
	

}

