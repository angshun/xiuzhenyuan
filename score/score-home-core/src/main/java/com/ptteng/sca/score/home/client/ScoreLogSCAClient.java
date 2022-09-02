/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.ScoreLog;
import com.ptteng.score.home.service.ScoreLogService;


import java.util.List;
import java.util.Map;

public class ScoreLogSCAClient implements ScoreLogService {

    private ScoreLogService scoreLogService;

	public ScoreLogService getScoreLogService() {
		return scoreLogService;
	}
	
	
	public void setScoreLogService(ScoreLogService scoreLogService) {
		this.scoreLogService =scoreLogService;
	}
	
	
			   
		@Override
		public Long insert(ScoreLog scoreLog)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.insert(scoreLog);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreLog> insertList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.insertList(scoreLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ScoreLog scoreLog)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.update(scoreLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.updateList(scoreLogList);
		          
		
		}	
		  
    	   
		@Override
		public ScoreLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return scoreLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getScoreLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreLogService.getScoreLogIds(start, limit);
	}

	@Override
	public Integer countScoreLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreLogService.countScoreLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   scoreLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.scoreLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

