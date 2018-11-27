<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Show Pool</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            padding: 3%;
        }
        .top {
            position: absolute;
            left: 85%;
            top: 0;
        }
        .poolinfo1 {
            display: inline-block;
            border: 1px solid black;
            padding: 1%;
            position: absolute;
            left: 25%;
        }
        .poolinfo2 {
            display: inline-block;
            border: 1px solid black;
            padding: 1%;
            position: absolute;
            right: 25%;
        }
        .detailBox {
            width:80%;
            border:1px solid #bbb;
            margin:50px;
            position: absolute;
            top: 20%;
        }
        .titleBox {
            background-color:#fdfdfd;
            padding:10px;
        }
        .titleBox label{
            color:#444;
            margin:0;
            display:inline-block;
        }
        .commentBox .form-group:first-child, .actionBox .form-group:first-child {
            width:80%;
        }
        .commentBox .form-group:nth-child(2), .actionBox .form-group:nth-child(2) {
            width:18%;
        }
        .actionBox .form-group * {
            width:100%;
        }
        .commentList {
            padding:0;
            list-style:none;
            max-height:200px;
            overflow:auto;
        }
        .commentList li {
            margin:0;
            margin-top:10px;
        }
        .commentList li > div {
            display:table-cell;
        }
        .commenterImage img {
            width:100%;
            border-radius:50%;
        }
        .commentText p {
            margin:0;
        }
        .sub-text {
            color:#aaa;
            font-family:verdana;
            font-size:11px;
        }
        .actionBox {
            border-top:1px dotted #bbb;
            padding:10px;
        }
    </style>
</head>
<body>

<div class="top">
    <c:choose>
        <c:when test="${currentUser != null}">
            <a href="/home">Home</a>
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout!" />
            </form>
        </c:when>
        <c:otherwise>
            <a href="/registration">Signup - Signin</a>
        </c:otherwise>
    </c:choose>
</div>

<div class="poolinfo1">
    <p>Address: <c:out value="${pool.address}"/></p>
    <p>Description: <c:out value="${pool.description}"/></p>
</div>
<div class="poolinfo2">
    <p>Host Email: <c:out value="${pool.host.email}"/></p>
    <p>Host Name: <c:out value="${pool.host.firstName} ${pool.host.lastName}"/></p>
    <p>Pool Size: <c:out value="${pool.size}"/></p>
    <p>Cost: $<c:out value="${pool.cost}"/></p>
</div>



</body>
</html>


<div class="detailBox">
    <div class="titleBox">
        <label>Reviews (${pool.rating}):</label>
    </div>
    <div class="actionBox">
        <ul class="commentList">
            <c:if test="${reviews != null}">
                <c:forEach items="${reviews}" var="review">
                    <li>
                        <div class="commentText">
                            <p><c:out value="${review.user.firstName} ${review.user.lastName}"/></p>
                            <p><c:out value="${review.rating}"/></p>
                            <p><c:out value="${review.content}"/></p>
                        </div>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
        <a href="/review/${pool.id}">Leave a review</a>
    </div>
</div>