<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="dailyAttendance" id="current_nav">
<div id="dailyAttendanceApp" ng-app="dailyAttendanceApp">
	<div ng-controller="dailyAttendanceController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DailyAttendance管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDailyAttendance(dailyAttendance)">新增</span>
		    </span>
	
			<paging url="/web/a/dailyAttendance">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>考勤类型0内勤1外勤</td>
			        				                    <td>正常奖励分数</td>
			        				                    <td>早到奖励积分</td>
			        				                    <td>迟到减积分</td>
			        				                    <td>加班奖励积分</td>
			        				                    <td>早退减积分</td>
			        				                    <td>缺勤扣积分</td>
			        				                    <td>上班时间</td>
			        				                    <td>下班时间</td>
			        				                    <td>公司地址(经纬度)</td>
			        				                    <td>考勤校验距离</td>
			        				                    <td>外勤正常上班时间奖励</td>
			        				                    <td>外勤正常下班时间奖励</td>
			        				                    <td>每天发布日志次数</td>
			        				                    <td>点赞他人日报获得积分</td>
			        				                    <td>日报被赞获得积分</td>
			        				                    <td>爱心积分</td>
			        				                    <td>太阳积分</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="dailyAttendance in data">				
									                    <td ng-bind="dailyAttendance.id" ></td>
			        				                    <td ng-bind="dailyAttendance.attendanceType" ></td>
			        				                    <td ng-bind="dailyAttendance.normalScore" ></td>
			        				                    <td ng-bind="dailyAttendance.morningScore" ></td>
			        				                    <td ng-bind="dailyAttendance.lateScore" ></td>
			        				                    <td ng-bind="dailyAttendance.overtimeScore" ></td>
			        				                    <td ng-bind="dailyAttendance.leftEarlyScore" ></td>
			        				                    <td ng-bind="dailyAttendance.absenceScore" ></td>
			        				                    <td ng-bind="dailyAttendance.workTime" ></td>
			        				                    <td ng-bind="dailyAttendance.closingTime" ></td>
			        				                    <td ng-bind="dailyAttendance.companyCoordinate" ></td>
			        				                    <td ng-bind="dailyAttendance.attendanceInstance" ></td>
			        				                    <td ng-bind="dailyAttendance.outsideWorkTimeScore" ></td>
			        				                    <td ng-bind="dailyAttendance.outsideClosingTimeScore" ></td>
			        				                    <td ng-bind="dailyAttendance.logReleaseTime" ></td>
			        				                    <td ng-bind="dailyAttendance.approveScore" ></td>
			        				                    <td ng-bind="dailyAttendance.beApproveScore" ></td>
			        				                    <td ng-bind="dailyAttendance.loveScore" ></td>
			        				                    <td ng-bind="dailyAttendance.sunScore" ></td>
			        				                    <td ng-bind="dailyAttendance.createAt" ></td>
			        				                    <td ng-bind="dailyAttendance.updateAt" ></td>
			        				                    <td ng-bind="dailyAttendance.createBy" ></td>
			        				                    <td ng-bind="dailyAttendance.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDailyAttendance(dailyAttendance.id)" /> 
							<input type="button" value="删除" ng-click="deleteDailyAttendance(dailyAttendance.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/dailyAttendance/dailyAttendanceList.js"></script>
