<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="enterpriseLog" id="current_nav">
	<div id="enterpriseLogDetailApp" ng-app="enterpriseLogDetailApp">
		<div ng-controller="enterpriseLogDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="enterpriseLogForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="enterpriseLogId" ng-model="enterpriseLog.id" ng-bind="enterpriseLog.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="enterpriseLog.staffId" ng-bind="enterpriseLog.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="logContent" class="col-sm-2 control-label">日志内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="logContent" ng-model="enterpriseLog.logContent" ng-bind="enterpriseLog.logContent" placeholder="请输入日志内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approveNum" class="col-sm-2 control-label">点赞数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approveNum" ng-model="enterpriseLog.approveNum" ng-bind="enterpriseLog.approveNum" placeholder="请输入点赞数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="commentNum" class="col-sm-2 control-label">评论数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="commentNum" ng-model="enterpriseLog.commentNum" ng-bind="enterpriseLog.commentNum" placeholder="请输入评论数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="picture" class="col-sm-2 control-label">日志图片</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="picture" ng-model="enterpriseLog.picture" ng-bind="enterpriseLog.picture" placeholder="请输入日志图片" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="enterpriseLog.createBy" ng-bind="enterpriseLog.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="enterpriseLog.updateBy" ng-bind="enterpriseLog.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateEnterpriseLog(enterpriseLog)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/enterpriseLog">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/enterpriseLog/enterpriseLogDetail.js"></script>
