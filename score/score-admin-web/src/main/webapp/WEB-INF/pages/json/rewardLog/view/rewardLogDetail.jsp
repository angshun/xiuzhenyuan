<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="rewardLog" id="current_nav">
	<div id="rewardLogDetailApp" ng-app="rewardLogDetailApp">
		<div ng-controller="rewardLogDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="rewardLogForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="rewardLogId" ng-model="rewardLog.id" ng-bind="rewardLog.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="rewardLog.staffId" ng-bind="rewardLog.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="adminName" class="col-sm-2 control-label">管理员姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="adminName" ng-model="rewardLog.adminName" ng-bind="rewardLog.adminName" placeholder="请输入管理员姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="adminPhoto" class="col-sm-2 control-label">管理员头像</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="adminPhoto" ng-model="rewardLog.adminPhoto" ng-bind="rewardLog.adminPhoto" placeholder="请输入管理员头像" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="rewardContent" class="col-sm-2 control-label">表扬内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="rewardContent" ng-model="rewardLog.rewardContent" ng-bind="rewardLog.rewardContent" placeholder="请输入表扬内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="rewardScore" class="col-sm-2 control-label">表扬积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="rewardScore" ng-model="rewardLog.rewardScore" ng-bind="rewardLog.rewardScore" placeholder="请输入表扬积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="rewardRemark" class="col-sm-2 control-label">审批备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="rewardRemark" ng-model="rewardLog.rewardRemark" ng-bind="rewardLog.rewardRemark" placeholder="请输入审批备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="rewardTitle" class="col-sm-2 control-label">表扬标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="rewardTitle" ng-model="rewardLog.rewardTitle" ng-bind="rewardLog.rewardTitle" placeholder="请输入表扬标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreType" class="col-sm-2 control-label">积分类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreType" ng-model="rewardLog.scoreType" ng-bind="rewardLog.scoreType" placeholder="请输入积分类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="rewardLog.createBy" ng-bind="rewardLog.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="rewardLog.updateBy" ng-bind="rewardLog.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateRewardLog(rewardLog)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/rewardLog">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/rewardLog/rewardLogDetail.js"></script>
