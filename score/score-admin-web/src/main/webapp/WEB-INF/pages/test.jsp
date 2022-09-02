<%--
  Created by IntelliJ IDEA.
  User: hfismyangel@163.com
  Date: 2017/9/29
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传实例 - 菜鸟教程</h1>
<form method="post" action="${pageContext.request.contextPath}/a/u/excelRead" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
