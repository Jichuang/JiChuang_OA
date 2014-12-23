<%@ page language="java" pageEncoding="UTF-8" %>
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
    <title>集创团队</title>
    <jsp:include page="template/template_head.jsp"/>
</head>

<body>
<jsp:include page="template/template_header.jsp"/>

<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
<!-- BEGIN REVOLUTION SLIDER -->
<div class="fullwidthbanner-container slider-main">
    <div class="fullwidthabnner">
        <ul id="revolutionul" style="display:none;">
            <!-- THE FIRST SLIDE -->
            <li data-transition="fade" data-slotamount="8"
                data-masterspeed="700" data-delay="9400"
                data-thumb="frontend_assets/img/sliders/revolution/thumbs/thumb2.jpg">
                <!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img
                    src="frontend_assets/img/sliders/revolution/bg1.jpg" alt="">

                <div class="caption lft slide_title slide_item_left" data-x="0"
                     data-y="105" data-speed="400" data-start="1500"
                     data-easing="easeOutExpo">Hadoop集群火热搭建中
                </div>
                <div class="caption lft slide_desc slide_item_left" data-x="0"
                     data-y="180" data-speed="400" data-start="2000"
                     data-easing="easeOutExpo">
                    使用分布式计算进行数据采集和分析<br/>遨游在数据的海洋中洞察世界的规律<br/>处理你所想不到的大数据
                </div>
                <a
                        class="caption lft btn green slide_btn slide_item_left btn-large"
                        href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes"
                        data-x="0" data-y="270" data-speed="400" data-start="3000"
                        data-easing="easeOutExpo"> 加入我们 </a>

                <div class="caption lfb" data-x="640" data-y="55" data-speed="700"
                     data-start="1000" data-easing="easeOutExpo">
                    <img src="frontend_assets/img/sliders/revolution/man-winner.png"
                         alt="Image 1">
                </div>
            </li>

            <!-- THE SECOND SLIDE -->
            <li data-transition="fade" data-slotamount="7"
                data-masterspeed="300" data-delay="9400"
                data-thumb="frontend_assets/img/sliders/revolution/thumbs/thumb2.jpg">
                <img src="frontend_assets/img/sliders/revolution/bg2.jpg" alt="">

                <div class="caption lfl slide_title slide_item_left" data-x="0"
                     data-y="125" data-speed="400" data-start="1500"
                     data-easing="easeOutExpo">JavaEE 教程班正在进行中
                </div>
                <div class="caption lfl slide_subtitle slide_item_left" data-x="0"
                     data-y="200" data-speed="400" data-start="2000"
                     data-easing="easeOutExpo">Spring+SpringMVC+Mybatis
                </div>
                <div class="caption lfl slide_desc slide_item_left" data-x="0"
                     data-y="245" data-speed="400" data-start="2500"
                     data-easing="easeOutExpo">
                    从JavaSE到SSH2<br/> 从黑框框到Android Java的能力超乎你的想象<br/> 编写你想要的程序
                </div>
                <!-- <div class="caption lfr slide_item_right" data-x="635"
                                           data-y="105" data-speed="1200" data-start="1500"
                                           data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/mac.png"
                                               alt="Image 1">
                                       </div>
                                       <div class="caption lfr slide_item_right" data-x="580"
                                           data-y="245" data-speed="1200" data-start="2000"
                                           data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/ipad.png"
                                               alt="Image 1">
                                       </div>
                                       <div class="caption lfr slide_item_right" data-x="735"
                                           data-y="290" data-speed="1200" data-start="2500"
                                           data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/iphone.png"
                                               alt="Image 1">
                                       </div>
                                       <div class="caption lfr slide_item_right" data-x="835"
                                           data-y="230" data-speed="1200" data-start="3000"
                                           data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/macbook.png"
                                               alt="Image 1">
                                       </div>
                                       <div class="caption lft slide_item_right" data-x="865" data-y="45"
                                           data-speed="500" data-start="5000" data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/hint1-blue.png"
                                               id="rev-hint1" alt="Image 1">
                                       </div>
                                       <div class="caption lfb slide_item_right" data-x="355"
                                           data-y="355" data-speed="500" data-start="5500"
                                           data-easing="easeOutBack">
                                           <img src="frontend_assets/img/sliders/revolution/hint2-blue.png"
                                               id="rev-hint2" alt="Image 1">
                                       </div> -->

            </li>

            <!-- THE THIRD SLIDE -->
            <li data-transition="fade" data-slotamount="8"
                data-masterspeed="700" data-delay="9400"
                data-thumb="frontend_assets/img/sliders/revolution/thumbs/thumb2.jpg">
                <img src="frontend_assets/img/sliders/revolution/bg3.jpg" alt="">

                <div class="caption lfl slide_item_left" data-x="20" data-y="95"
                     data-speed="400" data-start="1500" data-easing="easeOutBack">
                    <iframe
                            src="http://static.acfun.mm111.net/player/ACFlashPlayer.out.swf?type=page&url=http://www.acfun.tv/v/ac1559320"
                            width="420" height="240" style="border:0" allowFullScreen></iframe>
                </div>
                <div class="caption lfr slide_title" data-x="470" data-y="100"
                     data-speed="400" data-start="2000" data-easing="easeOutExpo">
                    Cocos2D-X 手游开发进行中
                </div>
                <div class="caption lfr slide_subtitle" data-x="470" data-y="170"
                     data-speed="400" data-start="2500" data-easing="easeOutExpo">
                    C++ Android iOS
                </div>
                <div class="caption lfr slide_desc" data-x="470" data-y="220"
                     data-speed="400" data-start="3000" data-easing="easeOutExpo">
                    实现我们内心中的理想乡，用游戏描绘我们的思想。<br/>世界都在我们的手中创造
                </div>
                <a class="caption lfr btn yellow slide_btn" href="" data-x="470"
                   data-y="280" data-speed="400" data-start="3500"
                   data-easing="easeOutExpo"> 观看演示视频 </a>
            </li>

        </ul>
        <div class="tp-bannertimer tp-bottom"></div>
    </div>
