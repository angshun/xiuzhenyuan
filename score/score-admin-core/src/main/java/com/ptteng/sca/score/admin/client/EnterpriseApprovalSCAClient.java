/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.EnterpriseApproval;
import com.ptteng.score.admin.service.EnterpriseApprovalService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class EnterpriseApprovalSCAClient implements EnterpriseApprovalService {

    private EnterpriseApprovalService enterpriseApprovalService;

	public EnterpriseApprovalService getEnterpriseApprovalService() {
		return enterpriseApprovalService;
	}
	
	
	public void setEnterpriseApprovalService(EnterpriseApprovalService enterpriseApprovalService) {
		this.enterpriseApprovalService =enterpriseApprovalService;
	}
	
	
			   
		@Override
		public Long insert(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.insert(enterpriseApproval);
		          
		
		}	
		  
    	   
		@Override
		public List<EnterpriseApproval> insertList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.insertList(enterpriseApprovalList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(EnterpriseApproval enterpriseApproval)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.update(enterpriseApproval);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<EnterpriseApproval> enterpriseApprovalList)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.updateList(enterpriseApprovalList);
		          
		
		}	
		  
    	   
		@Override
		public EnterpriseApproval getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<EnterpriseApproval> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return enterpriseApprovalService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getEnterpriseApprovalIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseApprovalService.getEnterpriseApprovalIds(start, limit);
	}

	@Override
	public Integer countEnterpriseApprovalIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseApprovalService.countEnterpriseApprovalIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseApprovalService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return enterpriseApprovalService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   enterpriseApprovalService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.enterpriseApprovalService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

