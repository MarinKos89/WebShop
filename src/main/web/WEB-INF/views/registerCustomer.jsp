<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">




<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Fill information bellow! </p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">


        <h1>Information section</h1>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="customerName" id="name" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <span style="color: #ff0000">${emailMsg}</span><form:errors
                path="customerEmail" cssStyle="color: #ff0000"/>
            <form:input path="customerEmail" id="email" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <span style="color: #ff0000">${usernameMsg}</span><form:errors
                path="username" cssStyle="color: #ff0000"/>
            <form:input path="username" id="username" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:errors path="password" cssStyle="color: #ff0000"/>
            <form:password path="password" id="password" cssClass="form-control"/>
        </div>
        <h2>Billing Address</h2>
        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city" id="billingCity" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingZipCode">ZipCode</label>
            <form:input path="billingAddress.zipCode" id="billingZipCode" cssClass="form-control"/>
        </div>
        <h2>Shipping Address</h2>
        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="shippingCountry" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="shippingState" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingZipCode">Zip Code</label>
            <form:input path="shippingAddress.zipCode" id="shippingZipCode" cssClass="form-control"/>
        </div>
        <br>
        <br>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="template/footer.jsp" %>