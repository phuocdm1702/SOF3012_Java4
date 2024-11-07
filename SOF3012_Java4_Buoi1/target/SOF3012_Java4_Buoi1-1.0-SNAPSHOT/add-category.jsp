<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="/category/add" method="post">
      Cate code: <input type="text" name="categoryCode" />
      <br />
      Cate name: <input type="text" name="categoryName" />
      <br />
      <button type="submit">Add</button>
    </form>
  </body>
</html>
