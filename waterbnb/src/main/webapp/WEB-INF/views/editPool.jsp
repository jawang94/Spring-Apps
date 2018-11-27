<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        .edit1 {
            display: inline-block;
            border: 1px solid black;
            padding: 1%;
            position: absolute;
            right: 20%;
            left: 20%;
        }

        .detailBox {
            width:80%;
            border:1px solid #bbb;
            margin:50px;
            display: inline-block;
            position: absolute;
            top: 30%;
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

<div class="edit1">
    <form:form method="POST" action="/edit/${p.id}" modelAttribute="pool">
        <p><c:out value="${p.address}"/></p>
        <p>
            <form:label path="description">Description: </form:label>
            <form:errors path="description"/>
            <form:input type="description" path="description" placeholder="${p.description}"/>
        </p>
        <label>Host Email: <c:out value="${p.host.email}"/></label>
        <label>Host Name: <c:out value="${p.host.firstName} ${p.host.lastName}"/></label>
        <p>
            <form:label path="cost">Cost per night: </form:label>
            <form:select type="Double" path="cost" items="${cost}"/>
        </p>
        <p>
            <form:label path="size">Pool Size: </form:label>
            <form:select path="size" items="${size}"/>
        </p>
        <input type="submit" value="Save Changes"/>
    </form:form>
    <p><form:errors path="pool.*"/></p>
</div>


<div class="detailBox">
    <div class="titleBox">
        <label>Reviews (${p.rating}):</label>
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
    </div>
</div>

</body>
</html>
