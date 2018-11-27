<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html>
<head>
    <meta charset="UTF-8">
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

<h1>Welcome, <c:out value="${user.firstName} ${user.lastName}" /> <a href="/logout" class="logout">Logout</a></h1>

<h3>Here are some events in your state: </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Date</th>
        <th scope="col">Location</th>
        <th scope="col">Host</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${inStateEvents}" var="event">
        <tr>
            <td><a href="/event/${event.id}/${user.id}"><c:out value="${event.name}"/></a></td>
            <td><c:out value="${event.date}"/></td>
            <td><c:out value="${event.location} ${event.state}"/></td>
            <td><c:out value="${event.hostName}"/></td>
            <c:choose>
                <c:when test="${event.hostId == user.id}">
                    <td><a href="/edit/${event.id}">Edit</a> <a href="/cancel/${event.id}">Cancel</a></td>
                </c:when>
                <c:otherwise>
                    <c:when test="${not fn:contains(event.users, user)}">
                        <td><p>Joined</p></td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/join/${event.id}/${user.id}">Join</a></td>
                    </c:otherwise>
                </c:otherwise>
            </c:choose>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h3>Here are some events in other states: </h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Date</th>
        <th scope="col">Location</th>
        <th scope="col">Host</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${outOfStateEvents}" var="event">
        <tr>
            <td><a href="/event/${event.id}/${user.id}"><c:out value="${event.name}"/></a></td>
            <td><c:out value="${event.date}"/></td>
            <td><c:out value="${event.location} ${event.state}"/></td>
            <td><c:out value="${event.hostName}"/></td>
            <c:choose>
                <c:when test="${event.hostId == user.id}">
                    <td><a href="/edit/${event.id}">Edit</a> <a href="/cancel/${event.id}">Cancel</a></td>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${not fn:contains(event.users, user)}">
                            <td><p>Joined</p></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="/join/${event.id}/${user.id}">Join</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form:form method="POST" action="/create/${user.id}" modelAttribute="event">
    <p>
        <form:label path="name">Name</form:label>
        <form:input type="name" path="name" placeholder="Name of Event"/>
    </p>
    <p>
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:input type="Date" path="date" placeholder="mm/dd/yyyy"/>
    </p>
    <p>
        <form:label path="location">Location</form:label>
        <form:input path="location" placeholder="Enter your street address"/>
        <form:select path="state" items="${states}"/>
    </p>
    <input type="submit" value="Add Event!"/>
</form:form>
</body>

</html>