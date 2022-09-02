<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">

		<c:forEach items="${staffList}" var="staff">
			<json:object>


                    <json:property name="id" value="${staff.map.id}"></json:property>

                    <json:property name="name" value="${staff.map.name}"></json:property>

                    <json:property name="img" value="${staff.map.img}"></json:property>

                    <json:property name="addScore" value="${staff.map.subScore}"></json:property>

                    <json:property name="ranking" value="${staff.map.ranking}"></json:property>
                    <json:property name="totalScore" value="${staff.map.totalScore}"></json:property>


        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


