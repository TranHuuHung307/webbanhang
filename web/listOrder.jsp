<%-- 
    Document   : listOrder
    Created on : Mar 9, 2024, 6:57:32 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .xx a{
                text-decoration: none;
                margin-top: -2px;
                margin-left: -2px;
            }
        </style>
    </head>
    <body>
        <table class="table table-hover container" border="1">
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Name Product</th>
                    <th>IMG</th>
                    <th>Price</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOPA}" var="o">
                    <tr>
                        <td>${o.fullName}</td>
                        <td>${o.nameProduct}</td>
                        <td><img src="${o.img}" width="75px" height="75px" alt="alt"/></td>
                        <td>${o.prive}</td>
                        <td>${o.phone}</td>
                        <td>${o.email}</td>
                        <td>
                            <c:if test="${o.status == 0}">
                                Chờ duyệt
                                <button type="button" class="btn btn-info xx"><a href="duyet?id=${o.id}">Duyệt</a></button>
                            </c:if>
                            <c:if test="${o.status == 1}">
                                Đang giao
                            </c:if>
                        </td>

                    </tr></c:forEach>
                </tbody>
            </table>

        </body>
    <%@ include file="footer.jsp" %>
</html>
