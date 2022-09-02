<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="scoreType" id="current_nav">
	<div id="scoreTypeDetailApp" ng-app="scoreTypeDetailApp">
		<div ng-controller="scoreTypeDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="scoreTypeForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="scoreTypeId" ng-model="scoreType.id" ng-bind="scoreType.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="moral" class="col-sm-2 control-label">品德准则</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="moral" ng-model="scoreType.moral" ng-bind="scoreType.moral" placeholder="请输入品德准则" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">积分详细内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="scoreType.content" ng-bind="scoreType.content" placeholder="请输入积分详细内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="project" class="col-sm-2 control-label">可申请方式</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="project" ng-model="scoreType.project" ng-bind="scoreType.project" placeholder="请输入可申请方式" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreType" class="col-sm-2 control-label">积分类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreType" ng-model="scoreType.scoreType" ng-bind="scoreType.scoreType" placeholder="请输入积分类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="times" class="col-sm-2 control-label">已完成次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="times" ng-model="scoreType.times" ng-bind="scoreType.times" placeholder="请输入已完成次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">积分状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="scoreType.status" ng-bind="scoreType.status" placeholder="请输入积分状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="scoreType.createBy" ng-bind="scoreType.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="scoreType.updateBy" ng-bind="scoreType.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateScoreType(scoreType)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/scoreType">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/scoreType/scoreTypeDetail.js"></script>
