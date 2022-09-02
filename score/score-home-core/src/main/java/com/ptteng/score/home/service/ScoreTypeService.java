package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.score.home.model.ScoreType;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ScoreTypeService extends BaseDaoService {

	



   		   
		
		public Long insert(ScoreType scoreType)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreType> insertList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ScoreType scoreType)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ScoreType getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ScoreType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getScoreTypeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countScoreTypeIds() throws ServiceException, ServiceDaoException;
	

}

