<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Show Task</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="task">
    <p>Creator: <c:out value="${task.creator.name}"/></p>
    <p>Assignee: <c:out value="${task.assignee[0].name}"/></p>
    <p>Priority: <c:out value="${task.priority}"/></p>
</div>

<c:choose>
    <c:when test="${task.creator.id == currentUser.id}">
        <a href="/edit/${task.id}">Edit</a>
        <a href="/delete/${task.id}">Delete</a>
    </c:when>
    <c:otherwise>
        <c:if test="${task.assignee[0].id == currentUser.id}">
            <a href="/delete/${task.id}">Completed</a>
        </c:if>
    </c:otherwise>
</c:choose>




</body>
</html>
