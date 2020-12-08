<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/11/26
  Time: 上午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  以前配置一个servlet，这个servlet配置一个url-patter(/hello)--%>
  <a href="hello">你好</a>
  <h1>RequestMapping测试</h1>
  <a href="handle01"> test01 写在方法上的requestMapping</a>
<br/>
  <a href="haha/handle01"> test01 写在方法上的RequestMapping</a>
  <h1>测试RequestMapping的属性</h1>
  <a href="haha/handle02">handle02</a>
  <form action="haha/handle02" method="post">
    <input type="submit" />
  </form>
  <a href="haha/handle03">handle03-测试params属性</a>
  <a href="haha/handle04">handle04测试headers</a>
  <hr/>
  <h1>RequestMapping-Ant风格的URL</h1>
  <a href="antTest01">精确请求</a>
<br/>
  <a href="user/admin">测试pathVariable</a>
  <hr/>
  <hr/>

<%-- 发起图书的增删改查请求，使用Rest风格的URL地址
 请求URL    请求方式   表示含义
 /book/1   GET,      查询1号图书
 /book/1   DELETE,   删除1号图书
 /book/1   PUT,      更新1号图书
 /book/1   POST,     添加1号图书


 从页面发起PUT,DELETE形式的请求? SPring提供了对Rest风格的支持
 1）。SpringMVC中有一个Filter，它可以把普通的请求转化为规定形式的请求，配置这个Filter;
     <filter>
     <filter-name>HiddenHttpMethodFilter</filter-name>
     <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
     </filter>
     <filter-mapping>
         <filter-name>HiddenHttpMethodFilter</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>
 2）。如何发其他形式的请求？
       按照以下要求，
         1.创建一个post类型的表单
         2.表单项中携带一个_method的参数
         3.这个_method的值就是DELETE,PUT
 --%>
<a href="book/1">查询图书</a><br/>
<form action="book" method="post">
  <input type="submit" value="添加1号图书">
</form><br/>
<%-- 发送DELETE请求 --%>
<form action="book/1" method="post">
  <input name="_method" value="delete"/>
  <input type="submit" value="删除1号图书">
</form><br/>
<%-- 发送PUT请求--%>
<form action="book/1" method="post">
  <input name="_method" value="put"/>
  <input type="submit" value="更新1号图书">
</form><br/>
<br/>
<a href="hello">hello</a>
<br/>
<a href="handle01?username=tomcat"> handle01</a>

<form action="book1" method="post">
  书名:<input type="text" name="bookName"><br/>
  作者:<input type="text" name="author"><br/>
  价格:<input type="text" name="price"><br/>
  库存:<input type="text" name="stock"><br/>
  销量:<input type="text" name="sales"><br/>
  <hr/>
  省:<input type="text" name="address.province">
  市:<input type="text" name="address.city">
  街道:<input type="text" name="address.street"><br/>
  <input type="submit">
</form>




  </body>
</html>
