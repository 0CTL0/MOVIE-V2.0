<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/27
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link href="../../../css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="/user/login">登录</a> <a href="/user/regist">注册</a>
        </h1>
        <%
            String username="";
            //获取登录失败的提示信息
            String msg="";
            if(request.getAttribute("msg")!=null){
                msg=(String)request.getAttribute("msg");
            }
        %>
        <h3 style="color: red;"><%=msg%></h3>

    </div>
    <form action="/user/toLogin" method="post">
        <table>
            <tr>
                <td class="td1">用户名</td>
                <td><input type="text" class="input1" name="userName" vlaue="<%=username%>"></td>
            </tr>
            <tr>
                <td class="td1">密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
                <td><input type="password" class="input1" name="userPassword"></td>
            </tr>
            <tr>
                <td class="td1" colspan="2">
                    <input type="checkbox" name="remember" value="true" checked="checked"> 记住用户名</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="submit" value="登录" id="login-btn">
                    </div>
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
