package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ProfessionTagServiceImpl extends BaseDaoServiceImpl implements ProfessionTagService {

 

	private static final Log log = LogFactory.getLog(ProfessionTagServiceImpl.class);



		   
		@Override
		public Long insert(ProfessionTag professionTag)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + professionTag);

		if (professionTag == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		professionTag.setCreateAt(currentTimeMillis);
		professionTag.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(professionTag);
		} catch (DaoException e) {
			log.error(" insert wrong : " + professionTag);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ProfessionTag> insertList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (professionTagList == null ? "null" : professionTagList.size()));
      
		List<ProfessionTag> resultList = null;

		if (CollectionUtils.isEmpty(professionTagList)) {
			return new ArrayList<ProfessionTag>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ProfessionTag professionTag : professionTagList) {
			professionTag.setCreateAt(currentTimeMillis);
			professionTag.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ProfessionTag>) dao.batchSave(professionTagList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + professionTagList);
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
			result = dao.delete(ProfessionTag.class, id);
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
		public boolean update(ProfessionTag professionTag)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (professionTag == null ? "null" : professionTag.getId()));

		boolean result = false;

		if (professionTag == null) {
			return true;
		}

		professionTag.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(professionTag);
		} catch (DaoException e) {
			log.error(" update wrong : " + professionTag);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + professionTag);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (professionTagList == null ? "null" : professionTagList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(professionTagList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ProfessionTag professionTag : professionTagList) {
			professionTag.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(professionTagList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + professionTagList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + professionTagList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ProfessionTag getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ProfessionTag professionTag = null;

		if (id == null) {
			return professionTag;
		}

		try {
			professionTag = (ProfessionTag) dao.get(ProfessionTag.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return professionTag;		
		}	
		  
    	   
		@Override
		public List<ProfessionTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ProfessionTag> professionTag = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ProfessionTag>();
		}

		try {
			professionTag = (List<ProfessionTag>) dao.getList(ProfessionTag.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (professionTag == null ? "null" : professionTag.size()));
    
		return professionTag;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getProfessionTagIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getProfessionTagIdsAll",new Object[] {},start, limit, false);
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
	public Integer countProfessionTagIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getProfessionTagIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getProfessionTagIds " ) ;
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

