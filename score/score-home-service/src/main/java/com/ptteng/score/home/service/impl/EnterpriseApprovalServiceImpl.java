package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.EnterpriseApproval;
import com.ptteng.score.home.service.EnterpriseApprovalService;

import java.util.ArrayList;
import java.util.List;


public class EnterpriseApprovalServiceImpl extends BaseDaoServiceImpl implements EnterpriseApprovalService {

 

	private static final Log log = LogFactory.getLog(EnterpriseApprovalServiceImpl.class);



		   
		@Override
		public Long insert(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + enterpriseApproval);

		if (enterpriseApproval == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		enterpriseApproval.setCreateAt(currentTimeMillis);
		enterpriseApproval.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(enterpriseApproval);
		} catch (DaoException e) {
			log.error(" insert wrong : " + enterpriseApproval);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<EnterpriseApproval> insertList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (enterpriseApprovalList == null ? "null" : enterpriseApprovalList.size()));
      
		List<EnterpriseApproval> resultList = null;

		if (CollectionUtils.isEmpty(enterpriseApprovalList)) {
			return new ArrayList<EnterpriseApproval>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
			enterpriseApproval.setCreateAt(currentTimeMillis);
			enterpriseApproval.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<EnterpriseApproval>) dao.batchSave(enterpriseApprovalList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + enterpriseApprovalList);
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
			result = dao.delete(EnterpriseApproval.class, id);
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
		public boolean update(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (enterpriseApproval == null ? "null" : enterpriseApproval.getId()));

		boolean result = false;

		if (enterpriseApproval == null) {
			return true;
		}

		enterpriseApproval.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(enterpriseApproval);
		} catch (DaoException e) {
			log.error(" update wrong : " + enterpriseApproval);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + enterpriseApproval);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (enterpriseApprovalList == null ? "null" : enterpriseApprovalList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(enterpriseApprovalList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
			enterpriseApproval.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(enterpriseApprovalList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + enterpriseApprovalList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + enterpriseApprovalList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public EnterpriseApproval getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		EnterpriseApproval enterpriseApproval = null;

		if (id == null) {
			return enterpriseApproval;
		}

		try {
			enterpriseApproval = (EnterpriseApproval) dao.get(EnterpriseApproval.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return enterpriseApproval;		
		}	
		  
    	   
		@Override
		public List<EnterpriseApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<EnterpriseApproval> enterpriseApproval = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<EnterpriseApproval>();
		}

		try {
			enterpriseApproval = (List<EnterpriseApproval>) dao.getList(EnterpriseApproval.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (enterpriseApproval == null ? "null" : enterpriseApproval.size()));
    
		return enterpriseApproval;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getEnterpriseApprovalIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getEnterpriseApprovalIdsAll",new Object[] {},start, limit, false);
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
	public Integer countEnterpriseApprovalIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getEnterpriseApprovalIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getEnterpriseApprovalIds " ) ;
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

