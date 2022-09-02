package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.EnterpriseApproval;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface EnterpriseApprovalService extends BaseDaoService {

	



   		   
		
		public Long insert(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<EnterpriseApproval> insertList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public EnterpriseApproval getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<EnterpriseApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getEnterpriseApprovalIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countEnterpriseApprovalIds() throws ServiceException, ServiceDaoException;
	

}

