/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.service.StaffService;
import com.ptteng.score.home.model.Staff;


import java.util.List;
import java.util.Map;

public class StaffSCAClient implements StaffService {

    private StaffService staffService;

	public StaffService getStaffService() {
		return staffService;
	}
	
	
	public void setStaffService(StaffService staffService) {
		this.staffService =staffService;
	}
	
	
			   
		@Override
		public Long insert(Staff staff)throws ServiceException, ServiceDaoException{
		
		return staffService.insert(staff);
		          
		
		}	
		  
    	   
		@Override
		public List<Staff> insertList(List<Staff> staffList)throws ServiceException, ServiceDaoException{
		
		return staffService.insertList(staffList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return staffService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Staff staff)throws ServiceException, ServiceDaoException{
		
		return staffService.update(staff);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Staff> staffList)throws ServiceException, ServiceDaoException{
		
		return staffService.updateList(staffList);
		          
		
		}	
		  
    	   
		@Override
		public Staff getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return staffService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Staff> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return staffService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getStaffIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffService.getStaffIds(start, limit);
	}

	@Override
	public Integer countStaffIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffService.countStaffIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return staffService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   staffService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.staffService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

