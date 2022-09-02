<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="task" id="current_nav">
<div id="taskApp" ng-app="taskApp">
	<div ng-controller="taskController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Task管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTask(task)">新增</span>
		    </span>
	
			<paging url="/web/a/task">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>任务名称</td>
			        				                    <td>任务标题</td>
			        				                    <td>任务内容</td>
			        				                    <td>积分类型</td>
			        				                    <td>任务类型</td>
			        				                    <td>可申请方式</td>
			        				                    <td>任务开始时间</td>
			        				                    <td>任务结束时间</td>
			        				                    <td>已参加人数</td>
			        				                    <td>限制人数</td>
			        				                    <td>已完成次数</td>
			        				                    <td>任务积分</td>
			        				                    <td>可见部门(数组)</td>
			        				                    <td>任务状态（始终为null，表示参与/未参与/完成）</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="task in data">				
									                    <td ng-bind="task.id" ></td>
			        				                    <td ng-bind="task.name" ></td>
			        				                    <td ng-bind="task.title" ></td>
			        				                    <td ng-bind="task.content" ></td>
			        				                    <td ng-bind="task.scoreType" ></td>
			        				                    <td ng-bind="task.taskType" ></td>
			        				                    <td ng-bind="task.project" ></td>
			        				                    <td ng-bind="task.startAt" ></td>
			        				                    <td ng-bind="task.endAt" ></td>
			        				                    <td ng-bind="task.joinNum" ></td>
			        				                    <td ng-bind="task.number" ></td>
			        				                    <td ng-bind="task.times" ></td>
			        				                    <td ng-bind="task.taskScore" ></td>
			        				                    <td ng-bind="task.visualDepartment" ></td>
			        				                    <td ng-bind="task.taskStatus" ></td>
			        				                    <td ng-bind="task.createAt" ></td>
			        				                    <td ng-bind="task.updateAt" ></td>
			        				                    <td ng-bind="task.createBy" ></td>
			        				                    <td ng-bind="task.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTask(task.id)" /> 
							<input type="button" value="删除" ng-click="deleteTask(task.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/task/taskList.js"></script>
