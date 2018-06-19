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



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is a administrator page! </p>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome: ${pageContext.request.userPrincipal.name} | <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Log out" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </h2>
        </c:if>
        <h3>
            <a href="<c:url value="/admin/productInventory"/> ">Product inventory</a>
        </h3>
        <p>Here you can edit and modify product inventory</p>

        <br>
        <br>


        <h3>
            <a href="<c:url value="/admin/customer"/> ">Customer Management</a>
        </h3>
        <p>Here you can view customer info!</p>

<%@include file="template/footer.jsp" %>

