<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="department" id="current_nav">
<div id="departmentApp" ng-app="departmentApp">
	<div ng-controller="departmentController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Department管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDepartment(department)">新增</span>
		    </span>
	
			<paging url="/web/a/department">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>部门名称</td>
			        				                    <td>父id</td>
			        				                    <td>是否为父级</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="department in data">				
									                    <td ng-bind="department.id" ></td>
			        				                    <td ng-bind="department.name" ></td>
			        				                    <td ng-bind="department.parentId" ></td>
			        				                    <td ng-bind="department.isParent" ></td>
			        				                    <td ng-bind="department.createAt" ></td>
			        				                    <td ng-bind="department.updateAt" ></td>
			        				                    <td ng-bind="department.createBy" ></td>
			        				                    <td ng-bind="department.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDepartment(department.id)" /> 
							<input type="button" value="删除" ng-click="deleteDepartment(department.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/department/departmentList.js"></script>
