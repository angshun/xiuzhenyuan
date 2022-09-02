package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.Manager;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ManagerService extends BaseDaoService {

	



   		   
		
		public Long insert(Manager manager)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Manager> insertList(List<Manager> managerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Manager manager)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Manager> managerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Manager getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Manager> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;




	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getManagerIdsByRoleID(Long rid, Integer start,
											Integer limit) throws ServiceException, ServiceDaoException;

	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getManagerIdsByRoleIDAndStatus(Long rid, String status, Integer start,
													 Integer limit) throws ServiceException, ServiceDaoException;









	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getManagerIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countManagerIds() throws ServiceException, ServiceDaoException;
	

}