</div>
<!-- END REVOLUTION SLIDER -->

<!-- BEGIN CONTAINER -->
<div class="container">
<!-- BEGIN SERVICE BOX -->
<div class="row service-box">
    <div class="col-md-4 col-sm-4">
        <div class="service-box-heading">
            <em><i class="icon-location-arrow blue"></i></em> <span>JavaSE/EE,Android</span>
        </div>
        <p>
            Java作用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，拥有全球最大的开发者专业社群 <br/>全球份额最高的移动平台，并从智能手机逐渐扩展到平板电脑及其他领域上，如电视、数码相机、游戏机等
        </p>
    </div>
    <div class="col-md-4 col-sm-4">
        <div class="service-box-heading">
            <em><i class="icon-ok red"></i></em> <span>C++,Cocos2D-X</span>
        </div>
        <p>
            C++是在C语言的基础上开发的一种集面向对象编程、泛型编程和过程化编程于一体的编程语言,具有广泛的用途 <br/>Cocos2d-x是一个开源的移动2D游戏框架，具有跨平台特性，Cocos2d-x提供的框架。手机游戏，可以写在C++中
        </p>
    </div>
    <div class="col-md-4 col-sm-4">
        <div class="service-box-heading">
            <em><i class="icon-resize-small green"></i></em> <span>ACM/ICPC</span>
        </div>
        <p>ACM国际大学生程序设计竞赛是由美国计算机协会主办
            一项旨在展示大学生创新能力、团队精神和在压力下编写程序、分析和解决问题能力的年度竞赛。</p>
    </div>
</div>
<!-- END SERVICE BOX -->

