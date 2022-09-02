/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.service.TaskService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TaskSCAClient implements TaskService {

    private TaskService taskService;

	public TaskService getTaskService() {
		return taskService;
	}
	
	
	public void setTaskService(TaskService taskService) {
		this.taskService =taskService;
	}
	
	
			   
		@Override
		public Long insert(Task task)throws ServiceException, ServiceDaoException{
		
		return taskService.insert(task);
		          
		
		}	
		  
    	   
		@Override
		public List<Task> insertList(List<Task> taskList)throws ServiceException, ServiceDaoException{
		
		return taskService.insertList(taskList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return taskService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Task task)throws ServiceException, ServiceDaoException{
		
		return taskService.update(task);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Task> taskList)throws ServiceException, ServiceDaoException{
		
		return taskService.updateList(taskList);
		          
		
		}	
		  
    	   
		@Override
		public Task getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return taskService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Task> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return taskService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getTaskIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return taskService.getTaskIds(start, limit);
	}

	@Override
	public Integer countTaskIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return taskService.countTaskIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return taskService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return taskService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   taskService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.taskService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

