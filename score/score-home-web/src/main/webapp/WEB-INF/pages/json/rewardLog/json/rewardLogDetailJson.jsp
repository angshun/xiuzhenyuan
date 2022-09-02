<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:object name="data">
        <json:property name="departmentName" value="${staff.departmentName}"></json:property>
        <json:property name="positionName" value="${staff.positionName}"></json:property>
        <json:property name="img" value="${staff.img}"></json:property>
        <%--<json:property name="img" value="${rewardLog.adminPhoto}"></json:property>--%>
        <%--<json:property name="adminName" value="${rewardLog.adminName}"></json:property>--%>
        <json:property name="adminName" value="${staff.name}"></json:property>
        <json:property name="createAt" value="${rewardLog.createAt}"></json:property>
        <json:property name="content" value="${rewardLog.rewardContent}"></json:property>
        <json:property name="rewardTitle" value="${rewardLog.rewardTitle}"></json:property>
        <json:property name="scoreType" value="${rewardLog.scoreType}"></json:property>
        <json:property name="rewardScore" value="${rewardLog.rewardScore}"></json:property>
        <json:property name="picture" value="${rewardLog.img}"></json:property>
        <json:property name="status" value="${rewardLog.rewardRemark}"></json:property>
    </json:object>
</json:object>


