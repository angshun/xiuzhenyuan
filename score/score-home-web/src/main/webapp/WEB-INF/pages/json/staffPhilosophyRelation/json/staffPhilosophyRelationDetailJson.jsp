<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${staffPhilosophyRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="staffId" value="${staffPhilosophyRelation.staffId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="philosophyId" value="${staffPhilosophyRelation.philosophyId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${staffPhilosophyRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${staffPhilosophyRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${staffPhilosophyRelation.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${staffPhilosophyRelation.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


