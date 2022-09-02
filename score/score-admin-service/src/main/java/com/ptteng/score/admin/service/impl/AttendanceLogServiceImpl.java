package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.AttendanceLog;
import com.ptteng.score.admin.service.AttendanceLogService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AttendanceLogServiceImpl extends BaseDaoServiceImpl implements AttendanceLogService {

 

	private static final Log log = LogFactory.getLog(AttendanceLogServiceImpl.class);



		   
		@Override
		public Long insert(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + attendanceLog);

		if (attendanceLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		attendanceLog.setCreateAt(currentTimeMillis);
		attendanceLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(attendanceLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + attendanceLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<AttendanceLog> insertList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (attendanceLogList == null ? "null" : attendanceLogList.size()));
      
		List<AttendanceLog> resultList = null;

		if (CollectionUtils.isEmpty(attendanceLogList)) {
			return new ArrayList<AttendanceLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AttendanceLog attendanceLog : attendanceLogList) {
			attendanceLog.setCreateAt(currentTimeMillis);
			attendanceLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AttendanceLog>) dao.batchSave(attendanceLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + attendanceLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(AttendanceLog.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(AttendanceLog attendanceLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (attendanceLog == null ? "null" : attendanceLog.getId()));

		boolean result = false;

		if (attendanceLog == null) {
			return true;
		}

		attendanceLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(attendanceLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + attendanceLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + attendanceLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AttendanceLog> attendanceLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (attendanceLogList == null ? "null" : attendanceLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(attendanceLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AttendanceLog attendanceLog : attendanceLogList) {
			attendanceLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(attendanceLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + attendanceLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + attendanceLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public AttendanceLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		AttendanceLog attendanceLog = null;

		if (id == null) {
			return attendanceLog;
		}

		try {
			attendanceLog = (AttendanceLog) dao.get(AttendanceLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return attendanceLog;		
		}	
		  
    	   
		@Override
		public List<AttendanceLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<AttendanceLog> attendanceLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AttendanceLog>();
		}

		try {
			attendanceLog = (List<AttendanceLog>) dao.getList(AttendanceLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (attendanceLog == null ? "null" : attendanceLog.size()));
    
		return attendanceLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAttendanceLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getAttendanceLogIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countAttendanceLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAttendanceLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAttendanceLogIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

