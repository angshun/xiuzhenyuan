<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data">
        <c:forEach items="${enterpriseApprovalList}" var="enterpriseApproval">

            <json:object>


                <json:property name="id" value="${enterpriseApproval.id}"></json:property>

                <json:property name="name" value="${staff_alias[enterpriseApproval.applyId]}"></json:property>

                <json:property name="img" value="${staff_img[enterpriseApproval.applyId]}"></json:property>

                <json:property name="title" value="${enterpriseApproval.title}"></json:property>

                <json:property name="scoreType" value="${enterpriseApproval.scoreType}"></json:property>

                <json:property name="updateAt" value="${enterpriseApproval.updateAt}"></json:property>

                <json:property name="score" value="${enterpriseApproval.score}"></json:property>

                <json:property name="status" value="${enterpriseApproval.status}"></json:property>

            </json:object>


        </c:forEach>
    </json:array>
</json:object>


