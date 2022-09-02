<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="staff" id="current_nav">
	<div id="staffDetailApp" ng-app="staffDetailApp">
		<div ng-controller="staffDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="staffForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="staffId" ng-model="staff.id" ng-bind="staff.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">员工名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="staff.name" ng-bind="staff.name" placeholder="请输入员工名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="img" class="col-sm-2 control-label">员工头像</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="img" ng-model="staff.img" ng-bind="staff.img" placeholder="请输入员工头像" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">员工手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="staff.phone" ng-bind="staff.phone" placeholder="请输入员工手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pwd" class="col-sm-2 control-label">登录密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pwd" ng-model="staff.pwd" ng-bind="staff.pwd" placeholder="请输入登录密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="departmentId" class="col-sm-2 control-label">部门id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="departmentId" ng-model="staff.departmentId" ng-bind="staff.departmentId" placeholder="请输入部门id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="departmentName" class="col-sm-2 control-label">部门名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="departmentName" ng-model="staff.departmentName" ng-bind="staff.departmentName" placeholder="请输入部门名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="position" class="col-sm-2 control-label">职位id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="position" ng-model="staff.position" ng-bind="staff.position" placeholder="请输入职位id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="iniScore" class="col-sm-2 control-label">可用点赞分数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="iniScore" ng-model="staff.iniScore" ng-bind="staff.iniScore" placeholder="请输入可用点赞分数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="degreeScore" class="col-sm-2 control-label">学位积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="degreeScore" ng-model="staff.degreeScore" ng-bind="staff.degreeScore" placeholder="请输入学位积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="honorScore" class="col-sm-2 control-label">荣誉积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="honorScore" ng-model="staff.honorScore" ng-bind="staff.honorScore" placeholder="请输入荣誉积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="jopScore" class="col-sm-2 control-label">职称积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="jopScore" ng-model="staff.jopScore" ng-bind="staff.jopScore" placeholder="请输入职称积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="specialityScore" class="col-sm-2 control-label">特长积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="specialityScore" ng-model="staff.specialityScore" ng-bind="staff.specialityScore" placeholder="请输入特长积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="commendScore" class="col-sm-2 control-label">可用表彰积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="commendScore" ng-model="staff.commendScore" ng-bind="staff.commendScore" placeholder="请输入可用表彰积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="baseScore" class="col-sm-2 control-label">基础积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="baseScore" ng-model="staff.baseScore" ng-bind="staff.baseScore" placeholder="请输入基础积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="addScore" class="col-sm-2 control-label">加分总分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="addScore" ng-model="staff.addScore" ng-bind="staff.addScore" placeholder="请输入加分总分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="subScore" class="col-sm-2 control-label">减分总分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="subScore" ng-model="staff.subScore" ng-bind="staff.subScore" placeholder="请输入减分总分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="scoreSituation" class="col-sm-2 control-label">积分情况（按年/月/日）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="scoreSituation" ng-model="staff.scoreSituation" ng-bind="staff.scoreSituation" placeholder="请输入积分情况（按年/月/日）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="totalScore" class="col-sm-2 control-label">总积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="totalScore" ng-model="staff.totalScore" ng-bind="staff.totalScore" placeholder="请输入总积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="seniority" class="col-sm-2 control-label">工龄</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="seniority" ng-model="staff.seniority" ng-bind="staff.seniority" placeholder="请输入工龄" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="star" class="col-sm-2 control-label">星级</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="star" ng-model="staff.star" ng-bind="staff.star" placeholder="请输入星级" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="incumbency" class="col-sm-2 control-label">离职状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="incumbency" ng-model="staff.incumbency" ng-bind="staff.incumbency" placeholder="请输入离职状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sunScore" class="col-sm-2 control-label">太阳积分(每月初始化为0)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sunScore" ng-model="staff.sunScore" ng-bind="staff.sunScore" placeholder="请输入太阳积分(每月初始化为0)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="loveScore" class="col-sm-2 control-label">爱心积分(每月初始化为0)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="loveScore" ng-model="staff.loveScore" ng-bind="staff.loveScore" placeholder="请输入爱心积分(每月初始化为0)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="approvalLogNum" class="col-sm-2 control-label">审批日志</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="approvalLogNum" ng-model="staff.approvalLogNum" ng-bind="staff.approvalLogNum" placeholder="请输入审批日志" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="waitApprovalNum" class="col-sm-2 control-label">待我审批</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="waitApprovalNum" ng-model="staff.waitApprovalNum" ng-bind="staff.waitApprovalNum" placeholder="请输入待我审批" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="myApprovalNum" class="col-sm-2 control-label">我发起的</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="myApprovalNum" ng-model="staff.myApprovalNum" ng-bind="staff.myApprovalNum" placeholder="请输入我发起的" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="myCopyNum" class="col-sm-2 control-label">我的抄送</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="myCopyNum" ng-model="staff.myCopyNum" ng-bind="staff.myCopyNum" placeholder="请输入我的抄送" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="ranking" class="col-sm-2 control-label">积分排行</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="ranking" ng-model="staff.ranking" ng-bind="staff.ranking" placeholder="请输入积分排行" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="joinRank" class="col-sm-2 control-label">是否参与积分排行</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="joinRank" ng-model="staff.joinRank" ng-bind="staff.joinRank" placeholder="请输入是否参与积分排行" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="entryAt" class="col-sm-2 control-label">入职时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="entryAt" ng-model="staff.entryAt" ng-bind="staff.entryAt" placeholder="请输入入职时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="role" class="col-sm-2 control-label">员工角色</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="role" ng-model="staff.role" ng-bind="staff.role" placeholder="请输入员工角色" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="staff.createBy" ng-bind="staff.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="staff.updateBy" ng-bind="staff.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateStaff(staff)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/staff">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/staff/staffDetail.js"></script>
