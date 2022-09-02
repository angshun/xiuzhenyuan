package com.ptteng.score.admin.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.StaffService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class StaffServiceImpl extends BaseDaoServiceImpl implements StaffService {

 

	private static final Log log = LogFactory.getLog(StaffServiceImpl.class);



		   
		@Override
		public Long insert(Staff staff)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + staff);

		if (staff == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		staff.setCreateAt(currentTimeMillis);
		staff.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(staff);
		} catch (DaoException e) {
			log.error(" insert wrong : " + staff);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Staff> insertList(List<Staff> staffList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (staffList == null ? "null" : staffList.size()));
      
		List<Staff> resultList = null;

		if (CollectionUtils.isEmpty(staffList)) {
			return new ArrayList<Staff>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Staff staff : staffList) {
			staff.setCreateAt(currentTimeMillis);
			staff.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Staff>) dao.batchSave(staffList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + staffList);
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
			result = dao.delete(Staff.class, id);
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
		public boolean update(Staff staff)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (staff == null ? "null" : staff.getId()));

		boolean result = false;

		if (staff == null) {
			return true;
		}

		staff.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(staff);
		} catch (DaoException e) {
			log.error(" update wrong : " + staff);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + staff);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Staff> staffList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (staffList == null ? "null" : staffList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(staffList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Staff staff : staffList) {
			staff.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(staffList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + staffList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + staffList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Staff getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Staff staff = null;

		if (id == null) {
			return staff;
		}

		try {
			staff = (Staff) dao.get(Staff.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return staff;		
		}	
		  
    	   
		@Override
		public List<Staff> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Staff> staff = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Staff>();
		}

		try {
			staff = (List<Staff>) dao.getList(Staff.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (staff == null ? "null" : staff.size()));
    
		return staff;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getStaffIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getStaffIdsAll",new Object[] {},start, limit, false);
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
	public Integer countStaffIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getStaffIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getStaffIds " ) ;
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

