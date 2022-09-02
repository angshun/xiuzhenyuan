package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.EnterpriseLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface EnterpriseLogService extends BaseDaoService {

	



   		   
		
		public Long insert(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<EnterpriseLog> insertList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public EnterpriseLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<EnterpriseLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getEnterpriseLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countEnterpriseLogIds() throws ServiceException, ServiceDaoException;
	

}

