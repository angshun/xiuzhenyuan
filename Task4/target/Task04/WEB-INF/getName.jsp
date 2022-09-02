<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: shun
  Date: 2017/6/23
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<json:object>
    <json:property name="id" value="${getName.id}"/>
    <json:property name="v_name" value="${getName.v_name}"/>
    <json:property name="avatar" value="${getName.avatar}"/>
    <json:property name="v_introduce" value="${getName.v_introduce}"/>
    <json:property name="doorsill" value="${getName.doorsill}"/>
    <json:property name="difficulty_level" value="${getName.difficulty_level}"/>
    <json:property name="growth_cycle" value="${getName.growth_cycle}"/>
    <json:property name="com_count" value="${getName.com_count}"/>
    <json:property name="salary_low" value="${getName.salary_low}"/>
    <json:property name="salary_mid" value="${getName.salary_mid}"/>
    <json:property name="salary_high" value="${getName.salary_high}"/>
    <json:property name="number" value="${getName.number}"/>
    <json:property name="condition" value="${getName.condition}"/>
</json:object>
