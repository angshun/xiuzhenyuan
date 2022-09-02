<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="star" id="current_nav">
<div id="starApp" ng-app="starApp">
	<div ng-controller="starController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Star管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addStar(star)">新增</span>
		    </span>
	
			<paging url="/web/a/star">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>等级类型</td>
			        				                    <td>等级名称</td>
			        				                    <td>等级积分</td>
			        				                    <td>等级</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="star in data">				
									                    <td ng-bind="star.id" ></td>
			        				                    <td ng-bind="star.gradeType" ></td>
			        				                    <td ng-bind="star.name" ></td>
			        				                    <td ng-bind="star.score" ></td>
			        				                    <td ng-bind="star.level" ></td>
			        				                    <td ng-bind="star.createAt" ></td>
			        				                    <td ng-bind="star.updateAt" ></td>
			        				                    <td ng-bind="star.createBy" ></td>
			        				                    <td ng-bind="star.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateStar(star.id)" /> 
							<input type="button" value="删除" ng-click="deleteStar(star.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/star/starList.js"></script>
