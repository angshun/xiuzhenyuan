<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${operationLogList}" var="operationLog">
			<json:object>
					
               
                    <json:property name="id" value="${operationLog.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="admin" value="${operationLog.admin}"></json:property>
           
           
	   
        			
               
                    <json:property name="operation" value="${operationLog.operation}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${operationLog.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${operationLog.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${operationLog.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${operationLog.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


