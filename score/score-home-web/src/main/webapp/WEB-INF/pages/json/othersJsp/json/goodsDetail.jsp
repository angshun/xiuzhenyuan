<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data">
        <json:object>
            <json:property name="totalScore" value="${totalScore.get('totalScore')}"></json:property>
        </json:object>
            <c:forEach items="${goodsList}" var="goods">
                <json:object>
                    <json:property name="id" value="${goods.id}"></json:property>
                    <json:property name="name" value="${goods.name}"></json:property>
                    <json:property name="img" value="${goods.img}"></json:property>
                    <json:property name="content" value="${goods.content}"></json:property>
                    <json:property name="score" value="${goods.score}"></json:property>
                    <json:property name="number" value="${goods.number}"></json:property>
                    <json:property name="createAt" value="${goods.createAt}"></json:property>
                    <json:property name="updateAt" value="${goods.updateAt}"></json:property>
                    <json:property name="createBy" value="${goods.createBy}"></json:property>
                    <json:property name="updateBy" value="${goods.updateBy}"></json:property>
                </json:object>
            </c:forEach>
    </json:array>
</json:object>


