package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.Department;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface DepartmentService extends BaseDaoService {

	



   		   
		
		public Long insert(Department department)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Department> insertList(List<Department> departmentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Department department)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Department> departmentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Department getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Department> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getDepartmentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countDepartmentIds() throws ServiceException, ServiceDaoException;
	

}

