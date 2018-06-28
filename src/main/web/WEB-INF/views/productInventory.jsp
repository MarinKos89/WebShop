<%--
  Created by IntelliJ IDEA.
  User: mkos8
  Date: 14.5.2018.
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">


<script>
    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[5,10,-1], [5,10, "All"]],
            "oSearch": {"sSearch": searchCondition}
        });
    });
</script>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product inventory page</h1>

            <p class="lead">This is product inventory page </p>
        </div>

        <table class="table table-info table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo thumb</th>
                <th>Product Name</th>
                <th>Product Category</th>
                <th>Product condition</th>
                <th>Product price</th>
                <th>Info</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productID}.png" /> " alt="image"
                             style="width: 150px"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td>
                        <a href="<spring:url value="/product/viewProduct/${product.productID}"/>">
                            <i class="fas fa-info fa-fw"></i>
                        </a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productID}"/>">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.productID}"/>">
                            <i class="fas fa-pencil-alt"></i>
                        </a>
                    </td>


                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add product</a>

<%@include file="template/footer.jsp" %>