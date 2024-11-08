<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/11/2024
  Time: 5:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/add" method="post">
    Mã: <input type="text" name="ma">
    <br>
    Tên: <input type="text" name="ten">
    <br>
    Tuổi: <input type="text" name="tuoi">
    <br>
    Giới tính: <input type="text" name="gioiTinh">
    <br>
    Địa chỉ: <input type="text" name="diaChi">
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
