package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.AttendanceLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

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

