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
		<c:forEach items="${departmentList}" var="department">
			<json:object>
					
               
                    <json:property name="id" value="${department.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${department.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="parentId" value="${department.parentId}"></json:property>
           
           
	   
        			
               
                    <json:property name="isParent" value="${department.isParent}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${department.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${department.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${department.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${department.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


