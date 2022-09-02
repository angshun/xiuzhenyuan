<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="applyManage" id="current_nav">
<div id="applyManageApp" ng-app="applyManageApp">
	<div ng-controller="applyManageController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ApplyManage管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addApplyManage(applyManage)">新增</span>
		    </span>
	
			<paging url="/web/a/applyManage">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>模块编号</td>
			        				                    <td>状态0下线/1上线</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="applyManage in data">				
									                    <td ng-bind="applyManage.id" ></td>
			        				                    <td ng-bind="applyManage.moduleId" ></td>
			        				                    <td ng-bind="applyManage.status" ></td>
			        				                    <td ng-bind="applyManage.createAt" ></td>
			        				                    <td ng-bind="applyManage.updateAt" ></td>
			        				                    <td ng-bind="applyManage.createBy" ></td>
			        				                    <td ng-bind="applyManage.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateApplyManage(applyManage.id)" /> 
							<input type="button" value="删除" ng-click="deleteApplyManage(applyManage.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/applyManage/applyManageList.js"></script>
