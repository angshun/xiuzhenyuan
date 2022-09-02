<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${data.enterpriseLog.id}"></json:property>

        <json:property name="staffId" value="${data.staff.id}"></json:property>

        <json:property name="img" value="${data.staff.img}"></json:property>

        <json:property name="name" value="${data.staff.name}"></json:property>

        <json:property name="departmentName" value="${data.staff.departmentName}"></json:property>

        <json:property name="logContent" value="${data.enterpriseLog.logContent}"></json:property>

        <json:property name="approveNum" value="${data.enterpriseLog.approveNum}"></json:property>

        <json:property name="commentNum" value="${data.enterpriseLog.commentNum}"></json:property>

        <json:property name="picture" value="${data.enterpriseLog.picture}"></json:property>
        <json:property name="isPraise" value="${data.isPraise}"></json:property>

        <json:property name="createAt" value="${data.enterpriseLog.createAt}"></json:property>
        <json:property name="updateAt" value="${data.enterpriseLog.updateAt}"></json:property>
        <json:property name="createBy" value="${data.enterpriseLog.createBy}"></json:property>
        <json:property name="updateBy" value="${data.enterpriseLog.updateBy}"></json:property>

        <json:array name="praise">

            <c:forEach items="${data.praise}" var="now">
                <json:property value="${now}"></json:property>
            </c:forEach>

        </json:array>

        <json:array name="commentList">
            <c:forEach items="${data.commentList}" var="now">
                <json:object>
                    <json:property name="logId" value="${now.logId}"></json:property>
                    <json:property name="name" value="${now.name}"></json:property>
                    <json:property name="img" value="${now.img}"></json:property>
                    <json:property name="comment" value="${now.comment}"></json:property>
                    <json:property name="createAt" value="${now.createAt}"></json:property>
                </json:object>
            </c:forEach>
        </json:array>
    </json:object>

</json:object>

