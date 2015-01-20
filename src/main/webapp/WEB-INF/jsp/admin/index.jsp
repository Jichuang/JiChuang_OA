<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="template/template_page_head.jsp" %>
    <title>欢迎进入OA后台系统</title>
    <!-- head的include区 结束  -->
</head>
<body class="page-header-fixed page-footer-fixed">


<jsp:include page="template/template_page_header.jsp" flush="true"/>

<div class="page-container">

    <jsp:include page="template/template_page_sidebar.jsp" flush="true"/>

    <!--========================页面开始处======================== -->
    <div class="page-content">
        <jsp:include page="template/template_page_modal.jsp" flush="true"/>
        <jsp:include page="template/template_page_style.jsp" flush="true"/>

        <div class="row">
            <div class="col-md-12">

                <h3 class="page-title">
                    早上好！
                    <small>WelCome To OA!</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="pull-right">
                        <div id="dashboard-report-range"
                             class="dashboard-date-range tooltips" data-placement="top"
                             data-original-title="Change dashboard date range">
                            <i class="icon-calendar"></i> <span></span> <i
                                class="icon-angle-down"></i>
                        </div>
                    </li>
                    <li><i class="icon-home"></i> <a href="index.html">主页</a> <i
                            class="icon-angle-right"></i></li>
                    <li><a href="#">欢迎界面</a> <i class="icon-angle-right"></i></li>
                </ul>

            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="dashboard-stat blue">
                    <div class="visual">
                        <i class="icon-comments"></i>
                    </div>
                    <div class="details">
                        <div class="number">12</div>
                        <div class="desc">您收到的新私信</div>
                    </div>
                    <a class="more" href="#"> 查看详情 <i
                            class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="dashboard-stat green">
                    <div class="visual">
                        <i class="icon-pushpin"></i>
                    </div>
                    <div class="details">
                        <div class="number">15</div>
                        <div class="desc">您所需要完成的任务</div>
                    </div>
                    <a class="more" href="#"> View more <i
                            class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="dashboard-stat purple">
                    <div class="visual">
                        <i class="icon-globe"></i>
                    </div>
                    <div class="details">
                        <div class="number">20</div>
                        <div class="desc">您所收到的新通知</div>
                    </div>
                    <a class="more" href="#"> View more <i
                            class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="dashboard-stat yellow">
                    <div class="visual">
                        <i class="icon-bar-chart"></i>
                    </div>
                    <div class="details">
                        <div class="number">4</div>
                        <div class="desc">您现在的审批事项</div>
                    </div>
                    <a class="more" href="#"> View more <i
                            class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="col-md-6 col-sm-6">
                <div class="portlet box blue">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-bell"></i>集创最新动态
                        </div>
                        <div class="actions">
                            <div class="btn-group">
                                <a class="btn btn-sm default" href="#" data-toggle="dropdown"
                                   data-hover="dropdown" data-close-others="true"> 根据事项类型进行过滤
                                    <i class="icon-angle-down"></i>
                                </a>

                                <div
                                        class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
                                    <label><input type="checkbox"/> 集创通知</label> <label><input
                                        type="checkbox" checked=""/> 项目组动态</label> <label><input
                                        type="checkbox"/> 朋友动态</label> <label><input
                                        type="checkbox" checked=""/> 活动动态</label> <label><input
                                        type="checkbox"/> 系统通知</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="scroller" style="height: 300px;"
                             data-always-visible="1" data-rail-visible="0">
                            <ul class="feeds">
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-info">
                                                    <i class="icon-check"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    您有四项紧急事项 <span class="label label-sm label-warning ">
															赶紧去查看 <i class="icon-share-alt"></i>
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">刚刚</div>
                                    </div>
                                </li>
                                <li><a href="#">
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-success">
                                                    <i class="icon-bar-chart"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">您的好友法克儿刚刚发布了一篇博文</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">20 mins</div>
                                    </div>
                                </a></li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-danger">
                                                    <i class="icon-user"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">You have 5 pending membership that
                                                    requires a quick review.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">24 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-info">
                                                    <i class="icon-shopping-cart"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    New order received with <span
                                                        class="label label-sm label-success">Reference
															Number: DR23923</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">30 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-success">
                                                    <i class="icon-user"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">You have 5 pending membership that
                                                    requires a quick review.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">24 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-default">
                                                    <i class="icon-bell-alt"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    Web server hardware needs to be upgraded. <span
                                                        class="label label-sm label-default ">Overdue</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">2 hours</div>
                                    </div>
                                </li>
                                <li><a href="#">
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-default">
                                                    <i class="icon-briefcase"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">IPO Report for year 2013 has been
                                                    released.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">20 mins</div>
                                    </div>
                                </a></li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-info">
                                                    <i class="icon-check"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    You have 4 pending tasks. <span
                                                        class="label label-sm label-warning "> Take action
															<i class="icon-share-alt"></i>
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">Just now</div>
                                    </div>
                                </li>
                                <li><a href="#">
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-danger">
                                                    <i class="icon-bar-chart"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">Finance Report for year 2013 has
                                                    been released.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">20 mins</div>
                                    </div>
                                </a></li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-default">
                                                    <i class="icon-user"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">You have 5 pending membership that
                                                    requires a quick review.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">24 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-info">
                                                    <i class="icon-shopping-cart"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    New order received with <span
                                                        class="label label-sm label-success">Reference
															Number: DR23923</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">30 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-success">
                                                    <i class="icon-user"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">You have 5 pending membership that
                                                    requires a quick review.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">24 mins</div>
                                    </div>
                                </li>
                                <li>
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-warning">
                                                    <i class="icon-bell-alt"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">
                                                    Web server hardware needs to be upgraded. <span
                                                        class="label label-sm label-default ">Overdue</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">2 hours</div>
                                    </div>
                                </li>
                                <li><a href="#">
                                    <div class="col1">
                                        <div class="cont">
                                            <div class="cont-col1">
                                                <div class="label label-sm label-info">
                                                    <i class="icon-briefcase"></i>
                                                </div>
                                            </div>
                                            <div class="cont-col2">
                                                <div class="desc">IPO Report for year 2013 has been
                                                    released.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col2">
                                        <div class="date">20 mins</div>
                                    </div>
                                </a></li>
                            </ul>
                        </div>
                        <div class="scroller-footer">
                            <div class="pull-right">
                                <a href="#">See All Records <i
                                        class="m-icon-swapright m-icon-gray"></i></a> &nbsp;
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 下面是任务栏 -->
            <div class="col-md-6 col-sm-6">
                <div class="portlet box green tasks-widget">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-check"></i>团队&个人最新任务
                        </div>
                        <div class="tools">
                            <a href="#portlet-config" data-toggle="modal" class="config"></a>
                            <a href="" class="reload"></a>
                        </div>
                        <div class="actions">
                            <div class="btn-group">
                                <a class="btn default btn-xs" href="#" data-toggle="dropdown"
                                   data-hover="dropdown" data-close-others="true"> More <i
                                        class="icon-angle-down"></i>
                                </a>
                                <ul class="dropdown-menu pull-right">
                                    <li><a href="#"><i class="i"></i>全部任务</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">只看个人任务</a></li>
                                    <li><a href="#">只看团队任务</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="task-content">
                            <div class="scroller" style="height: 305px;"
                                 data-always-visible="1" data-rail-visible1="1">
                                <!-- START TASK LIST -->
                                <ul class="task-list">
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
                                            <span class="task-title-sp">爱我操赶紧的要死啦！</span> <span
                                                class="label label-sm label-success">第一项目组</span> <span
                                                class="task-bell"><i class="icon-bell"></i></span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a href="www.baidu.com"
                                                   class="label label-sm label-warning "> 查看详情 <i
                                                        class="icon-share-alt"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">Hold An Interview for
													Marketing Manager Position</span> <span
                                                class="label label-sm label-danger">Marketing</span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"> <i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">AirAsia Intranet System
													Project Internal Meeting</span> <span
                                                class="label label-sm label-success">AirAsia</span> <span
                                                class="task-bell"><i class="icon-bell"></i></span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"> <i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">Technical Management
													Meeting</span> <span
                                                class="label label-sm label-warning">Company</span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">Kick-off Company CRM
													Mobile App Development</span> <span
                                                class="label label-sm label-info">Internal Products</span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp"> Prepare Commercial Offer
													For SmartVision Website Rewamp </span> <span
                                                class="label label-sm label-danger">SmartVision</span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">Sign-Off The Comercial
													Agreement With AutoSmart</span> <span
                                                class="label label-sm label-default">AutoSmart</span> <span
                                                class="task-bell"><i class="icon-bell"></i></span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
                                            <span class="task-title-sp">Company Staff Meeting</span> <span
                                                class="label label-sm label-success">Cruise</span> <span
                                                class="task-bell"><i class="icon-bell"></i></span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="last-line">
                                        <div class="task-checkbox">
                                            <input type="checkbox" class="liChild" value=""/>
                                        </div>
                                        <div class="task-title">
												<span class="task-title-sp">KeenThemes Investment
													Discussion</span> <span class="label label-sm label-warning">KeenThemes</span>
                                        </div>
                                        <div class="task-config">
                                            <div class="task-config-btn btn-group">
                                                <a class="btn btn-xs default" href="#"
                                                   data-toggle="dropdown" data-hover="dropdown"
                                                   data-close-others="true"><i class="icon-cog"></i><i
                                                        class="icon-angle-down"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="#"><i class="icon-ok"></i> Complete</a></li>
                                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                    <li><a href="#"><i class="icon-trash"></i> Cancel</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <!-- END START TASK LIST -->
                            </div>
                        </div>
                        <div class="task-footer">
								<span class="pull-right"> <a href="#">See All Tasks <i
                                        class="m-icon-swapright m-icon-gray"></i></a> &nbsp;
								</span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Status1 -->
            <div class="col-md-6 col-sm-6">
                <div class="portlet box purple">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-calendar"></i>个人工作情况
                        </div>
                        <div class="actions">
                            <a href="javascript:;"
                               class="btn btn-sm yellow easy-pie-chart-reload"><i
                                    class="icon-repeat"></i> 重新载入</a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="easy-pie-chart">
                                    <div class="number transactions" data-percent="55">
                                        <span>↑55</span>
                                    </div>
                                    <a class="title" href="#">社区活跃度 <i
                                            class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                            <div class="margin-bottom-10 visible-sm"></div>
                            <div class="col-md-4">
                                <div class="easy-pie-chart">
                                    <div class="number visits" data-percent="84">
                                        <span>12/17</span>
                                    </div>
                                    <a class="title" href="#">预期任务完成度 <i
                                            class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                            <div class="margin-bottom-10 visible-sm"></div>
                            <div class="col-md-4">
                                <div class="easy-pie-chart">
                                    <div class="number bounce" data-percent="22">
                                        <span>22</span>%
                                    </div>
                                    <a class="title" href="#">绩效评价<i class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Status2 -->
            <div class="col-md-6 col-sm-6">
                <div class="portlet box blue">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-calendar"></i>团队工作情况
                        </div>
                        <div class="tools">
                            <a href="" class="collapse"></a> <a href="#portlet-config"
                                                                data-toggle="modal" class="config"></a> <a href=""
                                                                                                           class="reload"></a>
                            <a
                                    href="" class="remove"></a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="sparkline-chart">
                                    <div class="number" id="sparkline_bar"></div>
                                    <a class="title" href="#">Network <i
                                            class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                            <div class="margin-bottom-10 visible-sm"></div>
                            <div class="col-md-4">
                                <div class="sparkline-chart">
                                    <div class="number" id="sparkline_bar2"></div>
                                    <a class="title" href="#">CPU Load <i
                                            class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                            <div class="margin-bottom-10 visible-sm"></div>
                            <div class="col-md-4">
                                <div class="sparkline-chart">
                                    <div class="number" id="sparkline_line"></div>
                                    <a class="title" href="#">Load Rate <i
                                            class="m-icon-swapright"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- 页面内容头结束 -->
        <!-- 页面正文-->
        <div class="row">
            <div class="col-md-12">到静安寺肯德基阿斯科利</div>
        </div>
        <!-- 页面正文结束-->
    </div>
    <!-- ======================== 页面结束处======================== -->
</div>
<%@include file="template/template_page_footer.jsp" %>

</body>

<%@include file="template/template_page_javascript.jsp" %>
<script type="text/javascript">
    $(document).on("ready", function () {
        $("#indexLi").attr("class", "active");
    });
</script>

<!-- djhaskdaskdh -->
</html>
