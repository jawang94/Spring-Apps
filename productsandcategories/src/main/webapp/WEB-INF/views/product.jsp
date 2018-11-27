<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Product</title>
</head>
<body>
<h1>${p.name}</h1>

<form:form action="/products/${p.id}/add" method="post" modelAttribute="product">
    <p>
        <form:label path="categories">Category</form:label>
        <form:errors path="categories"/>
        <form:select path="categories" type="Category" items = "${allCategories}" itemLabel="name" />
    </p>
    <input type="submit" value="Submit"/>
</form:form>

<table>
    <thead>
    <tr>
        <th>Categories</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${thisCategories}" var="category">
        <tr>
            <td><c:out value="${category.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>