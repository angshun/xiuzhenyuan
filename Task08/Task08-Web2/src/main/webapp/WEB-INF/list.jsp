<%--
  Created by IntelliJ IDEA.
  User: shun
  Date: 2017/7/5
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>





<json:object>
    <json:array name="内门弟子" var="stu" items="${list}">
        <json:object>
            <json:property name="id" value="${stu.id}"/>
            <json:property name="name" value="${stu.name}"/>
            <json:property name="avatar" value="${stu.avatar}"/>
            <json:property name="introduction" value="${stu.introduction}"/>

        </json:object>
    </json:array>
</json:object>


