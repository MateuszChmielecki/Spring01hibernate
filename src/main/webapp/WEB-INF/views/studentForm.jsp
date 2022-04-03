<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 03.04.2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="student" type="pl.coderslab.entity.Student"--%>
<form:form modelAttribute="student" method="post">
    Name <form:input path="firstName"/><br>

    Last Name <form:input path="lastName"/><br>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Country <form:select items="${countries}" path="country"/><br>
    Notes <form:textarea path="notes"/><br>
    Mailing List <form:checkbox path="mailingList"/><br>
    Programming Skils <form:select items="${skills}" path="programmingSkills" multiple="true"/><br>
    Hobbies <form:checkboxes path="hobbies" items="${hobbiesList}"/><br>
    <input type="submit">
</form:form>
</body>
</html>
