<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="allTypeScore" id="current_nav">
	<div id="allTypeScoreDetailApp" ng-app="allTypeScoreDetailApp">
		<div ng-controller="allTypeScoreDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="allTypeScoreForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="allTypeScoreId" ng-model="allTypeScore.id" ng-bind="allTypeScore.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">类型(职位0/学历1/荣耀2/职称3/特长4)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="allTypeScore.type" ng-bind="allTypeScore.type" placeholder="请输入类型(职位0/学历1/荣耀2/职称3/特长4)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">积分名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="allTypeScore.name" ng-bind="allTypeScore.name" placeholder="请输入积分名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="score" class="col-sm-2 control-label">积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="score" ng-model="allTypeScore.score" ng-bind="allTypeScore.score" placeholder="请输入积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="allTypeScore.createBy" ng-bind="allTypeScore.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="allTypeScore.updateBy" ng-bind="allTypeScore.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAllTypeScore(allTypeScore)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/allTypeScore">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/allTypeScore/allTypeScoreDetail.js"></script>
