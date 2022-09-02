<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data">
        <c:forEach items="${nodes}" var="department">
            <json:object>

                <json:property name="id" value="${department.id}"></json:property>

                <json:property name="name" value="${department.name}"></json:property>

                <json:array name="node">

                    <c:forEach items="${department.node}" var="now">
                        <json:property value="${now}"></json:property>
                    </c:forEach>


                </json:array>

            </json:object>
        </c:forEach>
    </json:array>
</json:object>


