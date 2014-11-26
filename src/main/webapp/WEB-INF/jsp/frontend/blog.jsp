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
						for (int i = 0; i < 3; i++) {
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
								<a href="blog_item.html">Hadoop 2.5.0 新特性初探</a>
							</h2>
							<ul class="blog-info">
								<li><i class="icon-calendar"></i> 2014-11-26</li>
								<li><i class="icon-comments"></i> 22条评论</li>
								<li><i class="icon-tags"></i> Hope6537 , Java Engineer</li>
							</ul>
							<p>Apache Hadoop
								2.5.0是一个在2.x.y发布线上的一个小版本，建立在之前稳定的发布版本2.4.1之上。主要特性和改进：1. Commona)
								使用HTTP代理服务器时认证改进。当通过代理服务器使用WebHDFS时这是非常有用的。b)
								增加了一个新的Hadoop指标监控sink，允许直接写到Graphite。c) Hadoop文件系统兼容相关的规范工作。2.
								HDFSa) 支持 POSIX风格的扩展文件......</p>
							<a class="more" href="blog_item.html">点击阅读全文 <i
								class="icon-angle-right"></i></a>
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
				<div class="col-md-9 col-sm-9 blog-posts margin-bottom-40"
					id="blogEdit">
					<div class="row">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">写新文章</h3>
							</div>
							<div class="panel-body">
								<form role="form" action="blog/addblog.hopedo" method="post">
									<div class="form-body">
										<div class="form-group">
											<label>博客标题</label> <input type="text"
												class="form-control input-lg" name="blogtitle"
												placeholder="输入新文章的标题...">
										</div>
										<div class="form-group">
											<label>文章内容&nbsp;<small>可以从Word文档中复制哦！</small></label>
											<textarea class="ckeditor form-control" name="blogcont"
												id="blogcont" rows="200" cols="50"></textarea>
										</div>
										<div class="form-group">
											<label>插入图片 <small>上传后使用链接到编辑器提交链接来显示图片</small></label>
											<div class="confirm-group">
												<ul class="breadcrumb">
													<li>文件名 <span class="divider">:</span>
														http://www.baidu.com/test.jpg <a href="javascript:;">[插入]</a><br />
												</ul>
											</div>
										</div>
										<div class="form-group" style="margin-bottom: 87px;">
											<label class="col-md-3 control-label">上传图片<br />
												<button class="btn btn-primary">插入图片</button></label>
											<div class="col-md-9">
												<input type="file">
												<p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
											</div>
										</div>
										<div class="form-group">
											<label>文章标签 <small>以分号为分割</small></label> <input type="text"
												class="form-control input-lg" name="blogtags"
												placeholder="输入新文章的标签...">
										</div>
										<div class="form-group">
											<label>选择文章种类</label> <select class="form-control input-lg"
												name="blogtype">
												<option value="原创资料">原创资料</option>
												<option value="转载资料">转载资料</option>
												<option value="体会心得">体会心得</option>
											</select>
										</div>
									</div>
									<div class="form-actions right">
										<button type="submit" class="btn btn-block green">提交新文章</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

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
<script type="text/javascript">
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
</script>
</html>
