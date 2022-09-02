<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data">
        <c:forEach items="${staffList}" var="approveLog">
            <json:object>


                <json:property name="id" value="${approveLog.id}"></json:property>

                <json:property name="name" value="${approveLog.name}"></json:property>

                <json:property name="img" value="${approveLog.img}"></json:property>

                <json:property name="iniScore" value="${approveLog.iniScore}"></json:property>

                <json:property name="sunScore" value="${approveLog.sunScore}"></json:property>

                <json:property name="loveScore" value="${approveLog.loveScore}"></json:property>

                <json:property name="totalScore" value="${approveLog.sunScore+approveLog.loveScore}"></json:property>

                <json:property name="sunScoreSet" value="${dailyAttendance.sunScore}"></json:property>

                <json:property name="loveScoreSet" value="${dailyAttendance.loveScore}"></json:property>

                <%--<json:property name="id" value="${approveLog.staff.id}"></json:property>--%>

                <%--<json:property name="name" value="${approveLog.staff.name}"></json:property>--%>

                <%--<json:property name="img" value="${approveLog.staff.img}"></json:property>--%>

                <%--<json:property name="iniScore" value="${approveLog.staff.iniScore}"></json:property>--%>

                <%--<json:property name="sunScore" value="${approveLog.staff.sunScore}"></json:property>--%>

                <%--<json:property name="loveScore" value="${approveLog.staff.loveScore}"></json:property>--%>

                <%--<json:property name="totalScore" value="${approveLog.staff.totalScore}"></json:property>--%>

                <%--<json:property name="sunScoreSet" value="${approveLog.dailyAttendance.sunScore}"></json:property>--%>

                <%--<json:property name="loveScoreSet" value="${approveLog.dailyAttendance.loveScore}"></json:property>--%>


            </json:object>
        </c:forEach>
    </json:array>
</json:object>


