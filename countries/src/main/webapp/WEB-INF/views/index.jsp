<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<table class="table">
    <thead>
    <th>Country name</th>
    <th>Language</th>
    <th>Percentage</th>
    </thead>
    <tbody>
    <c:forEach var="row" items="${table}">
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>