<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="enterpriseApproval" id="current_nav">
	<div id="enterpriseApprovalDetailApp" ng-app="enterpriseApprovalDetailApp">
		<div ng-controller="enterpriseApprovalDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="enterpriseApprovalForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="enterpriseApprovalId" ng-model="enterpriseApproval.id" ng-bind="enterpriseApproval.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">审批标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="enterpriseApproval.title" ng-bind="enterpriseApproval.title" placeholder="请输入审批标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="applyId" class="col-sm-2 control-label">申请人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="applyId" ng-model="enterpriseApproval.applyId" ng-bind="enterpriseApproval.applyId" placeholder="请输入申请人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreType" class="col-sm-2 control-label">积分类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreType" ng-model="enterpriseApproval.scoreType" ng-bind="enterpriseApproval.scoreType" placeholder="请输入积分类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="score" class="col-sm-2 control-label">申请积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="score" ng-model="enterpriseApproval.score" ng-bind="enterpriseApproval.score" placeholder="请输入申请积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">审批状态0审批中/1审批通过/2审批未通过</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="enterpriseApproval.status" ng-bind="enterpriseApproval.status" placeholder="请输入审批状态0审批中/1审批通过/2审批未通过" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">审批内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="enterpriseApproval.content" ng-bind="enterpriseApproval.content" placeholder="请输入审批内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="picture" class="col-sm-2 control-label">审批图片</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="picture" ng-model="enterpriseApproval.picture" ng-bind="enterpriseApproval.picture" placeholder="请输入审批图片" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approvalId" class="col-sm-2 control-label">审批人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approvalId" ng-model="enterpriseApproval.approvalId" ng-bind="enterpriseApproval.approvalId" placeholder="请输入审批人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="enterpriseApproval.createBy" ng-bind="enterpriseApproval.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="enterpriseApproval.updateBy" ng-bind="enterpriseApproval.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateEnterpriseApproval(enterpriseApproval)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/enterpriseApproval">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/enterpriseApproval/enterpriseApprovalDetail.js"></script>
