/**
 * 
 */
package com.ptteng.sca.carrots.bangbang.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.ProfessionTag;
import com.ptteng.carrots.bangbang.service.ProfessionTagService;

import java.util.List;
import java.util.Map;

public class ProfessionTagSCAClient implements ProfessionTagService {

    private ProfessionTagService professionTagService;

	public ProfessionTagService getProfessionTagService() {
		return professionTagService;
	}
	
	
	public void setProfessionTagService(ProfessionTagService professionTagService) {
		this.professionTagService =professionTagService;
	}
	
	
			   
		@Override
		public Long insert(ProfessionTag professionTag)throws ServiceException, ServiceDaoException{
		
		return professionTagService.insert(professionTag);
		          
		
		}	
		  
    	   
		@Override
		public List<ProfessionTag> insertList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException{
		
		return professionTagService.insertList(professionTagList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return professionTagService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ProfessionTag professionTag)throws ServiceException, ServiceDaoException{
		
		return professionTagService.update(professionTag);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ProfessionTag> professionTagList)throws ServiceException, ServiceDaoException{
		
		return professionTagService.updateList(professionTagList);
		          
		
		}	
		  
    	   
		@Override
		public ProfessionTag getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return professionTagService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ProfessionTag> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return professionTagService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getProfessionTagIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionTagService.getProfessionTagIds(start, limit);
	}

	@Override
	public Integer countProfessionTagIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionTagService.countProfessionTagIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionTagService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return professionTagService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   professionTagService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.professionTagService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

