<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Bill</title>
<link href="/image/fontawesome/fontawesome/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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
          <a class="dropdown-item" href="/TheWayShop/admin/product/list">ListAllProduct</a>
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
        <a class="badge badge-pill badge-primary"  href="/TheWayShop/logout-admin">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<nav class="navbar navbar-light bg-light">
  <form class="form-inline" action="/TheWayShop/admin/bill/search" method="post">
    <input class="form-control mr-sm-2" type="search" name="buyer" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</nav>

	<table  class="table table-dark">
		<tr>
			<th>ID</th>
			<th>Buyer</th>
			<th>Buy Date</th>
			<th>Price Total</th>
			<th>Action</th>
		</tr>
<c:forEach items="${allBill}" var="bill">
		<tr>
			<td>${bill.id }</td>
			<td>${bill.buyer.name }</td>
			<td>${bill.buyDate }</td>
			<td>${bill.priceTotal }</td>
			<td><a href="/TheWayShop/admin/bill/delete?id=${bill.id }">Delete</a>|
			<a href="/TheWayShop/admin/bill-product?id=${bill.id }">Detail Bill Product</a>
			</td>
		</tr>
</c:forEach>
	</table>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>