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
					<h1>团队博客</h1>
				</div>
				<div class="col-md-8 col-sm-8">
					<ul class="pull-right breadcrumb">
						<li><a href="index.html">集创主页</a></li>
						<li class="active">团队博客</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- END BREADCRUMBS -->

		<!-- BEGIN CONTAINER -->
		<div class="container min-hight">
			<!-- BEGIN BLOG -->
			<div class="row">
				<!-- BEGIN LEFT SIDEBAR -->
				<div class="col-md-9 col-sm-9 blog-posts margin-bottom-40">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<!-- BEGIN CAROUSEL -->
							<div class="front-carousel">
								<div id="myCarousel" class="carousel slide">
									<!-- Carousel items -->
									<div class="carousel-inner">
										<div class="active item">
											<img src="frontend_assets/img/works/img1.jpg" alt="">
										</div>
										<div class="item">
											<img src="frontend_assets/img/works/img2.jpg" alt="">
										</div>
										<div class="item">
											<img src="frontend_assets/img/works/img3.jpg" alt="">
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
						</div>
						<div class="col-md-8 col-sm-8">
							<h2>
								<a href="blog_item.html">Corrupti quos dolores etquas</a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> 25/07/2013</li>
								<li><i class="icon-comments"></i> 17</li>
								<li><i class="icon-tags"></i> Metronic, Keenthemes, UI
									Design</li>
							</ul>
							<p>At vero eos et accusamus et iusto odio dignissimos ducimus
								qui sint blanditiis prae sentium voluptatum deleniti atque
								corrupti quos dolores et quas molestias excepturi sint occaecati
								cupiditate non eleifend enim a feugiat. Pellentesque viverra
								vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
								consectetur adipiscing condimentum eleifend enim a feugiat.</p>
							<a class="more" href="blog_item.html">Read more <i
								class="icon-angle-right"></i></a>
						</div>
					</div>
					<hr class="blog-post-sep">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<img src="frontend_assets/img/works/img4.jpg" alt=""
								class="img-responsive">
						</div>
						<div class="col-md-8 col-sm-8">
							<h2>
								<a href="blog_item.html">Corrupti quos dolores etquas</a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> 25/07/2013</li>
								<li><i class="icon-comments"></i> 17</li>
								<li><i class="icon-tags"></i> Metronic, Keenthemes, UI
									Design</li>
							</ul>
							<p>At vero eos et accusamus et iusto odio dignissimos ducimus
								qui sint blanditiis prae sentium voluptatum deleniti atque
								corrupti quos dolores et quas molestias excepturi sint occaecati
								cupiditate non eleifend enim a feugiat. Pellentesque viverra
								vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
								consectetur adipiscing condimentum eleifend enim a feugiat.</p>
							<a class="more" href="blog_item.html">Read more <i
								class="icon-angle-right"></i></a>
						</div>
					</div>
					<hr class="blog-post-sep">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<!-- BEGIN VIDEO -->
							<iframe src="http://player.vimeo.com/video/56974716?portrait=0"
								height="205" style="width:100%; border:0" allowFullScreen></iframe>
							<!-- END VIDEO -->
						</div>
						<div class="col-md-8 col-sm-8">
							<h2>
								<a href="blog_item.html">Corrupti quos dolores etquas</a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> 25/07/2013</li>
								<li><i class="icon-comments"></i> 17</li>
								<li><i class="icon-tags"></i> Metronic, Keenthemes, UI
									Design</li>
							</ul>
							<p>At vero eos et accusamus et iusto odio dignissimos ducimus
								qui sint blanditiis prae sentium voluptatum deleniti atque
								corrupti quos dolores et quas molestias excepturi sint occaecati
								cupiditate non eleifend enim a feugiat. Pellentesque viverra
								vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
								consectetur adipiscing condimentum eleifend enim a feugiat.</p>
							<a class="more" href="blog_item.html">Read more <i
								class="icon-angle-right"></i></a>
						</div>
					</div>
					<hr class="blog-post-sep">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<img src="frontend_assets/img/works/img2.jpg" alt=""
								class="img-responsive">
						</div>
						<div class="col-md-8 col-sm-8">
							<h2>
								<a href="#">Corrupti quos dolores etquas</a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> 25/07/2013</li>
								<li><i class="icon-comments"></i> 17</li>
								<li><i class="icon-tags"></i> Metronic, Keenthemes, UI
									Design</li>
							</ul>
							<p>At vero eos et accusamus et iusto odio dignissimos ducimus
								qui sint blanditiis prae sentium voluptatum deleniti atque
								corrupti quos dolores et quas molestias excepturi sint occaecati
								cupiditate non eleifend enim a feugiat. Pellentesque viverra
								vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
								consectetur adipiscing condimentum eleifend enim a feugiat.</p>
							<a class="more" href="blog_item.html">Read more <i
								class="icon-angle-right"></i></a>
						</div>
					</div>
					<div class="text-center">
						<ul class="pagination pagination-centered">
							<li><a href="#">Prev</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li class="active"><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
				</div>
				<!-- END LEFT SIDEBAR -->


				<jsp:include page="template/template_blog_right.jsp" />

			</div>
			<!-- END BEGIN BLOG -->
		</div>
		<!-- END CONTAINER -->

	</div>
	<!-- END BEGIN PAGE CONTAINER -->



	<!-- 
	 	内容结束 -->
	<jsp:include page="template/template_footer.jsp" />
</body>
<jsp:include page="template/template_script.jsp" />
</html>
