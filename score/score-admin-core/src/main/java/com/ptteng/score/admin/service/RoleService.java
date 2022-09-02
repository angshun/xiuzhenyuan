package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.Role;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface RoleService extends BaseDaoService {

	



   		   
		
		public Long insert(Role role)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Role> insertList(List<Role> roleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Role role)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Role> roleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Role getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Role> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countRoleIds() throws ServiceException, ServiceDaoException;
	

}

