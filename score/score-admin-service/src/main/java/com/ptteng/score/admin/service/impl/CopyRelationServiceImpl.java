package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.CopyRelation;
import com.ptteng.score.admin.service.CopyRelationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class CopyRelationServiceImpl extends BaseDaoServiceImpl implements CopyRelationService {

 

	private static final Log log = LogFactory.getLog(CopyRelationServiceImpl.class);



		   
		@Override
		public Long insert(CopyRelation copyRelation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + copyRelation);

		if (copyRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		copyRelation.setCreateAt(currentTimeMillis);
		copyRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(copyRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + copyRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CopyRelation> insertList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (copyRelationList == null ? "null" : copyRelationList.size()));
      
		List<CopyRelation> resultList = null;

		if (CollectionUtils.isEmpty(copyRelationList)) {
			return new ArrayList<CopyRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CopyRelation copyRelation : copyRelationList) {
			copyRelation.setCreateAt(currentTimeMillis);
			copyRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CopyRelation>) dao.batchSave(copyRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + copyRelationList);
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
			result = dao.delete(CopyRelation.class, id);
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
		public boolean update(CopyRelation copyRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (copyRelation == null ? "null" : copyRelation.getId()));

		boolean result = false;

		if (copyRelation == null) {
			return true;
		}

		copyRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(copyRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + copyRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + copyRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (copyRelationList == null ? "null" : copyRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(copyRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CopyRelation copyRelation : copyRelationList) {
			copyRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(copyRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + copyRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + copyRelationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CopyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CopyRelation copyRelation = null;

		if (id == null) {
			return copyRelation;
		}

		try {
			copyRelation = (CopyRelation) dao.get(CopyRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return copyRelation;		
		}	
		  
    	   
		@Override
		public List<CopyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CopyRelation> copyRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CopyRelation>();
		}

		try {
			copyRelation = (List<CopyRelation>) dao.getList(CopyRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (copyRelation == null ? "null" : copyRelation.size()));
    
		return copyRelation;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getCopyRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCopyRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCopyRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCopyRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCopyRelationIds " ) ;
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

