<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login And Registration Page</title>
    <style>
        body {
            background: azure;
        }
        #title {
            text-align: center;
        }
        #register {
            display: inline-block;
            position: absolute;
            left: 5%;
            border: 3px solid black;
            padding: 3%;
            background: beige;
        }
        #login {
            display: inline-block;
            position: absolute;
            right: 10%;
            border: 3px solid black;
            padding: 3%;
            background: beige;
        }
    </style>
</head>


<body>
<div id="title">
    <h1>Welcome to WaterBnB</h1>
</div>

<div id="register">
    <h1>Register!</h1>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <p>
            <form:select type="Role" path="roles" items="${roles}" itemLabel="name"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
    <p><form:errors path="user.*"/></p>
</div>

<div id="login">
    <h1>Login</h1>

    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="pw">Password</label>
            <input type="password" id="pw" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>

    <c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>

</div>
</body>

</html>