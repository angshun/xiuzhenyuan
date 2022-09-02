package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.Task;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface TaskService extends BaseDaoService {

	



   		   
		
		public Long insert(Task task)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Task> insertList(List<Task> taskList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Task task)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Task> taskList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Task getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Task> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getTaskIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countTaskIds() throws ServiceException, ServiceDaoException;
	

}

