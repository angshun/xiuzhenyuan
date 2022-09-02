<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${staff.id}"></json:property>


        <json:property name="name" value="${staff.name}"></json:property>


        <json:property name="approvalLogNum" value="${staff.approvalLogNum}"></json:property>


        <json:property name="waitApprovalNum" value="${staff.waitApprovalNum}"></json:property>


        <json:property name="myApprovalNum" value="${staff.myApprovalNum}"></json:property>


        <json:property name="myCopyNum" value="${staff.myCopyNum}"></json:property>


    </json:object>

</json:object>


