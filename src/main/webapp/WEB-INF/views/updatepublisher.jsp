<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form modelAttribute="publisher" method="post">
    Name: <form:input path="name"/>
    <input type="submit">
</form:form>
<a href="/list-publisher">List Publishers</a>
</body>
</html>
