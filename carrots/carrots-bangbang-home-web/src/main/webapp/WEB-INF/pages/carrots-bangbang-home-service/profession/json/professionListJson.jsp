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
    <json:array name="data">
        <c:forEach items="${professionList}" var="profession">
            <json:object>


                <json:property name="id" value="${profession.id}"></json:property>


                <json:property name="name" value="${profession.name}"></json:property>


                <json:property name="cId" value="${profession.cId}"></json:property>


                <json:property name="releaseAt" value="${profession.releaseAt}"></json:property>


                <json:property name="salary" value="${profession.salary}"></json:property>


                <json:property name="education" value="${profession.education}"></json:property>


                <json:property name="workExperience" value="${profession.workExperience}"></json:property>


                <json:property name="status" value="${profession.status}"></json:property>


                <json:property name="responsibility" value="${profession.responsibility}"></json:property>


                <json:property name="requirement" value="${profession.requirement}"></json:property>


                <json:property name="welfare" value="${profession.welfare}"></json:property>


                <json:property name="createAt" value="${profession.createAt}"></json:property>


                <json:property name="updateAt" value="${profession.updateAt}"></json:property>


                <json:property name="createBy" value="${profession.createBy}"></json:property>


                <json:property name="updateBy" value="${profession.updateBy}"></json:property>

            </json:object>
        </c:forEach>
    </json:array>
    <!-- 获取公司列表 -->
    <json:array name="companyList">
        <c:forEach items="${companyList}" var="company">
            <json:object>
                <json:property name="id" value="${company.id}"></json:property>

                <json:property name="name" value="${company.name}"></json:property>

                <json:property name="province" value="${company.province}"></json:property>

                <json:property name="city" value="${company.city}"></json:property>

                <json:property name="county" value="${company.county}"></json:property>

            </json:object>
        </c:forEach>
    </json:array>
</json:object>


