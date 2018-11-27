<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Show Language</title>
</head>
<body>
    <a href="/languages">Dashboard</a>
    <h1><c:out value="${language.name}"/></h1>
    <p>Description: <c:out value="${language.creator}"/></p>
    <p>Language: <c:out value="${language.currentVersion}"/></p>
    <a href="/languages/${language.id}/edit">Edit Language</a>
    <form action="/languages/${language.id}" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Delete">
    </form>
</body>
</html>