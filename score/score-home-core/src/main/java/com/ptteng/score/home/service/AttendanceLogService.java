package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.AttendanceLog;

import java.util.List;

@Remotable
public interface AttendanceLogService extends BaseDaoService {

	



   		   
		
		public Long insert(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AttendanceLog> insertList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AttendanceLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AttendanceLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getAttendanceLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countAttendanceLogIds() throws ServiceException, ServiceDaoException;
	

}

