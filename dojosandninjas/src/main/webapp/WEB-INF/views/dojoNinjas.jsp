<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Ninjas for Dojo</title>
</head>
<body>
    <h1>${dojoName}</h1>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ninjas}" var="ninja">
            <tr>
                <td><c:out value="${ninja.firstName}"/></td>
                <td><c:out value="${ninja.lastName}"/></td>
                <td><c:out value="${ninja.age}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>