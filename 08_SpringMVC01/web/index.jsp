<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/12/7
  Time: 上午 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="hello">HELLO</a>
  <%-- SpringMVC如何给页面携带数据过来--%><br/>
  <a href="handle01">handle01</a><br/>
  <a href="handle02">handle02</a><br/>
  <a href="handle03">handle03</a><br/>
  <a href="handle04">handle04</a><br/>

  <h1>修改图书 不能修改书名：</h1>
  <form action="updateBook" method="post">
    <input type="hidden" name="id" value="100">
    书名，西游记 <br/>
    作者:<input type="text" name="author"/><br/>
    价格:<input type="text" name="price"><br/>
    库存:<input type="text" name="stock"><br/>
    销量:<input type="text" name="sales"><br/>
    <input type="submit" name="修改图书"/>
  </form>

  </body>
</html>
