<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/TheWayShop/static/client/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="/TheWayShop/static/client/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="/TheWayShop/static/client/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="/TheWayShop/static/client/css/custom.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Start Main Top -->
	<jsp:include page="/view/client/common/main-top.jsp"></jsp:include>
	<!-- End Main Top -->

	<!-- Start Top Search -->
	<jsp:include page="/view/client/common/search.jsp"></jsp:include>
	<!-- End Top Search -->

	<!-- Start Slider -->
	<jsp:include page="/view/client/common/slider.jsp"></jsp:include>
	<!-- End Slider -->

	<!-- Start Categories  -->
	<div class="categories-shop">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/t-shirts-img.jpg" alt="" /> <a
							class="btn hvr-hover" href="#">T-shirts</a>
					</div>
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/shirt-img.jpg" alt="" /> <a
							class="btn hvr-hover" href="#">Shirt</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/wallet-img.jpg" alt="" /> <a
							class="btn hvr-hover" href="#">Wallet</a>
					</div>
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/women-bag-img.jpg" alt="" /> <a
							class="btn hvr-hover" href="#">Bags</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/shoes-img.jpg" alt="" /> <a
							class="btn hvr-hover" href="#">Shoes</a>
					</div>
					<div class="shop-cat-box">
						<img class="img-fluid" src="/TheWayShop/static/client/images/women-shoes-img.jpg" alt="" />
						<a class="btn hvr-hover" href="#">Women Shoes</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Categories -->

	<!-- Start Products  -->
	<div class="products-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>Featured Products</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Sed sit amet lacus enim.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="special-menu text-center">
						<div class="button-group filter-button-group">
							<button class="active" data-filter="*">All</button>
							<button data-filter=".top-featured">Top featured</button>
							<button data-filter=".best-seller">Best seller</button>
						</div>
					</div>
				</div>
			</div>

			<div class="row special-list">
				<div class="col-lg-3 col-md-6 special-grid best-seller">
					<div class="products-single fix">
						<div class="box-img-hover">
							<div class="type-lb">
								<p class="sale">Sale</p>
							</div>
							<img src="/TheWayShop/static/client/images/img-pro-01.jpg" class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
								<a class="cart" href="#">Add to Cart</a>
							</div>
						</div>
						<div class="why-text">
							<h4>Lorem ipsum dolor sit amet</h4>
							<h5>$7.79</h5>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid top-featured">
					<div class="products-single fix">
						<div class="box-img-hover">
							<div class="type-lb">
								<p class="new">New</p>
							</div>
							<img src="/TheWayShop/static/client/images/img-pro-02.jpg" class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
								<a class="cart" href="#">Add to Cart</a>
							</div>
						</div>
						<div class="why-text">
							<h4>Lorem ipsum dolor sit amet</h4>
							<h5>$9.79</h5>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid top-featured">
					<div class="products-single fix">
						<div class="box-img-hover">
							<div class="type-lb">
								<p class="sale">Sale</p>
							</div>
							<img src="/TheWayShop/static/client/images/img-pro-03.jpg" class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
								<a class="cart" href="#">Add to Cart</a>
							</div>
						</div>
						<div class="why-text">
							<h4>Lorem ipsum dolor sit amet</h4>
							<h5>$10.79</h5>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid best-seller">
					<div class="products-single fix">
						<div class="box-img-hover">
							<div class="type-lb">
								<p class="sale">Sale</p>
							</div>
							<img src="/TheWayShop/static/client/images/img-pro-04.jpg" class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
								<a class="cart" href="#">Add to Cart</a>
							</div>
						</div>
						<div class="why-text">
							<h4>Lorem ipsum dolor sit amet</h4>
							<h5>$15.79</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Products  -->

	<!-- Start Blog  -->
	<div class="latest-blog">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>latest blog</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Sed sit amet lacus enim.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-lg-4 col-xl-4">
					<div class="blog-box">
						<div class="blog-img">
							<img class="img-fluid" src="/TheWayShop/static/client/images/blog-img.jpg" alt="" />
						</div>
						<div class="blog-content">
							<div class="title-blog">
								<h3>Fusce in augue non nisi fringilla</h3>
								<p>Nulla ut urna egestas, porta libero id, suscipit orci.
									Quisque in lectus sit amet urna dignissim feugiat. Mauris
									molestie egestas pharetra. Ut finibus cursus nunc sed mollis.
									Praesent laoreet lacinia elit id lobortis.</p>
							</div>
							<ul class="option-blog">
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Likes"><i
										class="far fa-heart"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Comments"><i
										class="far fa-comments"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 col-xl-4">
					<div class="blog-box">
						<div class="blog-img">
							<img class="img-fluid" src="/TheWayShop/static/client/images/blog-img-01.jpg" alt="" />
						</div>
						<div class="blog-content">
							<div class="title-blog">
								<h3>Fusce in augue non nisi fringilla</h3>
								<p>Nulla ut urna egestas, porta libero id, suscipit orci.
									Quisque in lectus sit amet urna dignissim feugiat. Mauris
									molestie egestas pharetra. Ut finibus cursus nunc sed mollis.
									Praesent laoreet lacinia elit id lobortis.</p>
							</div>
							<ul class="option-blog">
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Likes"><i
										class="far fa-heart"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Comments"><i
										class="far fa-comments"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 col-xl-4">
					<div class="blog-box">
						<div class="blog-img">
							<img class="img-fluid" src="/TheWayShop/static/client/images/blog-img-02.jpg" alt="" />
						</div>
						<div class="blog-content">
							<div class="title-blog">
								<h3>Fusce in augue non nisi fringilla</h3>
								<p>Nulla ut urna egestas, porta libero id, suscipit orci.
									Quisque in lectus sit amet urna dignissim feugiat. Mauris
									molestie egestas pharetra. Ut finibus cursus nunc sed mollis.
									Praesent laoreet lacinia elit id lobortis.</p>
							</div>
							<ul class="option-blog">
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Likes"><i
										class="far fa-heart"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
								<li><a href="#" data-toggle="tooltip"
									data-placement="right" title="Comments"><i
										class="far fa-comments"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Blog  -->


	<!-- Start Instagram Feed  -->
	<jsp:include page="/view/client/common/feed.jsp"></jsp:include>
	<!-- End Instagram Feed  -->


	<!-- Start Footer  -->
	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design By
			: <a href="https://html.design/">html design</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="/TheWayShop/static/client/js/jquery-3.2.1.min.js"></script>
	<script src="/TheWayShop/static/client/js/popper.min.js"></script>
	<script src="/TheWayShop/static/client/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script src="/TheWayShop/static/client/js/jquery.superslides.min.js"></script>
	<script src="/TheWayShop/static/client/js/bootstrap-select.js"></script>
	<script src="/TheWayShop/static/client/js/inewsticker.js"></script>
	<script src="/TheWayShop/static/client/js/bootsnav.js."></script>
	<script src="/TheWayShop/static/client/js/images-loded.min.js"></script>
	<script src="/TheWayShop/static/client/js/isotope.min.js"></script>
	<script src="/TheWayShop/static/client/js/owl.carousel.min.js"></script>
	<script src="/TheWayShop/static/client/js/baguetteBox.min.js"></script>
	<script src="/TheWayShop/static/client/js/form-validator.min.js"></script>
	<script src="/TheWayShop/static/client/js/contact-form-script.js"></script>
	<script src="/TheWayShop/static/client/js/custom.js"></script>
</body>

</html>