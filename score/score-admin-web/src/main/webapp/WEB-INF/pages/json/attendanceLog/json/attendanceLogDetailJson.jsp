<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
               
                    <json:property name="id" value="${attendanceLog.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="staffId" value="${attendanceLog.staffId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="attendanceType" value="${attendanceLog.attendanceType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="attendanceAddress" value="${attendanceLog.attendanceAddress}"></json:property>
           
           
	   
                    			
               
                    <json:property name="attendanceStatus" value="${attendanceLog.attendanceStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${attendanceLog.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${attendanceLog.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${attendanceLog.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${attendanceLog.updateBy}"></json:property>





			</json:object>
		
</json:object>


