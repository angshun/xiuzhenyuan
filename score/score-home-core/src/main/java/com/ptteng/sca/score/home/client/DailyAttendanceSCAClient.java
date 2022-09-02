/**
 * 
 */
package com.ptteng.sca.score.home.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.home.model.DailyAttendance;
import com.ptteng.score.home.service.DailyAttendanceService;


import java.util.List;
import java.util.Map;

public class DailyAttendanceSCAClient implements DailyAttendanceService {

    private DailyAttendanceService dailyAttendanceService;

	public DailyAttendanceService getDailyAttendanceService() {
		return dailyAttendanceService;
	}
	
	
	public void setDailyAttendanceService(DailyAttendanceService dailyAttendanceService) {
		this.dailyAttendanceService =dailyAttendanceService;
	}
	
	
			   
		@Override
		public Long insert(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.insert(dailyAttendance);
		          
		
		}	
		  
    	   
		@Override
		public List<DailyAttendance> insertList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.insertList(dailyAttendanceList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.update(dailyAttendance);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.updateList(dailyAttendanceList);
		          
		
		}	
		  
    	   
		@Override
		public DailyAttendance getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DailyAttendance> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return dailyAttendanceService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getDailyAttendanceIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return dailyAttendanceService.getDailyAttendanceIds(start, limit);
	}

	@Override
	public Integer countDailyAttendanceIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return dailyAttendanceService.countDailyAttendanceIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return dailyAttendanceService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return dailyAttendanceService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   dailyAttendanceService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.dailyAttendanceService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

