<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="staff" id="current_nav">
<div id="staffApp" ng-app="staffApp">
	<div ng-controller="staffController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Staff管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addStaff(staff)">新增</span>
		    </span>
	
			<paging url="/web/a/staff">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增id</td>
			        				                    <td>员工名字</td>
			        				                    <td>员工头像</td>
			        				                    <td>员工手机号</td>
			        				                    <td>登录密码</td>
			        				                    <td>部门id</td>
			        				                    <td>部门名称</td>
			        				                    <td>职位id</td>
			        				                    <td>可用点赞分数</td>
			        				                    <td>学位积分</td>
			        				                    <td>荣誉积分</td>
			        				                    <td>职称积分</td>
			        				                    <td>特长积分</td>
			        				                    <td>可用表彰积分</td>
			        				                    <td>基础积分</td>
			        				                    <td>加分总分</td>
			        				                    <td>减分总分</td>
			        				                    <td>积分情况（按年/月/日）</td>
			        				                    <td>总积分</td>
			        				                    <td>工龄</td>
			        				                    <td>星级</td>
			        				                    <td>离职状态</td>
			        				                    <td>太阳积分(每月初始化为0)</td>
			        				                    <td>爱心积分(每月初始化为0)</td>
			        				                    <td>审批日志</td>
			        				                    <td>待我审批</td>
			        				                    <td>我发起的</td>
			        				                    <td>我的抄送</td>
			        				                    <td>积分排行</td>
			        				                    <td>是否参与积分排行</td>
			        				                    <td>入职时间</td>
			        				                    <td>员工角色</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="staff in data">				
									                    <td ng-bind="staff.id" ></td>
			        				                    <td ng-bind="staff.name" ></td>
			        				                    <td ng-bind="staff.img" ></td>
			        				                    <td ng-bind="staff.phone" ></td>
			        				                    <td ng-bind="staff.pwd" ></td>
			        				                    <td ng-bind="staff.departmentId" ></td>
			        				                    <td ng-bind="staff.departmentName" ></td>
			        				                    <td ng-bind="staff.position" ></td>
			        				                    <td ng-bind="staff.iniScore" ></td>
			        				                    <td ng-bind="staff.degreeScore" ></td>
			        				                    <td ng-bind="staff.honorScore" ></td>
			        				                    <td ng-bind="staff.jopScore" ></td>
			        				                    <td ng-bind="staff.specialityScore" ></td>
			        				                    <td ng-bind="staff.commendScore" ></td>
			        				                    <td ng-bind="staff.baseScore" ></td>
			        				                    <td ng-bind="staff.addScore" ></td>
			        				                    <td ng-bind="staff.subScore" ></td>
			        				                    <td ng-bind="staff.scoreSituation" ></td>
			        				                    <td ng-bind="staff.totalScore" ></td>
			        				                    <td ng-bind="staff.seniority" ></td>
			        				                    <td ng-bind="staff.star" ></td>
			        				                    <td ng-bind="staff.incumbency" ></td>
			        				                    <td ng-bind="staff.sunScore" ></td>
			        				                    <td ng-bind="staff.loveScore" ></td>
			        				                    <td ng-bind="staff.approvalLogNum" ></td>
			        				                    <td ng-bind="staff.waitApprovalNum" ></td>
			        				                    <td ng-bind="staff.myApprovalNum" ></td>
			        				                    <td ng-bind="staff.myCopyNum" ></td>
			        				                    <td ng-bind="staff.ranking" ></td>
			        				                    <td ng-bind="staff.joinRank" ></td>
			        				                    <td ng-bind="staff.entryAt" ></td>
			        				                    <td ng-bind="staff.role" ></td>
			        				                    <td ng-bind="staff.createAt" ></td>
			        				                    <td ng-bind="staff.updateAt" ></td>
			        				                    <td ng-bind="staff.createBy" ></td>
			        				                    <td ng-bind="staff.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateStaff(staff.id)" /> 
							<input type="button" value="删除" ng-click="deleteStaff(staff.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/score-admin-service/staff/staffList.js"></script>
