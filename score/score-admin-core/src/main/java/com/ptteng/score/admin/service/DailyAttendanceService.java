package com.ptteng.score.admin.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.score.admin.model.DailyAttendance;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface DailyAttendanceService extends BaseDaoService {

	



   		   
		
		public Long insert(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DailyAttendance> insertList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DailyAttendance getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DailyAttendance> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getDailyAttendanceIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countDailyAttendanceIds() throws ServiceException, ServiceDaoException;
	

}

