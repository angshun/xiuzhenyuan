package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.ScoreExchangeApproval;
import com.ptteng.score.home.service.ScoreExchangeApprovalService;

import java.util.ArrayList;
import java.util.List;


public class ScoreExchangeApprovalServiceImpl extends BaseDaoServiceImpl implements ScoreExchangeApprovalService {

 

	private static final Log log = LogFactory.getLog(ScoreExchangeApprovalServiceImpl.class);



		   
		@Override
		public Long insert(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + scoreExchangeApproval);

		if (scoreExchangeApproval == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		scoreExchangeApproval.setCreateAt(currentTimeMillis);
		scoreExchangeApproval.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(scoreExchangeApproval);
		} catch (DaoException e) {
			log.error(" insert wrong : " + scoreExchangeApproval);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ScoreExchangeApproval> insertList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (scoreExchangeApprovalList == null ? "null" : scoreExchangeApprovalList.size()));
      
		List<ScoreExchangeApproval> resultList = null;

		if (CollectionUtils.isEmpty(scoreExchangeApprovalList)) {
			return new ArrayList<ScoreExchangeApproval>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreExchangeApproval scoreExchangeApproval : scoreExchangeApprovalList) {
			scoreExchangeApproval.setCreateAt(currentTimeMillis);
			scoreExchangeApproval.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ScoreExchangeApproval>) dao.batchSave(scoreExchangeApprovalList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + scoreExchangeApprovalList);
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
			result = dao.delete(ScoreExchangeApproval.class, id);
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
		public boolean update(ScoreExchangeApproval scoreExchangeApproval)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (scoreExchangeApproval == null ? "null" : scoreExchangeApproval.getId()));

		boolean result = false;

		if (scoreExchangeApproval == null) {
			return true;
		}

		scoreExchangeApproval.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(scoreExchangeApproval);
		} catch (DaoException e) {
			log.error(" update wrong : " + scoreExchangeApproval);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + scoreExchangeApproval);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreExchangeApproval> scoreExchangeApprovalList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (scoreExchangeApprovalList == null ? "null" : scoreExchangeApprovalList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(scoreExchangeApprovalList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ScoreExchangeApproval scoreExchangeApproval : scoreExchangeApprovalList) {
			scoreExchangeApproval.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(scoreExchangeApprovalList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + scoreExchangeApprovalList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + scoreExchangeApprovalList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ScoreExchangeApproval getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ScoreExchangeApproval scoreExchangeApproval = null;

		if (id == null) {
			return scoreExchangeApproval;
		}

		try {
			scoreExchangeApproval = (ScoreExchangeApproval) dao.get(ScoreExchangeApproval.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return scoreExchangeApproval;		
		}	
		  
    	   
		@Override
		public List<ScoreExchangeApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ScoreExchangeApproval> scoreExchangeApproval = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ScoreExchangeApproval>();
		}

		try {
			scoreExchangeApproval = (List<ScoreExchangeApproval>) dao.getList(ScoreExchangeApproval.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (scoreExchangeApproval == null ? "null" : scoreExchangeApproval.size()));
    
		return scoreExchangeApproval;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getScoreExchangeApprovalIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getScoreExchangeApprovalIdsAll",new Object[] {},start, limit, false);
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
	public Integer countScoreExchangeApprovalIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getScoreExchangeApprovalIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getScoreExchangeApprovalIds " ) ;
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

