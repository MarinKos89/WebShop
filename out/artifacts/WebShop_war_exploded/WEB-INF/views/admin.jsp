<%--
  Created by IntelliJ IDEA.
  User: mkos8
  Date: 14.5.2018.
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All products</h1>

            <p class="lead">Administrator page! </p>
        </div>
        <h3>
            <a href="<c:url value="admin/productInventory"/> ">Product inventory</a>
        </h3>
        <p>Here you can edit and modify product inventory</p>

<%@include file="template/footer.jsp" %>