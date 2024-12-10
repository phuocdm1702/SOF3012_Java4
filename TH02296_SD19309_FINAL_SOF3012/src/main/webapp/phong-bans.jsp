<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/12/2024
  Time: 2:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${sessionScope.us}</p>
<h1 style="text-align: center">Quản Lý Phòng Ban</h1>
<div class="container">
    <form action="/phong-ban/update?idUpdate=${detail.id}" method="post">
        <div class="mb-3">
            ID: <input type="text" name="id" value="${detail.id}" class="form-control">
        </div>
        <br>
        <div class="mb-3">
            Mã: <input type="text" name="ma" value="${detail.ma}" class="form-control">
        </div>
        <br>
        <div class="mb-3">
            Tên: <input type="text" name="ten" value="${detail.ten}" class="form-control">
        </div>
        <br>
        <div class="mb-3">
            Số lượng: <input type="text" name="soLuong" value="${detail.soLuong}" class="form-control">
        </div>
        <br>
        <div class="mb-3">
            Mã loại phòng ban:
            <select name="cbbMaLPB" class="form-select">
                <c:forEach items="${hienThiCbb}" var="cbb">
                    <option value="${cbb.id}" ${cbb.id == detail.lpb.id ? 'selected' : ''}>${cbb.ma}</option>
                </c:forEach>
            </select>
        </div>

        <br>
        <button onclick="return confirm('Bạn có muốn Update không?')">update</button>
    </form>
</div>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã phòng ban</th>
        <th>Tên phòng ban</th>
        <th>Số lượng</th>
        <th>Mã loại phòng ban</th>
        <th>Tên loại phòng ban</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThi}" var="pb">
        <tr>
            <td>${pb.id}</td>
            <td>${pb.ma}</td>
            <td>${pb.ten}</td>
            <td>${pb.soLuong}</td>
            <td>${pb.lpb.ma}</td>
            <td>${pb.lpb.ten}</td>
            <td>
                <button onclick="return confirm('Bạn có muốn Detail không?')"><a
                        href="/phong-ban/detail?idDetail=${pb.id}">Detail</a></button>
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
