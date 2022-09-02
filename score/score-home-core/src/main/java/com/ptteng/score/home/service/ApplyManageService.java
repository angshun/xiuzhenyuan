package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import com.ptteng.score.home.model.ApplyManage;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ApplyManageService extends BaseDaoService {

	



   		   
		
		public Long insert(ApplyManage applyManage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ApplyManage> insertList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ApplyManage applyManage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ApplyManage getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ApplyManage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getApplyManageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countApplyManageIds() throws ServiceException, ServiceDaoException;
	

}

