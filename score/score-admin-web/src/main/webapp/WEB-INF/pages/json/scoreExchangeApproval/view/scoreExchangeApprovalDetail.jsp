<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="scoreExchangeApproval" id="current_nav">
	<div id="scoreExchangeApprovalDetailApp" ng-app="scoreExchangeApprovalDetailApp">
		<div ng-controller="scoreExchangeApprovalDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="scoreExchangeApprovalForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="scoreExchangeApprovalId" ng-model="scoreExchangeApproval.id" ng-bind="scoreExchangeApproval.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="staffId" class="col-sm-2 control-label">用户姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="staffId" ng-model="scoreExchangeApproval.staffId" ng-bind="scoreExchangeApproval.staffId" placeholder="请输入用户姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="goodsId" class="col-sm-2 control-label">商品id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="goodsId" ng-model="scoreExchangeApproval.goodsId" ng-bind="scoreExchangeApproval.goodsId" placeholder="请输入商品id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="exchangeStatus" class="col-sm-2 control-label">兑换状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="exchangeStatus" ng-model="scoreExchangeApproval.exchangeStatus" ng-bind="scoreExchangeApproval.exchangeStatus" placeholder="请输入兑换状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="scoreExchangeApproval.createBy" ng-bind="scoreExchangeApproval.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="scoreExchangeApproval.updateBy" ng-bind="scoreExchangeApproval.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateScoreExchangeApproval(scoreExchangeApproval)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/scoreExchangeApproval">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/scoreExchangeApproval/scoreExchangeApprovalDetail.js"></script>
