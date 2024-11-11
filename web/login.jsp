<head>
    <title>Login</title>
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fefefe;
            width: 400px;
            margin: 0 auto;
            padding: 20px;
        }

        .card-header {
            background-color: #333;
            color: #fff;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 20px;
            text-align: center;
        }

        .card-body {
            padding: 20px;
        }

        .form-label {
            font-weight: bold;
        }

        .form-control {
            border-radius: 5px;
            border: 1px solid #ced4da;
            padding: 10px;
            width: 100%;
            margin-bottom: 15px;
        }

        .btn {
            background-color: #007bff;
            border-color: #007bff;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            color: #fff;
            width: 100%;
            display: block;
            text-align: center;
            margin-top: 15px;
        }

        .btn:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 mt-5">
                <div class="card">
                    <div class="card-header">
                        <h3>Login</h3>
                        <% String messageSuccess = request.getParameter("messageSuccess"); if (messageSuccess != null && !messageSuccess.isEmpty()) { %>
                        <div class="alert alert-success" role="alert">
                            <%= messageSuccess %>
                        </div>
                        <% } %>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty message}">
                            <div class="alert alert-danger" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <form action="login" method="POST">
                            <div class="mb-3">
                                <label for="username" class="form-label">Username</label>
                                <input type="text" class="form-control" id="username" name="username" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-success">Login</button>
                        </form>
                        <div class="register-link">
                            <p>Don't have an account? <a href="register.jsp">Register</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
