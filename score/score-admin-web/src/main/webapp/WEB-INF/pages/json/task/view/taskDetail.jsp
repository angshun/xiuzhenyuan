<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="task" id="current_nav">
	<div id="taskDetailApp" ng-app="taskDetailApp">
		<div ng-controller="taskDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="taskForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="taskId" ng-model="task.id" ng-bind="task.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">任务名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="task.name" ng-bind="task.name" placeholder="请输入任务名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">任务标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="task.title" ng-bind="task.title" placeholder="请输入任务标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">任务内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="task.content" ng-bind="task.content" placeholder="请输入任务内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreType" class="col-sm-2 control-label">积分类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreType" ng-model="task.scoreType" ng-bind="task.scoreType" placeholder="请输入积分类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskType" class="col-sm-2 control-label">任务类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskType" ng-model="task.taskType" ng-bind="task.taskType" placeholder="请输入任务类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="project" class="col-sm-2 control-label">可申请方式</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="project" ng-model="task.project" ng-bind="task.project" placeholder="请输入可申请方式" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="startAt" class="col-sm-2 control-label">任务开始时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="startAt" ng-model="task.startAt" ng-bind="task.startAt" placeholder="请输入任务开始时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="endAt" class="col-sm-2 control-label">任务结束时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="endAt" ng-model="task.endAt" ng-bind="task.endAt" placeholder="请输入任务结束时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="joinNum" class="col-sm-2 control-label">已参加人数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="joinNum" ng-model="task.joinNum" ng-bind="task.joinNum" placeholder="请输入已参加人数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="number" class="col-sm-2 control-label">限制人数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="number" ng-model="task.number" ng-bind="task.number" placeholder="请输入限制人数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="times" class="col-sm-2 control-label">已完成次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="times" ng-model="task.times" ng-bind="task.times" placeholder="请输入已完成次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskScore" class="col-sm-2 control-label">任务积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskScore" ng-model="task.taskScore" ng-bind="task.taskScore" placeholder="请输入任务积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="visualDepartment" class="col-sm-2 control-label">可见部门(数组)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="visualDepartment" ng-model="task.visualDepartment" ng-bind="task.visualDepartment" placeholder="请输入可见部门(数组)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskStatus" class="col-sm-2 control-label">任务状态（始终为null，表示参与/未参与/完成）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskStatus" ng-model="task.taskStatus" ng-bind="task.taskStatus" placeholder="请输入任务状态（始终为null，表示参与/未参与/完成）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="task.createBy" ng-bind="task.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="task.updateBy" ng-bind="task.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateTask(task)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/task">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/task/taskDetail.js"></script>
