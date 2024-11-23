<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Chi Tiết Sản Phẩm</title>
</head>
<button><a href="/dang-xuat">Đăng xuất</a></button>
<body class="container mt-5">
<span>${{success}}</span>
<form action="/chi-tiet-san-pham/add" method="post" class="mb-4">
    <div class="mb-3">
        <label for="cbbTenDVT" class="form-label">Tên Đơn Vị Tính:</label>
        <select name="cbbTenDVT" id="cbbTenDVT" class="form-select">
            <c:forEach items="${hienThiCBB}" var="cbb">
                <option value="${cbb.id}">${cbb.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label for="soLuongTon" class="form-label">Số Lượng Tồn:</label>
        <input type="text" name="soLuongTon" id="soLuongTon" class="form-control">
    </div>

    <div class="mb-3">
        <label for="donGia" class="form-label">Đơn Giá:</label>
        <input type="text" name="donGia" id="donGia" class="form-control">
    </div>

    <div class="mb-3">
        <label for="ghiChu" class="form-label">Ghi Chú:</label>
        <input type="text" name="ghiChu" id="ghiChu" class="form-control">
    </div>

    <button type="submit" class="btn btn-primary">Add</button>
</form>

<table class="table table-bordered">
    <thead class="table-dark">
    <tr>
        <th>ID CTSP</th>
        <th>Mã Đơn Vị Tính</th>
        <th>Số Lượng Tồn</th>
        <th>Đơn Giá</th>
        <th>Ghi Chú</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienThi}" var="ctsp">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ctsp.donViTinh.id}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.donGia}</td>
            <td>${ctsp.ghiChu}</td>
            <td>
                <a href="/chi-tiet-san-pham/delete?idDelete=${ctsp.id}" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center mt-4">
        <c:forEach var="i" begin="1" end="${totalPages}">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
                <a class="page-link" href="/chi-tiet-san-pham/hien-thi?page=${i}">${i}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
