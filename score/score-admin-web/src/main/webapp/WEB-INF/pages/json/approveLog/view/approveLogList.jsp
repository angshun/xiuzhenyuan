<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="approveLog" id="current_nav">
<div id="approveLogApp" ng-app="approveLogApp">
	<div ng-controller="approveLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ApproveLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addApproveLog(approveLog)">新增</span>
		    </span>
	
			<paging url="/web/a/approveLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>点赞类型（点赞日志、点赞人）</td>
			        				                    <td>日志id/被点赞人id</td>
			        				                    <td>点赞人id</td>
			        				                    <td>创建时间(考勤时间)</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="approveLog in data">				
									                    <td ng-bind="approveLog.id" ></td>
			        				                    <td ng-bind="approveLog.type" ></td>
			        				                    <td ng-bind="approveLog.logId" ></td>
			        				                    <td ng-bind="approveLog.attendanceType" ></td>
			        				                    <td ng-bind="approveLog.createAt" ></td>
			        				                    <td ng-bind="approveLog.updateAt" ></td>
			        				                    <td ng-bind="approveLog.createBy" ></td>
			        				                    <td ng-bind="approveLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateApproveLog(approveLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteApproveLog(approveLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/approveLog/approveLogList.js"></script>
