package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import org.osoa.sca.annotations.Remotable;
import com.ptteng.score.home.model.DailyAttendance;

import java.util.List;

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

