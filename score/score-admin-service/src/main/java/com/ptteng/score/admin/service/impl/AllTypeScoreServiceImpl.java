package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.AllTypeScore;
import com.ptteng.score.admin.service.AllTypeScoreService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AllTypeScoreServiceImpl extends BaseDaoServiceImpl implements AllTypeScoreService {

 

	private static final Log log = LogFactory.getLog(AllTypeScoreServiceImpl.class);



		   
		@Override
		public Long insert(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + allTypeScore);

		if (allTypeScore == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		allTypeScore.setCreateAt(currentTimeMillis);
		allTypeScore.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(allTypeScore);
		} catch (DaoException e) {
			log.error(" insert wrong : " + allTypeScore);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<AllTypeScore> insertList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (allTypeScoreList == null ? "null" : allTypeScoreList.size()));
      
		List<AllTypeScore> resultList = null;

		if (CollectionUtils.isEmpty(allTypeScoreList)) {
			return new ArrayList<AllTypeScore>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AllTypeScore allTypeScore : allTypeScoreList) {
			allTypeScore.setCreateAt(currentTimeMillis);
			allTypeScore.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AllTypeScore>) dao.batchSave(allTypeScoreList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + allTypeScoreList);
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
			result = dao.delete(AllTypeScore.class, id);
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
		public boolean update(AllTypeScore allTypeScore)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (allTypeScore == null ? "null" : allTypeScore.getId()));

		boolean result = false;

		if (allTypeScore == null) {
			return true;
		}

		allTypeScore.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(allTypeScore);
		} catch (DaoException e) {
			log.error(" update wrong : " + allTypeScore);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + allTypeScore);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AllTypeScore> allTypeScoreList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (allTypeScoreList == null ? "null" : allTypeScoreList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(allTypeScoreList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AllTypeScore allTypeScore : allTypeScoreList) {
			allTypeScore.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(allTypeScoreList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + allTypeScoreList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + allTypeScoreList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public AllTypeScore getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		AllTypeScore allTypeScore = null;

		if (id == null) {
			return allTypeScore;
		}

		try {
			allTypeScore = (AllTypeScore) dao.get(AllTypeScore.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return allTypeScore;		
		}	
		  
    	   
		@Override
		public List<AllTypeScore> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<AllTypeScore> allTypeScore = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AllTypeScore>();
		}

		try {
			allTypeScore = (List<AllTypeScore>) dao.getList(AllTypeScore.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (allTypeScore == null ? "null" : allTypeScore.size()));
    
		return allTypeScore;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAllTypeScoreIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAllTypeScoreIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAllTypeScoreIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAllTypeScoreIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAllTypeScoreIds " ) ;
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

