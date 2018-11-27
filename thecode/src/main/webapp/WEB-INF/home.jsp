<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Human</title>
</head>
<body>
    <h1>What is the code</h1>
    <form method="post" action="/guess">
        <label>Code: <input type="text" name="code"></label>
        <button type="submit">Submit</button>
    </form>
    <h3>${error}</h3>
</body>
</html>