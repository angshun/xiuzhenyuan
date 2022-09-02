
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%--<tiles:insertAttribute name="title"/>--%>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../bootstrap-3.3.5-dist/css/bootstrap.css">
        <link href="css/Untitled-3.css" rel="stylesheet" type="text/css">
        <link href="css/Untitled-1base.css" rel="stylesheet" type="text/css">
        <title>首页</title>

</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</body>
<script src="jquery.min.js"></script>
<script  src="bootstrap.min.js"></script>
</html>
