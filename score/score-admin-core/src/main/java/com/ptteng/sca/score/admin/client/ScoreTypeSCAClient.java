/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.ScoreType;
import com.ptteng.score.admin.service.ScoreTypeService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ScoreTypeSCAClient implements ScoreTypeService {

    private ScoreTypeService scoreTypeService;

	public ScoreTypeService getScoreTypeService() {
		return scoreTypeService;
	}
	
	
	public void setScoreTypeService(ScoreTypeService scoreTypeService) {
		this.scoreTypeService =scoreTypeService;
	}
	
	
			   
		@Override
		public Long insert(ScoreType scoreType)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.insert(scoreType);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreType> insertList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.insertList(scoreTypeList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ScoreType scoreType)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.update(scoreType);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ScoreType> scoreTypeList)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.updateList(scoreTypeList);
		          
		
		}	
		  
    	   
		@Override
		public ScoreType getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ScoreType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return scoreTypeService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getScoreTypeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreTypeService.getScoreTypeIds(start, limit);
	}

	@Override
	public Integer countScoreTypeIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreTypeService.countScoreTypeIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreTypeService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return scoreTypeService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   scoreTypeService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.scoreTypeService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

