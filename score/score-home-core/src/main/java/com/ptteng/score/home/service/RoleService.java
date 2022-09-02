package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.Role;

import java.util.List;

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

