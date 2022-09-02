<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="attendanceLog" id="current_nav">
<div id="attendanceLogApp" ng-app="attendanceLogApp">
	<div ng-controller="attendanceLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>AttendanceLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAttendanceLog(attendanceLog)">新增</span>
		    </span>
	
			<paging url="/web/a/attendanceLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工id</td>
			        				                    <td>考勤类型</td>
			        				                    <td>考勤地址</td>
			        				                    <td>考勤状态</td>
			        				                    <td>创建时间(考勤时间)</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="attendanceLog in data">				
									                    <td ng-bind="attendanceLog.id" ></td>
			        				                    <td ng-bind="attendanceLog.staffId" ></td>
			        				                    <td ng-bind="attendanceLog.attendanceType" ></td>
			        				                    <td ng-bind="attendanceLog.attendanceAddress" ></td>
			        				                    <td ng-bind="attendanceLog.attendanceStatus" ></td>
			        				                    <td ng-bind="attendanceLog.createAt" ></td>
			        				                    <td ng-bind="attendanceLog.updateAt" ></td>
			        				                    <td ng-bind="attendanceLog.createBy" ></td>
			        				                    <td ng-bind="attendanceLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAttendanceLog(attendanceLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteAttendanceLog(attendanceLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/attendanceLog/attendanceLogList.js"></script>
