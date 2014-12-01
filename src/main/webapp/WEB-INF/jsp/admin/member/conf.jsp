<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="org.jichuang.hope6537.base.model.Member" %>
<%@ page import="org.jichuang.hope6537.utils.InfoUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    Member member = (Member) session.getAttribute("loginMember");
    if (member == null) {
        response.sendRedirect("../page/login.hopedo");
    }
    Map<String, List<String>> memberInfos = InfoUtils.getInfoMap(member.getQa());
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- head的include区 -->
    <jsp:include page="../template/template_page_head.jsp" flush="true"/>

    <title>博客维护</title>
    <!-- head的include区 结束  -->
</head>
<body class="page-header-fixed page-footer-fixed">
<!-- 头部顶端菜单栏开始 -->
<jsp:include page="../template/template_page_header.jsp" flush="true"/>
<!-- 头部顶端菜单栏结束 -->
<div class="page-container">
<!-- 侧面菜单栏开始 -->
<jsp:include page="../template/template_page_sidebar.jsp" flush="true"/>
<!-- 侧面菜单栏结束 -->
<!--========================页面开始处======================== -->
<div class="page-content">
<jsp:include page="../template/template_page_modal.jsp" flush="true"/>
<jsp:include page="../template/template_page_style.jsp" flush="true"/>
<!-- 页面内容头开始 修改之-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title">
            个人信息
            <small>Member Profile</small>
        </h3>
        <ul class="page-breadcrumb breadcrumb">
            <li class="btn-group">
                <button type="button" class="btn blue dropdown-toggle"
                        data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                        data-close-others="true">
                    <span>动作</span> <i class="icon-angle-down"></i>
                </button>
                <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="javascript:;" id="reload"><i
                            class="icon-refresh"></i>刷新个人信息</a></li>
                </ul>
            </li>
            <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                <i class="icon-angle-right"></i></li>
            <li><a href="javascript:;">维护个人信息</a></li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- 页面内容头结束 -->
<!-- 页面正文-->
<!-- BEGIN PAGE CONTENT-->
<div class="row profile">
<div class="col-md-12">
<!--BEGIN TABS-->
<div class="tabbable tabbable-custom tabbable-full-width">
<ul class="nav nav-tabs">
    <li class="active"><a href="#tab_1_1" data-toggle="tab">信息总览</a></li>
    <li><a href="#tab_1_3" data-toggle="tab">账号设置</a></li>
    <li><a href="#tab_1_4" data-toggle="tab">项目组信息</a></li>
    <li><a href="#tab_1_6" data-toggle="tab">FAQ</a></li>
</ul>
<div class="tab-content">
<div class="tab-pane active" id="tab_1_1">
<div class="row">
<div class="col-md-3">
    <ul class="list-unstyled profile-nav">
        <li><img src="frontend_assets/img/people/zhao.png" class="img-responsive" alt=""/>
            <a href="#" class="profile-edit">编辑头像</a>
        </li>
        <li><a href="#">查看参与项目组</a></li>
        <li><a href="#">查看个人文件树</a></li>
        <li><a href="<%=basePath%>/blog/conf.hopedo">查看博客信息</a></li>
    </ul>
</div>
<div class="col-md-9">
<div class="row">
    <div class="col-md-8 profile-info">
        <h1>赵鹏
            <small>Hope6537</small>
        </h1>
        <p>
            以Java开发为主 具有3年Java开发经验 擅长Web、Android应用开发
            研究基于Hadoop的数据分析
        </p>

        <p><a href="#">www.hope6537.org</a></p>
        <ul class="list-inline">
            <li><i class="icon-map-marker"></i> 中国</li>
            <li><i class="icon-calendar"></i> 1994-08-24</li>
            <li><i class="icon-briefcase"></i> Java Engineer</li>
            <li><i class="icon-star"></i> Founder</li>
        </ul>
    </div>
    <!--end col-md-8-->
    <div class="col-md-4">
        <div class="portlet sale-summary">
            <div class="portlet-title">
                <div class="caption">权限信息</div>
                <div class="tools">
                    <a class="reload" href="javascript:;"></a>
                </div>
            </div>
            <div class="portlet-body">
                <ul class="list-unstyled">
                    <li>
                        <span class="sale-info">目前职位 </span>
                        <span class="sale-num">Java Engineer</span>
                    </li>
                    <li>
                        <span class="sale-info">所属组别  </span>
                        <span class="sale-num">Administrator</span>
                    </li>
                    <li>
                        <span class="sale-info">账户状态</span>
                        <span class="sale-num">正常</span>
                    </li>
                    <li>
                        <a class="btn btn-block red" style="margin-top: 20px;" href="member/logout.hopedo"><i
                                class="icon-arrow-left"></i>退出登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--end col-md-4-->
