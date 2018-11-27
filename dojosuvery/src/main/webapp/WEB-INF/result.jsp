<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <!-- LOCAL CSS -->
    <style type="text/css">
        <%@include file="css/result.css" %>
    </style>
</head>
    <%--<h1>Submitted Info</h1>--%>
    <%--<label>Name: ${name}</label>--%>
    <%--<label>Location: ${location}</label>--%>
    <%--<label>Language: ${language}</label>--%>
    <%--<label>Comment: ${comment}</label>--%>

<body>
<div id="result">
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Language</th>
            <th scope="col">Comment</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${name}</td>
            <td>${location}</td>
            <td>${language}</td>
            <td>${comment}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>