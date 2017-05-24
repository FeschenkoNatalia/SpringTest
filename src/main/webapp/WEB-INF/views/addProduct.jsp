<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
        <form class="form-signin" action="/product/add" method="post">
            <div class="form-group">
                <input class="form-control" type="text" name="productName" placeholder="ProductName: ">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="description" placeholder="Description: ">
            </div>
            <div class="form-group">
                <input class="form-control" type="number" name="price" placeholder="Price: ">
            </div>
            <div class="form-group">
                <select class="form-control" name="category.id" size="1">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add Product</button>
            <p>${message}</p>
        </form>
</div>
</body>
</html>