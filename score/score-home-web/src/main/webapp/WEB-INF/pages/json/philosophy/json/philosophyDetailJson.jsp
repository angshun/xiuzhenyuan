<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/json;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
    <json:property name="page" value="${page}"></json:property>
    <json:property name="toatl" value="${total}"></json:property>
    <json:property name="size" value="${size}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
			<json:object name="data">
                    <json:property name="id" value="${philosophy.id}"></json:property>
                    <json:property name="title" value="${philosophy.title}"></json:property>
                    <json:property name="reward" value="${philosophy.reward}"></json:property>
                    <json:property name="content" value="${philosophy.content}"></json:property>
                    <json:property name="project" value="${philosophy.project}"></json:property>
                    <json:property name="readNum" value="${philosophy.readNum}"></json:property>
                    <json:property name="status" value="${philosophy.status}"></json:property>
                    <json:property name="articleStatus" value="${philosophy.articleStatus}"></json:property>
                    <json:property name="createAt" value="${philosophy.createAt}"></json:property>
                    <json:property name="updateAt" value="${philosophy.updateAt}"></json:property>
                    <json:property name="createBy" value="${philosophy.createBy}"></json:property>
                    <json:property name="updateBy" value="${philosophy.updateBy}"></json:property>
			</json:object>

</json:object>


