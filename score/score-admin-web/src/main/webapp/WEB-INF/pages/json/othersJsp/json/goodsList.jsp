<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/json;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data">
        <c:forEach items="${scoreExchangeApprovalList}" var="sea">


            <json:object>
                <json:property name="name" value="${staffId_alias[sea.staffId]}"></json:property>

                <json:property name="id" value="${sea.id}"></json:property>
                <json:property name="img" value="${goodsId_imgs[sea.goodsId]}"></json:property>
                <json:property name="goodsName" value="${goodsId_alias[sea.goodsId]}"></json:property>


                <json:property name="status" value="${sea.exchangeStatus}"></json:property>
                <json:property name="createAt" value="${sea.createAt}"></json:property>
            </json:object>


        </c:forEach>
    </json:array>
</json:object>


