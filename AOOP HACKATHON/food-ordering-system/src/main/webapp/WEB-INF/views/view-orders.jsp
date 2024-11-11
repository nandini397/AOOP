<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Orders</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
    <h2>Order Summary</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.itemName}</td>
                    <td>${order.price}</td>
                    <td>${order.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h4>Total: $${total}</h4>
    <h4>Tax: $${tax}</h4>
    <h4>Discount: $${discount}</h4>
    <h4>Final Amount: $${finalAmount}</h4>
</div>
</body>
</html>
