<%-- 
    Document   : listAccount
    Created on : Mar 9, 2024, 6:04:14 AM
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
            .custom-button a {
                text-decoration: none;
                color: inherit;
            }
        </style>
    </head>
    <body>
        <table class="table table-hover container" border="1">
            <thead>
                <tr>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>FullName</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Status</th>
                    <th>Role</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody><c:forEach items="${listA}" var="a">
                <tr>
                    <td>${a.username}</td>
                    <td>${a.password}</td>
                    <td>${a.fullname}</td>
                    <td>${a.email}</td>
                    <td>${a.phone}</td>
                    <td>${a.address}</td>
                    <td>${a.status}</td>
                    <td>${a.role}</td>
                    <td><button class="custom-button btn btn-danger"><a href="deleteAccount?id=${a.id}">Delete</a></button></td>
                </tr></c:forEach>
            </tbody>
        </table>

    </body>
    <%@include file="footer.jsp" %>
</html>
