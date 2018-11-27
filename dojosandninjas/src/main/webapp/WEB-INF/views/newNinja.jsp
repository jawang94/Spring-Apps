<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Create a Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <p>
            <form:label path="dojo">Dojo</form:label>
            <form:errors path="dojo"/>
            <form:select type="Dojo" path="dojo" items="${dojos}" itemLabel="name"/>

        </p>
        <p>
            <form:label path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName" placeholder="First Name"/>
        </p>
        <p>
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName" placeholder="Last Name"/>
        </p>
        <p>
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input type="int" path="age" placeholder="Age"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>