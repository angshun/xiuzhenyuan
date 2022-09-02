<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="manager" id="current_nav">
<div id="managerApp" ng-app="managerApp">
	<div ng-controller="managerController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Manager管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addManager(manager)">新增</span>
		    </span>
	
			<paging url="/web/a/manager">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>手机号码</td>
			        				                    <td>角色id</td>
			        				                    <td></td>
			        				                    <td>密码</td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td>用户名</td>
			        				                    <td>状态</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="manager in data">				
									                    <td ng-bind="manager.id" ></td>
			        				                    <td ng-bind="manager.phone" ></td>
			        				                    <td ng-bind="manager.roleId" ></td>
			        				                    <td ng-bind="manager.nick" ></td>
			        				                    <td ng-bind="manager.pwd" ></td>
			        				                    <td ng-bind="manager.region" ></td>
			        				                    <td ng-bind="manager.company" ></td>
			        				                    <td ng-bind="manager.type" ></td>
			        				                    <td ng-bind="manager.name" ></td>
			        				                    <td ng-bind="manager.status" ></td>
			        				                    <td ng-bind="manager.createAt" ></td>
			        				                    <td ng-bind="manager.updateAt" ></td>
			        				                    <td ng-bind="manager.createBy" ></td>
			        				                    <td ng-bind="manager.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateManager(manager.id)" /> 
							<input type="button" value="删除" ng-click="deleteManager(manager.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/manager/managerList.js"></script>
