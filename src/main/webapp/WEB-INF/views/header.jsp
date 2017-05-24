<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 18.05.2017
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cover Template for Bootstrap</title>

    <style>
        <%@include file="../resources/bootstrap/css/bootstrap.min.css"%>
        <%@include file="../resources/bootstrap/css/cover.css"%>
    </style>
    <!-- Bootstrap core CSS -->
    <%-- <link href="<c:url value ="/WEB-INF/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
     <!-- Custom styles for this template -->
     <link href="<c:url value ="/WEB-INF/resources/bootstrap/css/cover.css"/>" rel="stylesheet">--%>


</head>

<body>

<div class="masthead clearfix">
    <div class="inner">
        <h3 class="masthead-brand">Cover</h3>
        <nav>
            <ul class="nav masthead-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Features</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAnonymous()">
                    <li><a href="<c:url value="/login"/>">Sign In</a></li>
                    <li><a href="<c:url value="/register"/>">Sign Up<span class="sr-only">(current)</span></a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li>${pageContext.request.userPrincipal.name}</li>
                    <form action="/j_spring_security_logout" method="post">
                        <input type="submit" value="Logout"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</div>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>