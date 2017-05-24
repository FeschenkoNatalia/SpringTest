<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:if test="${not empty message}">
    <div class="msg">${message}</div>
</c:if>
<form:form method="post" action="/register" modelAttribute="newUser">
    <c:if test="${not empty error}">
        <div class="msg">${error}</div>
    </c:if>
    <form:label path="username">Name</form:label>
    <form:input type="text" path="username"/>

    <form:label path="password">Password</form:label>
    <form:input path="password" type="password"/>
    <button type="submit">Sign up</button>
</form:form>
</body>
</html>
