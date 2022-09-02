package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.EnterpriseLog;
import com.ptteng.score.admin.service.EnterpriseLogService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class EnterpriseLogServiceImpl extends BaseDaoServiceImpl implements EnterpriseLogService {

 

	private static final Log log = LogFactory.getLog(EnterpriseLogServiceImpl.class);



		   
		@Override
		public Long insert(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + enterpriseLog);

		if (enterpriseLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		enterpriseLog.setCreateAt(currentTimeMillis);
		enterpriseLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(enterpriseLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + enterpriseLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<EnterpriseLog> insertList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (enterpriseLogList == null ? "null" : enterpriseLogList.size()));
      
		List<EnterpriseLog> resultList = null;

		if (CollectionUtils.isEmpty(enterpriseLogList)) {
			return new ArrayList<EnterpriseLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (EnterpriseLog enterpriseLog : enterpriseLogList) {
			enterpriseLog.setCreateAt(currentTimeMillis);
			enterpriseLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<EnterpriseLog>) dao.batchSave(enterpriseLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + enterpriseLogList);
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
			result = dao.delete(EnterpriseLog.class, id);
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
		public boolean update(EnterpriseLog enterpriseLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (enterpriseLog == null ? "null" : enterpriseLog.getId()));

		boolean result = false;

		if (enterpriseLog == null) {
			return true;
		}

		enterpriseLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(enterpriseLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + enterpriseLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + enterpriseLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<EnterpriseLog> enterpriseLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (enterpriseLogList == null ? "null" : enterpriseLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(enterpriseLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (EnterpriseLog enterpriseLog : enterpriseLogList) {
			enterpriseLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(enterpriseLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + enterpriseLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + enterpriseLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public EnterpriseLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		EnterpriseLog enterpriseLog = null;

		if (id == null) {
			return enterpriseLog;
		}

		try {
			enterpriseLog = (EnterpriseLog) dao.get(EnterpriseLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return enterpriseLog;		
		}	
		  
    	   
		@Override
		public List<EnterpriseLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<EnterpriseLog> enterpriseLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<EnterpriseLog>();
		}

		try {
			enterpriseLog = (List<EnterpriseLog>) dao.getList(EnterpriseLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (enterpriseLog == null ? "null" : enterpriseLog.size()));
    
		return enterpriseLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getEnterpriseLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getEnterpriseLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countEnterpriseLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getEnterpriseLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getEnterpriseLogIds " ) ;
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

