/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.Philosophy;
import com.ptteng.score.admin.service.PhilosophyService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PhilosophySCAClient implements PhilosophyService {

    private PhilosophyService philosophyService;

	public PhilosophyService getPhilosophyService() {
		return philosophyService;
	}
	
	
	public void setPhilosophyService(PhilosophyService philosophyService) {
		this.philosophyService =philosophyService;
	}
	
	
			   
		@Override
		public Long insert(Philosophy philosophy)throws ServiceException, ServiceDaoException{
		
		return philosophyService.insert(philosophy);
		          
		
		}	
		  
    	   
		@Override
		public List<Philosophy> insertList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException{
		
		return philosophyService.insertList(philosophyList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return philosophyService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Philosophy philosophy)throws ServiceException, ServiceDaoException{
		
		return philosophyService.update(philosophy);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException{
		
		return philosophyService.updateList(philosophyList);
		          
		
		}	
		  
    	   
		@Override
		public Philosophy getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return philosophyService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Philosophy> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return philosophyService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getPhilosophyIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return philosophyService.getPhilosophyIds(start, limit);
	}

	@Override
	public Integer countPhilosophyIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return philosophyService.countPhilosophyIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return philosophyService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return philosophyService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   philosophyService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.philosophyService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

