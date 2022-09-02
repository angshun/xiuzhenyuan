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
		<c:forEach items="${rewardLogList}" var="rewardLog">
			<json:object>
					
               
                    <json:property name="id" value="${rewardLog.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="staffId" value="${rewardLog.staffId}"></json:property>
           
           
	   
        			
               
                    <json:property name="adminName" value="${rewardLog.adminName}"></json:property>
           
           
	   
        			
               
                    <json:property name="adminPhoto" value="${rewardLog.adminPhoto}"></json:property>
           
           
	   
        			
               
                    <json:property name="rewardContent" value="${rewardLog.rewardContent}"></json:property>
           
           
	   
        			
               
                    <json:property name="rewardScore" value="${rewardLog.rewardScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="rewardRemark" value="${rewardLog.rewardRemark}"></json:property>
           
           
	   
        			
               
                    <json:property name="rewardTitle" value="${rewardLog.rewardTitle}"></json:property>
           
           
	   
        			
               
                    <json:property name="scoreType" value="${rewardLog.scoreType}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${rewardLog.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${rewardLog.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${rewardLog.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${rewardLog.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


