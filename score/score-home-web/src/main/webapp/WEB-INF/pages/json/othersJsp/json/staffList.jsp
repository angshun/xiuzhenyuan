<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${staffList}" var="staff">
			<json:object>
					
               
                    <json:property name="id" value="${staff.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${staff.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="img" value="${staff.img}"></json:property>
           
           
	   
        			
               
                    <json:property name="phone" value="${staff.phone}"></json:property>
           
           
	   
        			
               
                    <json:property name="pwd" value="${staff.pwd}"></json:property>
           
           
	   
        			
               
                    <json:property name="departmentId" value="${staff.departmentId}"></json:property>
           
           
	   
        			
               
                    <json:property name="departmentName" value="${staff.departmentName}"></json:property>
           
           
	   
        			
               
                    <json:property name="positionId" value="${staff.positionId}"></json:property>

                <json:property name="positionName" value="${staff.positionName}"></json:property>

	   
        			
               
                    <json:property name="iniScore" value="${staff.iniScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="degreeScore" value="${staff.degreeScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="honorScore" value="${staff.honorScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="jopScore" value="${staff.jopScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="specialityScore" value="${staff.specialityScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="commendScore" value="${staff.commendScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="baseScore" value="${staff.baseScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="addScore" value="${staff.addScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="subScore" value="${staff.subScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="scoreSituation" value="${staff.scoreSituation}"></json:property>
           
           
	   
        			
               
                    <json:property name="totalScore" value="${staff.totalScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="seniority" value="${staff.seniority}"></json:property>
           
           
	   
        			
               
                    <json:property name="star" value="${staff.star}"></json:property>
           
           
	   
        			
               
                    <json:property name="incumbency" value="${staff.incumbency}"></json:property>
           
           
	   
        			
               
                    <json:property name="sunScore" value="${staff.sunScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="loveScore" value="${staff.loveScore}"></json:property>
           
           
	   
        			
               
                    <json:property name="approvalLogNum" value="${staff.approvalLogNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="waitApprovalNum" value="${staff.waitApprovalNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="myApprovalNum" value="${staff.myApprovalNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="myCopyNum" value="${staff.myCopyNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="ranking" value="${staff.ranking}"></json:property>
           
           
	   
        			
               
                    <json:property name="joinRank" value="${staff.joinRank}"></json:property>
           
           
	   
        			
               
                    <json:property name="entryAt" value="${staff.entryAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="role" value="${staff.role}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${staff.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${staff.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${staff.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${staff.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


