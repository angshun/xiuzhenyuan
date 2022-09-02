<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="module" id="current_nav">
<div id="moduleApp" ng-app="moduleApp">
	<div ng-controller="moduleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Module管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addModule(module)">新增</span>
		    </span>
	
			<paging url="/web/a/module">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>模块名称</td>
			        				                    <td>父模块id</td>
			        				                    <td>模块类型</td>
			        				                    <td>菜单id</td>
			        				                    <td>图标</td>
			        				                    <td>等级</td>
			        				                    <td>模块url</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="module in data">				
									                    <td ng-bind="module.id" ></td>
			        				                    <td ng-bind="module.name" ></td>
			        				                    <td ng-bind="module.parentId" ></td>
			        				                    <td ng-bind="module.type" ></td>
			        				                    <td ng-bind="module.menuId" ></td>
			        				                    <td ng-bind="module.icon" ></td>
			        				                    <td ng-bind="module.level" ></td>
			        				                    <td ng-bind="module.url" ></td>
			        				                    <td ng-bind="module.createAt" ></td>
			        				                    <td ng-bind="module.updateAt" ></td>
			        				                    <td ng-bind="module.createBy" ></td>
			        				                    <td ng-bind="module.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateModule(module.id)" /> 
							<input type="button" value="删除" ng-click="deleteModule(module.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/module/moduleList.js"></script>
