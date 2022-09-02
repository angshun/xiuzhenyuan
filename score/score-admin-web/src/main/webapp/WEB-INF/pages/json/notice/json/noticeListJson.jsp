<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${noticeList}" var="notice">
            <json:object>


                <json:property name="id" value="${notice.id}"></json:property>


                <json:property name="content" value="${notice.content}"></json:property>


                <json:property name="createAt" value="${notice.createAt}"></json:property>


                <json:property name="updateAt" value="${notice.updateAt}"></json:property>


                <json:property name="createBy" value="${notice.createBy}"></json:property>


                <json:property name="updateBy" value="${notice.updateBy}"></json:property>


            </json:object>
        </c:forEach>
    </json:array>
</json:object>


