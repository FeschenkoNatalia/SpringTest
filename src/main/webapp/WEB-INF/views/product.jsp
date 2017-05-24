<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product</title>
</head>
<body>
<table>
<h2 align="center">${product.category.categoryName}-->${product.productName}</h2>
<c:out value="${product.price}"/>
<c:out value="${product.description}"/>
</table>

</body>
</html>