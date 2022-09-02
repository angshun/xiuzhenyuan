<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="module" id="current_nav">
	<div id="moduleDetailApp" ng-app="moduleDetailApp">
		<div ng-controller="moduleDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="moduleForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="moduleId" ng-model="module.id" ng-bind="module.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">模块名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="module.name" ng-bind="module.name" placeholder="请输入模块名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pid" class="col-sm-2 control-label">父模块id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pid" ng-model="module.pid" ng-bind="module.pid" placeholder="请输入父模块id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">模块类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="module.type" ng-bind="module.type" placeholder="请输入模块类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="menuId" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="menuId" ng-model="module.menuId" ng-bind="module.menuId" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="icon" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="icon" ng-model="module.icon" ng-bind="module.icon" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="level" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="level" ng-model="module.level" ng-bind="module.level" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="url" class="col-sm-2 control-label">模块相对于的url</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="url" ng-model="module.url" ng-bind="module.url" placeholder="请输入模块相对于的url" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="module.createBy" ng-bind="module.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="module.updateBy" ng-bind="module.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateModule(module)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/module">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-bangbang-admin-service/module/moduleDetail.js"></script>
