<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${epLogList}" var="enterpriseLog">
            <json:object>


                <json:property name="id" value="${enterpriseLog.id}"></json:property>

                <json:property name="staffId" value="${staff_staffId[enterpriseLog.staffId]}"></json:property>

                <json:property name="name" value="${staff_alias[enterpriseLog.staffId]}"></json:property>

                <json:property name="img" value="${staff_img[enterpriseLog.staffId]}"></json:property>

                <json:property name="departmentName"
                               value="${staff_departmentName[enterpriseLog.staffId]}"></json:property>

                <json:property name="logContent" value="${enterpriseLog.logContent}"></json:property>


                <json:property name="approveNum" value="${enterpriseLog.approveNum}"></json:property>


                <json:property name="commentNum" value="${enterpriseLog.commentNum}"></json:property>


                <json:property name="picture" value="${enterpriseLog.picture}"></json:property>
                <json:property name="isPraise" value="${isPraiseMap[enterpriseLog.id]}"></json:property>


                <json:property name="createAt" value="${enterpriseLog.createAt}"></json:property>
                <json:property name="updateAt" value="${enterpriseLog.updateAt}"></json:property>
                <json:property name="createBy" value="${enterpriseLog.createBy}"></json:property>
                <json:property name="updateBy" value="${enterpriseLog.updateBy}"></json:property>


            </json:object>
        </c:forEach>
    </json:array>
</json:object>


