<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Category</title>
</head>
<body>
<h1>${c.name}</h1>

<form:form action="/categories/${c.id}/add" method="post" modelAttribute="category">
    <p>
        <form:label path="products">Product</form:label>
        <form:errors path="products"/>
        <form:select path="products" type="Product" items = "${allProducts}" itemLabel="name" />
    </p>
    <input type="submit" value="Submit"/>
</form:form>

<table>
    <thead>
    <tr>
        <th>Products</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${thisProducts}" var="product">
        <tr>
            <td><c:out value="${product.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>