</div>
<!--end row-->
<div class="tabbable tabbable-custom tabbable-custom-profile">
<ul class="nav nav-tabs">
    <li class="active"><a href="#tab_1_11" data-toggle="tab">私信信息</a></li>
    <li><a href="#tab_1_22" data-toggle="tab">任务信息</a></li>
</ul>
<div class="tab-content">
<div class="tab-pane active" id="tab_1_11">
    <div class="portlet-body">
        <table class="table table-striped table-bordered table-advance table-hover">
            <thead>
            <tr>
                <th><i class="icon-briefcase"></i> 私信标题</th>
                <th class="hidden-xs"><i class="icon-question-sign"></i> 发起人</th>
                <th><i class="icon-bookmark"></i> 发送时间</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><a href="#">哎呀夭寿啦！Q老师更新了！</a></td>
                <td class="hidden-xs">AC基佬</td>
                <td>2014-12-1 19:42:10</td>
                <td><a class="btn default btn-xs green-stripe" href="#">点击查看细节</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<!--tab-pane-->
<div class="tab-pane" id="tab_1_22">
<div class="tab-pane active" id="tab_1_1_1">
<div class="scroller" data-height="290px" data-always-visible="1" data-rail-visible1="1">
<ul class="feeds">
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-success">
                    <i class="icon-bell"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    You have 4 pending tasks.
                                                               <span class="label label-danger label-sm">
                                                               Take action
                                                               <i class="icon-share-alt"></i>
                                                               </span>
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            Just now
        </div>
    </div>
</li>
<li>
    <a href="#">
        <div class="col1">
            <div class="cont">
                <div class="cont-col1">
                    <div class="label label-success">
                        <i class="icon-bell"></i>
                    </div>
                </div>
                <div class="cont-col2">
                    <div class="desc">
                        New version v1.4 just lunched!
                    </div>
                </div>
            </div>
        </div>
        <div class="col2">
            <div class="date">
                20 mins
            </div>
        </div>
    </a>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-danger">
                    <i class="icon-bolt"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    Database server #12 overloaded. Please fix the issue.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            24 mins
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            30 mins
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-success">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            40 mins
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-warning">
                    <i class="icon-plus"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New user registered.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            1.5 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-success">
                    <i class="icon-bell-alt"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    Web server hardware needs to be upgraded.
                    <span class="label label-inverse label-sm">Overdue</span>
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            2 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-default">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            3 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-warning">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            5 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            18 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-default">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            21 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            22 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-default">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            21 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            22 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-default">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            21 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            22 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-default">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            21 hours
        </div>
    </div>
</li>
<li>
    <div class="col1">
        <div class="cont">
            <div class="cont-col1">
                <div class="label label-info">
                    <i class="icon-bullhorn"></i>
                </div>
            </div>
            <div class="cont-col2">
                <div class="desc">
                    New order received. Please take care of it.
                </div>
            </div>
        </div>
    </div>
    <div class="col2">
        <div class="date">
            22 hours
        </div>
    </div>
