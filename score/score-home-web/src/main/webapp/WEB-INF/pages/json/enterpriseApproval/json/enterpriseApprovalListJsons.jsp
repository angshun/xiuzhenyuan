<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>


    <json:object name="data">


        <json:property name="id" value="${enterpriseApproval.enterpriseApproval.id}"></json:property>

        <json:property name="name" value="${enterpriseApproval.staff.name}"></json:property>

        <json:property name="img" value="${enterpriseApproval.staff.img}"></json:property>
        <json:property name="scoreType" value="${enterpriseApproval.enterpriseApproval.scoreType}"></json:property>
        <json:property name="departmentName" value="${enterpriseApproval.staff.departmentName}"></json:property>

        <json:property name="title" value="${enterpriseApproval.enterpriseApproval.title}"></json:property>


        <json:property name="updateAt" value="${enterpriseApproval.enterpriseApproval.updateAt}"></json:property>

        <json:property name="score" value="${enterpriseApproval.enterpriseApproval.score}"></json:property>

        <json:property name="status" value="${enterpriseApproval.enterpriseApproval.status}"></json:property>


        <json:property name="content" value="${enterpriseApproval.enterpriseApproval.content}"></json:property>
        <json:property name="createAt" value="${enterpriseApproval.enterpriseApproval.createAt}"></json:property>


        <json:property name="picture" value="${enterpriseApproval.enterpriseApproval.picture}"></json:property>


    </json:object>

</json:object>


