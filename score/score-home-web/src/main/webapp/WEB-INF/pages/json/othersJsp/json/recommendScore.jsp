<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@ page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="commendScore" value="${commendScore}"></json:property>
</json:object>