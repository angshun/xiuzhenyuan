<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="staffTaskRelation" id="current_nav">
<div id="staffTaskRelationApp" ng-app="staffTaskRelationApp">
	<div ng-controller="staffTaskRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>StaffTaskRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addStaffTaskRelation(staffTaskRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/staffTaskRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工id</td>
			        				                    <td>任务id</td>
			        				                    <td>任务状态（0已参与/1已完成）</td>
			        				                    <td>任务类型</td>
			        				                    <td>创建时间(考勤时间)</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="staffTaskRelation in data">				
									                    <td ng-bind="staffTaskRelation.id" ></td>
			        				                    <td ng-bind="staffTaskRelation.staffId" ></td>
			        				                    <td ng-bind="staffTaskRelation.taskId" ></td>
			        				                    <td ng-bind="staffTaskRelation.attendanceType" ></td>
			        				                    <td ng-bind="staffTaskRelation.taskType" ></td>
			        				                    <td ng-bind="staffTaskRelation.createAt" ></td>
			        				                    <td ng-bind="staffTaskRelation.updateAt" ></td>
			        				                    <td ng-bind="staffTaskRelation.createBy" ></td>
			        				                    <td ng-bind="staffTaskRelation.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateStaffTaskRelation(staffTaskRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteStaffTaskRelation(staffTaskRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/staffTaskRelation/staffTaskRelationList.js"></script>
