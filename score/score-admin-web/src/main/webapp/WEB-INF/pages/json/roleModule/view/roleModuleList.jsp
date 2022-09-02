<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="roleModule" id="current_nav">
<div id="roleModuleApp" ng-app="roleModuleApp">
	<div ng-controller="roleModuleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>RoleModule管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRoleModule(roleModule)">新增</span>
		    </span>
	
			<paging url="/web/a/roleModule">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>角色id</td>
			        				                    <td>模块id</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="roleModule in data">				
									                    <td ng-bind="roleModule.id" ></td>
			        				                    <td ng-bind="roleModule.roleId" ></td>
			        				                    <td ng-bind="roleModule.moduleId" ></td>
			        				                    <td ng-bind="roleModule.createAt" ></td>
			        				                    <td ng-bind="roleModule.updateAt" ></td>
			        				                    <td ng-bind="roleModule.createBy" ></td>
			        				                    <td ng-bind="roleModule.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRoleModule(roleModule.id)" /> 
							<input type="button" value="删除" ng-click="deleteRoleModule(roleModule.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/roleModule/roleModuleList.js"></script>
