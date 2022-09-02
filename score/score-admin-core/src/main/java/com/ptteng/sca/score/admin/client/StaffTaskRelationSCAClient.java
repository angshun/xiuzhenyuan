/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.StaffTaskRelation;
import com.ptteng.score.admin.service.StaffTaskRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class StaffTaskRelationSCAClient implements StaffTaskRelationService {

    private StaffTaskRelationService staffTaskRelationService;

	public StaffTaskRelationService getStaffTaskRelationService() {
		return staffTaskRelationService;
	}
	
	
	public void setStaffTaskRelationService(StaffTaskRelationService staffTaskRelationService) {
		this.staffTaskRelationService =staffTaskRelationService;
	}
	
	
			   
		@Override
		public Long insert(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.insert(staffTaskRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<StaffTaskRelation> insertList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.insertList(staffTaskRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.update(staffTaskRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.updateList(staffTaskRelationList);
		          
		
		}	
		  
    	   
		@Override
		public StaffTaskRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<StaffTaskRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return staffTaskRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getStaffTaskRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffTaskRelationService.getStaffTaskRelationIds(start, limit);
	}

	@Override
	public Integer countStaffTaskRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffTaskRelationService.countStaffTaskRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffTaskRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffTaskRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   staffTaskRelationService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.staffTaskRelationService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

