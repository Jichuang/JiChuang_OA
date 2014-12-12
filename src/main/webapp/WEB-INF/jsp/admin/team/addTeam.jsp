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


%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- head的include区 -->
    <jsp:include page="../template/template_page_head.jsp" flush="true"/>
    <title>项目组维护</title>
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
            创建新项目组
            <small>Create New Team</small>
        </h3>
        <span hidden="hidden" id="isEdit"><%=request.getAttribute("isEdit")%></span>
        <span hidden="hidden" id="teamId"><%=request.getAttribute("teamId")%></span>
        <span hidden="hidden" id="oldTeamName"></span>
        <span id="editBlogInfo" hidden="hidden"> </span>
        <ul class="page-breadcrumb breadcrumb">、
            <li class="btn-group">
                <button type="button" class="btn blue dropdown-toggle"
                        data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                        data-close-others="true">
                    <span>动作</span> <i class="icon-angle-down"></i>
                </button>
                <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="javascript:;" id="refreshTeam"><i
                            class="icon-refresh"></i>刷新项目组信息</a></li>
                    <li><a href="javascript:;" id="deleteTeam"><i
                            class="icon-refresh"></i>删除当前项目组</a></li>
                </ul>
            </li>
            <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                <i class="icon-angle-right"></i></li>
            <li><a href="javascript:;">项目组维护</a></li>
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
                    <i class="icon-globe"></i>Create New Team
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
                            <label>项目组名称</label>
                            <input type="text" class="form-control input-lg" name="title" id="title"
                                   placeholder="输入新项目组的名称...">
                        </div>
                        <div class="form-group">
                            <label>项目组描述&nbsp;
                                <small>可以从Word文档中复制哦！</small>
                            </label>
                            <textarea class="form-control" name="newDes"
                                      id="newDes" rows="200" cols="50"></textarea>
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
                            <div class="form-group" style="margin-bottom: 87px;">
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
                            <label>项目组种类</label>
                            <select class="form-control input-lg" id="teamType" name="teamType">
                                <option value="1">1</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-actions right">
                        <button type="submit" class="btn btn-block green" id="addTeamButton">创建新项目组</button>
                    </div>
                </form>

            </div>
        </div>

    </div>

    <div class="col-md-12" id="updateArea">
        <div class="portlet box red">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-globe"></i>Edit Exist Team
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

                        <input type="hidden" name="blogId" id="_blogId" value=""/>

                        <div class="form-group">
                            <label>项目组名称</label>
                            <input type="text" class="form-control input-lg" name="title" id="_title" value=""
                                   placeholder="输入新文章的标题...">
                        </div>
                        <div class="form-group">
                            <label>项目组描述&nbsp;
                                <small>可以从Word文档中复制哦！</small>
                            </label>
                            <textarea class="form-control" name="_des"
                                      id="_des" rows="200" cols="50">
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
                            <div class="form-group" style="margin-bottom: 87px;">
                                <label class="col-md-3 control-label btn btn-primary"
                                       id="_updateImageButton">上传当前图片<br/>
                                </label>

                                <div class="col-md-9">
                                    <input type="file" id="_image" name="image">

                                    <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                                </div>
                            </div>
                        </form>

                        <div class="portlet-body col-md-6" style="padding-left: 0px;">
                            <label>成员信息</label>
                            <table class="table table-striped table-bordered table-hover"
                                   id="datatable">
                                <thead>
                                <tr>
                                    <th>成员编号</th>
                                    <th>成员姓名</th>
                                    <th>成员加入日期</th>
                                    <th>对成员操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>

                        <div class="portlet-body col-md-6" style=" padding-left: 0px;">
                            <label>成员信息</label>
                            <table class="table table-striped table-bordered table-hover"
                                   id="_datatable">
                                <thead>
                                <tr>
                                    <th>成员编号</th>
                                    <th>成员姓名</th>
                                    <th>成员加入日期</th>
                                    <th>对成员操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>


                        <div class="form-group">
                            <label>项目组种类</label>
                            <select class="form-control input-lg" id="_teamType" name="_teamType">
                                <option value="1" selected="selected">1</option>
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
<!-- full width -->
<div id="deleteModal" class="modal fade" tabindex="-1">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">删除项目组</h4>
    </div>
    <div class="modal-body">
        <p><font color="red"><h4>注意：您正在进行危险操作</h4></font></p>

        <p>您确定您要删除这个项目组么？<br/>
            它的一切数据、工程、图片、任务和成员关系将无法找回，您确定要这样做么？<br/>
            如果您确实想要删除这个项目组，那么在下面的输入框中输入项目组的名称</p>
        <input type="text" class="form-control" name="" id="deleteTeamName"/>
    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
        <button type="button" id="deleteTeamButton" class="btn red">确认删除项目组</button>
    </div>
</div>
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
        $("#teamLi").attr("class", "active");
        Team.init();
        var isEdit = $("#isEdit").text();
        $(".page-title").text("");
        if (isEdit == "1") {
            $("#addArea").hide();
            $(".page-title").append("编辑现有项目组 <small>Edit Exist Team</small>");
            Team.refresh();
        } else {
            $("#updateArea").hide();
            $(".page-title").append("创建新项目组 <small>Create New Team</small>");
            Team.refreshTeamTypeForAdd();
        }
    });
</script>
<!-- Js核心脚本结束 -->
</html>

