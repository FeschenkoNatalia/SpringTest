<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<c:if test="${not empty message}">
    <div class="msg">
            ${message}
    </div>
</c:if>


<form:form method="post" action="/j_spring_security_check" modelAttribute="newUser">
    <c:if test="${not empty error}">
        <div class="msg">
                ${error}
        </div>
    </c:if>
    <form:label path="username">Name</form:label>
    <form:input type="text" path="username"/>

    <form:label path="password">Password</form:label>
    <form:input path="password" type="password"/>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button type="submit">Log In</button>
</form:form>
</body>
</html>