package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.StaffTaskRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface StaffTaskRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<StaffTaskRelation> insertList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public StaffTaskRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<StaffTaskRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getStaffTaskRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countStaffTaskRelationIds() throws ServiceException, ServiceDaoException;
	

}

