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
                <json:property name="totalNum" value="${professionDataMap.totalNum}"></json:property>

                <json:property name="logo" value="${professionDataMap.logo}"></json:property>

                <json:property name="industry" value="${professionDataMap.industry}"></json:property>

                <json:property name="province" value="${professionDataMap.province}"></json:property>

                <json:property name="city" value="${professionDataMap.city}"></json:property>

                <%--<json:property name="county" value="${professionDataMap.county}"></json:property>--%>

                <!-- 获取公司标签信息 -->
                <json:array name="companyTag" items="${professionDataMap.companyTagList}"></json:array>
            </json:object>


        </c:forEach>





















        <%--<json:object name="company">--%>
            <%--<!-- 获取公司信息 -->--%>
            <%--<json:property name="id" value="${company.id}"></json:property>--%>


            <%--<json:property name="name" value="${company.name}"></json:property>--%>


            <%--<json:property name="province" value="${company.province}"></json:property>--%>


            <%--<json:property name="city" value="${company.city}"></json:property>--%>


            <%--<json:property name="county" value="${company.county}"></json:property>--%>


            <%--<json:property name="logo" value="${company.logo}"></json:property>--%>


            <%--<json:property name="slogan" value="${company.slogan}"></json:property>--%>


            <%--<json:property name="financing" value="${company.financing}"></json:property>--%>


            <%--<json:property name="totalNum" value="${company.totalNum}"></json:property>--%>


            <%--<json:property name="approved" value="${company.approved}"></json:property>--%>


            <%--<json:property name="introduction" value="${company.introduction}"></json:property>--%>


            <%--<json:property name="industry" value="${company.industry}"></json:property>--%>


            <%--&lt;%&ndash;<json:property name="approvedAt" value="${company.approvedAt}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="freezed" value="${company.freezed}"></json:property>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<json:property name="moblile" value="${company.moblile}"></json:property>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<json:property name="address" value="${company.address}"></json:property>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<json:property name="mail" value="${company.mail}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="map" value="${company.map}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="createAt" value="${company.createAt}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="updateAt" value="${company.updateAt}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="createBy" value="${company.createBy}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="releaseAt" value="${company.releaseAt}"></json:property>&ndash;%&gt;--%>


            <%--&lt;%&ndash;<json:property name="updateBy" value="${company.updateBy}"></json:property>&ndash;%&gt;--%>


        <%--</json:object>--%>


        <%--<!-- 获取公司标签列表 -->--%>
        <%--<json:array name="companyTagList">--%>
            <%--<c:forEach items="${companyTagList}" var="companyTag">--%>
                <%--<json:object>--%>
                    <%--<json:property name="tag" value="${companyTag.tag}"></json:property>--%>
                <%--</json:object>--%>
            <%--</c:forEach>--%>
        <%--</json:array>--%>


        <%--<!-- 获取职位列表信息 -->--%>
        <%--<json:array name="professionList">--%>
            <%--<c:forEach items="${professionList}" var="profession">--%>
                <%--<json:object>--%>
                    <%--<json:property name="id" value="${profession.id}"></json:property>--%>

                    <%--<json:property name="name" value="${profession.name}"></json:property>--%>

                    <%--<json:property name="salary" value="${profession.salary}"></json:property>--%>


                    <%--<json:property name="education" value="${profession.education}"></json:property>--%>


                    <%--<json:property name="experience" value="${profession.workExperience}"></json:property>--%>


                    <%--<json:property name="releaseAt" value="${profession.releaseAt}"></json:property>--%>


                    <%--&lt;%&ndash;<json:property name="type" value="${profession.type}"></json:property>&ndash;%&gt;--%>


                    <%--&lt;%&ndash;<json:property name="slogan" value="${profession.slogan}"></json:property>&ndash;%&gt;--%>

                <%--</json:object>--%>
            <%--</c:forEach>--%>
        <%--</json:array>--%>


    <%--</json:object>--%>

</json:array>


</json:object>