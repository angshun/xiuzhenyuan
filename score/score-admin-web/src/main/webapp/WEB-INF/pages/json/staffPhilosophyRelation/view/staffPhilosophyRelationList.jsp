<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="staffPhilosophyRelation" id="current_nav">
<div id="staffPhilosophyRelationApp" ng-app="staffPhilosophyRelationApp">
	<div ng-controller="staffPhilosophyRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>StaffPhilosophyRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addStaffPhilosophyRelation(staffPhilosophyRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/staffPhilosophyRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工id</td>
			        				                    <td>文章id</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="staffPhilosophyRelation in data">				
									                    <td ng-bind="staffPhilosophyRelation.id" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.staffId" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.philosophyId" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.createAt" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.updateAt" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.createBy" ></td>
			        				                    <td ng-bind="staffPhilosophyRelation.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateStaffPhilosophyRelation(staffPhilosophyRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteStaffPhilosophyRelation(staffPhilosophyRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/staffPhilosophyRelation/staffPhilosophyRelationList.js"></script>
