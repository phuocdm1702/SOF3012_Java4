<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/11/2024
  Time: 3:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="hienThiData()">Click me</button>

<div id="result">

<script>
    function hienThiData(){
        $.ajax({
            url:'/api/ajax/demo', //Đây là đường dẫn phía Value => Servlet
            type: 'GET',
            dataType:'json', //Kiểu dữ liệu trả về json/xml
            success: function (response){
                console.log(response)
                document.getElementById("result").innerHTML =
                    'MSSV' + response.maSSV +'Tên' + response.ten +
                    'tuổi' +response.tuoi
            },
            error: function (){
                document.getElementById("result").innerHTML =  'Lỗi'
            }
        })
    }
</script>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
</body>
</html>
