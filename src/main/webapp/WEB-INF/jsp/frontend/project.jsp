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
<link href="frontend_assets/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet" />
<title>工程展示</title>
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
					<h1>工程展示</h1>
				</div>
				<div class="col-md-8 col-sm-8">
					<ul class="pull-right breadcrumb">
						<li><a href="index.html">首页</a></li>
						<li class="active">工程展示</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- END BREADCRUMBS -->

		<div class="row">
			<!-- BEGIN CONTAINER -->
			<div class="container min-hight portfolio-page margin-bottom-40">
				<!-- BEGIN FILTER -->
				<div class="filter-v1 margin-top-10">
					<ul class="mix-filter">
						<li class="filter" data-filter="all">All</li>
						<li class="filter" data-filter="type1">JavaWeb</li>
						<li class="filter" data-filter="type2">C++/Cocos2D-X</li>
						<li class="filter" data-filter="type3">Hadoop</li>
						<li class="filter" data-filter="type4">Android</li>
					</ul>
					<div class="row mix-grid thumbnails">
						<div class="col-md-4 col-sm-6 mix type1">
							<div class="mix-inner">
								<img class="img-responsive"
									src="frontend_assets/img/works/img1.jpg" alt="">
								<div class="mix-details">
									<h4>Cascusamus et iusto odio</h4>
									<p>At vero eos et accusamus et iusto odio digniss imos duc
										sasdimus qui sint blanditiis prae sentium voluptatum deleniti
										atque corrupti quos dolores.</p>
									<a class="mix-link"><i class="icon-link"></i></a> <a
										class="mix-preview fancybox-button"
										href="frontend_assets/img/works/img1.jpg" title="Project Name"
										data-rel="fancybox-button"><i class="icon-search"></i></a>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 mix type1">
							<div class="mix-inner">
								<img class="img-responsive"
									src="frontend_assets/img/works/img2.jpg" alt="">
								<div class="mix-details">
									<h4>Cascusamus et iusto odio</h4>
									<p>At vero eos et accusamus et iusto odio digniss imos duc
										sasdimus qui sint blanditiis prae sentium voluptatum deleniti
										atque corrupti quos dolores.</p>
									<a class="mix-link"><i class="icon-link"></i></a> <a
										class="mix-preview fancybox-button"
										href="frontend_assets/img/works/img2.jpg" title="Project Name"
										data-rel="fancybox-button"><i class="icon-search"></i></a>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 mix type2">
							<div class="mix-inner">
								<img class="img-responsive"
									src="frontend_assets/img/works/img3.jpg" alt="">
								<div class="mix-details">
									<h4>Cascusamus et iusto odio</h4>
									<p>At vero eos et accusamus et iusto odio digniss imos duc
										sasdimus qui sint blanditiis prae sentium voluptatum deleniti
										atque corrupti quos dolores.</p>
									<a class="mix-link"><i class="icon-link"></i></a> <a
										class="mix-preview fancybox-button"
										href="frontend_assets/img/works/img3.jpg" title="Project Name"
										data-rel="fancybox-button"><i class="icon-search"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END FILTER -->
			</div>
			<!-- END CONTAINER -->
		</div>
	</div>
	<!-- END PAGE CONTAINER -->
	<!-- 
	 	内容结束 -->
	<jsp:include page="template/template_footer.jsp" />
</body>
<jsp:include page="template/template_script.jsp" />
</html>
