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
		<c:forEach items="${staffTaskRelationList}" var="staffTaskRelation">
			<json:object>
					
               
                    <json:property name="id" value="${staffTaskRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="staffId" value="${staffTaskRelation.staffId}"></json:property>
           
           
	   
        			
               
                    <json:property name="taskId" value="${staffTaskRelation.taskId}"></json:property>
           
           
	   
        			
               
                    <json:property name="attendanceType" value="${staffTaskRelation.attendanceType}"></json:property>
           
           
	   
        			
               
                    <json:property name="taskType" value="${staffTaskRelation.taskType}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${staffTaskRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${staffTaskRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${staffTaskRelation.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${staffTaskRelation.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


