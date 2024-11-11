<%-- 
   Document   : product-details
   Created on : Jun 26, 2023, 12:09:13 AM
   Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <h1 style="text-align: center">Product Details</h1>
        <div class="row">
            <div class="col-md-6">
                <img src="${product.img}" class="card-img-top" alt="Shoe 1">
        </div>
        <div class="col-md-6">
            <h2>${product.name}</h2>

            <p>Mô tả sản phẩm: ${product.description}</p>
            <p style="color: red">${product.price}VND</p>
            <a href="by?id=${product.id}" class="btn btn-danger"style = "background: #00BFFF" >Mua hàng</a>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>