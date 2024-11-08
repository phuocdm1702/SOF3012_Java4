<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/11/2024
  Time: 5:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Mã: ${detail.ma}
<br>
Tên: ${detail.ten}
<br>
Tuổi: ${detail.tuoi}
<br>
Giới tính: ${detail.gioiTinh ? "Nam" : "Nữ"}
<br>
Địa chỉ: ${detail.diaChi}
</body>
</html>
