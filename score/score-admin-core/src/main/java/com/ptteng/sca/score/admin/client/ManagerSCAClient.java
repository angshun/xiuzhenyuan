/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.Manager;
import com.ptteng.score.admin.service.ManagerService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ManagerSCAClient implements ManagerService {

    private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}
	
	
	public void setManagerService(ManagerService managerService) {
		this.managerService =managerService;
	}
	
	
			   
		@Override
		public Long insert(Manager manager)throws ServiceException, ServiceDaoException{
		
		return managerService.insert(manager);
		          
		
		}	
		  
    	   
		@Override
		public List<Manager> insertList(List<Manager> managerList)throws ServiceException, ServiceDaoException{
		
		return managerService.insertList(managerList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return managerService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Manager manager)throws ServiceException, ServiceDaoException{
		
		return managerService.update(manager);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Manager> managerList)throws ServiceException, ServiceDaoException{
		
		return managerService.updateList(managerList);
		          
		
		}	
		  
    	   
		@Override
		public Manager getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return managerService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Manager> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return managerService.getObjectsByIds(ids);
		          
		
		}




	@Override
	public List<Long> getManagerIdsByRoleID(Long rid, Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		return managerService.getManagerIdsByRoleID(rid, start, limit);

	}

	@Override
	public List<Long> getManagerIdsByRoleIDAndStatus(Long rid, String status, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		return managerService.getManagerIdsByRoleIDAndStatus(rid, status, start, limit);

	}











	@Override
	public List<Long> getManagerIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return managerService.getManagerIds(start, limit);
	}

	@Override
	public Integer countManagerIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return managerService.countManagerIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return managerService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return managerService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   managerService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.managerService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