<!-- BEGIN BLOCKQUOTE BLOCK -->
<div class="row quote-v1">
    <div class="col-md-9 quote-v1-inner">
					<span><i class="icon-light-on"></i>Write the Code Change the
						World</span>
    </div>
    <div class="col-md-3 quote-v1-inner text-right">
        <a class="btn-transparent"
           href="http://www.keenthemes.com/preview/index.php?theme=metronic_admin"
           target="_blank"><i class="icon-rocket margin-right-10"></i>加入我们！
            用代码改变世界</a>
        <!--<a class="btn-transparent" href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469"><i class="icon-gift margin-right-10"></i>Purchase 2 in 1</a>-->
    </div>
</div>
<!-- END BLOCKQUOTE BLOCK -->

<div class="clearfix"></div>

<!-- BEGIN RECENT WORKS -->
<div class="row recent-work margin-bottom-40">
    <div class="col-md-3">
        <h2>
            <a href="portfolio.html">近期工作项目</a>

        </h2>

        <p>
            展示团队近期任务<br/> 期待您加入我们的开发
        </p>
    </div>
    <div class="col-md-9">
        <ul class="bxslider">
            <li><em> <img src="frontend_assets/img/works/img1.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img1.jpg"
                    class="fancybox-button" title="Project Name #1"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img2.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img2.jpg"
                    class="fancybox-button" title="Project Name #2"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img3.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img3.jpg"
                    class="fancybox-button" title="Project Name #3"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img4.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img4.jpg"
                    class="fancybox-button" title="Project Name #4"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img5.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img5.jpg"
                    class="fancybox-button" title="Project Name #5"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img6.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img6.jpg"
                    class="fancybox-button" title="Project Name #6"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img3.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img3.jpg"
                    class="fancybox-button" title="Project Name #3"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
            <li><em> <img src="frontend_assets/img/works/img4.jpg"
                          alt=""/> <a href="portfolio_item.html"><i
                    class="icon-link icon-hover icon-hover-1"></i></a> <a
                    href="frontend_assets/img/works/img4.jpg"
                    class="fancybox-button" title="Project Name #4"
                    data-rel="fancybox-button"><i
                    class="icon-search icon-hover icon-hover-2"></i></a>
            </em> <a class="bxslider-block" href="#"> <strong>Amazing
                Project</strong> <b>Agenda corp.</b>
            </a></li>
        </ul>
    </div>
</div>
<!-- END RECENT WORKS -->

<div class="clearfix"></div>

