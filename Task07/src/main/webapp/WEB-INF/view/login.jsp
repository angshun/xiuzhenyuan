<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.jnshu.Utils.SendMSG" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2017/5/16
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>


</head>
<body>

<form action="/loginer" method="get" id="form1">
    <table>
        <tr>
            <td><table>手  机：</table></td>
            <td><input type="text" id="tel" name="tel" value="${tel}"/></td>
        </tr>
        <tr>
            <td><table>密  码：</table></td>
            <td><input type="text" id="pwd" name="pwd" value="${pwd}"/></td>
        </tr>
        <tr>
            <td><table>验证码：</table></td>
            <td><input type="text" id="code" name="code"/></td>
        </tr>
        <tr>
            <td><table><button type="button" onclick="send()">点击获取验证码</button></table></td>
        </tr>
        <tr>
            <td><input type="button" onclick="abc()" value="注册" /></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function send(){

			var tel =document.getElementById("tel").value;
			var pwd =document.getElementById("pwd").value;
			location.href="/sendMsg?tel="+tel+"&pwd="+pwd;
        }

    function abc(){
        if(<%=session.getAttribute("code")%>==null)
        {
         alert("请重新获取验证码！");
         form1.action="/login";
         form1.submit();
         }
         else if(<%=session.getAttribute("code")%> == document.getElementById("code").value)
         {

         var tel =document.getElementById("tel").value;
		 var pwd =document.getElementById("pwd").value;
         form1.action="/loginer?tel="+tel+"&pwd="+pwd;
         form1.submit();
         }else{
         alert("验证码不正确");
         <%--form1.action="/home";--%>
         }

    }
</script>

</body>
</html>
