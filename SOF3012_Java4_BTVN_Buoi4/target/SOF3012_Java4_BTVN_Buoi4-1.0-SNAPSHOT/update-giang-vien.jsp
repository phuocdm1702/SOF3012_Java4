<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/11/2024
  Time: 5:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/update?idUpdateDate=${detail.id}" method="post">
    Mã: <input type="text" name="ma" value="${detail.ma}">
    <br>
    Tên: <input type="text" name="ten" value="${detail.ten}">
    <br>
    Tuổi: <input type="text" name="tuoi" value="${detail.tuoi}">
    <br>
    Giới tính: <input type="text" name="gioiTinh" value="${detail.gioiTinh ? "Nam": "Nữ"}">
    <br>
    Địa chỉ: <input type="text" name="diaChi" value="${detail.diaChi}">
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>
