<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>${q.text}</h1>
<h2>Tags:
<c:forEach items="${q.tags}" var="tag">
    ${tag.subject},
</c:forEach>
</h2>

<form:form action="/questions/${q.id}/add" method="post" modelAttribute="answer">
    <p>
        <form:label path="content">Answer</form:label>
        <form:errors path="content"/>
        <form:input path="content"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

<table>
    <thead>
    <tr>
        <th>Answers</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${thisAnswers}" var="answer">
        <tr>
            <td><c:out value="${answer.content}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>