package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.bangbang.model.Manager;
import com.ptteng.carrots.bangbang.service.ManagerService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ManagerServiceImpl extends BaseDaoServiceImpl implements ManagerService {

 

	private static final Log log = LogFactory.getLog(ManagerServiceImpl.class);



		   
		@Override
		public Long insert(Manager manager)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + manager);

		if (manager == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		manager.setCreateAt(currentTimeMillis);
		manager.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(manager);
		} catch (DaoException e) {
			log.error(" insert wrong : " + manager);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Manager> insertList(List<Manager> managerList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (managerList == null ? "null" : managerList.size()));
      
		List<Manager> resultList = null;

		if (CollectionUtils.isEmpty(managerList)) {
			return new ArrayList<Manager>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Manager manager : managerList) {
			manager.setCreateAt(currentTimeMillis);
			manager.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Manager>) dao.batchSave(managerList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + managerList);
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
			result = dao.delete(Manager.class, id);
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
		public boolean update(Manager manager)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (manager == null ? "null" : manager.getId()));

		boolean result = false;

		if (manager == null) {
			return true;
		}

		manager.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(manager);
		} catch (DaoException e) {
			log.error(" update wrong : " + manager);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + manager);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Manager> managerList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (managerList == null ? "null" : managerList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(managerList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Manager manager : managerList) {
			manager.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(managerList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + managerList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + managerList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Manager getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Manager manager = null;

		if (id == null) {
			return manager;
		}

		try {
			manager = (Manager) dao.get(Manager.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return manager;		
		}	
		  
    	   
		@Override
		public List<Manager> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Manager> manager = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Manager>();
		}

		try {
			manager = (List<Manager>) dao.getList(Manager.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (manager == null ? "null" : manager.size()));
    
		return manager;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getManagerIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getManagerIdsAll",new Object[] {},start, limit, false);
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
	public Integer countManagerIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getManagerIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getManagerIds " ) ;
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

