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

<div class="results">
    <h1>Search results: </h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Address</th>
            <th scope="col">Pool Size</th>
            <th scope="col">Cost per night</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${searchResult != null}">
            <c:forEach items="${searchResult}" var="pool">
                <tr>
                    <td><c:out value="${pool.address}"/></td>
                    <td><c:out value="${pool.size}"/></td>
                    <td>$<c:out value="${pool.cost}"/></td>
                    <td><a href="/show/${pool.id}"><c:out value="${pool.rating}"/> - See more</a></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>

</body>
</html>