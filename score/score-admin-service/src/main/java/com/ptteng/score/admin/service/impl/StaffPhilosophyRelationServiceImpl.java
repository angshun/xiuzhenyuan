package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.StaffPhilosophyRelation;
import com.ptteng.score.admin.service.StaffPhilosophyRelationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class StaffPhilosophyRelationServiceImpl extends BaseDaoServiceImpl implements StaffPhilosophyRelationService {

 

	private static final Log log = LogFactory.getLog(StaffPhilosophyRelationServiceImpl.class);



		   
		@Override
		public Long insert(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + staffPhilosophyRelation);

		if (staffPhilosophyRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		staffPhilosophyRelation.setCreateAt(currentTimeMillis);
		staffPhilosophyRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(staffPhilosophyRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + staffPhilosophyRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<StaffPhilosophyRelation> insertList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (staffPhilosophyRelationList == null ? "null" : staffPhilosophyRelationList.size()));
      
		List<StaffPhilosophyRelation> resultList = null;

		if (CollectionUtils.isEmpty(staffPhilosophyRelationList)) {
			return new ArrayList<StaffPhilosophyRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (StaffPhilosophyRelation staffPhilosophyRelation : staffPhilosophyRelationList) {
			staffPhilosophyRelation.setCreateAt(currentTimeMillis);
			staffPhilosophyRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<StaffPhilosophyRelation>) dao.batchSave(staffPhilosophyRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + staffPhilosophyRelationList);
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
			result = dao.delete(StaffPhilosophyRelation.class, id);
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
		public boolean update(StaffPhilosophyRelation staffPhilosophyRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (staffPhilosophyRelation == null ? "null" : staffPhilosophyRelation.getId()));

		boolean result = false;

		if (staffPhilosophyRelation == null) {
			return true;
		}

		staffPhilosophyRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(staffPhilosophyRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + staffPhilosophyRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + staffPhilosophyRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<StaffPhilosophyRelation> staffPhilosophyRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (staffPhilosophyRelationList == null ? "null" : staffPhilosophyRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(staffPhilosophyRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (StaffPhilosophyRelation staffPhilosophyRelation : staffPhilosophyRelationList) {
			staffPhilosophyRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(staffPhilosophyRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + staffPhilosophyRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + staffPhilosophyRelationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public StaffPhilosophyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		StaffPhilosophyRelation staffPhilosophyRelation = null;

		if (id == null) {
			return staffPhilosophyRelation;
		}

		try {
			staffPhilosophyRelation = (StaffPhilosophyRelation) dao.get(StaffPhilosophyRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return staffPhilosophyRelation;		
		}	
		  
    	   
		@Override
		public List<StaffPhilosophyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<StaffPhilosophyRelation> staffPhilosophyRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<StaffPhilosophyRelation>();
		}

		try {
			staffPhilosophyRelation = (List<StaffPhilosophyRelation>) dao.getList(StaffPhilosophyRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (staffPhilosophyRelation == null ? "null" : staffPhilosophyRelation.size()));
    
		return staffPhilosophyRelation;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getStaffPhilosophyRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getStaffPhilosophyRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countStaffPhilosophyRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getStaffPhilosophyRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getStaffPhilosophyRelationIds " ) ;
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

