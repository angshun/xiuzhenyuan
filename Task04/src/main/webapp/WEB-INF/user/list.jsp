<%--
  Created by IntelliJ IDEA.
  User: yangshun
  Date: 2017/6/1
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ptteng.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<h1>北京Java内门弟子<a href="/task04/info/add">添加</a></h1>

<table width="60%" border=1px cellpadding="0" cellspacing="0">
    <tr>
        <td>&nbsp;id</td>
        <td>姓名</td>
        <td>宣言</td>
        <td>操作</td>
    </tr>
    <%
        List<Student> list=(List)request.getAttribute("list");
        for(int i=0;i<list.size();i++){
            Student stu=list.get(i);

    %>
    <tr class=row<%=(i%2)+1 %>>
        <td><%=stu.getId() %></td>
        <td><%=stu.getStu_name() %></td>
        <td><%=stu.getSign() %></td>
        <td><a href='/task04/info/delete/<%=stu.getId()%>'>删除</a>
            <a href='/task04/info/list/<%=stu.getId()%>'>修改</a>
        </td>
        <%--<td><a href='/delete?id=<%=stu.getId()%>'>删除</a></td>--%>
        <%--onclick="return confirm('确定删除<%stu.getStu_name()%>吗')"--%>
    </tr>
    <%} %>
</table>
</body>
</html>



