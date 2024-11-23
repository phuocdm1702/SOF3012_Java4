<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23/11/2024
  Time: 12:16 CH
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
<form action="/nhom-datn/add" method="post">
    Ma: <input type="text" value="${detail.maNhom}" name="maNhom">
    <br>
    Tên Đề tài: <input type="text" value="${detail.tenDeTai}" name="tenDeTai">
    <br>
    Lĩnh vưc: <input type="text" value="${detail.linhVuc}" name="linhVuc">
    <br>
    Mã GVHD:
    <select name="cbbGVHD">
        <c:forEach items="${hienThiCbb}" var="cbb">
            <option value="${cbb.id}" ${detail.gvhd.maGVHD == cbb.maGVHD ? 'selected' : ''}>${cbb.maGVHD}</option>
        </c:forEach>
    </select>
    <br>
    <button>Add</button>
</form>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma Nhóm</th>
        <th>Tên Đề Tài</th>
        <th>Lĩnh Vực</th>
        <th>GVHD ID</th>
        <th>Mã GVHD</th>
        <th>Tên GVHD</th>
        <th>Tên Khoa</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThi}" var="nhomDATN">
        <tr>
            <td>${nhomDATN.id}</td>
            <td>${nhomDATN.maNhom}</td>
            <td>${nhomDATN.tenDeTai}</td>
            <td>${nhomDATN.linhVuc}</td>
            <td>${nhomDATN.gvhd.id}</td>
            <td>${nhomDATN.gvhd.maGVHD}</td>
            <td>${nhomDATN.gvhd.tenGVHD}</td>
            <td>${nhomDATN.gvhd.khoa}</td>
            <td>
                <button><a href="/nhom-datn/detail?idDetail=${nhomDATN.id}">Detail</a></button>
                <button><a href="/nhom-datn/view-update?idViewUpdate=${nhomDATN.id}">Update</a></button>
                <button><a href="/nhom-datn/delete?idDelete=${nhomDATN.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div aria-label="Page navigation">
    <ul class="pagination justify-content-center mt-4">
        <c:forEach begin="1" end="${tongTrang}" var="i">
            <li class="page-item" ${i == hienThiTrang ? 'active' : ''}>
                <a class="page-link" href="/nhom-datn/hien-thi?page=${i}">${i}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
