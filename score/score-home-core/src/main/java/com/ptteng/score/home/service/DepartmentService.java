package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.Department;

import java.util.List;

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

