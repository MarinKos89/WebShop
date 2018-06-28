<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>



<div class="container-wrapper" >
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>Products in your shopping cart</p>

                </div>
            </div>
        </section>
        <section class="container">
            <div  >
            <div >
                <a class="btn btn-danger pull-left" ><i class="fas fa-trash-alt">Clear cart</i></a>

                <a href="<spring:url value="/order/${cartId}"/>"
                   class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon"></span> Check out
                </a>
            </div>
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>

                </tr>
            <c:forEach items="${cartItems}" var="items">
            <tr>

                <td>${items.product.productName}</td>
                <td>${items.product.productPrice}</td>
                <td>${items.quantity}</td>
                <td>${items.totalPrice}</td>
                <td><a href="#" class="label label-danger"  >
                    <i class="fas fa-trash"></i>Remove</a></td>

            </tr>


             </c:forEach>



                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand total :</th>
                    <th></th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/product/productList"/> " class="btn btn default-color0">Continue shopping</a>
            </div>
        </section>
    </div>
</div>


<script src="<c:url value="/resources/js/productController.js"/>"></script>
<%@include file="template/footer.jsp" %>