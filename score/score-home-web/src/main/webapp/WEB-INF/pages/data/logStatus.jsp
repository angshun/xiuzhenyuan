<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>

    <json:object name="data">


        <json:property name="status" value="${logStatus.status}"></json:property>


        <json:property name="score" value="${logStatus.score}"></json:property>




    </json:object>

</json:object>


