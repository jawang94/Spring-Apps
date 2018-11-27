<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1><c:out value="${person.firstName} ${person.lastName}"/></h1>
    <p>License Number: <c:out value="${license.number}"/></p>
    <p>State: <c:out value="${license.state}"/></p>
    <p>Expiration Date: <c:out value="${license.expiration_date}"/></p>

</body>
</html>