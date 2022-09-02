<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${scoreType.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="moral" value="${scoreType.moral}"></json:property>
           
           
	   
                    			
               
                    <json:property name="content" value="${scoreType.content}"></json:property>
           
           
	   
                    			
               
                    <json:property name="project" value="${scoreType.project}"></json:property>
           
           
	   
                    			
               
                    <json:property name="scoreType" value="${scoreType.scoreType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="times" value="${scoreType.times}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${scoreType.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${scoreType.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${scoreType.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${scoreType.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${scoreType.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


