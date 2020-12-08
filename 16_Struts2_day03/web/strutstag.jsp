<%--
  Created by IntelliJ IDEA.
  User: LXW
  Date: 2020/12/7
  Time: 上午 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form>
        <%-- 1.普通输入项--%>
        <s:textfield name="username" label="username"></s:textfield>
        <%-- 2.密码输入项--%>
        <s:password name="password" label="password"></s:password>
        <%--3.单选输入项--%>
        <%-- value属性值和显数值一样的--%>
        <s:radio list="{'男','女'}" name="sex" label="性别"></s:radio>

        <%-- value属性值和显数值不一样的--%>
        <s:radio list="#{'nv':'女','nan':'男'}" name="sex1" label="性别"></s:radio>

        <%-- 4.复选输入项--%>
        <s:checkboxlist list="{'吃饭','睡觉','敲代码'}" name="love" label="爱好"></s:checkboxlist>

        <%-- 5.下拉输入框--%>
        <s:select list="{'幼儿园','小学','初中','高中','大学'}" name="college" label="学历"></s:select>

        <%-- 6.文件上传项--%>
        <s:file name="file" label="上传文件"></s:file>

        <%--7. 隐藏项--%>
        <s:hidden value="abcd" name="hid"></s:hidden>

        <%-- 8.文本域--%>
        <s:textarea rows="10" cols="3" name="resume" label="简历"></s:textarea>

        <%-- 9.提交按钮--%>
        <s:submit value="提交" ></s:submit>

        <%-- 10
        .重置按钮--%>
        <s:reset value="重置"></s:reset>

    </s:form>

</body>
</html>
