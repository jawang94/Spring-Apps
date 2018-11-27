<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Human</title>
</head>
<body>
    <h2>Welcome <c:out value="${first_name}"/> <c:out value="${last_name}"/>!</h2>
    <h3>Welcome to SpringBoot!</h3>
</body>
</html>