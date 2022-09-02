<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="professionTag" id="current_nav">
<div id="professionTagApp" ng-app="professionTagApp">
	<div ng-controller="professionTagController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ProfessionTag管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProfessionTag(professionTag)">新增</span>
		    </span>
	
			<paging url="/web/a/professionTag">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>公司id</td>
			        				                    <td>职业id</td>
			        				                    <td>职业标签</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="professionTag in data">				
									                    <td ng-bind="professionTag.id" ></td>
			        				                    <td ng-bind="professionTag.cId" ></td>
			        				                    <td ng-bind="professionTag.pId" ></td>
			        				                    <td ng-bind="professionTag.tag" ></td>
			        				                    <td ng-bind="professionTag.createAt" ></td>
			        				                    <td ng-bind="professionTag.updateAt" ></td>
			        				                    <td ng-bind="professionTag.createBy" ></td>
			        				                    <td ng-bind="professionTag.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProfessionTag(professionTag.id)" /> 
							<input type="button" value="删除" ng-click="deleteProfessionTag(professionTag.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-admin-service/professionTag/professionTagList.js"></script>
