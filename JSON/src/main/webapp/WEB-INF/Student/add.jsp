<%--
  Created by IntelliJ IDEA.
  User: shun
  Date: 2017/6/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="id" value="${show.id}"/>
    <json:property name="姓名" value="${show.stu_name}"/>
    <json:property name="宣言" value="${show.sign}"/>
    <json:property name="介绍人" value="${show.stu_introducer}"/>
    <json:property name="创建时间" value="${show.create_at}"/>
    <json:property name="更新时间" value="${show.update_at}"/>
</json:object>