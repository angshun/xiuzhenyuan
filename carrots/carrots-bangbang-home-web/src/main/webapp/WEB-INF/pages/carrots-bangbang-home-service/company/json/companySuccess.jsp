<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:object name="data">

        <!-- 认证公司 -->
        <json:array name="companyList1">

            <c:forEach items="${companyList1}" var="company1">
                <json:object>

                    <json:property name="logo1" value="${company1.logo}"></json:property>
                    <json:property name="img" value="${company1.img}"></json:property>

                </json:object>
            </c:forEach>

        </json:array>

        <!-- 普通公司 -->
        <json:array name="companyList2">

            <c:forEach items="${companyList2}" var="company2">
                <json:object>

                    <json:property name="logo2" value="${company2.logo}"></json:property>

                </json:object>
            </c:forEach>

        </json:array>
    </json:object>

</json:object>


