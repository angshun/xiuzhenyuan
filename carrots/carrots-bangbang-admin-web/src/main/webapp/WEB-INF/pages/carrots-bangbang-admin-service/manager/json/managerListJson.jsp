<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${managerList}" var="manager">
			<json:object>
					
               
                    <json:property name="id" value="${manager.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="mobile" value="${manager.mobile}"></json:property>
           
           
	   
        			
               
                    <json:property name="rid" value="${manager.rid}"></json:property>
           
           
	   
        			
               
                    <json:property name="pwd" value="${manager.pwd}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${manager.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${manager.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${manager.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${manager.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${manager.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${manager.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


