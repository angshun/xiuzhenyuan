<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="professionTag" id="current_nav">
	<div id="professionTagDetailApp" ng-app="professionTagDetailApp">
		<div ng-controller="professionTagDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="professionTagForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="professionTagId" ng-model="professionTag.id" ng-bind="professionTag.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cId" class="col-sm-2 control-label">公司id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cId" ng-model="professionTag.cId" ng-bind="professionTag.cId" placeholder="请输入公司id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pId" class="col-sm-2 control-label">职业id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pId" ng-model="professionTag.pId" ng-bind="professionTag.pId" placeholder="请输入职业id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tag" class="col-sm-2 control-label">职业标签</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tag" ng-model="professionTag.tag" ng-bind="professionTag.tag" placeholder="请输入职业标签" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="professionTag.createBy" ng-bind="professionTag.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="professionTag.updateBy" ng-bind="professionTag.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProfessionTag(professionTag)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/professionTag">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/carrots-bangbang-admin-service/professionTag/professionTagDetail.js"></script>
