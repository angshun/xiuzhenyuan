<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="scoreExchangeApproval" id="current_nav">
<div id="scoreExchangeApprovalApp" ng-app="scoreExchangeApprovalApp">
	<div ng-controller="scoreExchangeApprovalController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ScoreExchangeApproval管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addScoreExchangeApproval(scoreExchangeApproval)">新增</span>
		    </span>
	
			<paging url="/web/a/scoreExchangeApproval">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>用户姓名</td>
			        				                    <td>商品id</td>
			        				                    <td>兑换状态</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="scoreExchangeApproval in data">				
									                    <td ng-bind="scoreExchangeApproval.id" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.staffId" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.goodsId" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.exchangeStatus" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.createAt" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.updateAt" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.createBy" ></td>
			        				                    <td ng-bind="scoreExchangeApproval.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateScoreExchangeApproval(scoreExchangeApproval.id)" /> 
							<input type="button" value="删除" ng-click="deleteScoreExchangeApproval(scoreExchangeApproval.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/scoreExchangeApproval/scoreExchangeApprovalList.js"></script>
