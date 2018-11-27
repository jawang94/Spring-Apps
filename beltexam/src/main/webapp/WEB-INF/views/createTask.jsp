<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
</head>
<body>

<h1>Create a new task: </h1>
<form:form method="POST" action="/create/${currentUser.id}" modelAttribute="task">
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description" placeholder="Description of Task"/>
    </p>
    <ul>
        <form:label path="assignee">Assignee</form:label>
        <form:select path="assignee" items="${users}" itemLabel="name"/>
    </ul>
    <ul>
        <form:label path="priority">Priority</form:label>
        <form:select path="priority" items="${priority}"/>
    </ul>
    <input type="submit" value="Create"/>
</form:form>
<c:if test="${error != null}">
    <p>${error}</p>
</c:if>
<p><form:errors path="task.*"/></p>

</body>
</html>