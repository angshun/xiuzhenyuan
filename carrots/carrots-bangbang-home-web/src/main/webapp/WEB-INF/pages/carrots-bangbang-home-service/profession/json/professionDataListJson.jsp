<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>

    <json:array name="data">

        <c:forEach items="${professionDataList}" var="professionDataMap">
            <json:object>
                <!-- 获取职位信息 -->
                <json:property name="id" value="${professionDataMap.pId}"></json:property>

                <json:property name="name" value="${professionDataMap.pName}"></json:property>

                <json:property name="salary" value="${professionDataMap.salary}"></json:property>

                <json:property name="type" value="${professionDataMap.type}"></json:property>

                <json:property name="subType" value="${professionDataMap.subType}"></json:property>

                <json:property name="grade" value="${professionDataMap.grade}"></json:property>

                <json:property name="education" value="${professionDataMap.education}"></json:property>

                <json:property name="experience" value="${professionDataMap.experience}"></json:property>

                <json:property name="releaseAt" value="${professionDataMap.releaseAt}"></json:property>

                <!-- 获取公司信息 -->
                <json:property name="cId" value="${professionDataMap.cId}"></json:property>

                <json:property name="companyName" value="${professionDataMap.cName}"></json:property>

                <json:property name="logo" value="${professionDataMap.logo}"></json:property>

                <json:property name="industry" value="${professionDataMap.industry}"></json:property>

                <json:property name="province" value="${professionDataMap.province}"></json:property>

                <json:property name="city" value="${professionDataMap.city}"></json:property>

                <%--<json:property name="county" value="${professionDataMap.county}"></json:property>--%>

                <!-- 获取公司标签信息 -->
                <json:array name="companyTag" items="${professionDataMap.companyTagList}"></json:array>
            </json:object>


        </c:forEach>


    </json:array>
</json:object>
