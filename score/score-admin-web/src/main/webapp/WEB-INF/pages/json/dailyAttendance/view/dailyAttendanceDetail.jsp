<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="dailyAttendance" id="current_nav">
	<div id="dailyAttendanceDetailApp" ng-app="dailyAttendanceDetailApp">
		<div ng-controller="dailyAttendanceDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="dailyAttendanceForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="dailyAttendanceId" ng-model="dailyAttendance.id" ng-bind="dailyAttendance.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceType" class="col-sm-2 control-label">考勤类型0内勤1外勤</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceType" ng-model="dailyAttendance.attendanceType" ng-bind="dailyAttendance.attendanceType" placeholder="请输入考勤类型0内勤1外勤" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="normalScore" class="col-sm-2 control-label">正常奖励分数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="normalScore" ng-model="dailyAttendance.normalScore" ng-bind="dailyAttendance.normalScore" placeholder="请输入正常奖励分数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="morningScore" class="col-sm-2 control-label">早到奖励积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="morningScore" ng-model="dailyAttendance.morningScore" ng-bind="dailyAttendance.morningScore" placeholder="请输入早到奖励积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="lateScore" class="col-sm-2 control-label">迟到减积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="lateScore" ng-model="dailyAttendance.lateScore" ng-bind="dailyAttendance.lateScore" placeholder="请输入迟到减积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="overtimeScore" class="col-sm-2 control-label">加班奖励积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="overtimeScore" ng-model="dailyAttendance.overtimeScore" ng-bind="dailyAttendance.overtimeScore" placeholder="请输入加班奖励积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="leftEarlyScore" class="col-sm-2 control-label">早退减积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="leftEarlyScore" ng-model="dailyAttendance.leftEarlyScore" ng-bind="dailyAttendance.leftEarlyScore" placeholder="请输入早退减积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="absenceScore" class="col-sm-2 control-label">缺勤扣积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="absenceScore" ng-model="dailyAttendance.absenceScore" ng-bind="dailyAttendance.absenceScore" placeholder="请输入缺勤扣积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="workTime" class="col-sm-2 control-label">上班时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="workTime" ng-model="dailyAttendance.workTime" ng-bind="dailyAttendance.workTime" placeholder="请输入上班时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="closingTime" class="col-sm-2 control-label">下班时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="closingTime" ng-model="dailyAttendance.closingTime" ng-bind="dailyAttendance.closingTime" placeholder="请输入下班时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyCoordinate" class="col-sm-2 control-label">公司地址(经纬度)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyCoordinate" ng-model="dailyAttendance.companyCoordinate" ng-bind="dailyAttendance.companyCoordinate" placeholder="请输入公司地址(经纬度)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attendanceInstance" class="col-sm-2 control-label">考勤校验距离</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attendanceInstance" ng-model="dailyAttendance.attendanceInstance" ng-bind="dailyAttendance.attendanceInstance" placeholder="请输入考勤校验距离" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="outsideWorkTimeScore" class="col-sm-2 control-label">外勤正常上班时间奖励</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="outsideWorkTimeScore" ng-model="dailyAttendance.outsideWorkTimeScore" ng-bind="dailyAttendance.outsideWorkTimeScore" placeholder="请输入外勤正常上班时间奖励" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="outsideClosingTimeScore" class="col-sm-2 control-label">外勤正常下班时间奖励</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="outsideClosingTimeScore" ng-model="dailyAttendance.outsideClosingTimeScore" ng-bind="dailyAttendance.outsideClosingTimeScore" placeholder="请输入外勤正常下班时间奖励" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="logReleaseTime" class="col-sm-2 control-label">每天发布日志次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="logReleaseTime" ng-model="dailyAttendance.logReleaseTime" ng-bind="dailyAttendance.logReleaseTime" placeholder="请输入每天发布日志次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approveScore" class="col-sm-2 control-label">点赞他人日报获得积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approveScore" ng-model="dailyAttendance.approveScore" ng-bind="dailyAttendance.approveScore" placeholder="请输入点赞他人日报获得积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beApproveScore" class="col-sm-2 control-label">日报被赞获得积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beApproveScore" ng-model="dailyAttendance.beApproveScore" ng-bind="dailyAttendance.beApproveScore" placeholder="请输入日报被赞获得积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="loveScore" class="col-sm-2 control-label">爱心积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="loveScore" ng-model="dailyAttendance.loveScore" ng-bind="dailyAttendance.loveScore" placeholder="请输入爱心积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sunScore" class="col-sm-2 control-label">太阳积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sunScore" ng-model="dailyAttendance.sunScore" ng-bind="dailyAttendance.sunScore" placeholder="请输入太阳积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="dailyAttendance.createBy" ng-bind="dailyAttendance.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="dailyAttendance.updateBy" ng-bind="dailyAttendance.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDailyAttendance(dailyAttendance)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/dailyAttendance">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/dailyAttendance/dailyAttendanceDetail.js"></script>
