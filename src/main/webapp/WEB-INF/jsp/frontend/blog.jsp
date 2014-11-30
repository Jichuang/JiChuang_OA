<%@page import="org.jichuang.hope6537.blog.model.Blog"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Blog> blogList = (List<Blog>) request.getAttribute("blogList");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>团队博客 | 集创团队</title>
<jsp:include page="template/template_head.jsp" />
<link rel="stylesheet" type="text/css"
	href="frontend_assets/plugins/bootstrap-fileupload/bootstrap-fileupload.css" />
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
					<h1>
						<span id="title">团队博客</span>
					</h1>
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
				<div class="col-md-9 col-sm-9 blog-posts margin-bottom-40"
					id="blogShow">
					<!-- 博客显示开始 -->
					<%
						for (Blog blog : blogList) {
							if (!blog.getStatus().equals("正常")) {
								continue;
							}
					%>
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<!-- BEGIN CAROUSEL -->
							<div class="front-carousel">
								<div id="myCarousel" class="carousel slide">
									<!-- 这边是图像预览 -->
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
									`
									<!-- 图像预览时的图标 -->
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
								<a href="frontpage/<%=blog.getBlogId()%>/blogitem.hopedo"><%=blog.getTitle()%></a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> <%=blog.getDate()%></li>
								<li><i class="icon-comments"></i> <%=blog.getInfo()%></li>
								<li><i class="icon-tags"></i><%=blog.getMemberId().getName() + ","
						+ blog.getMemberId().getUsername()%></li>
							</ul>
							<%
								String cont = blog.getContent().replaceAll("<[^>]*>", "");
									System.out.println(cont.length());
									cont = cont.substring(0, cont.length() <= 200 ? cont.length()
											: 200);
							%>
							<p><%=cont%>......
							</p>
							<a class="more"
								href="frontpage/<%=blog.getBlogId()%>/blogitem.hopedo">点击阅读全文
								<i class="icon-angle-right"></i>
							</a>
						</div>
					</div>
					<hr class="blog-post-sep">
					<%
						}
					%>
					<!-- 博文结束 -->
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
				<!-- 博客显示结束 -->
				<!-- 博客编辑开始 -->
				<jsp:include page="template/template_blog_right.jsp" />
				<!-- END BEGIN BLOG -->
			</div>
			<!-- END CONTAINER -->
		</div>
		<!-- END BEGIN PAGE CONTAINER -->
	</div>
	<!--  
		内容结束 -->
	<jsp:include page="template/template_footer.jsp" />
</body>
<jsp:include page="template/template_script.jsp" />
<script type="text/javascript"
	src="frontend_assets/plugins/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<!-- <script type="text/javascript">
	$(document).on("ready", function() {
		$("#blogShow").show();
		$("#blogEdit").hide();
	});

	$("#newBlog").on(
			"click",
			function() {
				console.log($(this).text());
				if ($(this).text() == "退出撰写") {
					$("#blogShow").show();
					$("#title").text("团队博客");
					$("#blogEdit").hide();
					$("#newBlog").text("写新文章 ").append(
							"<i class='m-icon-big-swapright m-icon-white'>")
							.attr("class",
									"btn blue btn-block btn-lg m-icon-big");
				} else {
					$("#blogShow").hide();
					$("#title").text("博客撰写");
					$("#blogEdit").show();

					$("#newBlog").text("退出撰写").append(
							"<i class='m-icon-big-swapleft m-icon-white'>")
							.attr("class",
									"btn red btn-block btn-lg m-icon-big");
				}

			});
</script> -->
</html>
