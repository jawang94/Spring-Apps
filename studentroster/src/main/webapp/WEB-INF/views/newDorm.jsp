<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>New Dorm</title>
</head>
<body>
    <h1>New Dorm</h1>
    <form:form action="/dorms/new" method="post" modelAttribute="dorm">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>