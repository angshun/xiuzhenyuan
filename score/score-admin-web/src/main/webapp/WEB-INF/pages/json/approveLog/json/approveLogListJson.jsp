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
	<json:array name="data">
		<c:forEach items="${approveLogList}" var="approveLog">
			<json:object>
					
               
                    <json:property name="id" value="${approveLog.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${approveLog.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="logId" value="${approveLog.logId}"></json:property>
           
           
	   
        			
               
                    <json:property name="attendanceType" value="${approveLog.attendanceType}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${approveLog.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${approveLog.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${approveLog.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${approveLog.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


