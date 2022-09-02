package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.OperationLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface OperationLogService extends BaseDaoService {

	



   		   
		
		public Long insert(OperationLog operationLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<OperationLog> insertList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(OperationLog operationLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public OperationLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<OperationLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getOperationLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countOperationLogIds() throws ServiceException, ServiceDaoException;
	

}

