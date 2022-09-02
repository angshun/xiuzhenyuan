package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Star;
import com.ptteng.score.home.service.StarService;

import java.util.ArrayList;
import java.util.List;


public class StarServiceImpl extends BaseDaoServiceImpl implements StarService {

 

	private static final Log log = LogFactory.getLog(StarServiceImpl.class);



		   
		@Override
		public Long insert(Star star)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + star);

		if (star == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		star.setCreateAt(currentTimeMillis);
		star.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(star);
		} catch (DaoException e) {
			log.error(" insert wrong : " + star);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Star> insertList(List<Star> starList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (starList == null ? "null" : starList.size()));
      
		List<Star> resultList = null;

		if (CollectionUtils.isEmpty(starList)) {
			return new ArrayList<Star>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Star star : starList) {
			star.setCreateAt(currentTimeMillis);
			star.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Star>) dao.batchSave(starList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + starList);
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
			result = dao.delete(Star.class, id);
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
		public boolean update(Star star)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (star == null ? "null" : star.getId()));

		boolean result = false;

		if (star == null) {
			return true;
		}

		star.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(star);
		} catch (DaoException e) {
			log.error(" update wrong : " + star);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + star);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Star> starList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (starList == null ? "null" : starList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(starList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Star star : starList) {
			star.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(starList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + starList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + starList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Star getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Star star = null;

		if (id == null) {
			return star;
		}

		try {
			star = (Star) dao.get(Star.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return star;		
		}	
		  
    	   
		@Override
		public List<Star> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Star> star = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Star>();
		}

		try {
			star = (List<Star>) dao.getList(Star.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (star == null ? "null" : star.size()));
    
		return star;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getStarIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getStarIdsAll",new Object[] {},start, limit, false);
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
	public Integer countStarIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getStarIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getStarIds " ) ;
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

