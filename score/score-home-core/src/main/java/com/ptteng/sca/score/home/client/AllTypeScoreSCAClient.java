/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.AllTypeScore;
import com.ptteng.score.home.service.AllTypeScoreService;


import java.util.List;
import java.util.Map;

public class AllTypeScoreSCAClient implements AllTypeScoreService {

    private AllTypeScoreService allTypeScoreService;

	public AllTypeScoreService getAllTypeScoreService() {
		return allTypeScoreService;
	}
	
	
	public void setAllTypeScoreService(AllTypeScoreService allTypeScoreService) {
		this.allTypeScoreService =allTypeScoreService;
	}
	
	
			   
		@Override
		public Long insert(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.insert(allTypeScore);
		          
		
		}	
		  
    	   
		@Override
		public List<AllTypeScore> insertList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.insertList(allTypeScoreList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.update(allTypeScore);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.updateList(allTypeScoreList);
		          
		
		}	
		  
    	   
		@Override
		public AllTypeScore getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<AllTypeScore> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return allTypeScoreService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAllTypeScoreIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return allTypeScoreService.getAllTypeScoreIds(start, limit);
	}

	@Override
	public Integer countAllTypeScoreIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return allTypeScoreService.countAllTypeScoreIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return allTypeScoreService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return allTypeScoreService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   allTypeScoreService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.allTypeScoreService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

