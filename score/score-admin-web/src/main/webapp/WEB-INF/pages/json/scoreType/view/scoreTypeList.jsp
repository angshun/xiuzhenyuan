<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="scoreType" id="current_nav">
<div id="scoreTypeApp" ng-app="scoreTypeApp">
	<div ng-controller="scoreTypeController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ScoreType管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addScoreType(scoreType)">新增</span>
		    </span>
	
			<paging url="/web/a/scoreType">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>品德准则</td>
			        				                    <td>积分详细内容</td>
			        				                    <td>可申请方式</td>
			        				                    <td>积分类型</td>
			        				                    <td>已完成次数</td>
			        				                    <td>积分状态</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="scoreType in data">				
									                    <td ng-bind="scoreType.id" ></td>
			        				                    <td ng-bind="scoreType.moral" ></td>
			        				                    <td ng-bind="scoreType.content" ></td>
			        				                    <td ng-bind="scoreType.project" ></td>
			        				                    <td ng-bind="scoreType.scoreType" ></td>
			        				                    <td ng-bind="scoreType.times" ></td>
			        				                    <td ng-bind="scoreType.status" ></td>
			        				                    <td ng-bind="scoreType.createAt" ></td>
			        				                    <td ng-bind="scoreType.updateAt" ></td>
			        				                    <td ng-bind="scoreType.createBy" ></td>
			        				                    <td ng-bind="scoreType.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateScoreType(scoreType.id)" /> 
							<input type="button" value="删除" ng-click="deleteScoreType(scoreType.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/scoreType/scoreTypeList.js"></script>
