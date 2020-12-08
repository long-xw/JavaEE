<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/12/7
  Time: 下午 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>SUCCESS</h1>
pageContext:${pageScope.msg}<br/>
request:${requestScope.msg}<br/>
session:${sessionScope.msg}----${sessionScope.haha}<br/>
application:${applicationScope.msg}<br/>
</body>
</html>
