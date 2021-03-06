<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">SHOP</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Category </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/TheWayShop/admin/category/add">AddCategory</a>
						<a class="dropdown-item" href="/TheWayShop/admin/category/search">SearchCategory</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Product </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/TheWayShop/admin/product/add">AddProduct</a>
						<a class="dropdown-item" href="/TheWayShop/admin/product/search">SearchProduct</a>
						<div class="dropdown-divider"></div>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> User </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/TheWayShop/admin/user/add">AddUser</a>
						<a class="dropdown-item" href="/TheWayShop/admin/user/search">SearchUser</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Bill </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/TheWayShop/admin/bill/add">AddBill</a>
						<a class="dropdown-item" href="/TheWayShop/admin/bill/search">SearchBill</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/TheWayShop/logout-admin">Logout</a></li>
			</ul>
		</div>
	</nav>

	<form action="/TheWayShop/admin/bill-product/update" method="post">
		<div>
			<label>Bill ID:</label> <input type="text" name="bill_id"
				readonly="readonly" value="${bill.id }">
		</div>
		<div>
			<label>Buyer ID:</label> <input type="text" name="buyer_id"
				readonly="readonly" value="${bill.buyer.id }">
		</div>
		<div>
			<label>Buyer:</label> <input type="text" name="buyer"
				value="${bill.buyer.name }">
		</div>
		<div>
			<label>Ngay Mua:</label> <input type="text" name="buyDate"
				value="${bill.buyDate }">
		</div>
		<select name="productId">
			<c:forEach items="${prodList}" var="product">
				<option value=${product.id }>${product.name }</option>
			</c:forEach>
		</select>
		</div>
		<div>
			<label>So Luong:</label> <input type="number" name="quantity">
		</div>
		<div>
			<label>Don Gia:</label> <input type="number" name="price">

		</div>


		<div>
			<label>Image:</label> <input type="text" name="image"
				value="${billProduct.product.image }">
		</div>
		<div>
			<label>Tong Tien:</label> <input type="text" name="pricetotal"
				readonly="readonly">
		</div>
		<div>
			<input class="btn btn-primary" type="submit" value="Mua">
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>
</body>

</html>