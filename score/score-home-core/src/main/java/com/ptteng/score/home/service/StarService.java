package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.score.home.model.Star;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface StarService extends BaseDaoService {

	



   		   
		
		public Long insert(Star star)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Star> insertList(List<Star> starList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Star star)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Star> starList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Star getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Star> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getStarIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countStarIds() throws ServiceException, ServiceDaoException;
	

}