</li>
</ul>
</div>
</div>
</div>
<!--tab-pane-->
</div>
</div>
</div>
</div>
</div>
<!--tab_1_2-->
<div class="tab-pane" id="tab_1_3">
    <div class="row profile-account">
        <div class="col-md-3">
            <ul class="ver-inline-menu tabbable margin-bottom-10">
                <li class="active">
                    <a data-toggle="tab" href="#tab_1-1">
                        <i class="icon-cog"></i>
                        个人信息维护
                    </a>
                    <span class="after"></span>
                </li>
                <li><a data-toggle="tab" href="#tab_2-2"><i class="icon-picture"></i> 变更头像</a></li>
                <li><a data-toggle="tab" href="#tab_3-3"><i class="icon-lock"></i> 更换密码</a></li>
                <li><a data-toggle="tab" href="#tab_4-4"><i class="icon-eye-open"></i> 隐私设置</a></li>
            </ul>
        </div>
        <div class="col-md-9">
            <div class="tab-content">
                <div id="tab_1-1" class="tab-pane active">
                    <form role="form" action="#">
                        <div class="form-group">
                            <label class="control-label">姓名</label>
                            <input type="text" value="赵鹏" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">电话号码</label>
                            <input type="text" value="18686602599" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">性别</label>
                            <select class="form-control">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="control-label">简短介绍
                                <small>50字左右</small>
                            </label>
                            <textarea class="form-control" rows="3">
                            </textarea>
                        </div>
                        <div class="form-group">
                            <label class="control-label">个人简介</label>
                            <textarea class="ckeditor form-control" name="content" id="content" rows="200" cols="50"
                                      style="visibility: hidden; display: none;"></textarea>
                        </div>
                        <div class="margiv-top-10">
                            <a href="#" class="btn green">保存更改</a>
                        </div>
                    </form>
                </div>
                <div id="tab_2-2" class="tab-pane">
                    <p>请根据下面图像选择框选择头像，要求尽量是4:3的宽高比，同时大小不大于2048KB</p>

                    <form action="#" role="form">
                        <div class="form-group">
                            <div class="thumbnail" style="width: 310px;">
                                <img src="http://www.placehold.it/310x170/EFEFEF/AAAAAA&amp;text=no+image" alt="">
                            </div>
                            <div class="margin-top-10 fileupload fileupload-new" data-provides="fileupload">
                                <div class="input-group input-group-fixed">
                                                <span class="input-group-btn">
                                                <span class="uneditable-input">
                                                <i class="icon-file fileupload-exists"></i>
                                                <span class="fileupload-preview"></span>
                                                </span>
                                                </span>
                                                <span class="btn default btn-file">
                                                <span class="fileupload-new"><i class="icon-paper-clip"></i> Select file</span>
                                                <span class="fileupload-exists"><i class="icon-undo"></i> Change</span>
                                                <input type="file" class="default"/>
                                                </span>
                                    <a href="#" class="btn red fileupload-exists" data-dismiss="fileupload"><i
                                            class="icon-trash"></i> Remove</a>
                                </div>
                            </div>
                            <span class="label label-danger">注意!</span>
                                          <span>
                                         图像预览功能只在一下浏览器中可用 Firefox, Chrome, Opera,
                                          Safari 和 Internet Explorer 10及以上版本
                                          </span>
                        </div>
                        <div class="margin-top-10">
                            <a href="#" class="btn green">提交新头像</a>
                        </div>
                    </form>
                </div>
                <div id="tab_3-3" class="tab-pane">
                    <form action="#">
                        <div class="form-group">
                            <label class="control-label">当前账户密码</label>
                            <input type="password" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">新密码</label>
                            <input type="password" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">重新输入新密码</label>
                            <input type="password" class="form-control"/>
                        </div>
                        <div class="margin-top-10">
                            <a href="#" class="btn green">更改账户密码</a>
                        </div>
                    </form>
                </div>
                <div id="tab_4-4" class="tab-pane">
                    <form action="#" class="">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <td>
                                    接收每日推送？
                                </td>
                                <td>
                                    <label class="uniform-inline">
                                        <input type="radio" name="optionsRadios1" value="option1"/>
                                        是
                                    </label>
                                    <label class="uniform-inline">
                                        <input type="radio" name="optionsRadios1" value="option2" checked/>
                                        否
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    是否取消私信功能？
                                </td>
                                <td>
                                    <label class="uniform-inline">
                                        <input type="checkbox" value=""/> 是
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    是否取消通知功能？
                                </td>
                                <td>
                                    <label class="uniform-inline">
                                        <input type="checkbox" value=""/> 是
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    是否拒绝接受任务？
                                </td>
                                <td>
                                    <label class="uniform-inline">
                                        <input type="checkbox" value=""/> 是
                                    </label>
                                </td>
                            </tr>
                        </table>
                        <!--end profile-settings-->
                        <div class="margin-top-10">
                            <a href="#" class="btn green">保存个人偏好更改</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--end col-md-9-->
    </div>
</div>
<!--end tab-pane-->
<div class="tab-pane" id="tab_1_4">
    <div class="row">
        <div class="col-md-12">
            <div class="add-portfolio">
                <span>这里显示的是该账户当前所参加的项目组信息，具体细节请点击进入到项目组页面进行查看</span>
                <a href="#" class="btn icn-only green">查看所有项目组<i
                        class="m-icon-swapright m-icon-white"></i></a>
            </div>
        </div>
    </div>
    <!--end add-portfolio-->
    <div class="row portfolio-block">
        <div class="col-md-5">
            <div class="portfolio-text">
                <img src="admin_assets/img/profile/portfolio/logo_metronic.jpg" alt=""/>

                <div class="portfolio-text-info">
                    <h4>JiChuang_OA项目组</h4>

                    <p>组长：Hope6537进行主导开发</p>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <div class="portfolio-info">
                项目组创建时间
                <span>187天</span>
            </div>
            <div class="portfolio-info">
                项目组人数
                <span>1789</span>
            </div>
            <div class="portfolio-info">
                项目组工作进度
                <span>72%</span>
            </div>
            <div class="portfolio-info">
                项目组状态
                <span>开发中</span>
            </div>
        </div>
        <div class="col-md-2">
            <div class="portfolio-btn">
                <a href="#" class="btn bigicn-only"><span>查看工程细节</span></a>
            </div>
        </div>
    </div>
    <!--end row-->
