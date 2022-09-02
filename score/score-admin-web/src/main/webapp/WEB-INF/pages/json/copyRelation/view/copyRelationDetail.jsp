<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="copyRelation" id="current_nav">
	<div id="copyRelationDetailApp" ng-app="copyRelationDetailApp">
		<div ng-controller="copyRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="copyRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="copyRelationId" ng-model="copyRelation.id" ng-bind="copyRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="recordId" class="col-sm-2 control-label">申请记录id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="recordId" ng-model="copyRelation.recordId" ng-bind="copyRelation.recordId" placeholder="请输入申请记录id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="copyId" class="col-sm-2 control-label">抄送人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="copyId" ng-model="copyRelation.copyId" ng-bind="copyRelation.copyId" placeholder="请输入抄送人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="copyRelation.createBy" ng-bind="copyRelation.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="copyRelation.updateBy" ng-bind="copyRelation.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateCopyRelation(copyRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/copyRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/copyRelation/copyRelationDetail.js"></script>
