/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.EnterpriseLog;
import com.ptteng.score.home.service.EnterpriseLogService;


import java.util.List;
import java.util.Map;

public class EnterpriseLogSCAClient implements EnterpriseLogService {

    private EnterpriseLogService enterpriseLogService;

	public EnterpriseLogService getEnterpriseLogService() {
		return enterpriseLogService;
	}
	
	
	public void setEnterpriseLogService(EnterpriseLogService enterpriseLogService) {
		this.enterpriseLogService =enterpriseLogService;
	}
	
	
			   
		@Override
		public Long insert(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.insert(enterpriseLog);
		          
		
		}	
		  
    	   
		@Override
		public List<EnterpriseLog> insertList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.insertList(enterpriseLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.update(enterpriseLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.updateList(enterpriseLogList);
		          
		
		}	
		  
    	   
		@Override
		public EnterpriseLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<EnterpriseLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return enterpriseLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getEnterpriseLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseLogService.getEnterpriseLogIds(start, limit);
	}

	@Override
	public Integer countEnterpriseLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseLogService.countEnterpriseLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   enterpriseLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.enterpriseLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