</div>
<!--end tab-pane-->
<div class="tab-pane" id="tab_1_6">
<div class="row">
<div class="col-md-3">
    <ul class="ver-inline-menu tabbable margin-bottom-10">
        <li class="active">
            <a data-toggle="tab" href="#tab_1">
                <i class="icon-briefcase"></i>
                General Questions
            </a>
            <span class="after"></span>
        </li>
        <li><a data-toggle="tab" href="#tab_2"><i class="icon-group"></i> Membership</a></li>
        <li><a data-toggle="tab" href="#tab_3"><i class="icon-leaf"></i> Terms Of Service</a></li>
        <li><a data-toggle="tab" href="#tab_1"><i class="icon-info-sign"></i> License Terms</a></li>
        <li><a data-toggle="tab" href="#tab_2"><i class="icon-tint"></i> Payment Rules</a></li>
        <li><a data-toggle="tab" href="#tab_3"><i class="icon-plus"></i> Other Questions</a></li>
    </ul>
</div>
<div class="col-md-9">
<div class="tab-content">
<div id="tab_1" class="tab-pane active">
    <div id="accordion1" class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_1">
                        1. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_1" class="panel-collapse collapse  in">
                <div class="panel-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_2">
                        2. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_2" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_3">
                        3. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_3" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_4">
                        4. Wolf moon officia aute, non cupidatat skateboard dolor brunch ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_4" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-danger">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_5">
                        5. Leggings occaecat craft beer farm-to-table, raw denim aesthetic ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_5" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_6">
                        6. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_6" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#accordion1_7">
                        7. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft ?
                    </a>
                </h4>
            </div>
            <div id="accordion1_7" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
    </div>
</div>
<div id="tab_2" class="tab-pane">
    <div id="accordion2" class="panel-group">
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_1">
                        1. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_1" class="panel-collapse collapse  in">
                <div class="panel-body">
                    <p>
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                        laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                        coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes
                        anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings
                        occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard
                        of them accusamus labore sustainable VHS.
                    </p>

                    <p>
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                        laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                        coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes
                        anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings
                        occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard
                        of them accusamus labore sustainable VHS.
                    </p>
                </div>
            </div>
        </div>
        <div class="panel panel-danger">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_2">
                        2. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_2" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_3">
                        3. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_3" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_4">
                        4. Wolf moon officia aute, non cupidatat skateboard dolor brunch ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_4" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_5">
                        5. Leggings occaecat craft beer farm-to-table, raw denim aesthetic ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_5" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_6">
                        6. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_6" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#accordion2_7">
                        7. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft ?
                    </a>
                </h4>
            </div>
            <div id="accordion2_7" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
    </div>
</div>
<div id="tab_3" class="tab-pane">
    <div id="accordion3" class="panel-group">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_1">
                        1. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_1" class="panel-collapse collapse  in">
                <div class="panel-body">
                    <p>
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                        laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                        coffee nulla assumenda shoreditch et.
                    </p>

                    <p>
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                        laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                        coffee nulla assumenda shoreditch et.
                    </p>

                    <p>
                        Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on
                        it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
                        craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
                        vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                        probably haven't heard of them accusamus labore sustainable VHS.
                    </p>
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_2">
                        2. Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_2" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_3">
                        3. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_3" class="panel-collapse collapse">
                <div class="panel-body">
                    Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it
                    squid single-origin coffee nulla assumenda shoreditch et.
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_4">
                        4. Wolf moon officia aute, non cupidatat skateboard dolor brunch ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_4" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_5">
                        5. Leggings occaecat craft beer farm-to-table, raw denim aesthetic ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_5" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_6">
                        6. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_6" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#accordion3_7">
                        7. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft ?
                    </a>
                </h4>
            </div>
            <div id="accordion3_7" class="panel-collapse collapse">
                <div class="panel-body">
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
</div>
<!--end tab-pane-->
</div>
</div>
<!--END TABS-->
</div>
</div>
<!-- END PAGE CONTENT-->


<!-- 页面正文结束-->
<span id="tar"></span>
</div>
<!-- ======================== 页面结束处======================== -->
</div>
<!-- 页面尾端include  -->
<%@include file="../template/template_page_footer.jsp" %>
<!-- 页面尾端include 结束  -->
</body>
<!-- Js核心脚本 -->
<%@include file="../template/template_page_javascript.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {

        $("#reload").trigger("click");
        $("#blogLi").attr("class", "active");
    });
</script>
<!-- Js核心脚本结束 -->
</html>
