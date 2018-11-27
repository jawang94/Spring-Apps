<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>${dorm.name}</h1>

<form:form action="/students/${dorm.id}" method="post" modelAttribute="student">
    <p>
        <form:label path="student">Student</form:label>
        <form:errors path="student"/>
        <form:select path="student" type="Student" items = "${studentServiceAll}" itemLabel="fullName" />
    </p>
    <input type="submit" value="Submit"/>
</form:form>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.fullName}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
