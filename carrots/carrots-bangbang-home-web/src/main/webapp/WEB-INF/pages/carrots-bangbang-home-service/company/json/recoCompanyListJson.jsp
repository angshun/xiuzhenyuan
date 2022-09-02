<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:object name="data">

        <json:array name="recoCompanyList">
            <c:forEach items="${recoCompanyList}" var="company">
                <json:object>
                    <json:property name="id" value="${company.id}"></json:property>
                    <json:property name="name" value="${company.name}"></json:property>
                    <%--<json:property name="professionNum" value= "${3}" ></json:property>--%>
                    <json:property name="industry" value="${company.industry}"></json:property>
                    <json:property name="province" value="${company.province}"></json:property>
                    <json:property name="city" value="${company.city}"></json:property>
                    <json:property name="county" value="${company.county}"></json:property>
                    <json:property name="slogan" value="${company.slogan}"></json:property>
                    <json:property name="logo" value="${company.logo}"></json:property>

                </json:object>
            </c:forEach>
        </json:array>

        <!-- 在招职位个数列表 -->
        <json:array name="professionNum">
            <c:forEach items="${professionNum}" var="num">
                <json:property value="${num}"></json:property>
            </c:forEach>
        </json:array>
    </json:object>

</json:object>


