/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.service.ScoreExchangeApprovalService;
import com.ptteng.score.home.model.ScoreExchangeApproval;


import java.util.List;
import java.util.Map;

public class ScoreExchangeApprovalSCAClient implements ScoreExchangeApprovalService {

    private ScoreExchangeApprovalService scoreExchangeApprovalService;

	public ScoreExchangeApprovalService getScoreExchangeApprovalService() {
		return scoreExchangeApprovalService;
	}
	
	
	public void setScoreExchangeApprovalService(ScoreExchangeApprovalService scoreExchangeApprovalService) {
		this.scoreExchangeApprovalService =scoreExchangeApprovalService;
	}
	
	
			   
		@Override
		public Long insert(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.insert(scoreExchangeApproval);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreExchangeApproval> insertList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.insertList(scoreExchangeApprovalList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.update(scoreExchangeApproval);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.updateList(scoreExchangeApprovalList);
		          
		
		}	
		  
    	   
		@Override
		public ScoreExchangeApproval getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreExchangeApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return scoreExchangeApprovalService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getScoreExchangeApprovalIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreExchangeApprovalService.getScoreExchangeApprovalIds(start, limit);
	}

	@Override
	public Integer countScoreExchangeApprovalIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreExchangeApprovalService.countScoreExchangeApprovalIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreExchangeApprovalService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreExchangeApprovalService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   scoreExchangeApprovalService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.scoreExchangeApprovalService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

