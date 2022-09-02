<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="philosophy" id="current_nav">
	<div id="philosophyDetailApp" ng-app="philosophyDetailApp">
		<div ng-controller="philosophyDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="philosophyForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="philosophyId" ng-model="philosophy.id" ng-bind="philosophy.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="philosophy.title" ng-bind="philosophy.title" placeholder="请输入标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="reward" class="col-sm-2 control-label">奖励积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="reward" ng-model="philosophy.reward" ng-bind="philosophy.reward" placeholder="请输入奖励积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">经营内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="philosophy.content" ng-bind="philosophy.content" placeholder="请输入经营内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="project" class="col-sm-2 control-label">可申请方式</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="project" ng-model="philosophy.project" ng-bind="philosophy.project" placeholder="请输入可申请方式" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="readNum" class="col-sm-2 control-label">已阅读次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="readNum" ng-model="philosophy.readNum" ng-bind="philosophy.readNum" placeholder="请输入已阅读次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">积分状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="philosophy.status" ng-bind="philosophy.status" placeholder="请输入积分状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="articleStatus" class="col-sm-2 control-label">状态（已阅读/未阅读）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="articleStatus" ng-model="philosophy.articleStatus" ng-bind="philosophy.articleStatus" placeholder="请输入状态（已阅读/未阅读）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="philosophy.createBy" ng-bind="philosophy.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="philosophy.updateBy" ng-bind="philosophy.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updatePhilosophy(philosophy)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/philosophy">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/philosophy/philosophyDetail.js"></script>
