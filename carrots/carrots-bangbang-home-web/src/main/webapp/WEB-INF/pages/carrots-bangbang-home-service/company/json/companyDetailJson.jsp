<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">

        <json:object name="company">
            <!-- 获取公司信息 -->
            <json:property name="id" value="${company.id}"></json:property>


            <json:property name="name" value="${company.name}"></json:property>


            <json:property name="province" value="${company.province}"></json:property>


            <json:property name="city" value="${company.city}"></json:property>


            <json:property name="county" value="${company.county}"></json:property>


            <json:property name="logo" value="${company.logo}"></json:property>


            <json:property name="slogan" value="${company.slogan}"></json:property>


            <json:property name="financing" value="${company.financing}"></json:property>


            <json:property name="totalNum" value="${company.totalNum}"></json:property>


            <json:property name="approved" value="${company.approved}"></json:property>


            <json:property name="introduction" value="${company.introduction}"></json:property>


            <json:property name="industry" value="${company.industry}"></json:property>


            <%--<json:property name="approvedAt" value="${company.approvedAt}"></json:property>--%>


            <%--<json:property name="freezed" value="${company.freezed}"></json:property>--%>

            <%--<json:property name="moblile" value="${company.moblile}"></json:property>--%>

            <%--<json:property name="address" value="${company.address}"></json:property>--%>

            <%--<json:property name="mail" value="${company.mail}"></json:property>--%>


            <%--<json:property name="map" value="${company.map}"></json:property>--%>


            <%--<json:property name="createAt" value="${company.createAt}"></json:property>--%>


            <%--<json:property name="updateAt" value="${company.updateAt}"></json:property>--%>


            <%--<json:property name="createBy" value="${company.createBy}"></json:property>--%>


            <%--<json:property name="releaseAt" value="${company.releaseAt}"></json:property>--%>


            <%--<json:property name="updateBy" value="${company.updateBy}"></json:property>--%>


        </json:object>


        <!-- 获取公司标签列表 -->
        <json:array name="companyTagList">
            <c:forEach items="${companyTagList}" var="companyTag">
                <json:object>
                    <json:property name="tag" value="${companyTag.tag}"></json:property>
                </json:object>
            </c:forEach>
        </json:array>


        <json:object name="product">

            <json:property name="name" value="${product.name}"></json:property>

            <json:property name="logo" value="${product.logo}"></json:property>

            <json:property name="slogan" value="${product.slogan}"></json:property>

            <json:property name="summary" value="${product.summary}"></json:property>

        </json:object>


    </json:object>

</json:object>


