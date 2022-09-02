package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.CopyRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

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

