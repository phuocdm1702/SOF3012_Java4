<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23/11/2024
  Time: 1:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/nhom-datn/update?idUpdate=${viewUpdate.id}" method="post">
    Ma: <input type="text" value="${viewUpdate.maNhom}" name="maNhom">
    <br>
    Tên Đề tài: <input type="text" value="${viewUpdate.tenDeTai}" name="tenDeTai">
    <br>
    Lĩnh vưc: <input type="text" value="${viewUpdate.linhVuc}" name="linhVuc">
    <br>
    Mã GVHD:
    <select name="cbbGVHD">
        <c:forEach items="${hienThiCbb}" var="cbb">
            <option value="${cbb.id}" ${cbb.id == viewUpdate.gvhd.id  ? 'selected' : ''}>${cbb.maGVHD}</option>
        </c:forEach>
    </select>
    <br>
    <button>update</button>
</form>
</body>
</html>
