<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<style>
    body {
        margin: 1%;
    }
    .attendees {
        width: 30%;
        display: inline-block;
    }
    .messages {
        width: 40%;
        display: inline-block;
    }
</style>
<body>
<div>
    <h1><c:out value="${event.name}"/></h1>
    <p>Host: <c:out value="${event.hostName}"/></p>
    <p>Date: <c:out value="${event.date}"/></p>
    <p>Location: <c:out value="${event.location} ${event.state}"/></p>
    <p>People who are attending this event: ${numberOfAttendees}</p>
</div>

<h3>Event Attendees: </h3>
<div class="attendees">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${event.users}" var="user">
            <tr>
                <td><c:out value="${user.firstName} ${user.lastName}"/></td>
                <td><c:out value="${user.location}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<h3>Message Wall: </h3>
<div class="messages">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Poster</th>
            <th scope="col">Message</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td><c:out value="${message.user.firstName} ${message.user.lastName}"/></td>
                <td><c:out value="${message.content}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <form:form action="/post/${event.id}/${user.id}" method="post" modelAttribute="message">
        <p>
            <form:label path="content">Add Comment</form:label>
            <form:input path="content" placeholder="Your comment"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</div>



</body>
</html>