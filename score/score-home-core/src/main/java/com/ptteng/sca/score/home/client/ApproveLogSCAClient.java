/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.ApproveLog;
import com.ptteng.score.home.service.ApproveLogService;


import java.util.List;
import java.util.Map;

public class ApproveLogSCAClient implements ApproveLogService {

    private ApproveLogService approveLogService;

	public ApproveLogService getApproveLogService() {
		return approveLogService;
	}
	
	
	public void setApproveLogService(ApproveLogService approveLogService) {
		this.approveLogService =approveLogService;
	}
	
	
			   
		@Override
		public Long insert(ApproveLog approveLog)throws ServiceException, ServiceDaoException{
		
		return approveLogService.insert(approveLog);
		          
		
		}	
		  
    	   
		@Override
		public List<ApproveLog> insertList(List<ApproveLog> approveLogList)throws ServiceException, ServiceDaoException{
		
		return approveLogService.insertList(approveLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return approveLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ApproveLog approveLog)throws ServiceException, ServiceDaoException{
		
		return approveLogService.update(approveLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ApproveLog> approveLogList)throws ServiceException, ServiceDaoException{
		
		return approveLogService.updateList(approveLogList);
		          
		
		}	
		  
    	   
		@Override
		public ApproveLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return approveLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ApproveLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return approveLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getApproveLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return approveLogService.getApproveLogIds(start, limit);
	}

	@Override
	public Integer countApproveLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return approveLogService.countApproveLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return approveLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return approveLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   approveLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.approveLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

