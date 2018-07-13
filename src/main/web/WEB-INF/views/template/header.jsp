<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marin
  Date: 4.4.2018.
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Music Web Shop</title>

    <!-- AngularJS -->

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.32/angular.min.js"></script>



    <!-- Jquery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <%--Data Table--%>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Carousel  CSS -->
    <link href="<c:url value="/resources/css/carousel.css"/> " rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">




</head>
<body>


    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand"  href="<c:url value="/" />">Music Shop <span class="sr-only">(current)</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/" />">Home<span class="sr-only">(current)</span></a>
                </li>
                <li><a class="nav-link" href="<c:url value="/product/productList" />">Products</a> </li>
            </ul>
            <ul class="nav navbar-nav-pull-left" >
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/logout" />">Logout</a></li>

                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <li><a href="<c:url value="/customer/cart" />">Cart</a></li>
                    </c:if>

                    <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                        <li><a href="<c:url value="/admin" />">Admin</a></li>
                    </c:if>
                </c:if>


                <c:if test="${pageContext.request.userPrincipal.name  == null}">
                    <li><a class="nav-link" href="<c:url value="/login" />">Login</a></li>

                    <li><a class="nav-link" href="<c:url value="/register" />">Register</a></li>
                </c:if>
            </ul>





        </div>
    </nav>

