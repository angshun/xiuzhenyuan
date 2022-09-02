<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>

    <json:object name="data">



        <json:property name="id" value="1"></json:property>





        <json:property name="type" value="张三"></json:property>





        <json:property name="title" value="模拟数据"></json:property>





        <json:property name="img" value="图片"></json:property>





        <json:property name="url" value="www.baidu.com"></json:property>





        <json:property name="status" value="1"></json:property>





        <json:property name="industry" value="2"></json:property>





        <json:property name="createAt" value="20170821"></json:property>





        <json:property name="updateAt" value="20170821"></json:property>





        <json:property name="createBy" value="ys"></json:property>





        <json:property name="updateBy" value="ys"></json:property>





        <json:property name="rank" value="1"></json:property>





    </json:object>

</json:object>


