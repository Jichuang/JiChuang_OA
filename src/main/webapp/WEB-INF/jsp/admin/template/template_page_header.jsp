<%@page import="org.jichuang.hope6537.base.model.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    Member member = (Member) session.getAttribute("loginMember");
    if (member == null) {
        response.sendRedirect("../page/login.hopedo");
    }
%>
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="header-inner">
        <!-- BEGIN LOGO -->
        <a class="navbar-brand" href="page/index.hopedo"> <img
                src="admin_assets/img/logo2.png" alt="logo" class="img-responsive"/>
        </a>
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
           data-target=".navbar-collapse"> <img
                src="admin_assets/img/menu-toggler.png" alt=""/>
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <ul class="nav navbar-nav pull-right">
            <!-- BEGIN NOTIFICATION DROPDOWN -->
            <li class="dropdown" id="header_notification_bar"><a href="#"
                                                                 class="dropdown-toggle" data-toggle="dropdown"
                                                                 data-hover="dropdown"
                                                                 data-close-others="true"> <i
                    class="icon-warning-sign"></i> <span
                    class="badge">1</span>
            </a>
                <ul class="dropdown-menu extended notification">
                    <li>
                        <p>你现在有1条新推送</p>
                    </li>
                    <li>
                        <ul class="dropdown-menu-list scroller" style="height: 100px;">
                            <li><a href="#"> <span
                                    class="label label-sm label-icon label-info"><i
                                    class="icon-bullhorn"></i></span> Application error. <span
                                    class="time">40 mins</span>
                            </a></li>

                        </ul>
                    </li>
                    <li class="external"><a href="#">查看所有的通知<i
                            class="m-icon-swapright"></i></a></li>
                </ul>
            </li>
            <!-- END NOTIFICATION DROPDOWN -->
            <!-- 私信开始 -->
            <li class="dropdown" id="header_inbox_bar"><a href="#"
                                                          class="dropdown-toggle" data-toggle="dropdown"
                                                          data-hover="dropdown"
                                                          data-close-others="true"> <i class="icon-envelope"></i> <span
                    class="badge">1</span>
            </a>
                <ul class="dropdown-menu extended inbox">
                    <li>
                        <p>你有1条新私信</p>
                    </li>
                    <li>
                        <ul class="dropdown-menu-list scroller" style="height: 250px;">
                            <li><a href="inbox.html?a=view"> <span class="photo"><img
                                    src="./admin_assets/img/avatar3.jpg" alt=""/></span> <span
                                    class="subject"> <span class="from">Richard Doe</span> <span
                                    class="time">46 mins</span>
								</span> <span class="message"> Vivamus sed congue nibh auctor
										nibh congue nibh. auctor nibh auctor nibh... </span>
                            </a></li>
                        </ul>
                    </li>
                    <li class="external"><a href="inbox.html">See all messages
                        <i class="m-icon-swapright"></i>
                    </a></li>
                </ul>
            </li>
            <!-- 私信结束 -->
            <!-- 任务开始 -->
            <li class="dropdown" id="header_task_bar"><a href="#"
                                                         class="dropdown-toggle" data-toggle="dropdown"
                                                         data-hover="dropdown"
                                                         data-close-others="true"> <i class="icon-tasks"></i> <span
                    class="badge">1</span>
            </a>
                <ul class="dropdown-menu extended tasks">
                    <li>
                        <p>你有1个新任务</p>
                    </li>
                    <li>
                        <ul class="dropdown-menu-list scroller" style="height: 250px;">
                            <li><a href="#"> <span class="task"> <span
                                    class="desc">New UI release</span> <span class="percent">18%</span>
								</span> <span class="progress progress-striped"> <span
                                    style="width: 18%;"
                                    class="progress-bar progress-bar-important" aria-valuenow="18"
                                    aria-valuemin="0" aria-valuemax="100"> <span
                                    class="sr-only">18% Complete</span>
									</span>
								</span>
                            </a></li>
                        </ul>
                    </li>
                    <li class="external"><a href="#">See all tasks <i
                            class="m-icon-swapright"></i></a></li>
                </ul>
            </li>
            <!-- 任务结束 -->
            <!-- 用户登录信息 -->
            <li class="dropdown user"><a href="#" class="dropdown-toggle"
                                         data-toggle="dropdown" data-hover="dropdown"
                                         data-close-others="true"> <img alt=""
                                                                        src="admin_assets/img/avatar1_small.jpg"/> <span
                    class="username">
						<%=null == member ? null : member.getName()%>
				</span> <i class="icon-angle-down"></i>
            </a>
                <ul class="dropdown-menu">
                    <li><a href="extra_profile.html"><i class="icon-user"></i>
                        我的账户信息</a></li>
                    <li><a href="page_calendar.html"><i class="icon-calendar"></i>
                        我的工作日历</a></li>
                    <li><a href="inbox.html"><i class="icon-envelope"></i>
                        我的信息盒子<span class="badge badge-danger">1</span></a></li>
                    <li><a href="#"><i class="icon-tasks"></i> 我的任务集合<span
                            class="badge badge-success">1</span></a></li>
                    <li class="divider"></li>
                    <li><a href="javascript:;" id="trigger_fullscreen"><i
                            class="icon-move"></i> 全屏幕</a></li>
                    <li><a href="extra_lock.html"><i class="icon-lock"></i> 锁屏</a></li>
                    <li><a href="member/logout.hopedo"><i class="icon-key"></i> 登出</a></li>
                </ul>
            </li>
            <!-- 用户登录信息结束 -->
        </ul>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
