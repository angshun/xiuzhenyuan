<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="enterpriseLog" id="current_nav">
<div id="enterpriseLogApp" ng-app="enterpriseLogApp">
	<div ng-controller="enterpriseLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>EnterpriseLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addEnterpriseLog(enterpriseLog)">新增</span>
		    </span>
	
			<paging url="/web/a/enterpriseLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id（日志id）</td>
			        				                    <td>员工id</td>
			        				                    <td>日志内容</td>
			        				                    <td>点赞数</td>
			        				                    <td>评论数</td>
			        				                    <td>日志图片</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="enterpriseLog in data">				
									                    <td ng-bind="enterpriseLog.id" ></td>
			        				                    <td ng-bind="enterpriseLog.staffId" ></td>
			        				                    <td ng-bind="enterpriseLog.logContent" ></td>
			        				                    <td ng-bind="enterpriseLog.approveNum" ></td>
			        				                    <td ng-bind="enterpriseLog.commentNum" ></td>
			        				                    <td ng-bind="enterpriseLog.picture" ></td>
			        				                    <td ng-bind="enterpriseLog.createAt" ></td>
			        				                    <td ng-bind="enterpriseLog.updateAt" ></td>
			        				                    <td ng-bind="enterpriseLog.createBy" ></td>
			        				                    <td ng-bind="enterpriseLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateEnterpriseLog(enterpriseLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteEnterpriseLog(enterpriseLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/enterpriseLog/enterpriseLogList.js"></script>
