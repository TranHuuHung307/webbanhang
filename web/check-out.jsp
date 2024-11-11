<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
            <title>Checkout</title>
            <style>
                .container {
                    display: flex;
                    justify-content: space-between;
                }
                .shipping-info {
                    width: 55%;
                }
                .order-details {
                    width: 35%;
                }
                .product-image {
                    max-width: 50px;
                    max-height: 50px;
                    margin-right: 10px;
                }
            </style>
        </head>
        <body>
            <form action="order" method="post">
                <div class="container">
                    <div class="shipping-info">
                        <h2>Renting Information</h2>
                        <div class="mb-3">
                            <label for="name" class="form-label">Họ và tên:</label>
                            <input type="hidden" class="form-control" name="accountId" required value="${acc.id}">
                        <input type="hidden" class="form-control" name="productId" required value="${p.id}">
                        <input type="text" class="form-control" id="name" required value="${acc.fullname}">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Địa chỉ Email:</label>
                        <input type="email" class="form-control" id="email" value="${acc.email}" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">SĐT:</label>
                        <input type="text" class="form-control" id="phone" value="${acc.phone}" required>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Địa chỉ:</label>
                        <input type="text" class="form-control" id="address" value="${acc.address}" required>
                    </div>
                    <c:if test="${not empty param.mess}">

                        <p style="color: red">${param.mess}</p>
                    </c:if>
                    
                    <button type="submit" class="btn btn-primary">Place Order</button>
                </div>
                <div class="order-details">
                    <h2 style="text-align: center">Chi tiết đặt hàng</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Image</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${p.name}</td>
                                <td>${p.price}</td>
                                <td><img style="max-width: 59px" src="${p.img}" alt="alt"/></td>
                            </tr>
                        </tbody>
                    </table>
                                <p>Total Price: <span id="total_price">${p.price}VND</span></p>
                    <input type="hidden" value="${p.price}" name="total_price" id="total_price_input">
                </div>
            </div>
            <input type="hidden" value="${p.price}" name="price" id="price_input">
        </form>
        <jsp:include page="footer.jsp"></jsp:include>

        <script>
            function calculateTotalPrice() {
                var start = new Date(document.getElementById("start_datetime").value);
                var end = new Date(document.getElementById("end_datetime").value);
                var price = parseFloat(document.getElementById("price_input").value);

                var hours = Math.abs(end - start) / 36e5; // Divide by milliseconds in an hour (1000 * 60 * 60)

                var total = hours * price;

                // Update the value of the hidden input field to send the total price to the server
                document.getElementById("total_price_input").value = total.toFixed(2);

                // Display the total price dynamically
                document.getElementById("total_price").innerText = total.toFixed(2);
            }
        </script>
    </body>
</html>
