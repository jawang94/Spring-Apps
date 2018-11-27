<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Counter</title>
</head>
<body>
    <h1>You have visited your server:</h1>
    <h1>${count} times</h1>
    <button onclick="window.location.href='/wang_server'">Click to add more views</button>
</body>
</html>