<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="attendanceLog" id="current_nav">
	<div id="attendanceLogDetailApp" ng-app="attendanceLogDetailApp">
		<div ng-controller="attendanceLogDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="attendanceLogForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="attendanceLogId" ng-model="attendanceLog.id" ng-bind="attendanceLog.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">员工id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="attendanceLog.staffId" ng-bind="attendanceLog.staffId" placeholder="请输入员工id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceType" class="col-sm-2 control-label">考勤类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceType" ng-model="attendanceLog.attendanceType" ng-bind="attendanceLog.attendanceType" placeholder="请输入考勤类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceAddress" class="col-sm-2 control-label">考勤地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceAddress" ng-model="attendanceLog.attendanceAddress" ng-bind="attendanceLog.attendanceAddress" placeholder="请输入考勤地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceStatus" class="col-sm-2 control-label">考勤状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceStatus" ng-model="attendanceLog.attendanceStatus" ng-bind="attendanceLog.attendanceStatus" placeholder="请输入考勤状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="attendanceLog.createBy" ng-bind="attendanceLog.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="attendanceLog.updateBy" ng-bind="attendanceLog.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAttendanceLog(attendanceLog)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/attendanceLog">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/attendanceLog/attendanceLogDetail.js"></script>
