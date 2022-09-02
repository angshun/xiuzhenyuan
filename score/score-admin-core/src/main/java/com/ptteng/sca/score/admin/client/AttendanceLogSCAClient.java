/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.AttendanceLog;
import com.ptteng.score.admin.service.AttendanceLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AttendanceLogSCAClient implements AttendanceLogService {

    private AttendanceLogService attendanceLogService;

	public AttendanceLogService getAttendanceLogService() {
		return attendanceLogService;
	}
	
	
	public void setAttendanceLogService(AttendanceLogService attendanceLogService) {
		this.attendanceLogService =attendanceLogService;
	}
	
	
			   
		@Override
		public Long insert(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.insert(attendanceLog);
		          
		
		}	
		  
    	   
		@Override
		public List<AttendanceLog> insertList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.insertList(attendanceLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.update(attendanceLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.updateList(attendanceLogList);
		          
		
		}	
		  
    	   
		@Override
		public AttendanceLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<AttendanceLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return attendanceLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAttendanceLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return attendanceLogService.getAttendanceLogIds(start, limit);
	}

	@Override
	public Integer countAttendanceLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return attendanceLogService.countAttendanceLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return attendanceLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return attendanceLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   attendanceLogService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.attendanceLogService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

