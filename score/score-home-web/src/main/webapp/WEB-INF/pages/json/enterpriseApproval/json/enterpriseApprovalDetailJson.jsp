<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${enterpriseApproval.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="title" value="${enterpriseApproval.title}"></json:property>
           
           
	   
                    			
               
                    <json:property name="applyId" value="${enterpriseApproval.applyId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="scoreType" value="${enterpriseApproval.scoreType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="score" value="${enterpriseApproval.score}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${enterpriseApproval.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="content" value="${enterpriseApproval.content}"></json:property>
           
           
	   
                    			
               
                    <json:property name="picture" value="${enterpriseApproval.picture}"></json:property>
           
           
	   
                    			
               
                    <json:property name="approvalId" value="${enterpriseApproval.approvalId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${enterpriseApproval.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${enterpriseApproval.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${enterpriseApproval.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${enterpriseApproval.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


