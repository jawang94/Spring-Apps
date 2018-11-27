<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>

<body>

<div class="top">
    <c:choose>
        <c:when test="${currentUser != null}">
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout!" />
            </form>
        </c:when>
        <c:otherwise>
            <a href="/home">Home</a>
            <a href="/registration">Signup - Signin</a>
        </c:otherwise>
    </c:choose>
</div>


<div class="search">
    <h1>Find your pool!</h1>
    <form onsubmit="window.location = '/search/' + search.value; return false;">
        <input id="search" placeholder="Location" type="String" name="search">
        <button type="submit">Search</button>
    </form>
</div>

</body>
</html>