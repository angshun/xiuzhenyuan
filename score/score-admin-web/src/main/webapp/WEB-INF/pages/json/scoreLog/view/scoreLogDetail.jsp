<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="scoreLog" id="current_nav">
	<div id="scoreLogDetailApp" ng-app="scoreLogDetailApp">
		<div ng-controller="scoreLogDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="scoreLogForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="scoreLogId" ng-model="scoreLog.id" ng-bind="scoreLog.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="scoreLog.staffId" ng-bind="scoreLog.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreReason" class="col-sm-2 control-label">积分项目</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreReason" ng-model="scoreLog.scoreReason" ng-bind="scoreLog.scoreReason" placeholder="请输入积分项目" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreChange" class="col-sm-2 control-label">积分变动</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreChange" ng-model="scoreLog.scoreChange" ng-bind="scoreLog.scoreChange" placeholder="请输入积分变动" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreType" class="col-sm-2 control-label">积分类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreType" ng-model="scoreLog.scoreType" ng-bind="scoreLog.scoreType" placeholder="请输入积分类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="scoreLog.createBy" ng-bind="scoreLog.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="scoreLog.updateBy" ng-bind="scoreLog.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateScoreLog(scoreLog)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/scoreLog">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/scoreLog/scoreLogDetail.js"></script>
