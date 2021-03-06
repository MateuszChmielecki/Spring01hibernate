<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="books" type="java.util.List<pl.coderslab.entity.Book>"--%>
<table>
<c:forEach var="item" items="${books}">
    <tr>
        <td>${item.id}</td>
        <td>${item.title}</td>
        <td>${item.rating}</td>
        <td>${item.description}</td>
        <td>${item.publisher.name}</td>
        <c:forEach var="author" items="${item.authors}">
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
        </c:forEach>
        <td><a href="/book/saftydelete/${item.id}">delete</a></td>
        <td><a href="/update-book/${item.id}">update</a></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
