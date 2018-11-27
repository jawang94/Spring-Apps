<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Languages Index</title>
</head>
<body>
    <h1>All Languages</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${languages}" var="langs">
            <tr>
                <td><a href="/show/${langs.id}"><c:out value="${langs.name}"/></a></td>
                <td><c:out value="${langs.creator}"/></td>
                <td><c:out value="${langs.currentVersion}"/></td>
                <td>
                    <a href="/languages/${langs.id}/edit">Edit Language</a>
                    <form action="/languages/${langs.id}" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>New Language</h1>
    <form:form action="/languages" method="post" modelAttribute="language">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator"/>
        </p>
        <p>
            <form:label path="currentVersion">Current Version</form:label>
            <form:errors path="currentVersion"/>
            <form:input type="Double" path="currentVersion"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>