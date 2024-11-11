<%-- 
    Document   : home
    Created on : Jun 25, 2023, 11:44:09 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%--
    Document   : home
    Created on : Jun 25, 2023, 11:44:09 PM
    Author     : ADMIN
--%>


<div class="container">
    <div style="padding-top: 30px">
        <img src="https://cdn.tgdd.vn/2023/12/banner/Tivi-1-1200x80.jpg" style="width: 100%">
    </div>
    <form action="search" method="get" class="mb-3">
        <div class="input-group" style="padding-top: 20px">
            <input type="text" class="form-control" name="search" value="${search}" placeholder="Tìm kiếm sản phẩm">
            <input type="hidden" name="page" value="${currentPage}">
            <button class="btn btn-danger"  style="background: #00BFFF  " type="submit">Tìm Kiếm</button>
        </div>
    </form>
   
    <div class="row mt-5">
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">
                    Lọc theo loại sản phẩm
                </div>
                <div class="card-body">
                    <form action="getList">
                        <div class="mb-3">
                            <select class="form-select" name="category">
                                <option value="all" >All</option>
                                <c:forEach items="${listC}" var="c">
                                    <option value="${c.id}" <c:if test="${categoryID == c.id}">selected</c:if>>${c.name}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-danger" style="background: #00BFFF  ">Áp dụng</button>
                        </div>
                    </form>
                </div> 
            </div>
            <div class="card mt-3">
                <div class="card-header">
                    Lọc theo giá tiền
                </div>
                <div class="card-body">
                    <form action="filterbyprice" method="post">
                        <div class="mb-3">
                             <select class="form-select" name="sort">
                                <option value="asc" >Từ thấp đến cao</option>
                                <option value="desc" >Từ cao đến thấp</option>
                                <option value="new" >Sản phẩm mới nhất</option>
                                </select>

                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-danger"style="background: #00BFFF  ">Áp dụng</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <c:forEach items="${listP}" var="product" begin="1">
                    <div class="col-md-4 mt-3">
                        <div class="card">

                            <a href="productdetails?productId=${product.id}">
                                <img src="${product.img}" class="card-img-top" alt="Product Image">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-text">Price: ${product.price}<span style="color: red">VND</span></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <nav class="mt-3" aria-label="Page navigation example">
                <ul class="pagination">
                    <!-- Disable the "Previous" link if on the first page -->
                    <c:if test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" href="?category=${param.category}&amp;search=${param.search}&amp;sort=${param.sort}&amp;page=${currentPage - 1}">Previous</a>
                        </li>
                    </c:if>

                    <!-- Display the page numbers as links -->
                    <c:forEach var="pageNum" begin="1" end="${endP}">
                        <li class="page-item <c:if test='${pageNum == currentPage}'>active</c:if>">
                            <a class="page-link" href="listproduct?id=${pageNum}">${pageNum}</a>
                        </li>
                    </c:forEach>

                    <!-- Disable the "Next" link if on the last page -->
                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="?category=${param.category}&amp;search=${param.search}&amp;sort=${param.sort}&amp;page=${currentPage + 1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>