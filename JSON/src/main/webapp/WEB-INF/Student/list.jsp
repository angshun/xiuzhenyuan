<%--
  Created by IntelliJ IDEA.
  User: shun
  Date: 2017/6/19
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


 <json:object>
     <json:array name="内门弟子" var="stu" items="${list}">
         <json:object>
             <json:property name="id" value="${stu.id}"/>
             <json:property name="name" value="${stu.stu_name}"/>
             <json:property name="sign" value="${stu.sign}"/>
             <json:property name="introducer" value="${stu.stu_introducer}"/>
             <%--<json:property name="创建时间" value="${stu.create_at}"/>--%>
             <%--<json:property name="更新时间" value="${stu.update_at}"/>--%>
         </json:object>
     </json:array>
 </json:object>




















<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <%--<title>内门弟子</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<h1>线下Java学院列表   <a href="/add">添加</a></h1>--%>

<%--<table width="60%" border='11' cellspacing='11'>--%>
    <%--<tr>--%>
        <%--<td>序号</td>--%>
        <%--<td>姓名</td>--%>
        <%--<td>宣言</td>--%>
        <%--<td>毕业学校</td>--%>
        <%--<td>介绍人</td>--%>
        <%--&lt;%&ndash;<td>创建时间</td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td>更新时间</td>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--<c:forEach items="${list}" var="l">--%>
        <%--<tr>--%>
            <%--<td>${l.id }</td>--%>
            <%--<td>${l.stu_name }</td>--%>
            <%--<td>${l.sign}</td>--%>
            <%--<td>${l.stu_school}</td>--%>
            <%--<td>${l.stu_introducer}</td>--%>
            <%--&lt;%&ndash;<td>${l.create_at}</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td>${l.update_at}</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;使用el表达式获取id&ndash;%&gt;--%>
            <%--<td><a href="/list/${l.id}" >详情</a>--%>
                <%--<a href='/delete/${l.id}'>删除</a>--%>
                <%--<a href='/update/${l.id}'>修改</a>--%>
            <%--</td>--%>
        <%--</tr>--%>

    <%--</c:forEach>--%>




<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
