package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.ScoreLog;

import java.util.List;

@Remotable
public interface ScoreLogService extends BaseDaoService {

	



   		   
		
		public Long insert(ScoreLog scoreLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreLog> insertList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ScoreLog scoreLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ScoreLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getScoreLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countScoreLogIds() throws ServiceException, ServiceDaoException;
	

}

