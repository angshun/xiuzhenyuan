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
		<c:forEach items="${allTypeScoreList}" var="allTypeScore">
			<json:object>
					
               
                    <json:property name="id" value="${allTypeScore.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${allTypeScore.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${allTypeScore.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="score" value="${allTypeScore.score}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${allTypeScore.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${allTypeScore.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${allTypeScore.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${allTypeScore.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


