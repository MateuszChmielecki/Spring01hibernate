<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%--@elvariable id="publishers" type="java.util.List<pl.coderslab.entity.Publisher>"--%>
    <c:forEach var="item" items="${publishers}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><a href="/publisher/saftydelete/${item.id}">delete</a></td>
            <td><a href="/update-publisher/${item.id}">update</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-publisher">Add Publisher</a>
</body>
</html>
