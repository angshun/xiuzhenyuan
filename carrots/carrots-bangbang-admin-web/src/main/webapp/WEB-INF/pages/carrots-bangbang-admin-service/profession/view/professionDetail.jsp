<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="profession" id="current_nav">
	<div id="professionDetailApp" ng-app="professionDetailApp">
		<div ng-controller="professionDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="professionForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="professionId" ng-model="profession.id" ng-bind="profession.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">职业名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="profession.name" ng-bind="profession.name" placeholder="请输入职业名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cId" class="col-sm-2 control-label">公司id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cId" ng-model="profession.cId" ng-bind="profession.cId" placeholder="请输入公司id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="releaseAt" class="col-sm-2 control-label">发布时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="releaseAt" ng-model="profession.releaseAt" ng-bind="profession.releaseAt" placeholder="请输入发布时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="salary" class="col-sm-2 control-label">薪资</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="salary" ng-model="profession.salary" ng-bind="profession.salary" placeholder="请输入薪资" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="education" class="col-sm-2 control-label">学历</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="education" ng-model="profession.education" ng-bind="profession.education" placeholder="请输入学历" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="workExperience" class="col-sm-2 control-label">工作经验</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="workExperience" ng-model="profession.workExperience" ng-bind="profession.workExperience" placeholder="请输入工作经验" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">上架状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="profession.status" ng-bind="profession.status" placeholder="请输入上架状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="responsibility" class="col-sm-2 control-label">岗位职责</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="responsibility" ng-model="profession.responsibility" ng-bind="profession.responsibility" placeholder="请输入岗位职责" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="requirement" class="col-sm-2 control-label">必备条件</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="requirement" ng-model="profession.requirement" ng-bind="profession.requirement" placeholder="请输入必备条件" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="welfare" class="col-sm-2 control-label">公司福利</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="welfare" ng-model="profession.welfare" ng-bind="profession.welfare" placeholder="请输入公司福利" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="profession.createBy" ng-bind="profession.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="profession.updateBy" ng-bind="profession.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProfession(profession)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/profession">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-bangbang-admin-service/profession/professionDetail.js"></script>
