<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Spring</title>
    <style type="text/css">
        <%@include file="css/home.css" %>
    </style>
</head>
<body>
<div id="wrapper">
    <div id="top">
        <h3>Your gold:</h3>
        <p>${total}</p>
    </div>
    <div id="menu">
        <div class="option">
            <h1>Farm</h1>
            <h2>(earns 10-20 golds)</h2>
            <form action="/process_gold" method="post">
                <input type="hidden" name="building" value="farm" />
                <input type="submit" value="Find Gold!" class="submit"/>
            </form>
        </div>
        <div class="option">
            <h1>Cave</h1>
            <h2>(earns 5-10 golds)</h2>
            <form action="/process_gold" method="post">
                <input type="hidden" name="building" value="cave" />
                <input type="submit" value="Find Gold!" class="submit"/>
            </form>
        </div>
        <div class="option">
            <h1>House</h1>
            <h2>(earns 2-5 golds)</h2>
            <form action="/process_gold" method="post">
                <input type="hidden" name="building" value="house" />
                <input type="submit" value="Find Gold!" class="submit"/>
            </form>
        </div>
        <div class="option">
            <h1>Casino</h1>
            <h2>(earns/takes 0-50 golds)</h2>
            <form action="/process_gold" method="post">
                <input type="hidden" name="building" value="casino" />
                <input type="submit" value="Find Gold!" class="submit"/>
            </form>
        </div>
    </div>
    <div id="activity">
        <h4>Activities:</h4>
        <p>${history}</p>
    </div>
    <form method="post" action="/reset">
        <button type="submit" class="submit">Reset</button>
    </form>
</div>
</body>
</html>