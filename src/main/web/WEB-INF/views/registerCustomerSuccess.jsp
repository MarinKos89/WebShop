<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
          <div class="container">
              <h1>Customer successfuly registered</h1>
          </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/product/productList"/> " class="btn btn default-color0">Continue shopping</a>

            </p>
        </section>

    </div>
</div>


<%@include file="template/footer.jsp" %>