<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Song</title>
</head>
<body>
    <a href="/dashboard">Dashboard</a>
    <p>Title: <c:out value="${song.title}"/></p>
    <p>Description: <c:out value="${song.artist}"/></p>
    <p>Rating(1-10): <c:out value="${song.rating}"/></p>
    <form action="/dashboard/${song.id}" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Delete">
    </form>
</body>
</html>