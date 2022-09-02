<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="manager" id="current_nav">
	<div id="managerDetailApp" ng-app="managerDetailApp">
		<div ng-controller="managerDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="managerForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="managerId" ng-model="manager.id" ng-bind="manager.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="mobile" class="col-sm-2 control-label">手机号码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="mobile" ng-model="manager.mobile" ng-bind="manager.mobile" placeholder="请输入手机号码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="rid" class="col-sm-2 control-label">角色id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="rid" ng-model="manager.rid" ng-bind="manager.rid" placeholder="请输入角色id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pwd" class="col-sm-2 control-label">密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pwd" ng-model="manager.pwd" ng-bind="manager.pwd" placeholder="请输入密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">用户名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="manager.name" ng-bind="manager.name" placeholder="请输入用户名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="manager.status" ng-bind="manager.status" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="manager.createBy" ng-bind="manager.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="manager.updateBy" ng-bind="manager.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateManager(manager)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/manager">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-bangbang-admin-service/manager/managerDetail.js"></script>
