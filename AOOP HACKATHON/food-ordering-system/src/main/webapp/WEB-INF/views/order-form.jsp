<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Form</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
    <h2>Order Form</h2>
    <form action="/submitOrder" method="post">
        <div class="mb-3">
            <label for="itemName" class="form-label">Item Name</label>
            <input type="text" name="itemName" class="form-control" id="itemName" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" name="price" class="form-control" id="price" step="0.01" required>
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="number" name="quantity" class="form-control" id="quantity" min="1" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit Order</button>
    </form>
</div>
</body>
</html>
