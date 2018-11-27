<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
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
    Welcome, <c:out value="${currentUser.firstName} ${currentUser.lastName}"/>
</h1>

<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>

<h3>Current Listings: </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Address</th>
        <th scope="col">Pool Size</th>
        <th scope="col">Cost per night</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pools}" var="pool">
        <tr>
            <td><c:out value="${pool.address}"/></td>
            <td><c:out value="${pool.size}"/></td>
            <td>$<c:out value="${pool.cost}"/></td>
            <td><a href="/edit/${pool.id}"><c:out value="${pool.rating}"/> - edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>New Listing: </h1>
<form:form method="POST" action="/create/${currentUser.id}" modelAttribute="pool">
    <p>
        <form:label path="address">Address</form:label>
        <form:input type="address" path="address" placeholder="Address of Pool"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input type="description" path="description" placeholder="Description of Pool"/>
    </p>
    <p>
        <form:label path="cost">Cost per night</form:label>
        <form:select type="Double" path="cost" items="${cost}"/>
    </p>
    <p>
        <form:label path="size">Pool Size</form:label>
        <form:select path="size" items="${size}"/>
    </p>
    <input type="submit" value="Add Pool!"/>
</form:form>
<p><form:errors path="pool.*"/></p>

</body>

</html>