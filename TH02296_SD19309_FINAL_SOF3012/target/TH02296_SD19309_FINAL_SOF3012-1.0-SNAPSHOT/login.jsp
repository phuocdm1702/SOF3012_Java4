<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/12/2024
  Time: 2:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${erro}</p>
<form action="/LoginServlet" method="post">
    UserName: <input type="text" name="user">
    <br>
    passWord: <input type="password" name="pass">
    <br>
    <button type="submit">Login</button>
</form>

</body>
</html>
