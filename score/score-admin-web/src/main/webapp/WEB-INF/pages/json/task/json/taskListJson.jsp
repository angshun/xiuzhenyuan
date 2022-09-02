<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
    <json:property name="page" value="${page}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${taskList}" var="task">
			<json:object>
					
               
                    <json:property name="id" value="${task.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${task.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="title" value="${task.title}"></json:property>
           
           
	   
        			
               
                    <json:property name="content" value="${task.content}"></json:property>
           
           
	   
        			
               
                    <json:property name="scoreType" value="${task.scoreType}"></json:property>
           
           
	   
        			
               
                    <json:property name="taskType" value="${task.taskType}"></json:property>
           
           
	   
        			
               
                    <json:property name="project" value="${task.project}"></json:property>
           
           
	   
        			
               
                    <json:property name="startAt" value="${task.startAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="endAt" value="${task.endAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="joinNum" value="${task.joinNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="number" value="${task.number}"></json:property>
           
           
	   
        			
               
                    <json:property name="times" value="${task.times}"></json:property>
           
           
	   
        			
               
                    <json:property name="taskScore" value="${task.taskScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="visualDepartment" value="${task.visualDepartment}"></json:property>
           
           
	   
        			
               
                    <json:property name="taskStatus" value="${task.taskStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${task.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${task.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${task.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${task.updateBy}"></json:property>
                <json:property name="status" value="${task.status}"></json:property>
                <json:property name="approveStatus" value="${task.approveStatus}"></json:property>
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


