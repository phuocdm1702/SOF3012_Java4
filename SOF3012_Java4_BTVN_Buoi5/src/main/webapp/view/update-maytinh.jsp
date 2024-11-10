<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/11/2024
  Time: 11:22 CH
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
<form action="/may-tinh/update?idUpdate=${detailUpdate.ma}" method="post" class="form">
    Tên: <input type="text" value="${detailUpdate.ten}" name="ten">
    <br>
    Giá: <input type="text" value="${detailUpdate.gia}" name="gia">
    <br>
    Bộ nhớ <input type="text" value="${detailUpdate.boNho}" name="boNho">
    <br>
    Màu sắc:
    <input type="radio" value="Đen" name="mauSac" checked=${detailUpdate.mauSac == 'Đen' ? 'checked' : ''}>Đen
    <input type="radio" value="Bạc" name="mauSac" ${detailUpdate.mauSac == 'Bạc' ? 'checked' : ''}>Bạc
    <br>
    Hãng: <select name="hang">
    <option></option>
    <c:forEach items="${hienThiHang}" var="htHang">
        <option value="${htHang}" ${htHang == detailUpdate.hang ? 'selected' : ''}>${htHang}</option>
    </c:forEach>
</select>
    <br>
    Mô tả: <input type="text" value="${detailUpdate.mieuTa}" name="moTa">
    <br>
    <button type="submit">Update</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
