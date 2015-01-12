<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String blogItemId = (String) request.getAttribute("blogItemId");

%>


<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>博客正文 | 集创团队</title>
    <jsp:include page="template/template_head.jsp"/>
</head>
<body>
<jsp:include page="template/template_header.jsp"/>
<!--
    内容 -->
<span hidden="hidden" id="frontBlogItemId"><%=blogItemId%></span>
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
                    <li class="active">博客正文</li>
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
            <div class="col-md-9 blog-item margin-bottom-40">
                <h3>
                    <a href="#" id="_title"></a>
                </h3>
                <!-- 正文区 -->
                <span id="content"></span>
                <!-- 正文区结束 -->
                <ul class="blog-info">
                    <li><i class="icon-user"></i><span id="member"></span>
                    </li>
                    <li><i class="icon-calendar"></i><span id="date"></span>
                    </li>
                    <li><i class="icon-comments"></i> <span id="blogType"></span>
                    </li>
                    <li><i class="icon-tags"></i><span id="blogTags"></span>
                    </li>
                </ul>
                <hr>
                <div class="post-comment">
                    <h3>添加评论</h3>

                    <form role="form">
                        <div class="form-group">
                            <label>姓名</label> <input type="text" class="form-control">
                        </div>

                        <div class="form-group">app
                            <label>邮箱地址 <span class="color-red">*</span></label> <input
                                    type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>评论</label>
                            <textarea class="form-control" rows="8"></textarea>
                        </div>
                        <p>
                            <button class="btn btn-default theme-btn" type="submit">提交评论</button>
                        </p>
                    </form>
                </div>
            </div>
            <jsp:include page="template/template_blog_right.jsp"></jsp:include>
        </div>
    </div>
</div>
<!-- 内容结束 -->
<jsp:include page="template/template_footer.jsp"/>
</body>
<jsp:include page="template/template_script.jsp"/>
<script src="frontend_assets/scripts/blog.js"></script>
<script>
    $(document).ready(function () {
        FrontBlog.init();
    })
</script>
</html>
