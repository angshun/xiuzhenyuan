/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.OperationLog;
import com.ptteng.score.admin.service.OperationLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class OperationLogSCAClient implements OperationLogService {

    private OperationLogService operationLogService;

	public OperationLogService getOperationLogService() {
		return operationLogService;
	}
	
	
	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService =operationLogService;
	}
	
	
			   
		@Override
		public Long insert(OperationLog operationLog)throws ServiceException, ServiceDaoException{
		
		return operationLogService.insert(operationLog);
		          
		
		}	
		  
    	   
		@Override
		public List<OperationLog> insertList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException{
		
		return operationLogService.insertList(operationLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return operationLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(OperationLog operationLog)throws ServiceException, ServiceDaoException{
		
		return operationLogService.update(operationLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException{
		
		return operationLogService.updateList(operationLogList);
		          
		
		}	
		  
    	   
		@Override
		public OperationLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return operationLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<OperationLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return operationLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getOperationLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return operationLogService.getOperationLogIds(start, limit);
	}

	@Override
	public Integer countOperationLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return operationLogService.countOperationLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return operationLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return operationLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   operationLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.operationLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

