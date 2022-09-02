<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="goods" id="current_nav">
	<div id="goodsDetailApp" ng-app="goodsDetailApp">
		<div ng-controller="goodsDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="goodsForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="goodsId" ng-model="goods.id" ng-bind="goods.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">商品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="goods.name" ng-bind="goods.name" placeholder="请输入商品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="img" class="col-sm-2 control-label">商品图片</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="img" ng-model="goods.img" ng-bind="goods.img" placeholder="请输入商品图片" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">商品详情</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="goods.content" ng-bind="goods.content" placeholder="请输入商品详情" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="score" class="col-sm-2 control-label">兑换积分</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="score" ng-model="goods.score" ng-bind="goods.score" placeholder="请输入兑换积分" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="number" class="col-sm-2 control-label">商品数量</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="number" ng-model="goods.number" ng-bind="goods.number" placeholder="请输入商品数量" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="goods.createBy" ng-bind="goods.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="goods.updateBy" ng-bind="goods.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateGoods(goods)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/goods">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/score-admin-service/goods/goodsDetail.js"></script>
