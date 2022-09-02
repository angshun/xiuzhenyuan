<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="scoreLog" id="current_nav">
<div id="scoreLogApp" ng-app="scoreLogApp">
	<div ng-controller="scoreLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ScoreLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addScoreLog(scoreLog)">新增</span>
		    </span>
	
			<paging url="/web/a/scoreLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工id</td>
			        				                    <td>积分项目</td>
			        				                    <td>积分变动</td>
			        				                    <td>积分类型</td>
			        				                    <td>创建时间（获得积分时间）</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="scoreLog in data">				
									                    <td ng-bind="scoreLog.id" ></td>
			        				                    <td ng-bind="scoreLog.staffId" ></td>
			        				                    <td ng-bind="scoreLog.scoreReason" ></td>
			        				                    <td ng-bind="scoreLog.scoreChange" ></td>
			        				                    <td ng-bind="scoreLog.scoreType" ></td>
			        				                    <td ng-bind="scoreLog.createAt" ></td>
			        				                    <td ng-bind="scoreLog.updateAt" ></td>
			        				                    <td ng-bind="scoreLog.createBy" ></td>
			        				                    <td ng-bind="scoreLog.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateScoreLog(scoreLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteScoreLog(scoreLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/scoreLog/scoreLogList.js"></script>