<!-- BEGIN TABS AND TESTIMONIALS -->
<div class="row mix-block">
    <!-- TABS -->
    <div class="col-md-7 tab-style-1 margin-bottom-20">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tab-1" data-toggle="tab">Java精选文章</a></li>
            <li><a href="#tab-2" data-toggle="tab">Hadoop精选文章</a></li>
            <li><a href="#tab-3" data-toggle="tab">Android精选文章</a></li>
            <li><a href="#tab-4" data-toggle="tab">Cocos2D-X精选文章</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane row fade in active" id="tab-1">
                <div class="col-md-3">
                    <a href="frontend_assets/img/photos/img7.jpg"
                       class="fancybox-button" title="Image Title"
                       data-rel="fancybox-button"> <img class="img-responsive"
                                                        src="frontend_assets/img/photos/img7.jpg" alt=""/>
                    </a>
                </div>
                <div class="col-md-9">
                    <p class="margin-bottom-10">Raw denim you probably haven't
                        heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor,
                        williamsburg carles vegan helvetica. Cosby sweater eu banh mi,
                        qui irure terry richardson ex squid Aliquip placeat salvia
                        cillum iphone.</p>

                    <p>
                        <a class="more" href="#">Read more <i
                                class="icon-angle-right"></i></a>
                    </p>
                </div>
            </div>
            <div class="tab-pane row fade" id="tab-2">
                <div class="col-md-9">
                    <p>Food truck fixie locavore, accusamus mcsweeney's marfa
                        nulla single-origin coffee squid. Exercitation +1 labore velit,
                        blog sartorial PBR leggings next level wes anderson artisan
                        four loko farm-to-table craft beer twee. Qui photo booth
                        letterpress, commodo enim craft beer mlkshk aliquip jean shorts
                        ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda
                        labore aesthetic magna delectus mollit. Keytar helvetica VHS
                        salvia..</p>
                </div>
                <div class="col-md-3">
                    <a href="frontend_assets/img/photos/img10.jpg"
                       class="fancybox-button" title="Image Title"
                       data-rel="fancybox-button"> <img class="img-responsive"
                                                        src="frontend_assets/img/photos/img10.jpg" alt=""/>
                    </a>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-3">
                <p>Etsy mixtape wayfarers, ethical wes anderson tofu before
                    they sold out mcsweeney's organic lomo retro fanny pack lo-fi
                    farm-to-table readymade. Messenger bag gentrify pitchfork
                    tattooed craft beer, iphone skateboard locavore carles etsy
                    salvia banksy hoodie helvetica. DIY synth PBR banksy irony.
                    Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh
                    mi whatever gluten-free, carles pitchfork biodiesel fixie etsy
                    retro mlkshk vice blog. Scenester cred you probably haven't
                    heard of them, vinyl craft beer blog stumptown. Pitchfork
                    sustainable tofu synth chambray yr.</p>
            </div>
            <div class="tab-pane fade" id="tab-4">
                <p>Trust fund seitan letterpress, keytar raw denim keffiyeh
                    etsy art party before they sold out master cleanse gluten-free
                    squid scenester freegan cosby sweater. Fanny pack portland
                    seitan DIY, art party locavore wolf cliche high life echo park
                    Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they
                    sold out farm-to-table VHS viral locavore cosby sweater. Lomo
                    wolf viral, mustache readymade thundercats keffiyeh craft beer
                    marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park
                    vegan.</p>
            </div>
        </div>
    </div>
    <!-- END TABS -->

    <!-- TESTIMONIALS -->
    <div class="col-md-5 testimonials-v1">
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
                        <img class="pull-left"
                             src="frontend_assets/img/people/zhao.png" alt=""/>

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
                             alt=""/>

                        <div class="pull-left">
                            <span class="testimonials-name">CoderMan</span> <span
                                class="testimonials-post">Java Engineer</span>
                        </div>
                    </div>
                </div>
                <div class="item">
								<span class="testimonials-slide">Reprehenderit butcher
									stache cliche tempor, williamsburg carles vegan helvetica.retro
									keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui
									irure terry richardson ex squid Aliquip placeat salvia cillum
									iphone.</span>

                    <div class="carousel-info">
                        <img class="pull-left" src="frontend_assets/img/people/wei.png"
                             alt=""/>

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
</div>
<!-- END TABS AND TESTIMONIALS -->

<!-- BEGIN STEPS -->
<div class="row no-space-steps margin-bottom-40">
    <div class="col-md-4 col-sm-4">
        <div class="front-steps front-step-one">
            <h2>Goal definition</h2>

            <p>确认具体目标，了解需求定位</p>
        </div>
    </div>
    <div class="col-md-4 col-sm-4">
        <div class="front-steps front-step-two">
            <h2>Analyse</h2>

            <p>分析具体问题，抽象分化模块</p>
        </div>
    </div>
    <div class="col-md-4 col-sm-4">
        <div class="front-steps front-step-three">
            <h2>Implementation</h2>

            <p>设计实施实现，优化完善产品</p>
        </div>
    </div>
</div>
<!-- END STEPS -->

</div>
<!-- END CONTAINER -->
</div>
<!-- END PAGE CONTAINER -->
<jsp:include page="template/template_footer.jsp"/>

</body>
<jsp:include page="template/template_script.jsp"/>

</html>
