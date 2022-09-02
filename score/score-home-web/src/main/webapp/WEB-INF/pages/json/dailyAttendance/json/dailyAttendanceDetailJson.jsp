<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${dailyAttendance.id}"></json:property>


        <json:property name="companyCoordinate" value="${dailyAttendance.companyCoordinate}"></json:property>


        <json:property name="attendanceInstance" value="${dailyAttendance.attendanceInstance}"></json:property>


        <%--<json:property name="attendanceType" value="${dailyAttendance.attendanceType}"></json:property>--%>


        <%--<json:property name="normalScore" value="${dailyAttendance.normalScore}"></json:property>--%>


        <%--<json:property name="morningScore" value="${dailyAttendance.morningScore}"></json:property>--%>


        <%--<json:property name="lateScore" value="${dailyAttendance.lateScore}"></json:property>--%>


        <%--<json:property name="overtimeScore" value="${dailyAttendance.overtimeScore}"></json:property>--%>


        <%--<json:property name="leftEarlyScore" value="${dailyAttendance.leftEarlyScore}"></json:property>--%>


        <%--<json:property name="absenceScore" value="${dailyAttendance.absenceScore}"></json:property>--%>


        <%--<json:property name="workTime" value="${dailyAttendance.workTime}"></json:property>--%>


        <%--<json:property name="closingTime" value="${dailyAttendance.closingTime}"></json:property>--%>


        <%--<json:property name="outsideWorkTimeScore" value="${dailyAttendance.outsideWorkTimeScore}"></json:property>--%>


        <%--<json:property name="outsideClosingTimeScore" value="${dailyAttendance.outsideClosingTimeScore}"></json:property>--%>


        <%--<json:property name="logReleaseTime" value="${dailyAttendance.logReleaseTime}"></json:property>--%>


        <%--<json:property name="approveScore" value="${dailyAttendance.approveScore}"></json:property>--%>


        <%--<json:property name="beApproveScore" value="${dailyAttendance.beApproveScore}"></json:property>--%>


        <%--<json:property name="loveScore" value="${dailyAttendance.loveScore}"></json:property>--%>


        <%--<json:property name="sunScore" value="${dailyAttendance.sunScore}"></json:property>--%>


        <%--<json:property name="createAt" value="${dailyAttendance.createAt}"></json:property>--%>


        <%--<json:property name="updateAt" value="${dailyAttendance.updateAt}"></json:property>--%>


        <%--<json:property name="createBy" value="${dailyAttendance.createBy}"></json:property>--%>


        <%--<json:property name="updateBy" value="${dailyAttendance.updateBy}"></json:property>--%>


    </json:object>

</json:object>


