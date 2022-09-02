package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Department;
import com.ptteng.score.home.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;


public class DepartmentServiceImpl extends BaseDaoServiceImpl implements DepartmentService {

 

	private static final Log log = LogFactory.getLog(DepartmentServiceImpl.class);



		   
		@Override
		public Long insert(Department department)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + department);

		if (department == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		department.setCreateAt(currentTimeMillis);
		department.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(department);
		} catch (DaoException e) {
			log.error(" insert wrong : " + department);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Department> insertList(List<Department> departmentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (departmentList == null ? "null" : departmentList.size()));
      
		List<Department> resultList = null;

		if (CollectionUtils.isEmpty(departmentList)) {
			return new ArrayList<Department>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Department department : departmentList) {
			department.setCreateAt(currentTimeMillis);
			department.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Department>) dao.batchSave(departmentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + departmentList);
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
			result = dao.delete(Department.class, id);
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
		public boolean update(Department department)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (department == null ? "null" : department.getId()));

		boolean result = false;

		if (department == null) {
			return true;
		}

		department.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(department);
		} catch (DaoException e) {
			log.error(" update wrong : " + department);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + department);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Department> departmentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (departmentList == null ? "null" : departmentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(departmentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Department department : departmentList) {
			department.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(departmentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + departmentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + departmentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Department getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Department department = null;

		if (id == null) {
			return department;
		}

		try {
			department = (Department) dao.get(Department.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return department;		
		}	
		  
    	   
		@Override
		public List<Department> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Department> department = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Department>();
		}

		try {
			department = (List<Department>) dao.getList(Department.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (department == null ? "null" : department.size()));
    
		return department;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getDepartmentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDepartmentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDepartmentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDepartmentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDepartmentIds " ) ;
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

