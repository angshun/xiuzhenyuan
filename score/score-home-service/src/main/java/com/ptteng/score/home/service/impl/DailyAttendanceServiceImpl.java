package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.DailyAttendance;
import com.ptteng.score.home.service.DailyAttendanceService;

import java.util.ArrayList;
import java.util.List;


public class DailyAttendanceServiceImpl extends BaseDaoServiceImpl implements DailyAttendanceService {

 

	private static final Log log = LogFactory.getLog(DailyAttendanceServiceImpl.class);



		   
		@Override
		public Long insert(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + dailyAttendance);

		if (dailyAttendance == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		dailyAttendance.setCreateAt(currentTimeMillis);
		dailyAttendance.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(dailyAttendance);
		} catch (DaoException e) {
			log.error(" insert wrong : " + dailyAttendance);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DailyAttendance> insertList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (dailyAttendanceList == null ? "null" : dailyAttendanceList.size()));
      
		List<DailyAttendance> resultList = null;

		if (CollectionUtils.isEmpty(dailyAttendanceList)) {
			return new ArrayList<DailyAttendance>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DailyAttendance dailyAttendance : dailyAttendanceList) {
			dailyAttendance.setCreateAt(currentTimeMillis);
			dailyAttendance.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DailyAttendance>) dao.batchSave(dailyAttendanceList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + dailyAttendanceList);
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
			result = dao.delete(DailyAttendance.class, id);
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
		public boolean update(DailyAttendance dailyAttendance)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (dailyAttendance == null ? "null" : dailyAttendance.getId()));

		boolean result = false;

		if (dailyAttendance == null) {
			return true;
		}

		dailyAttendance.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(dailyAttendance);
		} catch (DaoException e) {
			log.error(" update wrong : " + dailyAttendance);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + dailyAttendance);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DailyAttendance> dailyAttendanceList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (dailyAttendanceList == null ? "null" : dailyAttendanceList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(dailyAttendanceList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DailyAttendance dailyAttendance : dailyAttendanceList) {
			dailyAttendance.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(dailyAttendanceList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + dailyAttendanceList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + dailyAttendanceList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DailyAttendance getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DailyAttendance dailyAttendance = null;

		if (id == null) {
			return dailyAttendance;
		}

		try {
			dailyAttendance = (DailyAttendance) dao.get(DailyAttendance.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return dailyAttendance;		
		}	
		  
    	   
		@Override
		public List<DailyAttendance> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DailyAttendance> dailyAttendance = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DailyAttendance>();
		}

		try {
			dailyAttendance = (List<DailyAttendance>) dao.getList(DailyAttendance.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (dailyAttendance == null ? "null" : dailyAttendance.size()));
    
		return dailyAttendance;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getDailyAttendanceIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDailyAttendanceIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDailyAttendanceIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDailyAttendanceIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDailyAttendanceIds " ) ;
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

