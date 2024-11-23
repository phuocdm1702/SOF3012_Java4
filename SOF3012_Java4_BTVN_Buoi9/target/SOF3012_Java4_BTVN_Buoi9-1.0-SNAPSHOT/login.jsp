<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 19/11/2024
  Time: 2:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<spant style="color: red">${{erro}}</spant>
<form action="/login" method="post">
    UserName:<input type="text" name="userName">
    <br>
    PassWord:<input type="password" name="pass">
    <br>
    <button>Đăng nhập</button>
</form>
</body>
</html>
