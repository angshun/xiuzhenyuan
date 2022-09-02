package com.ptteng.carrots.bangbang.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Manager;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ManagerService extends BaseDaoService {

	



   		   
		
		public Long insert(Manager manager)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Manager> insertList(List<Manager> managerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Manager manager)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Manager> managerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Manager getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Manager> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getManagerIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countManagerIds() throws ServiceException, ServiceDaoException;
	

}

