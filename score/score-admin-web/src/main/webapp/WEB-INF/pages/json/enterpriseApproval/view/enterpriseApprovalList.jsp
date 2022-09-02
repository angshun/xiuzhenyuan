<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="enterpriseApproval" id="current_nav">
<div id="enterpriseApprovalApp" ng-app="enterpriseApprovalApp">
	<div ng-controller="enterpriseApprovalController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>EnterpriseApproval管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addEnterpriseApproval(enterpriseApproval)">新增</span>
		    </span>
	
			<paging url="/web/a/enterpriseApproval">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>审批标题</td>
			        				                    <td>申请人id</td>
			        				                    <td>积分类型</td>
			        				                    <td>申请积分</td>
			        				                    <td>审批状态0审批中/1审批通过/2审批未通过</td>
			        				                    <td>审批内容</td>
			        				                    <td>审批图片</td>
			        				                    <td>审批人id</td>
			        				                    <td>创建时间（申请时间）</td>
			        				                    <td>更新时间（审批时间）</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="enterpriseApproval in data">				
									                    <td ng-bind="enterpriseApproval.id" ></td>
			        				                    <td ng-bind="enterpriseApproval.title" ></td>
			        				                    <td ng-bind="enterpriseApproval.applyId" ></td>
			        				                    <td ng-bind="enterpriseApproval.scoreType" ></td>
			        				                    <td ng-bind="enterpriseApproval.score" ></td>
			        				                    <td ng-bind="enterpriseApproval.status" ></td>
			        				                    <td ng-bind="enterpriseApproval.content" ></td>
			        				                    <td ng-bind="enterpriseApproval.picture" ></td>
			        				                    <td ng-bind="enterpriseApproval.approvalId" ></td>
			        				                    <td ng-bind="enterpriseApproval.createAt" ></td>
			        				                    <td ng-bind="enterpriseApproval.updateAt" ></td>
			        				                    <td ng-bind="enterpriseApproval.createBy" ></td>
			        				                    <td ng-bind="enterpriseApproval.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateEnterpriseApproval(enterpriseApproval.id)" /> 
							<input type="button" value="删除" ng-click="deleteEnterpriseApproval(enterpriseApproval.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/enterpriseApproval/enterpriseApprovalList.js"></script>
