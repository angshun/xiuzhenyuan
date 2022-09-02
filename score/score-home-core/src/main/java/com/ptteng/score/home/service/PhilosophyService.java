package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.Philosophy;

import java.util.List;

@Remotable
public interface PhilosophyService extends BaseDaoService {

	



   		   
		
		public Long insert(Philosophy philosophy)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Philosophy> insertList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Philosophy philosophy)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Philosophy getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Philosophy> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getPhilosophyIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countPhilosophyIds() throws ServiceException, ServiceDaoException;
	

}

