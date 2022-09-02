<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="goods" id="current_nav">
<div id="goodsApp" ng-app="goodsApp">
	<div ng-controller="goodsController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Goods管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addGoods(goods)">新增</span>
		    </span>
	
			<paging url="/web/a/goods">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>商品名称</td>
			        				                    <td>商品图片</td>
			        				                    <td>商品详情</td>
			        				                    <td>兑换积分</td>
			        				                    <td>商品数量</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="goods in data">				
									                    <td ng-bind="goods.id" ></td>
			        				                    <td ng-bind="goods.name" ></td>
			        				                    <td ng-bind="goods.img" ></td>
			        				                    <td ng-bind="goods.content" ></td>
			        				                    <td ng-bind="goods.score" ></td>
			        				                    <td ng-bind="goods.number" ></td>
			        				                    <td ng-bind="goods.createAt" ></td>
			        				                    <td ng-bind="goods.updateAt" ></td>
			        				                    <td ng-bind="goods.createBy" ></td>
			        				                    <td ng-bind="goods.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateGoods(goods.id)" /> 
							<input type="button" value="删除" ng-click="deleteGoods(goods.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/goods/goodsList.js"></script>
