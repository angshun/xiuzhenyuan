/**
 * 
 */
package com.ptteng.sca.score.admin.client;

import java.util.List;
import java.util.Map;

import com.ptteng.score.admin.model.Notice;
import com.ptteng.score.admin.service.NoticeService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class NoticeSCAClient implements NoticeService {

    private NoticeService noticeService;

	public NoticeService getNoticeService() {
		return noticeService;
	}
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService =noticeService;
	}
	
	
			   
		@Override
		public Long insert(Notice notice)throws ServiceException, ServiceDaoException{
		
		return noticeService.insert(notice);
		          
		
		}	
		  
    	   
		@Override
		public List<Notice> insertList(List<Notice> noticeList)throws ServiceException, ServiceDaoException{
		
		return noticeService.insertList(noticeList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return noticeService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Notice notice)throws ServiceException, ServiceDaoException{
		
		return noticeService.update(notice);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Notice> noticeList)throws ServiceException, ServiceDaoException{
		
		return noticeService.updateList(noticeList);
		          
		
		}	
		  
    	   
		@Override
		public Notice getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return noticeService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Notice> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return noticeService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getNoticeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return noticeService.getNoticeIds(start, limit);
	}

	@Override
	public Integer countNoticeIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return noticeService.countNoticeIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return noticeService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return noticeService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   noticeService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.noticeService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

