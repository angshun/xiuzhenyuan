<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="staffTaskRelation" id="current_nav">
	<div id="staffTaskRelationDetailApp" ng-app="staffTaskRelationDetailApp">
		<div ng-controller="staffTaskRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="staffTaskRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="staffTaskRelationId" ng-model="staffTaskRelation.id" ng-bind="staffTaskRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="staffTaskRelation.staffId" ng-bind="staffTaskRelation.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskId" class="col-sm-2 control-label">任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskId" ng-model="staffTaskRelation.taskId" ng-bind="staffTaskRelation.taskId" placeholder="请输入任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceType" class="col-sm-2 control-label">任务状态（0已参与/1已完成）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceType" ng-model="staffTaskRelation.attendanceType" ng-bind="staffTaskRelation.attendanceType" placeholder="请输入任务状态（0已参与/1已完成）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskType" class="col-sm-2 control-label">任务类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskType" ng-model="staffTaskRelation.taskType" ng-bind="staffTaskRelation.taskType" placeholder="请输入任务类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="staffTaskRelation.createBy" ng-bind="staffTaskRelation.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="staffTaskRelation.updateBy" ng-bind="staffTaskRelation.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateStaffTaskRelation(staffTaskRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/staffTaskRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/staffTaskRelation/staffTaskRelationDetail.js"></script>
