/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.RewardLog;
import com.ptteng.score.admin.service.RewardLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class RewardLogSCAClient implements RewardLogService {

    private RewardLogService rewardLogService;

	public RewardLogService getRewardLogService() {
		return rewardLogService;
	}
	
	
	public void setRewardLogService(RewardLogService rewardLogService) {
		this.rewardLogService =rewardLogService;
	}
	
	
			   
		@Override
		public Long insert(RewardLog rewardLog)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.insert(rewardLog);
		          
		
		}	
		  
    	   
		@Override
		public List<RewardLog> insertList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.insertList(rewardLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(RewardLog rewardLog)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.update(rewardLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.updateList(rewardLogList);
		          
		
		}	
		  
    	   
		@Override
		public RewardLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<RewardLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return rewardLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getRewardLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return rewardLogService.getRewardLogIds(start, limit);
	}

	@Override
	public Integer countRewardLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return rewardLogService.countRewardLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return rewardLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return rewardLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   rewardLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.rewardLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

