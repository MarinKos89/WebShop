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
            <h1>Add product</h1>

            <p class="lead">Fill required filds to add product! </p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control"/>


        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <form:select path="productCategory" name="Choose categoy" id="category">
                <form:option value="Records">Records</form:option>
                <form:option value="Instruments">Instruments</form:option>
                <form:option value="Vinyl">Vinyl</form:option>
            </form:select>
            <label for="status">Status</label>
            <form:select path="productStatus" name="Choose status" id="status">
                <form:option value="Active">Active</form:option>
                <form:option value="Inactive">Inactive</form:option>

            </form:select>

            <label for="condition">Condition</label>
            <form:select path="productCondition" name="Choose condition" id="condition">
                <form:option value="New">New</form:option>
                <form:option value="Used">Used</form:option>

            </form:select>
        </div>
        <div class="form-group">
            <label for ="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for ="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for ="unitStock">Unit in stocks</label>
            <form:input path="unitInStock" id="unitStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for ="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>
        <br>
        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="template/footer.jsp" %>