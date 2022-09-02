<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${starList}" var="star">
			<json:object>
					
               
                    <json:property name="id" value="${star.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="gradeType" value="${star.gradeType}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${star.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="score" value="${star.score}"></json:property>
           
           
	   
        			
               
                    <json:property name="level" value="${star.level}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${star.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${star.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${star.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${star.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


