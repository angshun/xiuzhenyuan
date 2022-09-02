<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${scoreExchangeApprovalList}" var="scoreExchangeApproval">
			<json:object>
					
               
                    <json:property name="id" value="${scoreExchangeApproval.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="staffId" value="${scoreExchangeApproval.staffId}"></json:property>
           
           
	   
        			
               
                    <json:property name="goodsId" value="${scoreExchangeApproval.goodsId}"></json:property>
           
           
	   
        			
               
                    <json:property name="exchangeStatus" value="${scoreExchangeApproval.exchangeStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${scoreExchangeApproval.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${scoreExchangeApproval.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${scoreExchangeApproval.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${scoreExchangeApproval.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


