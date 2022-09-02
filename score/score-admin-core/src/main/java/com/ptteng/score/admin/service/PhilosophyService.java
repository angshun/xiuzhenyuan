package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.Philosophy;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

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

