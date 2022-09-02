<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="operationLog" id="current_nav">
<div id="operationLogApp" ng-app="operationLogApp">
	<div ng-controller="operationLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>OperationLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addOperationLog(operationLog)">新增</span>
		    </span>
	
			<paging url="/web/a/operationLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>操作人（管理员）</td>
			        				                    <td>操作类型</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="operationLog in data">				
									                    <td ng-bind="operationLog.id" ></td>
			        				                    <td ng-bind="operationLog.admin" ></td>
			        				                    <td ng-bind="operationLog.operation" ></td>
			        				                    <td ng-bind="operationLog.createAt" ></td>
			        				                    <td ng-bind="operationLog.updateAt" ></td>
			        				                    <td ng-bind="operationLog.createBy" ></td>
			        				                    <td ng-bind="operationLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateOperationLog(operationLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteOperationLog(operationLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/operationLog/operationLogList.js"></script>
