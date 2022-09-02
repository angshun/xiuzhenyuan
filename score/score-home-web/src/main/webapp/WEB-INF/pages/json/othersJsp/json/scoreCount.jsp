<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<%--<c:forEach items="${staffList}" var="staff">--%>
			<json:object>
                    <json:property name="approveScore" value="${approveScore}"></json:property>
                    <json:property name="scoreB" value="${scoreB}"></json:property>
                    <json:property name="scoreC" value="${scoreC}"></json:property>
                    <json:property name="baseScore" value="${baseScore}"></json:property>
        			</json:object>
		<%--</c:forEach>--%>
	</json:array>
</json:object>


