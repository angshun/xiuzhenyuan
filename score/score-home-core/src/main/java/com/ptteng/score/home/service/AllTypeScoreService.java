package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import com.ptteng.score.home.model.AllTypeScore;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface AllTypeScoreService extends BaseDaoService {

	



   		   
		
		public Long insert(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AllTypeScore> insertList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AllTypeScore getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AllTypeScore> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getAllTypeScoreIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countAllTypeScoreIds() throws ServiceException, ServiceDaoException;
	

}

