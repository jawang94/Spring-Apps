<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Top Ten Songs</title>
</head>
<body>
    <a href="/dashboard">Dashboard</a>
    <h1>Top Ten Songs</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Artist</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${topTen}" var="song">
            <tr>
                <td><c:out value="${song.title}"/></td>
                <td><c:out value="${song.artist}"/></td>
                <td><c:out value="${song.rating}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>