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
    Blog editBlog = (Blog) request.getAttribute("editBlog");
    if (member == null) {
        response.sendRedirect("../page/login.hopedo");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- head的include区 -->
    <jsp:include page="../template/template_page_head.jsp" flush="true"/>
    <title>添加新博客</title>
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
            创建新博客
            <small>Add New Blog</small>
        </h3>
        <span hidden="hidden" id="blogItemId"><%=editBlog.getBlogId()%></span>
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
            <li><a href="#">博客维护</a></li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- 页面内容头结束 -->
<!-- 页面正文-->
<div class="row">
    <div class="col-md-12" id="addArea">
        <div class="portlet box blue">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-globe"></i>Add New Blog
                </div>
                <div class="tools">
                    <a href="javascript:;" class="reload"></a> <a
                        href="javascript:;" class="remove"></a>
                </div>
            </div>
            <div class="portlet-body">
                <form action="blog/insertBlog.hopedo" method="post"
                      id="addBlogForm">
                    <span id="editBlogInfo" hidden="hidden"><%=editBlog.getInfo()%></span>

                    <div class="form-body">
                        <div class="form-group">
                            <label>博客标题</label> <input type="text"
                                                       class="form-control input-lg" name="title" id="title"
                                                       placeholder="输入新文章的标题...">
                        </div>
                        <div class="form-group">
                            <label>文章内容&nbsp;
                                <small>可以从Word文档中复制哦！</small>
                            </label>
                            <textarea class="ckeditor form-control" name="content"
                                      id="content" rows="200" cols="50"></textarea>
                        </div>
                        <div class="form-group">
                            <label>插入图片
                                <small>上传后使用链接到编辑器提交链接来显示图片</small>
                            </label>

                            <div class="confirm-group">
                                <ul class="breadcrumb">
                                    <li>文件名 <span class="divider">:</span>
                                        http://www.baidu.com/test.jpg <a href="javascript:;">[插入]</a><br/>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 87px;">
                            <label class="col-md-3 control-label">上传图片<br/>
                                <button class="btn btn-primary">插入图片</button>
                            </label>

                            <div class="col-md-9">
                                <input type="file">

                                <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>文章标签
                                <small>以分号为分割</small>
                            </label> <input type="text"
                                            class="form-control input-lg" name="tags" id="tags"
                                            placeholder="输入新文章的标签...">
                        </div>
                        <div class="form-group">
                            <label>选择文章种类</label> <select class="form-control input-lg"
                                                          id="type" name="type">
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

    <div class="col-md-12" id="updateArea">
        <div class="portlet box red">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-globe"></i>Edit Exist Blog
                </div>
                <div class="tools">
                    <a href="javascript:;" class="reload"></a> <a
                        href="javascript:;" class="remove"></a>
                </div>
            </div>
            <div class="portlet-body">

                <!-- 两个编辑器的分界线 -->
                <form id="updateBlogForm">


                    <div class="form-body">
							 <span hidden="hidden"
                                   id="isEdit"><%=editBlog == null ? 0 : 1%></span>
                        <%
                            if (editBlog != null) {
                        %>
                        <input type="hidden" name="blogId" id="_blogId" value="<%=editBlog.getBlogId() %>"/>

                        <div class="form-group">
                            <label>博客标题</label> <input type="text"
                                                       class="form-control input-lg" name="title" id="_title"
                                                       value="<%=editBlog.getTitle()%>"
                                                       placeholder="输入新文章的标题...">
                        </div>
                        <div class="form-group">
                            <label>文章内容&nbsp;
                                <small>可以从Word文档中复制哦！</small>
                            </label>
                            <textarea class="ckeditor form-control" name="content"
                                      id="_content" rows="200" cols="50"><%=editBlog.getContent()%>
                            </textarea>
                        </div>
                        <div class="form-group">
                            <label>插入图片
                                <small>上传后使用链接到编辑器提交链接来显示图片</small>
                            </label>

                            <div class="confirm-group">
                                <ul class="breadcrumb">
                                    <li>文件名 <span class="divider">:</span>
                                        http://www.baidu.com/test.jpg <a href="javascript:;">[插入]</a><br/>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 87px;">
                            <label class="col-md-3 control-label">上传图片<br/>
                                <button class="btn btn-primary">插入图片</button>
                            </label>

                            <div class="col-md-9">
                                <input type="file">

                                <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>文章标签
                                <small>以分号为分割</small>
                            </label> <input type="text"
                                            class="form-control input-lg" name="tags" id="_tags"
                                            placeholder="输入新文章的标签...">
                        </div>
                        <div class="form-group">
                            <label>选择文章种类</label> <select class="form-control input-lg"
                                                          id="_type" name="type">
                            <option value="原创资料">原创资料</option>
                            <option value="转载资料">转载资料</option>
                            <option value="体会心得">体会心得</option>
                        </select>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <div class="form-actions right">
                        <button type="button" id="updateBlogButton" class="btn btn-block green">提交修改</button>
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>
<!-- 页面正文结束-->
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
    $(document).on("ready", function () {
        BlogTable.init();
        $("#blogLi").attr("class", "active");
        var isEdit = $("#isEdit").text();
        $(".page-title").text("");
        if (isEdit == "0") {
            $("#updateArea").hide();
            $(".page-title").append("创建新博客 <small>Add New Blog</small>");
        } else {
            $("#addArea").hide();
            $(".page-title").append("编辑现有博客 <small>Edit Exist Blog</small>");
        }
    });
</script>

<script>
    $(document).ready(function () {
        var info = eval("(" + $("#editBlogInfo").text() + ")");
        console.log(info);
        $("#_tags").val(info.blogTag);
        $("#_type").val(info.blogType);

    });


</script>
<!-- Js核心脚本结束 -->
</html>

