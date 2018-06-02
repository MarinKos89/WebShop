<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
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
            <div>
                <a class="btn btn-danger pull-left"><i class="fas fa-trash-alt">Clear cart</i></a>
            </div>
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>

                </tr>
                <tr>
                    <td>productName</td>
                    <td>productPrice</td>
                    <td>quantity</td>
                    <td>totalPrice</td>
                    <td>remove button</td>

                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <ht>Grand total</ht>
                    <th>grandTotal</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="productList.jsp"/> ">Continue shoppin</a>

        </section>
    </div>
</div>


<%@include file="template/footer.jsp" %>