<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@include file="css/home.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/home.js"></script>

<body>
    <form action="/date">
        <div class="button">
            <button type="submit" onclick="return confirm('Are you sure you want to view the date?')" >Date Template</button>
        </div>
    </form>

    <form action="/time">
        <div class="button">
            <button type="submit" onclick="return confirm('Are you sure you want to view the time?')" >Time Template</button>
        </div>
    </form>

</body>
</html>