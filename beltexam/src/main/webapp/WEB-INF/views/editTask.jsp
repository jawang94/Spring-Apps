<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
</head>
<body>

<h1>Edit ${t.description}: </h1>
<form:form method="POST" action="/edit/${t.id}" modelAttribute="task">
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description" placeholder="${t.description}"/>
    </p>
    <ul>
        <form:label path="assignee">Assignee</form:label>
        <form:select path="assignee" cssClass="select">
            <form:option value="${t.assignee[0]}" label="${t.assignee[0].name}"/>
            <form:options items="${users}" itemLabel="name"/>
        </form:select>
    </ul>
    <ul>
        <form:label path="priority">Priority</form:label>
        <form:select path="priority">
            <form:option value="${t.priority}"/>
            <form:options items="${priority}"/>
        </form:select>
    </ul>
    <input type="submit" value="Edit"/>
</form:form>
<p><form:errors path="task.*"/></p>

</body>
</html>