/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.Department;
import com.ptteng.score.admin.service.DepartmentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DepartmentSCAClient implements DepartmentService {

    private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService =departmentService;
	}
	
	
			   
		@Override
		public Long insert(Department department)throws ServiceException, ServiceDaoException{
		
		return departmentService.insert(department);
		          
		
		}	
		  
    	   
		@Override
		public List<Department> insertList(List<Department> departmentList)throws ServiceException, ServiceDaoException{
		
		return departmentService.insertList(departmentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return departmentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Department department)throws ServiceException, ServiceDaoException{
		
		return departmentService.update(department);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Department> departmentList)throws ServiceException, ServiceDaoException{
		
		return departmentService.updateList(departmentList);
		          
		
		}	
		  
    	   
		@Override
		public Department getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return departmentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Department> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return departmentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getDepartmentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return departmentService.getDepartmentIds(start, limit);
	}

	@Override
	public Integer countDepartmentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return departmentService.countDepartmentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return departmentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return departmentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   departmentService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.departmentService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

