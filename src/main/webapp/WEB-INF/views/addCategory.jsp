<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<form:form method="post" action="/category/add" modelAttribute="newCategory">

    <form:label path="categoryName">Category name</form:label>
    <form:input type="text" path="categoryName"/>

    <form:label path="description">Description</form:label>
    <form:input type="text" path="description"/>

    <button type="submit">Add category</button>
    <p>${message}</p>
</form:form>
</body>
</html>
