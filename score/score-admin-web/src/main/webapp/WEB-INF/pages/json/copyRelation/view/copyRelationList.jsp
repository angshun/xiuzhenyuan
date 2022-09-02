<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="copyRelation" id="current_nav">
<div id="copyRelationApp" ng-app="copyRelationApp">
	<div ng-controller="copyRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>CopyRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCopyRelation(copyRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/copyRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>申请记录id</td>
			        				                    <td>抄送人id</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="copyRelation in data">				
									                    <td ng-bind="copyRelation.id" ></td>
			        				                    <td ng-bind="copyRelation.recordId" ></td>
			        				                    <td ng-bind="copyRelation.copyId" ></td>
			        				                    <td ng-bind="copyRelation.createAt" ></td>
			        				                    <td ng-bind="copyRelation.updateAt" ></td>
			        				                    <td ng-bind="copyRelation.createBy" ></td>
			        				                    <td ng-bind="copyRelation.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCopyRelation(copyRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteCopyRelation(copyRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/copyRelation/copyRelationList.js"></script>
