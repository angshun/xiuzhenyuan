<%@ page import="com.ptteng.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: yangshun
  Date: 2017/6/2
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


<json:object>
    <json:property name="姓名" value="${show1.stu_name}"/>
    <json:property name="id" value="${show1.id}"/>
    <json:property name="宣言" value="${show1.sign}"/>
    <json:property name="介绍人" value="${show1.stu_introducer}"/>
    <json:property name="创建时间" value="${show1.create_at}"/>
    <json:property name="更新时间" value="${show1.update_at}"/>
</json:object>




<%--<!DOCTYPE html>--%>
<%--<html lang="zh-CN">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->--%>
    <%--<title>修真院 修改学员</title>--%>

    <%--<!-- 新 Bootstrap 核心 CSS 文件 -->--%>
    <%--<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">--%>

    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
    <%--<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--<h1>学员信息</h1>--%>
    <%--<form:form action="/list/stu/${show.stu_name}" method="get">--%>
        <%--<div class="form-group">--%>
            <%--<label for="stu_name">姓名:</label>--%>
            <%--<input type="text" class="form-control" id="stu_name" name="stu_name" value="${show.stu_name}"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="sign">宣言:</label>--%>
            <%--<input type="text" class="form-control" id="sign" name="sign" value="${show.sign}"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="stu_school">毕业学校:</label>--%>
            <%--<input type="text" class="form-control" id="stu_school" name="stu_school"value="${show.stu_school}"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="stu_introducer">推荐人:</label>--%>
            <%--<input type="text" class="form-control" id="stu_introducer" name="stu_introducer" value="${show.stu_introducer}"/>--%>

        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<button type="submit" class="btn btn-sm btn-success">提交</button>--%>
        <%--</div>--%>
    <%--</form:form>--%>
<%--</div>--%>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>
<%--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>--%>

<%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
<%--<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>