package com.ptteng.score.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ptteng.score.home.model.Goods;
import com.ptteng.score.home.service.GoodsService;

import java.util.ArrayList;
import java.util.List;


public class GoodsServiceImpl extends BaseDaoServiceImpl implements GoodsService {

 

	private static final Log log = LogFactory.getLog(GoodsServiceImpl.class);



		   
		@Override
		public Long insert(Goods goods)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + goods);

		if (goods == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		goods.setCreateAt(currentTimeMillis);
		goods.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(goods);
		} catch (DaoException e) {
			log.error(" insert wrong : " + goods);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Goods> insertList(List<Goods> goodsList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (goodsList == null ? "null" : goodsList.size()));
      
		List<Goods> resultList = null;

		if (CollectionUtils.isEmpty(goodsList)) {
			return new ArrayList<Goods>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Goods goods : goodsList) {
			goods.setCreateAt(currentTimeMillis);
			goods.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Goods>) dao.batchSave(goodsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + goodsList);
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
			result = dao.delete(Goods.class, id);
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
		public boolean update(Goods goods)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (goods == null ? "null" : goods.getId()));

		boolean result = false;

		if (goods == null) {
			return true;
		}

		goods.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(goods);
		} catch (DaoException e) {
			log.error(" update wrong : " + goods);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + goods);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Goods> goodsList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (goodsList == null ? "null" : goodsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(goodsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Goods goods : goodsList) {
			goods.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(goodsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + goodsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + goodsList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Goods getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Goods goods = null;

		if (id == null) {
			return goods;
		}

		try {
			goods = (Goods) dao.get(Goods.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return goods;		
		}	
		  
    	   
		@Override
		public List<Goods> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Goods> goods = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Goods>();
		}

		try {
			goods = (List<Goods>) dao.getList(Goods.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (goods == null ? "null" : goods.size()));
    
		return goods;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getGoodsIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGoodsIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGoodsIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGoodsIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGoodsIds " ) ;
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

