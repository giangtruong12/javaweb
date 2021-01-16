<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<style type="text/css">
img {
 height:100px;
 }
</style>
<meta charset="UTF-8">
<title>Gio hang</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">SHOP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/TheWayShop/admin/category/add">AddCategory</a>
          <a class="dropdown-item" href="/TheWayShop/admin/category/search">SearchCategory</a>         
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Product
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/TheWayShop/admin/product/add">AddProduct</a>
          <a class="dropdown-item" href="/TheWayShop/admin/product/search">SearchProduct</a>
          <div class="dropdown-divider"></div>

        </div>
      </li>
              <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         User
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/TheWayShop/admin/user/add">AddUser</a>
          <a class="dropdown-item" href="/TheWayShop/admin/user/search">SearchUser</a>
      </li>
             <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Bill
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/TheWayShop/admin/bill/add">AddBill</a>
          <a class="dropdown-item" href="/TheWayShop/admin/bill/search">SearchBill</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="/TheWayShop/logout-admin">Logout</a>
      </li>
    </ul>
  </div>
</nav>
				<h2>Thong tin don hang:</h2>
				<div>
					<p>Bill Id: ${bill.id }</p>
					<p>Nguoi mua: ${bill.buyer.name }</p>
					<p>Ngay mua: ${bill.buyDate }</p>
					<p>Tong tien: ${bill.priceTotal }</p>
				</div>
				
				<a href="/TheWayShop/admin/bill-product/add?billid=${bill.id }">Them Bill Product</a>
				<h2>Danh sach Bill Product:</h2>
				<table class="table table-dark">
					<tr>
						<td>Id</td>
						<td>San Pham</td>					
						<td>Anh</td>
						<td>So Luong</td>
						<td>Don Gia</td>
						<td>Tong Tien</td>
						<td>Action</td>
					</tr>
					<c:forEach items="${billProducts}" var="billProducts">
						<tr>
							<td>${billProducts.id }</td>
							<td>${billProducts.product.name  }</td>
							<td><img src="/TheWayShop/download?image=${billProducts.product.image }" alt=""></td>
							<td>${billProducts.quantity }</td>
							<td>${billProducts.unitPrice }</td>
							<td>${billProducts.unitPrice * billProducts.quantity}</td>
							<td>
							<a href="/TheWayShop/admin/bill-product/buy?billid=${bill.id }&tongtien=${billProducts.unitPrice * billProducts.quantity}">Buy</a>|
							<a href="/TheWayShop/admin/bill-product/delete?billid=${bill.id }&billproductid=${billProducts.id }">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</html>