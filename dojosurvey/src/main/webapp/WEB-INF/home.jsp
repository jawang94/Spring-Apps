<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Human</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <!-- LOCAL CSS -->
    <style type="text/css">
        <%@include file="css/home.css" %>
    </style>
</head>
<body>
<div id="survey">
    <form action="/submit" method="POST">
        <div class="form-group">
            <label for="exampleFormControlInput1">Your Name:</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="John Wick" name="name">
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Dojo Location:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="location">
                <option>Seattle</option>
                <option>Silicon Valley</option>
                <option>Burbank</option>
                <option>East Bay</option>
                <option>Chicago</option>
                <option>Tysons Corner</option>
                <option>Dallas</option>
                <option>Tulsa</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Favorite Language:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="language">
                <option>Python</option>
                <option>Javascript</option>
                <option>Java/C#</option>
                <option>Ruby</option>
                <option>PHP</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Comment (optional):</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>