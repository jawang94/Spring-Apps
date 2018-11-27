<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>${e.name}</h1>
<form:form method="POST" action="/edit/${e.id}" modelAttribute="event">
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
    <input type="submit" value="Update Event!"/>
</form:form>
</body>
</html>