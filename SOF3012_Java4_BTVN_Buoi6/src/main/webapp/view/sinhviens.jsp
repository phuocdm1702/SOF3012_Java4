<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/11/2024
  Time: 10:48 CH
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

<form action="/sinh-vien/search" method="get">
    Tìm kiếm: <input type="text" name="Search">
    <br>
    <button type="submit">Search</button>
    <br>
    Lớp: <select>
    <c:forEach items="${hienThiMaLop}" var="cboMaLop">
        <option>${cboMaLop.ma}</option>
    </c:forEach>
</select>
</form>
<form action="/sinh-vien/add" method="post">
    Mã: <input type="text" name="ma" value="${hienThiDetail.ma}">
    <br>
    Tên: <input type="text" name="ten" value="${hienThiDetail.ten}">
    <br>
    Tuổi: <input type="text" name="tuoi" value="${hienThiDetail.tuoi}">
    <br>
    Địa chỉ: <input type="text" name="diaChi" value="${hienThiDetail.diaChi}">
    <br>
    Giới tính: <input type="radio" name="gioiTinh"  value="1" ${hienThiDetail.gioiTinh == 1 ? 'checked': ''}>Nam

                <input type="radio" name="gioiTinh" value="0" ${hienThiDetail.gioiTinh == 0 ? 'checked': ''}>Nữ
    <br>
    Lớp: <select name="cboLop">
    <c:forEach items="${hienThiMaLop}" var="cboMaLop">
        <option value="${cboMaLop.id}" ${hienThiDetail.lop.ma == cboMaLop.ma ? 'selected' : ''}>${cboMaLop.ma}</option>
    </c:forEach>
</select>
    <br>
    <button type="submit">Add</button>
    <br>
    <button type="submit">Top 3</button>
</form>

<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã Sinh Viên</th>
        <th scope="col">Tên Sinh Viên</th>
        <th scope="col">Tuổi</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Giới tính</th>
        <th scope="col">ID Lớp</th>
        <th scope="col">Tên lớp</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThiTable}" var="sinhVien" varStatus="stt">
        <tr>
            <td>${stt.index + 1}</td>
            <td>${sinhVien.ma}</td>
            <td>${sinhVien.ten}</td>
            <td>${sinhVien.tuoi}</td>
            <td>${sinhVien.diaChi}</td>
<%--            <td>${sinhVien.gioiTinh}</td>--%>
            <td>
                <c:choose>
                    <c:when test="${sinhVien.gioiTinh == 1}">Nam</c:when>
                    <c:otherwise>Nữ</c:otherwise>
                </c:choose>
            </td>
            <td>${sinhVien.lop.id}</td>
            <td>${sinhVien.lop.ten}</td>
            <td>
                <button><a href="/sinh-vien/detail?idDetail=${sinhVien.id}">Detail</a></button>
                <button><a href="/sinh-vien/delete?idDelete=${sinhVien.id}">Delete</a></button>
                <button><a href="/sinh-vien/view-update?idViewUpdate=${sinhVien.id}">Update</a></button>
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
