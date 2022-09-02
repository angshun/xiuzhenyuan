package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.OperationLog;
import com.ptteng.score.home.service.OperationLogService;

import java.util.ArrayList;
import java.util.List;


public class OperationLogServiceImpl extends BaseDaoServiceImpl implements OperationLogService {

 

	private static final Log log = LogFactory.getLog(OperationLogServiceImpl.class);



		   
		@Override
		public Long insert(OperationLog operationLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + operationLog);

		if (operationLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		operationLog.setCreateAt(currentTimeMillis);
		operationLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(operationLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + operationLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<OperationLog> insertList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (operationLogList == null ? "null" : operationLogList.size()));
      
		List<OperationLog> resultList = null;

		if (CollectionUtils.isEmpty(operationLogList)) {
			return new ArrayList<OperationLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (OperationLog operationLog : operationLogList) {
			operationLog.setCreateAt(currentTimeMillis);
			operationLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<OperationLog>) dao.batchSave(operationLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + operationLogList);
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
			result = dao.delete(OperationLog.class, id);
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
		public boolean update(OperationLog operationLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (operationLog == null ? "null" : operationLog.getId()));

		boolean result = false;

		if (operationLog == null) {
			return true;
		}

		operationLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(operationLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + operationLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + operationLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<OperationLog> operationLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (operationLogList == null ? "null" : operationLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(operationLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (OperationLog operationLog : operationLogList) {
			operationLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(operationLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + operationLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + operationLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public OperationLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		OperationLog operationLog = null;

		if (id == null) {
			return operationLog;
		}

		try {
			operationLog = (OperationLog) dao.get(OperationLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return operationLog;		
		}	
		  
    	   
		@Override
		public List<OperationLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<OperationLog> operationLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<OperationLog>();
		}

		try {
			operationLog = (List<OperationLog>) dao.getList(OperationLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (operationLog == null ? "null" : operationLog.size()));
    
		return operationLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getOperationLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getOperationLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countOperationLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getOperationLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getOperationLogIds " ) ;
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

