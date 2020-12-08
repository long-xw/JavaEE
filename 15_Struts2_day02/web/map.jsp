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
    <form action="${pageContext.request.contextPath}/map.action" method="post">
        <%-- 设置key的值 map['key值']
            设置value值
        --%>
        username:<input type="text" name="map['one'].username">
        <br/>
        password:<input type="text" name="map['one'].password">
        <br/>
        address:<input type="text" name="map['one'].address">
        <br/>
        <br/>
        username:<input type="text" name="map['abce'].username">
        <br/>
        password:<input type="text" name="map['abce'].password">
        <br/>
        address:<input type="text" name="map['abce'].address">
        <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
