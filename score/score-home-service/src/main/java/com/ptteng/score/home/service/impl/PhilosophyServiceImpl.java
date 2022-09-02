package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Philosophy;
import com.ptteng.score.home.service.PhilosophyService;

import java.util.ArrayList;
import java.util.List;


public class PhilosophyServiceImpl extends BaseDaoServiceImpl implements PhilosophyService {

 

	private static final Log log = LogFactory.getLog(PhilosophyServiceImpl.class);



		   
		@Override
		public Long insert(Philosophy philosophy)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + philosophy);

		if (philosophy == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		philosophy.setCreateAt(currentTimeMillis);
		philosophy.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(philosophy);
		} catch (DaoException e) {
			log.error(" insert wrong : " + philosophy);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Philosophy> insertList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (philosophyList == null ? "null" : philosophyList.size()));
      
		List<Philosophy> resultList = null;

		if (CollectionUtils.isEmpty(philosophyList)) {
			return new ArrayList<Philosophy>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Philosophy philosophy : philosophyList) {
			philosophy.setCreateAt(currentTimeMillis);
			philosophy.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Philosophy>) dao.batchSave(philosophyList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + philosophyList);
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
			result = dao.delete(Philosophy.class, id);
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
		public boolean update(Philosophy philosophy)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (philosophy == null ? "null" : philosophy.getId()));

		boolean result = false;

		if (philosophy == null) {
			return true;
		}

		philosophy.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(philosophy);
		} catch (DaoException e) {
			log.error(" update wrong : " + philosophy);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + philosophy);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Philosophy> philosophyList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (philosophyList == null ? "null" : philosophyList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(philosophyList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Philosophy philosophy : philosophyList) {
			philosophy.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(philosophyList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + philosophyList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + philosophyList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Philosophy getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Philosophy philosophy = null;

		if (id == null) {
			return philosophy;
		}

		try {
			philosophy = (Philosophy) dao.get(Philosophy.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return philosophy;		
		}	
		  
    	   
		@Override
		public List<Philosophy> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Philosophy> philosophy = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Philosophy>();
		}

		try {
			philosophy = (List<Philosophy>) dao.getList(Philosophy.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (philosophy == null ? "null" : philosophy.size()));
    
		return philosophy;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getPhilosophyIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPhilosophyIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPhilosophyIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPhilosophyIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPhilosophyIds " ) ;
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

