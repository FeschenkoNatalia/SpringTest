<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Category</title>
</head>
<body>
<table>
    <h2 align="center">${category.categoryName}</h2>
    <h4 style="margin-top: 50px">${category.description}</h4>
    <c:forEach var='product' items = '${category.products}'>
        <tr>
            <td>
                <a href="<c:out value="/product?id=${product.id}"/>">
                <c:out value="${product.productName}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:out value="/product/add"/>"><h4>Add new product</h4></a>
</body>
</html>
