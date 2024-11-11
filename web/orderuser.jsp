<%-- 
    Document   : orderuser
    Created on : Mar 18, 2024, 2:15:02 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
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
                <c:forEach items="${list}" var="o">
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
                            </c:if>
                            <c:if test="${o.status == 1}">
                                Đang giao
                            </c:if>
                        </td>

                    </tr></c:forEach>
                </tbody>
            </table>
        <%@include file="footer.jsp" %>
    </body>
</html>
