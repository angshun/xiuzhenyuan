<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="profession" id="current_nav">
<div id="professionApp" ng-app="professionApp">
	<div ng-controller="professionController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Profession管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProfession(profession)">新增</span>
		    </span>
	
			<paging url="/web/a/profession">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>职业名称</td>
			        				                    <td>公司id</td>
			        				                    <td>发布时间</td>
			        				                    <td>薪资</td>
			        				                    <td>学历</td>
			        				                    <td>工作经验</td>
			        				                    <td>上架状态</td>
			        				                    <td>岗位职责</td>
			        				                    <td>必备条件</td>
			        				                    <td>公司福利</td>
			        				                    <td>创建时间</td>
			        				                    <td>修改时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="profession in data">				
									                    <td ng-bind="profession.id" ></td>
			        				                    <td ng-bind="profession.name" ></td>
			        				                    <td ng-bind="profession.cId" ></td>
			        				                    <td ng-bind="profession.releaseAt" ></td>
			        				                    <td ng-bind="profession.salary" ></td>
			        				                    <td ng-bind="profession.education" ></td>
			        				                    <td ng-bind="profession.workExperience" ></td>
			        				                    <td ng-bind="profession.status" ></td>
			        				                    <td ng-bind="profession.responsibility" ></td>
			        				                    <td ng-bind="profession.requirement" ></td>
			        				                    <td ng-bind="profession.welfare" ></td>
			        				                    <td ng-bind="profession.createAt" ></td>
			        				                    <td ng-bind="profession.updateAt" ></td>
			        				                    <td ng-bind="profession.createBy" ></td>
			        				                    <td ng-bind="profession.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProfession(profession.id)" /> 
							<input type="button" value="删除" ng-click="deleteProfession(profession.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-admin-service/profession/professionList.js"></script>
