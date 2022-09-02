/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.Star;
import com.ptteng.score.home.service.StarService;


import java.util.List;
import java.util.Map;

public class StarSCAClient implements StarService {

    private StarService starService;

	public StarService getStarService() {
		return starService;
	}
	
	
	public void setStarService(StarService starService) {
		this.starService =starService;
	}
	
	
			   
		@Override
		public Long insert(Star star)throws ServiceException, ServiceDaoException{
		
		return starService.insert(star);
		          
		
		}	
		  
    	   
		@Override
		public List<Star> insertList(List<Star> starList)throws ServiceException, ServiceDaoException{
		
		return starService.insertList(starList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return starService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Star star)throws ServiceException, ServiceDaoException{
		
		return starService.update(star);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Star> starList)throws ServiceException, ServiceDaoException{
		
		return starService.updateList(starList);
		          
		
		}	
		  
    	   
		@Override
		public Star getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return starService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Star> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return starService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getStarIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return starService.getStarIds(start, limit);
	}

	@Override
	public Integer countStarIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return starService.countStarIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return starService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return starService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   starService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.starService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

