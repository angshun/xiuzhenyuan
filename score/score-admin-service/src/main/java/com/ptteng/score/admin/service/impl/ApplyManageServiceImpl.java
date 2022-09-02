package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.ApplyManage;
import com.ptteng.score.admin.service.ApplyManageService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ApplyManageServiceImpl extends BaseDaoServiceImpl implements ApplyManageService {

 

	private static final Log log = LogFactory.getLog(ApplyManageServiceImpl.class);



		   
		@Override
		public Long insert(ApplyManage applyManage)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + applyManage);

		if (applyManage == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		applyManage.setCreateAt(currentTimeMillis);
		applyManage.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(applyManage);
		} catch (DaoException e) {
			log.error(" insert wrong : " + applyManage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ApplyManage> insertList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (applyManageList == null ? "null" : applyManageList.size()));
      
		List<ApplyManage> resultList = null;

		if (CollectionUtils.isEmpty(applyManageList)) {
			return new ArrayList<ApplyManage>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ApplyManage applyManage : applyManageList) {
			applyManage.setCreateAt(currentTimeMillis);
			applyManage.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ApplyManage>) dao.batchSave(applyManageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + applyManageList);
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
			result = dao.delete(ApplyManage.class, id);
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
		public boolean update(ApplyManage applyManage)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (applyManage == null ? "null" : applyManage.getId()));

		boolean result = false;

		if (applyManage == null) {
			return true;
		}

		applyManage.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(applyManage);
		} catch (DaoException e) {
			log.error(" update wrong : " + applyManage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + applyManage);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (applyManageList == null ? "null" : applyManageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(applyManageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ApplyManage applyManage : applyManageList) {
			applyManage.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(applyManageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + applyManageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + applyManageList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ApplyManage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ApplyManage applyManage = null;

		if (id == null) {
			return applyManage;
		}

		try {
			applyManage = (ApplyManage) dao.get(ApplyManage.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return applyManage;		
		}	
		  
    	   
		@Override
		public List<ApplyManage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ApplyManage> applyManage = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ApplyManage>();
		}

		try {
			applyManage = (List<ApplyManage>) dao.getList(ApplyManage.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (applyManage == null ? "null" : applyManage.size()));
    
		return applyManage;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getApplyManageIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getApplyManageIdsAll",new Object[] {},start, limit, false);
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
	public Integer countApplyManageIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getApplyManageIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getApplyManageIds " ) ;
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

