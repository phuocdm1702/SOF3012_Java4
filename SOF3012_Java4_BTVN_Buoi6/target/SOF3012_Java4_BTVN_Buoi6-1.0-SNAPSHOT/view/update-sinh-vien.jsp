<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/11/2024
  Time: 12:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/sinh-vien/update?idUpdate=${viewUpdate.id}" method="post">
        Mã: <input type="text" name="ma" value="${viewUpdate.ma}">
        <br>
        Tên: <input type="text" name="ten" value="${viewUpdate.ten}">
        <br>
        Tuổi: <input type="text" name="tuoi" value="${viewUpdate.tuoi}">
        <br>
        Địa chỉ: <input type="text" name="diaChi" value="${viewUpdate.diaChi}">
        <br>
        Giới tính: <input type="radio" name="gioiTinh" value="Nam" ${viewUpdate.gioiTinh == 'Nam' ? 'checked' : ''}  >Nam

                    <input type="radio" name="gioiTinh" value="Nu" ${viewUpdate.gioiTinh == 'Nu' ? 'checked' : ''}>Nữ
        <br>
        Lớp: <select name="cboLop">
        <c:forEach items="${hienThiMaLop}" var="cboMaLop">
            <option value="${cboMaLop.id}" ${cboMaLop.id == viewUpdate.lop.id ? 'selected' : ''}>${cboMaLop.ten}</option>
        </c:forEach>
    </select>
        <br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
