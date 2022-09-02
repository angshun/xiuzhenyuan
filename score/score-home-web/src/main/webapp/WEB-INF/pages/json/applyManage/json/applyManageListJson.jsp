<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <%--<json:property name="size" value="${size}"></json:property>--%>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${applyManageList}" var="applyManage">
            <json:object>


                <json:property name="id" value="${applyManage.id}"></json:property>


                <%--<json:property name="moduleId" value="${applyManage.moduleId}"></json:property>--%>


                <json:property name="status" value="${applyManage.status}"></json:property>
                <json:property name="img" value="${applyManage.img}"></json:property>
                <json:property name="url" value="${applyManage.url}"></json:property>
                <json:property name="title" value="${applyManage.title}"></json:property>


                <json:property name="createAt" value="${applyManage.createAt}"></json:property>


                <json:property name="updateAt" value="${applyManage.updateAt}"></json:property>


                <json:property name="createBy" value="${applyManage.createBy}"></json:property>


                <json:property name="updateBy" value="${applyManage.updateBy}"></json:property>


            </json:object>
        </c:forEach>
    </json:array>
</json:object>


