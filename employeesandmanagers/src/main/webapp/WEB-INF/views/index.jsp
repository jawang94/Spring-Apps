<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>Manager: ${manager.fullName}</h1>
<table class="table">
    <thead>
    <th>Employees</th>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.fullName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>