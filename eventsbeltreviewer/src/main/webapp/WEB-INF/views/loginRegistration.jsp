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
<h1>Register!</h1>

<p><form:errors path="user.*"/></p>

<form:form method="POST" action="/registration" modelAttribute="user">
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:input type="firstName" path="firstName" placeholder="First Name"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName" placeholder="Last Name"/>
    </p>
    <p>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="location">Location</form:label>
        <form:input path="location" placeholder="Enter your street address"/>
        <form:select path="state" items="${states}"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
        <form:password path="passwordConfirmation"/>
    </p>
    <input type="submit" value="Register!"/>
</form:form>


<h1>Login</h1>
<p><c:out value="${error}" /></p>
<form method="post" action="/login">
    <p>
        <label type="email" for="email">Email</label>
        <input type="text" id="email" name="email"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="submit" value="Login!"/>
</form>
</body>
</html>