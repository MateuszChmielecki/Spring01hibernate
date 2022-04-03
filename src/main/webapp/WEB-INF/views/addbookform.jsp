<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
<form:form modelAttribute="book" method="post">
    Title: <form:input path="title"/><br>
    Rating: <form:input path="rating"/><br>
    Description: <form:textarea path="description"/><br>
    <form:select path="publisher.id" items="${publisher}" itemLabel="name" itemValue="id"/><br>
    <form:select path="authors" items="${authors}" itemLabel="firstName" itemValue="id" multiple="true"/><br>
    <input type="submit">
</form:form>
</body>
</html>
