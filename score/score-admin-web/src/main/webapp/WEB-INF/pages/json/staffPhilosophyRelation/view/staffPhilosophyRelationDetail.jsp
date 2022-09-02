<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="staffPhilosophyRelation" id="current_nav">
	<div id="staffPhilosophyRelationDetailApp" ng-app="staffPhilosophyRelationDetailApp">
		<div ng-controller="staffPhilosophyRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="staffPhilosophyRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="staffPhilosophyRelationId" ng-model="staffPhilosophyRelation.id" ng-bind="staffPhilosophyRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="staffPhilosophyRelation.staffId" ng-bind="staffPhilosophyRelation.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="philosophyId" class="col-sm-2 control-label">文章id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="philosophyId" ng-model="staffPhilosophyRelation.philosophyId" ng-bind="staffPhilosophyRelation.philosophyId" placeholder="请输入文章id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="staffPhilosophyRelation.createBy" ng-bind="staffPhilosophyRelation.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="staffPhilosophyRelation.updateBy" ng-bind="staffPhilosophyRelation.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateStaffPhilosophyRelation(staffPhilosophyRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/staffPhilosophyRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/staffPhilosophyRelation/staffPhilosophyRelationDetail.js"></script>
