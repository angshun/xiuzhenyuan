<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>


    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="total" value="${total}"></json:property>

    <json:array name="data">
        <c:forEach items="${professionDataList}" var="profession">
            <json:object>


                <json:property name="id" value="${profession.pId}"></json:property>
                <json:property name="professionName" value="${profession.professionName}"></json:property>
                <json:property name="cId" value="${profession.cId}"></json:property>

                <json:property name="companyName" value="${profession.companyName}"></json:property>

                <json:property name="releaseAt" value="${profession.releaseAt}"></json:property>

                <json:property name="salary" value="${profession.salary}"></json:property>

                <json:property name="type" value="${profession.type}"></json:property>

                <json:property name="education" value="${profession.education}"></json:property>

                <json:property name="workExperience" value="${profession.workExperience}"></json:property>

                <json:property name="status" value="${profession.status}"></json:property>

            </json:object>

        </c:forEach>

        <c:forEach items="${companyList}" var="c">

            <json:property name="companyName" value="${c.name}"></json:property>

        </c:forEach>


    </json:array>


</json:object>


