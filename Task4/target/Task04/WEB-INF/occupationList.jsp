<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: shun
  Date: 2017/6/23
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<json:object>
    <json:array name="职业列表" items="${occupations}" var="s">
        <json:object>
            <json:property name="id" value="${s.id}"/>
            <json:property name="v_name" value="${s.v_name}"/>
            <json:property name="avatar" value="${s.avatar}"/>
            <json:property name="v_introduce" value="${s.v_introduce}"/>
            <json:property name="doorsill" value="${s.doorsill}"/>
            <json:property name="difficulty_level" value="${s.difficulty_level}"/>
            <json:property name="growth_cycle" value="${s.growth_cycle}"/>
            <json:property name="com_count" value="${s.com_count}"/>
            <json:property name="salary_low" value="${s.salary_low}"/>
            <json:property name="salary_mid" value="${s.salary_mid}"/>
            <json:property name="salary_high" value="${s.salary_high}"/>
            <json:property name="number" value="${s.number}"/>
            <json:property name="condition" value="${s.condition}"/>
        </json:object>
    </json:array>
</json:object>