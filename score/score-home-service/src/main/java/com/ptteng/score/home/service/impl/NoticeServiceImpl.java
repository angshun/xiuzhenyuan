package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Notice;
import com.ptteng.score.home.service.NoticeService;

import java.util.ArrayList;
import java.util.List;


public class NoticeServiceImpl extends BaseDaoServiceImpl implements NoticeService {

 

	private static final Log log = LogFactory.getLog(NoticeServiceImpl.class);



		   
		@Override
		public Long insert(Notice notice)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + notice);

		if (notice == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		notice.setCreateAt(currentTimeMillis);
		notice.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(notice);
		} catch (DaoException e) {
			log.error(" insert wrong : " + notice);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Notice> insertList(List<Notice> noticeList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (noticeList == null ? "null" : noticeList.size()));
      
		List<Notice> resultList = null;

		if (CollectionUtils.isEmpty(noticeList)) {
			return new ArrayList<Notice>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Notice notice : noticeList) {
			notice.setCreateAt(currentTimeMillis);
			notice.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Notice>) dao.batchSave(noticeList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + noticeList);
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
			result = dao.delete(Notice.class, id);
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
		public boolean update(Notice notice)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (notice == null ? "null" : notice.getId()));

		boolean result = false;

		if (notice == null) {
			return true;
		}

		notice.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(notice);
		} catch (DaoException e) {
			log.error(" update wrong : " + notice);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + notice);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Notice> noticeList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (noticeList == null ? "null" : noticeList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(noticeList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Notice notice : noticeList) {
			notice.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(noticeList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + noticeList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + noticeList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Notice getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Notice notice = null;

		if (id == null) {
			return notice;
		}

		try {
			notice = (Notice) dao.get(Notice.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return notice;		
		}	
		  
    	   
		@Override
		public List<Notice> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Notice> notice = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Notice>();
		}

		try {
			notice = (List<Notice>) dao.getList(Notice.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (notice == null ? "null" : notice.size()));
    
		return notice;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getNoticeIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getNoticeIdsAll",new Object[] {},start, limit, false);
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
	public Integer countNoticeIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getNoticeIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getNoticeIds " ) ;
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

