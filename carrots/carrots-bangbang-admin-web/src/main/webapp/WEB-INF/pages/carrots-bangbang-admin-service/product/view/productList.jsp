<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="product" id="current_nav">
<div id="productApp" ng-app="productApp">
	<div ng-controller="productController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Product管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProduct(product)">新增</span>
		    </span>
	
			<paging url="/web/a/product">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>产品名称</td>
			        				                    <td>产品logo</td>
			        				                    <td>产品简介</td>
			        				                    <td>产品标语</td>
			        				                    <td>公司id</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="product in data">				
									                    <td ng-bind="product.id" ></td>
			        				                    <td ng-bind="product.name" ></td>
			        				                    <td ng-bind="product.logo" ></td>
			        				                    <td ng-bind="product.summary" ></td>
			        				                    <td ng-bind="product.slogan" ></td>
			        				                    <td ng-bind="product.cid" ></td>
			        				                    <td ng-bind="product.createAt" ></td>
			        				                    <td ng-bind="product.updateAt" ></td>
			        				                    <td ng-bind="product.createBy" ></td>
			        				                    <td ng-bind="product.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProduct(product.id)" /> 
							<input type="button" value="删除" ng-click="deleteProduct(product.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-admin-service/product/productList.js"></script>
