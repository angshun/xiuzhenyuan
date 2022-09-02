package com.ptteng.score.home.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

import com.ptteng.score.home.model.Goods;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface GoodsService extends BaseDaoService {

	



   		   
		
		public Long insert(Goods goods)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Goods> insertList(List<Goods> goodsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Goods goods)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Goods> goodsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Goods getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Goods> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public List<Long> getGoodsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 *
	 *
	 */
	public Integer countGoodsIds() throws ServiceException, ServiceDaoException;
	

}

