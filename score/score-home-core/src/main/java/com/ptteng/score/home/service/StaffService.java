package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.Staff;

import java.util.List;

@Remotable
public interface StaffService extends BaseDaoService {

	



   		   
		
		public Long insert(Staff staff)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Staff> insertList(List<Staff> staffList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Staff staff)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Staff> staffList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Staff getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Staff> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getStaffIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countStaffIds() throws ServiceException, ServiceDaoException;
	

}

