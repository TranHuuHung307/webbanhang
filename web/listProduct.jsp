<%-- 
    Document   : listProduct
    Created on : Mar 9, 2024, 5:21:14 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .custom-button a {
                text-decoration: none;
                color: inherit;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <c:forEach items="${listP}" var="product">
                <div class="col-md-4 mt-3">
                    <div class="card">

                        <a href="productdetails?productId=${product.id}">
                            <img src="${product.img}" class="card-img-top" alt="Product Image">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">Price: ${product.price}<span style="color: red">VND</span></p>
                        </div>
                        <button class="btn btn-danger custom-button"><a  href="deleteProduct?id=${product.id}">Delete</a></button>
                    </div>
                </div>
            </c:forEach>
        </div>

    </body>
    <%@ include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
</html>
