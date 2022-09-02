<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">

        <%--<json:object name="profession">--%>

        <json:property name="id" value="${professionData.id}"></json:property>


        <json:property name="name" value="${professionData.name}"></json:property>

        <json:property name="companyName" value="${professionData.companyName}"></json:property>

        <json:property name="logo" value="${professionData.logo}"></json:property>

        <%--<json:property name="recommend" value="${professionData.recommend}"></json:property>--%>

        <json:property name="totalNum" value="${professionData.totalNum}"></json:property>

        <json:property name="salary" value="${professionData.salary}"></json:property>


        <json:property name="releaseAt" value="${professionData.releaseAt}"></json:property>


        <json:property name="education" value="${professionData.education}"></json:property>


        <json:property name="experience" value="${professionData.experience}"></json:property>


        <json:property name="responsibility" value="${professionData.responsibility}"></json:property>


        <json:property name="requisite" value="${professionData.requisite}"></json:property>

        <json:property name="industry" value="${professionData.industry}"></json:property>


        <json:property name="welfare" value="${professionData.welfare}"></json:property>

        <json:property name="city" value="${professionData.city}"></json:property>

        <json:property name="province" value="${professionData.province}"></json:property>

        <json:array name="professionTag" items="${professionData.professionTag}"></json:array>


    </json:object>

    <%--<json:array name="professionTag">--%>
    <%--<c:forEach items="${professionTag}" var="tagList">--%>
    <%--<json:object>--%>
    <%--<json:property name="tag" value="${tagList}"></json:property>--%>
    <%--</json:object>--%>
    <%--</c:forEach>--%>
    <%--</json:array>--%>


    <%--<json:property name="professionTag" value="${professionData.professionTag}"></json:property>--%>


    <%--<json:property name="id" value="${profession.id}"></json:property>--%>


    <%--<json:property name="name" value="${profession.name}"></json:property>--%>


    <%--&lt;%&ndash;<json:property name="cId" value="${profession.cId}"></json:property>&ndash;%&gt;--%>


    <%--<json:property name="releaseAt" value="${profession.releaseAt}"></json:property>--%>


    <%--<json:property name="salary" value="${profession.salary}"></json:property>--%>


    <%--<json:property name="education" value="${profession.education}"></json:property>--%>


    <%--<json:property name="experience" value="${profession.workExperience}"></json:property>--%>


    <%--&lt;%&ndash;<json:property name="status" value="${profession.status}"></json:property>&ndash;%&gt;--%>


    <%--<json:property name="responsibility" value="${profession.responsibility}"></json:property>--%>


    <%--<json:property name="requirement" value="${profession.requirement}"></json:property>--%>


    <%--<json:property name="welfare" value="${profession.welfare}"></json:property>--%>


    <%--&lt;%&ndash;<json:property name="createAt" value="${profession.createAt}"></json:property>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<json:property name="updateAt" value="${profession.updateAt}"></json:property>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<json:property name="createBy" value="${profession.createBy}"></json:property>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<json:property name="updateBy" value="${profession.updateBy}"></json:property>&ndash;%&gt;--%>

    <%--<!-- 获取公司信息 -->--%>
    <%--<json:array name="company">--%>
    <%--<json:object>--%>
    <%--<json:property name="id" value="${company.id}"></json:property>--%>

    <%--<json:property name="name" value="${company.name}"></json:property>--%>

    <%--<json:property name="province" value="${company.province}"></json:property>--%>

    <%--<json:property name="city" value="${company.city}"></json:property>--%>
    <%--<json:property name="instry" value="${company.industry}"></json:property>--%>

    <%--<json:property name="totalNam" value="${company.totalNum}"></json:property>--%>

    <%--&lt;%&ndash;<json:property name="county" value="${company.county}"></json:property>&ndash;%&gt;--%>

    <%--</json:object>--%>
    <%--</json:array>--%>

    <%--<!-- 获取职位标签 -->--%>
    <%--<json:array name="professionTagList">--%>
    <%--<c:forEach items="${professionTagList}" var="professionTag">--%>
    <%--<json:object>--%>
    <%--<json:property name="tag" value="${professionTag.tag}"></json:property>--%>
    <%--</json:object>--%>
    <%--</c:forEach>--%>
    <%--</json:array>--%>

    <%--</json:object>--%>

</json:object>


