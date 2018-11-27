<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <a href="/dashboard/new">Add New</a>
    <a href="/dashboard/topTen">Top Ten</a>
    <form onsubmit="window.location = '/search/' + search.value; return false;">
        <input id="search" placeholder="Artist" type="search" name="search">
        <button type="submit">Search</button>
    </form>

    <h1>All Songs</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Artist</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td><a href="/show/${song.id}"><c:out value="${song.title}"/></a></td>
                <td><c:out value="${song.artist}"/></td>
                <td><c:out value="${song.rating}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>