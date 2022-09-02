package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.ScoreType;
import com.ptteng.score.home.service.ScoreTypeService;

import java.util.ArrayList;
import java.util.List;


public class ScoreTypeServiceImpl extends BaseDaoServiceImpl implements ScoreTypeService {

 

	private static final Log log = LogFactory.getLog(ScoreTypeServiceImpl.class);



		   
		@Override
		public Long insert(ScoreType scoreType)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + scoreType);

		if (scoreType == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		scoreType.setCreateAt(currentTimeMillis);
		scoreType.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(scoreType);
		} catch (DaoException e) {
			log.error(" insert wrong : " + scoreType);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ScoreType> insertList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (scoreTypeList == null ? "null" : scoreTypeList.size()));
      
		List<ScoreType> resultList = null;

		if (CollectionUtils.isEmpty(scoreTypeList)) {
			return new ArrayList<ScoreType>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreType scoreType : scoreTypeList) {
			scoreType.setCreateAt(currentTimeMillis);
			scoreType.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ScoreType>) dao.batchSave(scoreTypeList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + scoreTypeList);
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
			result = dao.delete(ScoreType.class, id);
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
		public boolean update(ScoreType scoreType)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (scoreType == null ? "null" : scoreType.getId()));

		boolean result = false;

		if (scoreType == null) {
			return true;
		}

		scoreType.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(scoreType);
		} catch (DaoException e) {
			log.error(" update wrong : " + scoreType);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + scoreType);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (scoreTypeList == null ? "null" : scoreTypeList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(scoreTypeList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreType scoreType : scoreTypeList) {
			scoreType.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(scoreTypeList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + scoreTypeList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + scoreTypeList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ScoreType getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ScoreType scoreType = null;

		if (id == null) {
			return scoreType;
		}

		try {
			scoreType = (ScoreType) dao.get(ScoreType.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return scoreType;		
		}	
		  
    	   
		@Override
		public List<ScoreType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ScoreType> scoreType = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ScoreType>();
		}

		try {
			scoreType = (List<ScoreType>) dao.getList(ScoreType.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (scoreType == null ? "null" : scoreType.size()));
    
		return scoreType;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getScoreTypeIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getScoreTypeIdsAll",new Object[] {},start, limit, false);
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
	public Integer countScoreTypeIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getScoreTypeIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getScoreTypeIds " ) ;
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

