<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String editBlogId = (String) request.getAttribute("editBlogId");
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../template/template_page_head.jsp" %>
    <title>添加新博客</title>
</head>
<body class="page-header-fixed page-footer-fixed">

<jsp:include page="../template/template_page_header.jsp" flush="true"/>

<div class="page-container">

<jsp:include page="../template/template_page_sidebar.jsp" flush="true"/>

<!--========================页面开始处======================== -->
<div class="page-content">
    <jsp:include page="../template/template_page_modal.jsp" flush="true"/>
    <jsp:include page="../template/template_page_style.jsp" flush="true"/>

    <div class="row">
        <div class="col-md-12">

            <h3 class="page-title">
                创建新博客
                <small>Add New Blog</small>
            </h3>
            <span hidden="hidden" id="isEdit"><%=editBlogId == null ? 0 : editBlogId%></span>
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
                        <div class="form-body">
                            <div class="form-group">
                                <label>博客标题</label>
                                <input type="text" class="form-control input-lg" name="title" id="title"
                                       placeholder="输入新文章的标题...">
                            </div>
                            <div class="form-group">
                                <label>文章内容&nbsp;
                                    <small>可以从Word文档中复制哦！</small>
                                </label>
                                <textarea class="form-control" name="content"
                                          id="content" rows="200" cols="50"></textarea>
                            </div>
                            <div class="form-group">
                                <label>插入图片
                                    <small>上传后使用链接到编辑器提交链接来显示图片</small>
                                </label>

                                <div class="confirm-group">
                                    <ul class="breadcrumb" id="images">
                                        <li>
                                            上传过的图片链接，点击插入或者点击编辑器中的插入按钮输入链接皆可插入图片
                                        </li>
                                        <br/>
                                    </ul>
                                </div>
                            </div>
                            <form id="uploadImageForm" enctype="multipart/form-data">
                                <div class="form-group" style="margin-bottom: 50px;">
                                    <label class="col-md-3 control-label btn btn-primary"
                                           id="updateImageButton">上传当前图片<br/>
                                    </label>

                                    <div class="col-md-9">
                                        <input type="file" id="image" name="image">

                                        <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                                    </div>
                                </div>
                            </form>
                            <div class="form-group">
                                <label>文章标签
                                    <small>以分号为分割</small>
                                </label> <input type="text"
                                                class="form-control" name="blogTags" id="blogTags"
                                                placeholder="输入新文章的标签...">
                            </div>
                            <div class="form-group">
                                <label>选择文章种类</label> <select class="form-control input-lg"
                                                              id="blogType" name="blogType">
                                <option value="原创资料">原创资料</option>
                                <option value="转载资料">转载资料</option>
                                <option value="体会心得">体会心得</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-actions right">
                            <button id="addBlogButton" type="button" class="btn btn-block green">提交新文章</button>
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
                        <a href="javascript:;" class="reload" id="reloadEditBlog"></a> <a
                            href="javascript:;" class="remove"></a>
                    </div>
                </div>
                <div class="portlet-body">

                    <!-- 两个编辑器的分界线 -->
                    <form id="updateBlogForm">
                        <div class="form-body">
                            <input type="hidden" name="blogId" id="_blogId"/>

                            <div class="form-group">
                                <label>博客标题</label> <input type="text"
                                                           class="form-control input-lg" name="title" id="_title"
                                                           placeholder="输入新文章的标题...">
                            </div>
                            <div class="form-group">
                                <label>文章内容&nbsp;
                                    <small>可以从Word文档中复制哦！</small>
                                </label>
                                <textarea class="form-control" name="_content"
                                          id="_content" rows="200" cols="50">
                                </textarea>
                            </div>
                            <div class="form-group">
                                <label>插入图片
                                    <small>上传后使用链接到编辑器提交链接来显示图片</small>
                                </label>

                                <div class="confirm-group">
                                    <ul class="breadcrumb" id="_images">
                                        <li>
                                            上传过的图片链接，点击插入或者点击编辑器中的插入按钮输入链接皆可插入图片
                                        </li>
                                        <br/>
                                    </ul>
                                </div>
                            </div>
                            <form id="_uploadImageForm" enctype="multipart/form-data">
                                <div class="form-group" style="margin-bottom: 50px;">
                                    <label class="col-md-3 control-label btn btn-primary"
                                           id="_updateImageButton">上传当前图片<br/>
                                    </label>

                                    <div class="col-md-9">
                                        <input type="file" id="_image" name="image">

                                        <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                                    </div>
                                </div>
                            </form>
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
<%@include file="../template/template_page_footer.jsp" %>

</body>

<%@include file="../template/template_page_javascript.jsp" %>
<script type="text/javascript" src="admin_assets/js/blog/blog.js"></script>
<script type="javascript">
    console.log($("#isEdit").text());
</script>
<script type="text/javascript">
    $(document).on("ready", function () {
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
        Blog.init();

    });
</script>

</html>

