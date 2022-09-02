<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${copyRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="recordId" value="${copyRelation.recordId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="copyId" value="${copyRelation.copyId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${copyRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${copyRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${copyRelation.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${copyRelation.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


