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
	<!-- BEGIN BREADCRUMBS -->
	<div class="row breadcrumbs margin-bottom-40">
		<div class="container">
			<div class="col-md-4 col-sm-4">
				<h1>集创简介</h1>
			</div>
			<div class="col-md-8 col-sm-8">
				<ul class="pull-right breadcrumb">
					<li><a href="index.html">集创首页</a></li>
					<li class="active">关于我们</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- END BREADCRUMBS -->
	<!-- BEGIN CONTAINER -->
	<div class="container min-hight">
		<!-- BEGIN ABOUT INFO -->
		<div class="row margin-bottom-30">
			<!-- BEGIN INFO BLOCK -->
			<div class="col-md-7 space-mobile">
				<h2>Fun for Code , Code for Fun</h2>
				<p>
					集创团队，创建于2014年4月27日，所属长春大学计算机科学与技术学院，是一个精英聚集的地方。<br /> <br />
					在这里汇聚了许多有志之士，一起为了更好的明天而努力的学习和研究计算机知识<br /> 在这里，你可以随心所欲的遨游在代码的世界里，<br />
					在这里，你可以解决你心中的所有疑惑<br /> 。。。<br /> <br />
					团队目前有5位成员成员，研究方向包括：JAVASE JAVAEE Ｃ＋＋ COCOS2D-X 分布式计算等多种技术<br /> <br />
					我们的目标是：在不断提高自己能力的同时，尽自己最大的努力去帮助那些我们可以帮助的同学，<br /> 并带动他们不断的学习；<br />
					同时，我们尽量向其他学院的同学宣传我们学院的知识，以达到不同学院之间知识的交流与学习<br />
				</p>
				<!-- BEGIN LISTS -->
				<div class="row front-lists-v1">
					<div class="col-md-6">
						<ul class="list-unstyled margin-bottom-20">
							<li><i class="icon-ok"></i> 求是</li>
							<li><i class="icon-ok"></i> 务实</li>
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-unstyled">
							<li><i class="icon-ok"></i> 互助</li>
							<li><i class="icon-ok"></i> 创新</li>
						</ul>
					</div>
				</div>
				<!-- END LISTS -->
			</div>
			<!-- END INFO BLOCK -->

			<!-- BEGIN CAROUSEL -->
			<div class="col-md-5 front-carousel">
				<div id="myCarousel" class="carousel slide">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="active item">
							<img src="frontend_assets/img/pics/img2-medium.jpg" alt="">
							<div class="carousel-caption">
								<p>Excepturi sint occaecati cupiditate non provident</p>
							</div>
						</div>
						<div class="item">
							<img src="frontend_assets/img/pics/img1-medium.jpg" alt="">
							<div class="carousel-caption">
								<p>Ducimus qui blanditiis praesentium voluptatum</p>
							</div>
						</div>
						<div class="item">
							<img src="frontend_assets/img/pics/img2-medium.jpg" alt="">
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
		</div>
		<!-- END ABOUT INFO -->

		<!-- BEGIN TESTIMONIALS AND PROGRESS BAR -->
		<div class="row margin-bottom-40">
			<!-- BEGIN TESTIMONIALS -->
			<div class="col-md-7 testimonials-v1">
				<h2 class="block">我们的话</h2>
				<div id="myCarousel1" class="carousel slide">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="active item">
							<span class="testimonials-slide">Denim you probably
								haven't heard of. Lorem ipsum dolor met consectetur adipisicing
								sit amet, consectetur adipisicing elit, of them jean shorts sed
								magna aliqua. Lorem ipsum dolor met consectetur adipisicing sit
								amet do eiusmod dolore.</span>
							<div class="carousel-info">
								<img class="pull-left" src="frontend_assets/img/people/zhao.png"
									alt="" />
								<div class="pull-left">
									<span class="testimonials-name">Hope6537</span> <span
										class="testimonials-post">Java Engineer</span>
								</div>
							</div>
						</div>
						<div class="item">
							<span class="testimonials-slide">Raw denim you Mustache
								cliche tempor, williamsburg carles vegan helvetica probably
								haven't heard of them jean shorts austin. Nesciunt tofu
								stumptown aliqua, retro synth master cleanse. Mustache cliche
								tempor, williamsburg carles vegan helvetica.</span>
							<div class="carousel-info">
								<img class="pull-left" src="frontend_assets/img/people/fan.png"
									alt="" />
								<div class="pull-left">
									<span class="testimonials-name">CoderMan</span> <span
										class="testimonials-post">Java Engineer</span>
								</div>
							</div>
						</div>
						<div class="item">
							<span class="testimonials-slide">Reprehenderit butcher
								stache cliche tempor, williamsburg carles vegan helvetica.retro
								keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure
								terry richardson ex squid Aliquip placeat salvia cillum iphone.</span>
							<div class="carousel-info">
								<img class="pull-left" src="frontend_assets/img/people/wei.png"
									alt="" />
								<div class="pull-left">
									<span class="testimonials-name">Typist</span> <span
										class="testimonials-post">C++/Cocos2D-X Engineer</span>
								</div>
							</div>
						</div>
					</div>
					<!-- Carousel nav -->
					<a class="left-btn" href="#myCarousel1" data-slide="prev"></a> <a
						class="right-btn" href="#myCarousel1" data-slide="next"></a>
				</div>
			</div>
			<!-- END TESTIMONIALS -->

			<!-- BEGIN PROGRESS BAR -->
			<div class="col-md-5 front-skills space-mobile">
				<h2 class="block">团队技术</h2>
				<span>JavaWeb 80%</span>
				<div class="progress">
					<div style="width: 80%;" class="progress-bar" role="progressbar"></div>
				</div>
				<span>Android iOS 50%</span>
				<div class="progress">
					<div style="width: 50%;" class="progress-bar" role="progressbar"></div>
				</div>
				<span>Hadoop 20%</span>
				<div class="progress">
					<div style="width: 20%;" class="progress-bar" role="progressbar"></div>
				</div>
			</div>
			<!-- END PROGRESS BAR -->
		</div>
		<!-- END TESTIMONIALS AND PROGRESS BAR -->

		<!-- BEGIN OUR TEAM -->
		<div class="row front-team">
			<ul class="list-unstyled">
				<li class="col-md-3 space-mobile">
					<div class="thumbnail">
						<img src="frontend_assets/img/people/zhao.png" alt="">
						<h3>
							<a>赵鹏 (Hope6537)</a> <small>Founder/Java Engineer</small>
						</h3>
						<p>
							以Java开发为主 具有3年Java开发经验 <br /> 擅长Web、Android应用开发 <br />
							研究基于Hadoop的数据分析
						</p>
					</div>
				</li>
				<li class="col-md-3 space-mobile">
					<div class="thumbnail">
						<img src="frontend_assets/img/people/fan.png" alt="">
						<h3>
							<a>樊春帅(CoderMan)</a> <small>Java Engineer</small>
						</h3>
						<p>
							熟悉java web编程 对J2EE有深入的了解<br /> 熟悉数据库开发 对并发编程有一定的研究
						</p>
					</div>
				</li>
				<li class="col-md-3 space-mobile">
					<div class="thumbnail">
						<img src="frontend_assets/img/people/fan2.png" alt="">
						<h3>
							<a>范威振(Stone6762)</a> <small>Algorithm Learner</small>
						</h3>
						<p>
							研究数论和几何算法 <br /> 具有一定的软件开发经验 <br />明确基本的设计模式
						</p>
					</div>
				</li>
				<li class="col-md-3">
					<div class="thumbnail">
						<img src="frontend_assets/img/people/wei.png" alt="">
						<h3>
							<a>魏金胜(Typist)</a> <small>C++/Cocos2D-X Engineer</small>
						</h3>
						<p>
							熟悉c++ coco2d-x+vs手游开发 <br />熟悉Lua脚本语言 <br />对制作游戏及相关技术感兴趣
						</p>
					</div>
				</li>
			</ul>
		</div>
		<!-- END OUR TEAM -->
	</div>
	<!-- END CONTAINER -->

	<jsp:include page="template/template_footer.jsp" />
</body>
<jsp:include page="template/template_script.jsp" />

</html>
