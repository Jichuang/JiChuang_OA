<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="template/template_head.jsp" />
<link href="frontend_assets/css/pages/portfolio.css" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<jsp:include page="template/template_header.jsp" />
	<!-- 
		内容 -->

	<!-- BEGIN PAGE CONTAINER -->
	<div class="page-container">

		<!-- BEGIN BREADCRUMBS -->
		<div class="row breadcrumbs margin-bottom-40">
			<div class="container">
				<div class="col-md-4 col-sm-4">
					<h1>Portfolio Item</h1>
				</div>
				<div class="col-md-8 col-sm-8">
					<ul class="pull-right breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li><a href="">Pages</a></li>
						<li class="active">Portfolio Item</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- END BREADCRUMBS -->

		<!-- BEGIN CONTAINER -->
		<div class="container min-hight portfolio-page margin-bottom-30">
			<!-- BEGIN PORTFOLIO ITEM -->
			<div class="row">
				<!-- BEGIN CAROUSEL -->
				<div class="col-md-5 front-carousel">
					<div id="myCarousel" class="carousel slide">
						<!-- Carousel items -->
						<div class="carousel-inner">
							<div class="active item">
								<img src="frontend_assets/img/works/img1.jpg" alt="">
								<div class="carousel-caption">
									<p>Excepturi sint occaecati cupiditate non provident</p>
								</div>
							</div>
							<div class="item">
								<img src="frontend_assets/img/works/img2.jpg" alt="">
								<div class="carousel-caption">
									<p>Ducimus qui blanditiis praesentium voluptatum</p>
								</div>
							</div>
							<div class="item">
								<img src="frontend_assets/img/works/img3.jpg" alt="">
								<div class="carousel-caption">
									<p>Ut non libero consectetur adipiscing elit magna</p>
								</div>
							</div>
						</div>
						<!-- Carousel nav -->
						<a class="carousel-control left" href="#myCarousel"
							data-slide="prev"> <i class="icon-angle-left"></i>
						</a> <a class="carousel-control right" href="#myCarousel"
							data-slide="next"> <i class="icon-angle-right"></i>
						</a>
					</div>
				</div>
				<!-- END CAROUSEL -->

				<!-- BEGIN PORTFOLIO DESCRIPTION -->
				<div class="col-md-7">
					<h2>Quis tempor incididunt</h2>
					<p>Molestias excepturi sint occaecati cupiditate non provident,
						similique sunt in culpa quis tempor incididunt ut et dolore et
						dolorum fuga. Ut non libero consectetur adipiscing elit magna. Sed
						et quam lacus.</p>
					<p>Lorem ipsum dolor sit amet, dolore eiusmod quis tempor
						incididunt ut et dolore Ut veniam unde nostrudlaboris. Sed unde
						omnis iste natus error sit voluptatem.</p>
					<br>
					<div class="row front-lists-v2 margin-bottom-15">
						<div class="col-md-6">
							<ul class="list-unstyled">
								<li><i class="icon-html5"></i> HTML5/CSS3</li>
								<li><i class="icon-bell"></i> Web Deisgn</li>
								<li><i class="icon-globe"></i> Web Development</li>
								<li><i class="icon-shopping-cart"></i> Shoping Cart</li>
							</ul>
						</div>
						<div class="col-md-6">
							<ul class="list-unstyled">
								<li><i class="icon-dropbox"></i> Free Storage</li>
								<li><i class="icon-cloud"></i> Cloud Hosting</li>
								<li><i class="icon-comments"></i> Free Support</li>
								<li><i class="icon-star"></i> Awesome UI</li>
							</ul>
						</div>
					</div>
					<a href="#" class="btn theme-btn"> VISIT THE PROJECT</a>
				</div>
				<!-- END PORTFOLIO DESCRIPTION -->
			</div>
			<!-- END PORTFOLIO ITEM -->

			<!-- BEGIN BLOCKQUOTE BLOCK -->
			<div class="row quote-v1">
				<div class="col-md-7 quote-v1-inner">
					<span>Lorem ipsum dolor sit amet, consectetuer adipiscing
						tempor</span>
				</div>
				<div class="col-md-5 quote-v1-inner text-right">
					<a class="btn-transparent" href="#"><i
						class="icon-rocket margin-right-10"></i>Adipiscing</a> <a
						class="btn-transparent" href="#"><i
						class="icon-gift margin-right-10"></i>Get it FREE</a>
				</div>
			</div>
			<!-- END BLOCKQUOTE BLOCK -->

			<div class="clearfix"></div>

			<!-- BEGIN RECENT WORKS -->
			<div class="row recent-work margin-bottom-40">
				<div class="col-md-3">
					<h2>
						<a href="portfolio.html">Recent Works</a>
					</h2>
					<p>Lorem ipsum dolor sit amet, dolore eiusmod quis tempor
						incididunt ut et dolore Ut veniam unde voluptatem. Sed unde omnis
						iste natus error sit voluptatem.</p>
				</div>
				<div class="col-md-9">
					<ul class="bxslider">
						<li><em> <img src="frontend_assets/img/works/img1.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img1.jpg" class="fancybox-button"
								title="Project Name #1" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img2.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img2.jpg" class="fancybox-button"
								title="Project Name #2" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img3.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img3.jpg" class="fancybox-button"
								title="Project Name #3" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img4.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img4.jpg" class="fancybox-button"
								title="Project Name #4" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img5.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img5.jpg" class="fancybox-button"
								title="Project Name #5" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img6.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img6.jpg" class="fancybox-button"
								title="Project Name #6" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img3.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img3.jpg" class="fancybox-button"
								title="Project Name #3" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
						<li><em> <img src="frontend_assets/img/works/img4.jpg" alt="" />
								<a href="portfolio_item.html"><i
									class="icon-link icon-hover icon-hover-1"></i></a> <a
								href="frontend_assets/img/works/img4.jpg" class="fancybox-button"
								title="Project Name #4" data-rel="fancybox-button"><i
									class="icon-search icon-hover icon-hover-2"></i></a>
						</em> <a class="bxslider-block" href="#"> <strong>Amazing
									Project</strong> <b>Agenda corp.</b>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- END RECENT WORKS -->
		</div>
		<!-- END CONTAINER -->

	</div>
	<!-- END PAGE CONTAINER -->

	<!-- 
	 	内容结束 -->
	<jsp:include page="template/template_footer.jsp" />
</body>
<jsp:include page="template/template_script.jsp" />
</html>
