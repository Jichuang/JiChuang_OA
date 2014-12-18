<%@page import="org.jichuang.hope6537.blog.model.Blog" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="org.jichuang.hope6537.base.model.Member" %>
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
	/* List<Blog> blogList = (List<Blog>) request.getAttribute("blogList"); */
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
                    博客维护
                    <small>Blog Config</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="blog/toAddBlog.hopedo"><i
                                    class="icon-edit"></i>添加新博客</a></li>
                            <li><a href="javascript:;" id="reload"><i
                                    class="icon-refresh"></i>刷新博客信息</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">博客维护</a></li>
                </ul>
                <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
        </div>
        <!-- 页面内容头结束 -->
        <!-- 页面正文-->
        <div class="row">
            <div class="col-md-12">

                <!-- BEGIN EXAMPLE TABLE PORTLET-->
                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-globe"></i>Blog Configration
                        </div>
                        <div class="tools">
                            <a href="javascript:;" class="remove"></a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <table class="table table-striped table-bordered table-hover"
                               id="datatable">
                            <thead>
                            <tr>
                                <th>博客标题</th>
                                <th>博客内容概要</th>
                                <th>博客创建日期</th>
                                <th>博客状态</th>
                                <th>编辑博客</th>
                                <th>删除博客</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- END EXAMPLE TABLE PORTLET-->
            </div>
        </div>
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
<script type="text/javascript" src="admin_assets/js/blog/blogconf.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#blogLi").attr("class", "active");
        BlogTable.init();
    });
</script>
<!-- Js核心脚本结束 -->
</html>
