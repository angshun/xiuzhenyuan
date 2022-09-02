<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="approveLog" id="current_nav">
	<div id="approveLogDetailApp" ng-app="approveLogDetailApp">
		<div ng-controller="approveLogDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="approveLogForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="approveLogId" ng-model="approveLog.id" ng-bind="approveLog.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">点赞类型（点赞日志、点赞人）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="approveLog.type" ng-bind="approveLog.type" placeholder="请输入点赞类型（点赞日志、点赞人）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="logId" class="col-sm-2 control-label">日志id/被点赞人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="logId" ng-model="approveLog.logId" ng-bind="approveLog.logId" placeholder="请输入日志id/被点赞人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceType" class="col-sm-2 control-label">点赞人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceType" ng-model="approveLog.attendanceType" ng-bind="approveLog.attendanceType" placeholder="请输入点赞人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="approveLog.createBy" ng-bind="approveLog.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="approveLog.updateBy" ng-bind="approveLog.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateApproveLog(approveLog)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/approveLog">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/approveLog/approveLogDetail.js"></script>
