package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.RewardLog;
import com.ptteng.score.home.service.RewardLogService;

import java.util.ArrayList;
import java.util.List;


public class RewardLogServiceImpl extends BaseDaoServiceImpl implements RewardLogService {

 

	private static final Log log = LogFactory.getLog(RewardLogServiceImpl.class);



		   
		@Override
		public Long insert(RewardLog rewardLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + rewardLog);

		if (rewardLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		rewardLog.setCreateAt(currentTimeMillis);
		rewardLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(rewardLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + rewardLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<RewardLog> insertList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (rewardLogList == null ? "null" : rewardLogList.size()));
      
		List<RewardLog> resultList = null;

		if (CollectionUtils.isEmpty(rewardLogList)) {
			return new ArrayList<RewardLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RewardLog rewardLog : rewardLogList) {
			rewardLog.setCreateAt(currentTimeMillis);
			rewardLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<RewardLog>) dao.batchSave(rewardLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + rewardLogList);
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
			result = dao.delete(RewardLog.class, id);
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
		public boolean update(RewardLog rewardLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (rewardLog == null ? "null" : rewardLog.getId()));

		boolean result = false;

		if (rewardLog == null) {
			return true;
		}

		rewardLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(rewardLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + rewardLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + rewardLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<RewardLog> rewardLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (rewardLogList == null ? "null" : rewardLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(rewardLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RewardLog rewardLog : rewardLogList) {
			rewardLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(rewardLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + rewardLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + rewardLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public RewardLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		RewardLog rewardLog = null;

		if (id == null) {
			return rewardLog;
		}

		try {
			rewardLog = (RewardLog) dao.get(RewardLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return rewardLog;		
		}	
		  
    	   
		@Override
		public List<RewardLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<RewardLog> rewardLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<RewardLog>();
		}

		try {
			rewardLog = (List<RewardLog>) dao.getList(RewardLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (rewardLog == null ? "null" : rewardLog.size()));
    
		return rewardLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getRewardLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getRewardLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countRewardLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRewardLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRewardLogIds " ) ;
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

