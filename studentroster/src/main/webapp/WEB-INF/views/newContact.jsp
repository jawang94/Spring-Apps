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
<h1>Contact Info</h1>
    <form:form action="/contacts/new" method="post" modelAttribute="contact">
        <p>
            <form:label path="student">Student</form:label>
            <form:errors path="student"/>
            <form:select type="Student" path="student" items="${students}" itemLabel="fullName"/>

        </p>
        <p>
            <form:label path="address">Address</form:label>
            <form:errors path="address"/>
            <form:input path="address" placeholder="Address"/>
        </p>
        <p>
            <form:label path="city">City</form:label>
            <form:errors path="city"/>
            <form:input path="city" placeholder="City"/>
        </p>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input path="state" placeholder="State"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>