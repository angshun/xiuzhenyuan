<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>

    </json:property>

    <json:object name="data">

        <json:object name="profession">

            <json:property name="id" value="${professionData.pId}"></json:property>


            <json:property name="name" value="${professionData.professionName}"></json:property>

            <json:property name="companyName" value="${professionData.companyName}"></json:property>

            <json:property name="type" value="${professionData.type}"></json:property>

            <json:property name="recommend" value="${professionData.recommend}"></json:property>

            <json:property name="subType" value="${professionData.subType}"></json:property>

            <json:property name="grade" value="${professionData.grade}"></json:property>


            <json:property name="salary" value="${professionData.salary}"></json:property>


            <json:property name="education" value="${professionData.education}"></json:property>


            <json:property name="workExperience" value="${professionData.workExperience}"></json:property>


            <json:property name="responsibility" value="${professionData.responsibility}"></json:property>


            <json:property name="requirement" value="${professionData.requirement}"></json:property>


            <json:property name="welfare" value="${professionData.welfare}"></json:property>

            <json:property name="city" value="${professionData.city}"></json:property>

            <json:property name="county" value="${professionData.county}"></json:property>

            <json:property name="province" value="${professionData.province}"></json:property>



        </json:object>

        <%--<json:array name="professionTag">--%>
            <%--<c:forEach items="${professionTag}" var="tagList">--%>
                <%--<json:object>--%>
                    <%--<json:property name="tag" value="${tagList}"></json:property>--%>
                <%--</json:object>--%>
            <%--</c:forEach>--%>
        <%--</json:array>--%>


        <%--<json:property name="professionTag" value="${professionData.professionTag}"></json:property>--%>

        <json:array name="professionTag" items="${professionData.professionTag}"></json:array>




    </json:object>

</json:object>

<%--</json:object>--%>

