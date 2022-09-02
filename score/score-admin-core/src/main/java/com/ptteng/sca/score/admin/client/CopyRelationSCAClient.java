/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.CopyRelation;
import com.ptteng.score.admin.service.CopyRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CopyRelationSCAClient implements CopyRelationService {

    private CopyRelationService copyRelationService;

	public CopyRelationService getCopyRelationService() {
		return copyRelationService;
	}
	
	
	public void setCopyRelationService(CopyRelationService copyRelationService) {
		this.copyRelationService =copyRelationService;
	}
	
	
			   
		@Override
		public Long insert(CopyRelation copyRelation)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.insert(copyRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<CopyRelation> insertList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.insertList(copyRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CopyRelation copyRelation)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.update(copyRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CopyRelation> copyRelationList)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.updateList(copyRelationList);
		          
		
		}	
		  
    	   
		@Override
		public CopyRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CopyRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return copyRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getCopyRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return copyRelationService.getCopyRelationIds(start, limit);
	}

	@Override
	public Integer countCopyRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return copyRelationService.countCopyRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return copyRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return copyRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   copyRelationService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.copyRelationService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

