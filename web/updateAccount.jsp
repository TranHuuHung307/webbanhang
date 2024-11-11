<%-- 
    Document   : updateAccount
    Created on : Mar 9, 2024, 12:17:37 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 mt-5">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="text-center">Register</h3>
                            </div>
                            <div class="card-body">
                            
                            <form action="userprofile" method="post">
                                <div class="mb-3">
                                    <label for="username" class="form-label">Username</label>
                                    <input type="text" class="form-control" id="username" value="${account.username}" name="username" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" value="${account.password}" id="password" name="password" required>
                                </div>
                                <div class="mb-3">
                                    <label for="fullName" class="form-label">Full Name</label>
                                    <input type="text" class="form-control" id="fullName" value="${account.fullname}" name="fullName" required>
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" value="${account.email}" id="email" name="email" required>
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Phone</label>
                                    <input type="text" class="form-control" value="${account.phone}" id="phone" name="phone" required>
                                </div>
                                <div class="mb-3">
                                    <label for="address" class="form-label">Address</label>
                                    <input type="text" class="form-control" value="${account.address}" id="address" name="address" required>
                                </div>
                                <div class="d-grid">
                                    <input type="hidden" value="${account.id}" name="idAccount">
                                    <button type="submit" class="btn btn-success">Update Account</button>
                                </div>
                            </form>
                            <br>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    <%@ include file="footer.jsp" %>
</html>
