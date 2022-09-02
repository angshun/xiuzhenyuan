package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.ScoreLog;
import com.ptteng.score.home.service.ScoreLogService;

import java.util.ArrayList;
import java.util.List;


public class ScoreLogServiceImpl extends BaseDaoServiceImpl implements ScoreLogService {

 

	private static final Log log = LogFactory.getLog(ScoreLogServiceImpl.class);



		   
		@Override
		public Long insert(ScoreLog scoreLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + scoreLog);

		if (scoreLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		scoreLog.setCreateAt(currentTimeMillis);
		scoreLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(scoreLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + scoreLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ScoreLog> insertList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (scoreLogList == null ? "null" : scoreLogList.size()));
      
		List<ScoreLog> resultList = null;

		if (CollectionUtils.isEmpty(scoreLogList)) {
			return new ArrayList<ScoreLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreLog scoreLog : scoreLogList) {
			scoreLog.setCreateAt(currentTimeMillis);
			scoreLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ScoreLog>) dao.batchSave(scoreLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + scoreLogList);
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
			result = dao.delete(ScoreLog.class, id);
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
		public boolean update(ScoreLog scoreLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (scoreLog == null ? "null" : scoreLog.getId()));

		boolean result = false;

		if (scoreLog == null) {
			return true;
		}

		scoreLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(scoreLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + scoreLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + scoreLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreLog> scoreLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (scoreLogList == null ? "null" : scoreLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(scoreLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreLog scoreLog : scoreLogList) {
			scoreLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(scoreLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + scoreLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + scoreLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ScoreLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ScoreLog scoreLog = null;

		if (id == null) {
			return scoreLog;
		}

		try {
			scoreLog = (ScoreLog) dao.get(ScoreLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return scoreLog;		
		}	
		  
    	   
		@Override
		public List<ScoreLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ScoreLog> scoreLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ScoreLog>();
		}

		try {
			scoreLog = (List<ScoreLog>) dao.getList(ScoreLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (scoreLog == null ? "null" : scoreLog.size()));
    
		return scoreLog;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getScoreLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getScoreLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countScoreLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getScoreLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getScoreLogIds " ) ;
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

