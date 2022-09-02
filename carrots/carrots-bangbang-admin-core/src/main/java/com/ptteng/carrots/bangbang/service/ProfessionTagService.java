package com.ptteng.carrots.bangbang.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ProfessionTagService extends BaseDaoService {

	



   		   
		
		public Long insert(ProfessionTag professionTag)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ProfessionTag> insertList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ProfessionTag professionTag)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ProfessionTag getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ProfessionTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getProfessionTagIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countProfessionTagIds() throws ServiceException, ServiceDaoException;
	

}

