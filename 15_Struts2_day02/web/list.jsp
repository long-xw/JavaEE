<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/12/3
  Time: 上午 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/list.action" method="post">
        username:<input type="text" name="list[0].username">
        <br/>
        password:<input type="text" name="list[0].password">
        <br/>
        address:<input type="text" name="list[0].address">
        <br/>
        <br/>
        username:<input type="text" name="list[1].username">
        <br/>
        password:<input type="text" name="list[1].password">
        <br/>
        address:<input type="text" name="list[1].address">
        <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
