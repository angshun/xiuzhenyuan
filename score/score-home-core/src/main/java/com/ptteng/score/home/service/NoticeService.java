package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.Notice;

import java.util.List;

@Remotable
public interface NoticeService extends BaseDaoService {

	



   		   
		
		public Long insert(Notice notice)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Notice> insertList(List<Notice> noticeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Notice notice)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Notice> noticeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Notice getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Notice> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getNoticeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countNoticeIds() throws ServiceException, ServiceDaoException;
	

}

