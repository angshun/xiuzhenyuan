<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>

    <json:object name="data">



            <json:property name="img" value="${staff.img}"></json:property>


            <json:property name="name" value="${staff.name}"></json:property>


            <json:property name="departmentName" value="${staff.departmentName}"></json:property>


            <json:property name="id" value="${attendanceLog.id}"></json:property>


            <json:property name="attendanceStatus" value="${attendanceLog.attendanceStatus}"></json:property>


            <json:property name="attendanceType" value="${attendanceLog.attendanceType}"></json:property>


            <json:property name="createAt" value="${attendanceLog.createAt}"></json:property>


            <json:property name="scoreChange" value="${scoreLog.scoreChange}"></json:property>


            <json:property name="scoreType" value="${scoreLog.scoreType}"></json:property>










    </json:object>

</json:object>


