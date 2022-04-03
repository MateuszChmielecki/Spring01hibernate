<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<%--@elvariable id="authors" type="java.util.List<pl.coderslab.entity.Author>"--%>
<c:forEach var="item" items="${authors}">
    <tr>
        <td>${item.id}</td>
        <td>${item.firstName}</td>
        <td>${item.lastName}</td>
        <td><a href="/author/saftydelete/${item.id}">delete</a></td>
        <td><a href="/update-author/${item.id}">update</a></td>
    </tr>
</c:forEach>
</table>
<a href="/add-author">Add Author</a>
</body>
</html>
