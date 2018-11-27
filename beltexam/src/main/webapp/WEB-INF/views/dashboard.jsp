<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style>
    body {
        margin: 1%;
    }
    .logout {
        position: absolute;
        left: 90%;
    }
</style>
<body>

<h1>
    Welcome, <c:out value="${currentUser.name}"/>
</h1>

<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>

<a href="/home/desc">Priority High - Low</a>
<a href="/home/asc">Priority Low - High</a>

<h3>Current Tasks: </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Task</th>
        <th scope="col">Creator</th>
        <th scope="col">Assignee</th>
        <th scope="col">Priority</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td><a href="/task/${task.id}"><c:out value="${task.description}"/></a></td>
            <td><c:out value="${task.creator.name}"/></td>
            <td><c:out value="${task.assignee[0].name}"/></td>
            <td><c:out value="${task.priority}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/tasks/new">Create Task</a>

</body>

</html>