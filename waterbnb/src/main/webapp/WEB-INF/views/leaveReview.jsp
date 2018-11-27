<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Leave a review</title>
    <style>
        .top {
            position: absolute;
            left: 85%;
            top: 0;
        }
    </style>
</head>
<body>
<div class="top">
    <a href="/home">Home</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</div>


<div class="leaveReview">
    <h1>Review of <c:out value="${pool.address}"/></h1>
    <form:form action="/post/${pool.id}/${currentUser.id}" method="post" modelAttribute="review">
        <p>
            <form:textarea path="content" placeholder="Your review"/>
            <form:select path="rating" items="${rating}"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>