package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.StaffTaskRelation;
import com.ptteng.score.home.service.StaffTaskRelationService;

import java.util.ArrayList;
import java.util.List;


public class StaffTaskRelationServiceImpl extends BaseDaoServiceImpl implements StaffTaskRelationService {

 

	private static final Log log = LogFactory.getLog(StaffTaskRelationServiceImpl.class);



		   
		@Override
		public Long insert(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + staffTaskRelation);

		if (staffTaskRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		staffTaskRelation.setCreateAt(currentTimeMillis);
		staffTaskRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(staffTaskRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + staffTaskRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<StaffTaskRelation> insertList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (staffTaskRelationList == null ? "null" : staffTaskRelationList.size()));
      
		List<StaffTaskRelation> resultList = null;

		if (CollectionUtils.isEmpty(staffTaskRelationList)) {
			return new ArrayList<StaffTaskRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (StaffTaskRelation staffTaskRelation : staffTaskRelationList) {
			staffTaskRelation.setCreateAt(currentTimeMillis);
			staffTaskRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<StaffTaskRelation>) dao.batchSave(staffTaskRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + staffTaskRelationList);
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
			result = dao.delete(StaffTaskRelation.class, id);
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
		public boolean update(StaffTaskRelation staffTaskRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (staffTaskRelation == null ? "null" : staffTaskRelation.getId()));

		boolean result = false;

		if (staffTaskRelation == null) {
			return true;
		}

		staffTaskRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(staffTaskRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + staffTaskRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + staffTaskRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<StaffTaskRelation> staffTaskRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (staffTaskRelationList == null ? "null" : staffTaskRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(staffTaskRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (StaffTaskRelation staffTaskRelation : staffTaskRelationList) {
			staffTaskRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(staffTaskRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + staffTaskRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + staffTaskRelationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public StaffTaskRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		StaffTaskRelation staffTaskRelation = null;

		if (id == null) {
			return staffTaskRelation;
		}

		try {
			staffTaskRelation = (StaffTaskRelation) dao.get(StaffTaskRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return staffTaskRelation;		
		}	
		  
    	   
		@Override
		public List<StaffTaskRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<StaffTaskRelation> staffTaskRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<StaffTaskRelation>();
		}

		try {
			staffTaskRelation = (List<StaffTaskRelation>) dao.getList(StaffTaskRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (staffTaskRelation == null ? "null" : staffTaskRelation.size()));
    
		return staffTaskRelation;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getStaffTaskRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getStaffTaskRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countStaffTaskRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getStaffTaskRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getStaffTaskRelationIds " ) ;
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

