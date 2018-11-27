<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>New License</h1>
    <form:form action="/licenses/new" method="post" modelAttribute="license">
        <p>
            <form:label path="person">Person</form:label>
            <form:errors path="person"/>
            <form:select type="Person" path="person" items="${persons}" itemLabel="fullName"/>

        </p>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input path="state" placeholder="State"/>
        </p>
        <p>
            <form:label path="expiration_date">Expiration Date</form:label>
            <form:errors path="expiration_date"/>
            <form:input type="Date" path="expiration_date" placeholder="mm/dd/yyyy"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
<script>
    $(document).ready(function() {
        $("#datepicker").datepicker({dateFormat:"yy-mm-dd"});
    });
</script>
</html>