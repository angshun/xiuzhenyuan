package com.ptteng.carrots.bangbang.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Product;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ProductService extends BaseDaoService {

	



   		   
		
		public Long insert(Product product)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Product> insertList(List<Product> productList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Product product)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Product> productList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Product getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Product> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getProductIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countProductIds() throws ServiceException, ServiceDaoException;
	

}

