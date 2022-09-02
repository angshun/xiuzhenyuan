<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="companyTag" id="current_nav">
<div id="companyTagApp" ng-app="companyTagApp">
	<div ng-controller="companyTagController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>CompanyTag管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCompanyTag(companyTag)">新增</span>
		    </span>
	
			<paging url="/web/a/companyTag">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>公司id</td>
			        				                    <td>标签名称</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="companyTag in data">				
									                    <td ng-bind="companyTag.id" ></td>
			        				                    <td ng-bind="companyTag.cId" ></td>
			        				                    <td ng-bind="companyTag.tag" ></td>
			        				                    <td ng-bind="companyTag.createAt" ></td>
			        				                    <td ng-bind="companyTag.updateAt" ></td>
			        				                    <td ng-bind="companyTag.createBy" ></td>
			        				                    <td ng-bind="companyTag.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCompanyTag(companyTag.id)" /> 
							<input type="button" value="删除" ng-click="deleteCompanyTag(companyTag.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-admin-service/companyTag/companyTagList.js"></script>
