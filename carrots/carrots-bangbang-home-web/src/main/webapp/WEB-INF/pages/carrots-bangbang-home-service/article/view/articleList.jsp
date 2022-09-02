<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="article" id="current_nav">
<div id="articleApp" ng-app="articleApp">
	<div ng-controller="articleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Article管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addArticle(article)">新增</span>
		    </span>
	
			<paging url="/web/a/article">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>article类型</td>
			        				                    <td>标题</td>
			        				                    <td>图片</td>
			        				                    <td>链接</td>
			        				                    <td>上线状态</td>
			        				                    <td>行业</td>
			        				                    <td>创建时间</td>
			        				                    <td>修改时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        				                    <td>排序</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="article in data">				
									                    <td ng-bind="article.id" ></td>
			        				                    <td ng-bind="article.type" ></td>
			        				                    <td ng-bind="article.title" ></td>
			        				                    <td ng-bind="article.img" ></td>
			        				                    <td ng-bind="article.url" ></td>
			        				                    <td ng-bind="article.status" ></td>
			        				                    <td ng-bind="article.industry" ></td>
			        				                    <td ng-bind="article.createAt" ></td>
			        				                    <td ng-bind="article.updateAt" ></td>
			        				                    <td ng-bind="article.createBy" ></td>
			        				                    <td ng-bind="article.updateBy" ></td>
			        				                    <td ng-bind="article.rank" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateArticle(article.id)" /> 
							<input type="button" value="删除" ng-click="deleteArticle(article.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/carrots-bangbang-home-service/article/articleList.js"></script>
