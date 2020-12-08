<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/12/6
  Time: 下午 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--    使用struts2标签查看值栈结构--%>
    <s:debug></s:debug>
        <%-- 1.先获取字符串的值--%>
        <%--    <s:property value="username"></s:property>--%>

        <%-- 2.获取值栈对象的值--%>
        获取对象的值
        <br>
        <s:property value="user.username"></s:property>
        <s:property value="user.password"></s:property>
        <s:property value="user.address"></s:property>
    <%--3.获取值栈list集合的数据--%>
    <%--第一种方式实现--%>
    获取的list的值第一种方式
    <br/>
    <s:property value="list[0].username"></s:property>
    <s:property value="list[0].password"></s:property>
    <s:property value="list[0].address"></s:property>
    <br/>
    <s:property value="list[1].username"></s:property>
    <s:property value="list[1].password"></s:property>
    <s:property value="list[1].address"></s:property>

    <br/>[-
    获取的list的值第二种方式
    <br/>
    <%-- 使用struts2标签类死于jstl里面的foreach标签
        <s:iterator/> :遍历值栈中的list集合
    --%>
    <s:iterator value="list">
        <%-- 遍历list得到list里面每个user对象--%>
        <s:property value="username"/>
        <s:property value="password"/>
        <s:property value="address"/>
        <br/>
    </s:iterator>
    <br/>
    <br/>
    获取list的值第三种方式：
    <br/>
    <s:iterator value="list" var="user">
        <%--
            遍历值栈；list集合，得到每个user对象
             机制：把每次遍历出来的user对象放到context里面
             获取context里面数据特点，写ognl表达式
             使用特殊符号#
        --%>
        <s:property value="#user.username"/>
        <s:property value="#user.password"/>
        <s:property value="#user.address"/>
        <br/>
    </s:iterator>

<br/>
    <%--使用foreach标签+el表达式获取值栈list集合数据--%>
    <c:forEach items="${list}" var="user">
        ${user.username}
        ${user.password}
        ${user.address}
        <br/>
    </c:forEach>

<br/>
<%--获取set方法设置的值  根据名称获取值--%>
<%--<s:property value="bigjava"></s:property>--%>

<br/>
<%--获取push方法设置的值--%>
<%--<s:property value="[0].top"></s:property>--%>
</body>
</html>
