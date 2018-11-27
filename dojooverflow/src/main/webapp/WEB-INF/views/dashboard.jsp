<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Questions</th>
        <th>Tags</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="question">
        <tr>
            <td><a href="/questions/${question.id}"><c:out value="${question.text}"/></a></td>
            <c:forEach items="${question.tags}" var="tag">
                <td><c:out value="${tag.subject}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/questions/new">New Question</a>
</body>
</html>