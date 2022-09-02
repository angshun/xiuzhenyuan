<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="allTypeScore" id="current_nav">
<div id="allTypeScoreApp" ng-app="allTypeScoreApp">
	<div ng-controller="allTypeScoreController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>AllTypeScore管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAllTypeScore(allTypeScore)">新增</span>
		    </span>
	
			<paging url="/web/a/allTypeScore">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>类型(职位0/学历1/荣耀2/职称3/特长4)</td>
			        				                    <td>积分名称</td>
			        				                    <td>积分</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="allTypeScore in data">				
									                    <td ng-bind="allTypeScore.id" ></td>
			        				                    <td ng-bind="allTypeScore.type" ></td>
			        				                    <td ng-bind="allTypeScore.name" ></td>
			        				                    <td ng-bind="allTypeScore.score" ></td>
			        				                    <td ng-bind="allTypeScore.createAt" ></td>
			        				                    <td ng-bind="allTypeScore.updateAt" ></td>
			        				                    <td ng-bind="allTypeScore.createBy" ></td>
			        				                    <td ng-bind="allTypeScore.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAllTypeScore(allTypeScore.id)" /> 
							<input type="button" value="删除" ng-click="deleteAllTypeScore(allTypeScore.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/allTypeScore/allTypeScoreList.js"></script>
