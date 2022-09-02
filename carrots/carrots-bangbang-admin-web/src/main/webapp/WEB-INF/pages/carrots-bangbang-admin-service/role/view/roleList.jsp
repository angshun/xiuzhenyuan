<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="role" id="current_nav">
<div id="roleApp" ng-app="roleApp">
	<div ng-controller="roleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Role管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRole(role)">新增</span>
		    </span>
	
			<paging url="/web/a/role">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>角色名字</td>
			        				                    <td></td>
			        				                    <td>权限</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="role in data">				
									                    <td ng-bind="role.id" ></td>
			        				                    <td ng-bind="role.name" ></td>
			        				                    <td ng-bind="role.status" ></td>
			        				                    <td ng-bind="role.permissons" ></td>
			        				                    <td ng-bind="role.createAt" ></td>
			        				                    <td ng-bind="role.updateAt" ></td>
			        				                    <td ng-bind="role.createBy" ></td>
			        				                    <td ng-bind="role.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRole(role.id)" /> 
							<input type="button" value="删除" ng-click="deleteRole(role.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-admin-service/role/roleList.js"></script>
