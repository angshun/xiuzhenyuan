package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.ApproveLog;
import com.ptteng.score.home.service.ApproveLogService;

import java.util.ArrayList;
import java.util.List;


public class ApproveLogServiceImpl extends BaseDaoServiceImpl implements ApproveLogService {

 

	private static final Log log = LogFactory.getLog(ApproveLogServiceImpl.class);



		   
		@Override
		public Long insert(ApproveLog approveLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + approveLog);

		if (approveLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		approveLog.setCreateAt(currentTimeMillis);
		approveLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(approveLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + approveLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ApproveLog> insertList(List<ApproveLog> approveLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (approveLogList == null ? "null" : approveLogList.size()));
      
		List<ApproveLog> resultList = null;

		if (CollectionUtils.isEmpty(approveLogList)) {
			return new ArrayList<ApproveLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ApproveLog approveLog : approveLogList) {
			approveLog.setCreateAt(currentTimeMillis);
			approveLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ApproveLog>) dao.batchSave(approveLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + approveLogList);
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
			result = dao.delete(ApproveLog.class, id);
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
		public boolean update(ApproveLog approveLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (approveLog == null ? "null" : approveLog.getId()));

		boolean result = false;

		if (approveLog == null) {
			return true;
		}

		approveLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(approveLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + approveLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + approveLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ApproveLog> approveLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (approveLogList == null ? "null" : approveLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(approveLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ApproveLog approveLog : approveLogList) {
			approveLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(approveLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + approveLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + approveLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ApproveLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ApproveLog approveLog = null;

		if (id == null) {
			return approveLog;
		}

		try {
			approveLog = (ApproveLog) dao.get(ApproveLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return approveLog;		
		}	
		  
    	   
		@Override
		public List<ApproveLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ApproveLog> approveLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ApproveLog>();
		}

		try {
			approveLog = (List<ApproveLog>) dao.getList(ApproveLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (approveLog == null ? "null" : approveLog.size()));
    
		return approveLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getApproveLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getApproveLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countApproveLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getApproveLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getApproveLogIds " ) ;
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

