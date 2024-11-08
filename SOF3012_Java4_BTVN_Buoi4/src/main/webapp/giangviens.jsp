<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/11/2024
  Time: 4:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/search" method="get">
    Tên: <input type="text" name="tenSearch" placeholder="Nhập tên giảng viên">
    <br>
    <button type="submit">Search</button>
</form>
<button><a href="/giang-vien/view-add">Add</a></button>
<button type="submit">Giảng viên nữ</button>
<br>
<table border="1" class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${hienThi}" var="giangVien">
        <tr>
            <td>${giangVien.id}</td>
            <td>${giangVien.ma}</td>
            <td>${giangVien.ten}</td>
            <td>${giangVien.tuoi}</td>
            <td>${giangVien.gioiTinh ? "Nam" : "Nữ"}</td>
            <td>${giangVien.diaChi}</td>
            <td>
                <button><a href="/giang-vien/detai?idDetail=${giangVien.id}">Detail</a></button>
                <button><a href="/giang-vien/view-update?idViewUpdate=${giangVien.id}">Edit</a></button>
                <button><a href="/giang-vien/remove?idRemove=${giangVien.id}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
