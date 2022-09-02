package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.CopyRelation;

import java.util.List;

@Remotable
public interface CopyRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(CopyRelation copyRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CopyRelation> insertList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(CopyRelation copyRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public CopyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CopyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getCopyRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countCopyRelationIds() throws ServiceException, ServiceDaoException;
	

}

