<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="rewardLog" id="current_nav">
<div id="rewardLogApp" ng-app="rewardLogApp">
	<div ng-controller="rewardLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>RewardLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRewardLog(rewardLog)">新增</span>
		    </span>
	
			<paging url="/web/a/rewardLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工id</td>
			        				                    <td>管理员姓名</td>
			        				                    <td>管理员头像</td>
			        				                    <td>表扬内容</td>
			        				                    <td>表扬积分</td>
			        				                    <td>审批备注</td>
			        				                    <td>表扬标题</td>
			        				                    <td>积分类型</td>
			        				                    <td>创建时间（获得积分时间）</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="rewardLog in data">				
									                    <td ng-bind="rewardLog.id" ></td>
			        				                    <td ng-bind="rewardLog.staffId" ></td>
			        				                    <td ng-bind="rewardLog.adminName" ></td>
			        				                    <td ng-bind="rewardLog.adminPhoto" ></td>
			        				                    <td ng-bind="rewardLog.rewardContent" ></td>
			        				                    <td ng-bind="rewardLog.rewardScore" ></td>
			        				                    <td ng-bind="rewardLog.rewardRemark" ></td>
			        				                    <td ng-bind="rewardLog.rewardTitle" ></td>
			        				                    <td ng-bind="rewardLog.scoreType" ></td>
			        				                    <td ng-bind="rewardLog.createAt" ></td>
			        				                    <td ng-bind="rewardLog.updateAt" ></td>
			        				                    <td ng-bind="rewardLog.createBy" ></td>
			        				                    <td ng-bind="rewardLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRewardLog(rewardLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteRewardLog(rewardLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/rewardLog/rewardLogList.js"></script>
