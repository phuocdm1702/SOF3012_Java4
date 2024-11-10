<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/11/2024
  Time: 9:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/view/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/may-tinh/add" method="post" class="form">
    <input type="hidden" name="ma" value="${detail.ma}">
    Tên: <input type="text" name="ten" value="${detail.ten}">
    <br>
    Giá: <input type="text" name="gia" value="${detail.gia}">
    <br>
    Bộ nhớ: <input type="text" name="boNho" value="${detail.boNho}">
    <br>
    Màu sắc:
    <input type="radio" value="Đen" name="mauSac" checked=${detail.mauSac == 'Đen' ? 'checked' : ''}>Đen
    <input type="radio" value="Bạc" name="mauSac" ${detail.mauSac == 'Bạc' ? 'checked' : ''}>Bạc
    <br>
    Hãng:
    <select name="hang">
        <option></option>
        <c:forEach items="${hienThiHang}" var="htHang">

            <option value="${htHang}" ${htHang == detail.hang ? 'selected' : ''}>${htHang}</option>
        </c:forEach>
    </select>
    <br>
    Miêu tả: <input type="text" name="mieuTa" value="${detail.mieuTa}">
    <br>
    <button type="submit">Add</button>
</form>

<table class="table table-success table-striped">
    <thead>
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Bộ nhớ</th>
        <th>Màu sắc</th>
        <th>Hãng</th>
        <th>Miêu tả</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThi}" var="mayTinh">
        <tr>
            <td>${mayTinh.ma}</td>
            <td>${mayTinh.ten}</td>
            <td>${mayTinh.gia}</td>
            <td>${mayTinh.boNho}</td>
            <td>${mayTinh.mauSac}</td>
            <td>${mayTinh.hang}</td>
            <td>${mayTinh.mieuTa}</td>
            <td>
                <button class="btn btn-primary" ><a class="abutton" href="/may-tinh/detail?maDetail=${mayTinh.ma}">Detail</a></button>
                <button class="btn btn-success" ><a class="abutton" href="/may-tinh/delete?maDelete=${mayTinh.ma}">Delete</a></button>
                <button class="btn btn-danger" ><a class="abutton" href="/may-tinh/view-update?maUpdate=${mayTinh.ma}">Update</a></button>
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
