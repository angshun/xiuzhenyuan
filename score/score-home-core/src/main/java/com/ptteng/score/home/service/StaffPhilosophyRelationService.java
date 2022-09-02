package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.score.home.model.StaffPhilosophyRelation;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface StaffPhilosophyRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<StaffPhilosophyRelation> insertList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public StaffPhilosophyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<StaffPhilosophyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getStaffPhilosophyRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countStaffPhilosophyRelationIds() throws ServiceException, ServiceDaoException;
	

}

