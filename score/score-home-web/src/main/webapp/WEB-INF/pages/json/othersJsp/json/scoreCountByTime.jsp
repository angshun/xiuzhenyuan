<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>
    <json:array name="data">
        <%--<c:forEach items="${staffList}" var="staff">--%>
            <json:object>
                <json:property name="dayAdd" value="${dayAdd}"></json:property>
                <json:property name="daySub" value="${daySub}"></json:property>
                <json:property name="monthAdd" value="${monthAdd}"></json:property>
                <json:property name="monthSub" value="${monthSub}"></json:property>
                <json:property name="quarterAdd" value="${quarterAdd}"></json:property>
                <json:property name="quarterSub" value="${quarterSub}"></json:property>
                <json:property name="yearAdd" value="${yearAdd}"></json:property>
                <json:property name="yearSub" value="${yearSub}"></json:property>
            </json:object>
        <%--</c:forEach>--%>
    </json:array>
</json:object>


