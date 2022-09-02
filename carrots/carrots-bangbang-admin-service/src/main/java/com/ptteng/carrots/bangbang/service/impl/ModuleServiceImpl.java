package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.carrots.bangbang.model.Module;
import com.ptteng.carrots.bangbang.service.ModuleService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ModuleServiceImpl extends BaseDaoServiceImpl implements ModuleService {

 

	private static final Log log = LogFactory.getLog(ModuleServiceImpl.class);



		   
		@Override
		public Long insert(Module module)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + module);

		if (module == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		module.setCreateAt(currentTimeMillis);
		module.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(module);
		} catch (DaoException e) {
			log.error(" insert wrong : " + module);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Module> insertList(List<Module> moduleList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (moduleList == null ? "null" : moduleList.size()));
      
		List<Module> resultList = null;

		if (CollectionUtils.isEmpty(moduleList)) {
			return new ArrayList<Module>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Module module : moduleList) {
			module.setCreateAt(currentTimeMillis);
			module.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Module>) dao.batchSave(moduleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + moduleList);
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
			result = dao.delete(Module.class, id);
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
		public boolean update(Module module)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (module == null ? "null" : module.getId()));

		boolean result = false;

		if (module == null) {
			return true;
		}

		module.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(module);
		} catch (DaoException e) {
			log.error(" update wrong : " + module);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + module);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Module> moduleList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (moduleList == null ? "null" : moduleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(moduleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Module module : moduleList) {
			module.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(moduleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + moduleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + moduleList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Module getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Module module = null;

		if (id == null) {
			return module;
		}

		try {
			module = (Module) dao.get(Module.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return module;		
		}	
		  
    	   
		@Override
		public List<Module> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Module> module = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Module>();
		}

		try {
			module = (List<Module>) dao.getList(Module.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (module == null ? "null" : module.size()));
    
		return module;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getModuleIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getModuleIdsAll",new Object[] {},start, limit, false);
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
	public Integer countModuleIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getModuleIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getModuleIds " ) ;
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

