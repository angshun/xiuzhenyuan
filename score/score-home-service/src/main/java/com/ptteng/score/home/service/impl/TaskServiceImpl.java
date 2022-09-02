package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Task;
import com.ptteng.score.home.service.TaskService;

import java.util.ArrayList;
import java.util.List;


public class TaskServiceImpl extends BaseDaoServiceImpl implements TaskService {

 

	private static final Log log = LogFactory.getLog(TaskServiceImpl.class);



		   
		@Override
		public Long insert(Task task)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + task);

		if (task == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		task.setCreateAt(currentTimeMillis);
		task.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(task);
		} catch (DaoException e) {
			log.error(" insert wrong : " + task);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Task> insertList(List<Task> taskList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (taskList == null ? "null" : taskList.size()));
      
		List<Task> resultList = null;

		if (CollectionUtils.isEmpty(taskList)) {
			return new ArrayList<Task>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Task task : taskList) {
			task.setCreateAt(currentTimeMillis);
			task.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Task>) dao.batchSave(taskList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + taskList);
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
			result = dao.delete(Task.class, id);
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
		public boolean update(Task task)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (task == null ? "null" : task.getId()));

		boolean result = false;

		if (task == null) {
			return true;
		}

		task.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(task);
		} catch (DaoException e) {
			log.error(" update wrong : " + task);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + task);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Task> taskList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (taskList == null ? "null" : taskList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(taskList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Task task : taskList) {
			task.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(taskList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + taskList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + taskList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Task getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Task task = null;

		if (id == null) {
			return task;
		}

		try {
			task = (Task) dao.get(Task.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return task;		
		}	
		  
    	   
		@Override
		public List<Task> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Task> task = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Task>();
		}

		try {
			task = (List<Task>) dao.getList(Task.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (task == null ? "null" : task.size()));
    
		return task;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getTaskIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTaskIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTaskIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTaskIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTaskIds " ) ;
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

