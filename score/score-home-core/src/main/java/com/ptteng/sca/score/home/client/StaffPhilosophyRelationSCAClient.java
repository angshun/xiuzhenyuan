/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.StaffPhilosophyRelation;
import com.ptteng.score.home.service.StaffPhilosophyRelationService;


import java.util.List;
import java.util.Map;

public class StaffPhilosophyRelationSCAClient implements StaffPhilosophyRelationService {

    private StaffPhilosophyRelationService staffPhilosophyRelationService;

	public StaffPhilosophyRelationService getStaffPhilosophyRelationService() {
		return staffPhilosophyRelationService;
	}
	
	
	public void setStaffPhilosophyRelationService(StaffPhilosophyRelationService staffPhilosophyRelationService) {
		this.staffPhilosophyRelationService =staffPhilosophyRelationService;
	}
	
	
			   
		@Override
		public Long insert(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.insert(staffPhilosophyRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<StaffPhilosophyRelation> insertList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.insertList(staffPhilosophyRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.update(staffPhilosophyRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.updateList(staffPhilosophyRelationList);
		          
		
		}	
		  
    	   
		@Override
		public StaffPhilosophyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<StaffPhilosophyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return staffPhilosophyRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getStaffPhilosophyRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffPhilosophyRelationService.getStaffPhilosophyRelationIds(start, limit);
	}

	@Override
	public Integer countStaffPhilosophyRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffPhilosophyRelationService.countStaffPhilosophyRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffPhilosophyRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffPhilosophyRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   staffPhilosophyRelationService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.staffPhilosophyRelationService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

