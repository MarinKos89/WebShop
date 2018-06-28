<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>View products</h1>

            <p class="lead">Information about items! </p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<spring:url value="/resources/images/${product.productID}.png"/>" alt="image" style="width: 300px" >
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>${product.productManufacturer}</p>
                    <p>${product.productCategory}</p>
                    <p>${product.productCondition}</p>
                    <p>${product.productPrice}</p>
                    <br>
                    <c:set var="role" scope="page" value="${param.role}"/>

                    <c:set var="url" scope="page" value="/product/productList"/>

                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large"
                           ng-click="addToCart('${product.productID}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span>Order
                            Now</a>
                        <a href="<spring:url value="/customer/cart" />"
                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>

                    </p>
                </div>
            </div>

        </div>



        <script src="<c:url value="/resources/js/productController.js"/>"></script>
    <%@include file="template/footer.jsp" %>