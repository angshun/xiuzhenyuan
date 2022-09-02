/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.ApplyManage;
import com.ptteng.score.admin.service.ApplyManageService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ApplyManageSCAClient implements ApplyManageService {

    private ApplyManageService applyManageService;

	public ApplyManageService getApplyManageService() {
		return applyManageService;
	}
	
	
	public void setApplyManageService(ApplyManageService applyManageService) {
		this.applyManageService =applyManageService;
	}
	
	
			   
		@Override
		public Long insert(ApplyManage applyManage)throws ServiceException, ServiceDaoException{
		
		return applyManageService.insert(applyManage);
		          
		
		}	
		  
    	   
		@Override
		public List<ApplyManage> insertList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException{
		
		return applyManageService.insertList(applyManageList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return applyManageService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ApplyManage applyManage)throws ServiceException, ServiceDaoException{
		
		return applyManageService.update(applyManage);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ApplyManage> applyManageList)throws ServiceException, ServiceDaoException{
		
		return applyManageService.updateList(applyManageList);
		          
		
		}	
		  
    	   
		@Override
		public ApplyManage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return applyManageService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ApplyManage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return applyManageService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getApplyManageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return applyManageService.getApplyManageIds(start, limit);
	}

	@Override
	public Integer countApplyManageIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return applyManageService.countApplyManageIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return applyManageService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return applyManageService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   applyManageService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.applyManageService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

