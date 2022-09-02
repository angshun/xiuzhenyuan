<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="notice" id="current_nav">
<div id="noticeApp" ng-app="noticeApp">
	<div ng-controller="noticeController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Notice管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addNotice(notice)">新增</span>
		    </span>
	
			<paging url="/web/a/notice">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>通告内容</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="notice in data">				
									                    <td ng-bind="notice.id" ></td>
			        				                    <td ng-bind="notice.content" ></td>
			        				                    <td ng-bind="notice.createAt" ></td>
			        				                    <td ng-bind="notice.updateAt" ></td>
			        				                    <td ng-bind="notice.createBy" ></td>
			        				                    <td ng-bind="notice.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateNotice(notice.id)" /> 
							<input type="button" value="删除" ng-click="deleteNotice(notice.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/notice/noticeList.js"></script>
