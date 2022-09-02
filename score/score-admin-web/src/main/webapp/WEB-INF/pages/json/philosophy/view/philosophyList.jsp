<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="philosophy" id="current_nav">
<div id="philosophyApp" ng-app="philosophyApp">
	<div ng-controller="philosophyController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Philosophy管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addPhilosophy(philosophy)">新增</span>
		    </span>
	
			<paging url="/web/a/philosophy">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>标题</td>
			        				                    <td>奖励积分</td>
			        				                    <td>经营内容</td>
			        				                    <td>可申请方式</td>
			        				                    <td>已阅读次数</td>
			        				                    <td>积分状态</td>
			        				                    <td>状态（已阅读/未阅读）</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="philosophy in data">				
									                    <td ng-bind="philosophy.id" ></td>
			        				                    <td ng-bind="philosophy.title" ></td>
			        				                    <td ng-bind="philosophy.reward" ></td>
			        				                    <td ng-bind="philosophy.content" ></td>
			        				                    <td ng-bind="philosophy.project" ></td>
			        				                    <td ng-bind="philosophy.readNum" ></td>
			        				                    <td ng-bind="philosophy.status" ></td>
			        				                    <td ng-bind="philosophy.articleStatus" ></td>
			        				                    <td ng-bind="philosophy.createAt" ></td>
			        				                    <td ng-bind="philosophy.updateAt" ></td>
			        				                    <td ng-bind="philosophy.createBy" ></td>
			        				                    <td ng-bind="philosophy.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updatePhilosophy(philosophy.id)" /> 
							<input type="button" value="删除" ng-click="deletePhilosophy(philosophy.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/philosophy/philosophyList.js"></script>
