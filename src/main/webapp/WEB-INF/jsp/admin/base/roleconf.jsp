<%@ page language="java" import="org.jichuang.hope6537.base.model.Member" pageEncoding="UTF-8" %>
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
    <title>权限维护</title>
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
                    权限维护
                    <small>Role Config</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="javascript:;" id="addNewRole"><i
                                    class="icon-edit"></i>添加新权限</a></li>
                            <li><a href="javascript:;" id="reloadRoleTable"><i
                                    class="icon-refresh"></i>刷新权限信息</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">权限维护</a></li>
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
                            <i class="icon-globe"></i>Role Configration
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
                                <th style="width: 60px;">权限编号</th>
                                <th>权限内容</th>
                                <th>权限状态</th>
                                <th>权限操作</th>
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
    </div>
    <!-- ======================== 页面结束处======================== -->
</div>

<div id="addNewRoleModal" class="modal fade" tabindex="-1">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">添加新权限</h4>
    </div>


    <div class="modal-body">
        <p><font color="red"><h4>注意：您正在进行管理操作</h4></font></p>

        <div class="form-group">
            <label class="control-label">输入新权限的内容，请确认您填写的信息准确无误。</label>
            <input type="text" class="form-control" name="" id="addNewRoleDes"/>
        </div>

    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" id="cancel" class="btn btn-default">取消</button>
        <button type="button" id="addNewRoleButton" class="btn blue">添加新权限</button>
    </div>
</div>

<div id="updateRoleModal" class="modal fade" tabindex="-1">

    <span hidden="hidden" id="editRoleId"></span>

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">编辑已有权限</h4>
    </div>

    <div class="modal-body">
        <p><font color="red"><h4>注意：您正在进行管理风险操作</h4></font></p>

        <div class="form-group">
            <label class="control-label">更改权限的内容</label>
            <input type="text" class="form-control" name="" id="updateRoleDes"/>
        </div>
        <div class="form-group">
            <label class="control-label">更改权限的状态</label>
            <select id="updateRoleStatus" class="form-control">
                <option value="正常">正常</option>
                <option value="不可用">不可用</option>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" id="updateRoleButton" class="btn blue"><i class="icon-edit"></i>修改该权限</button>
        <button type="button" id="deleteRoleButton" class="btn red"><i class="icon-edit"></i>删除该权限</button>
    </div>
</div>


<div id="confrimModal" class="modal fade"
     style="width: 480px;">
    <div class="modal-dialog" style="width: 480px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">请确认您的操作</h4>
            </div>
            <div class="modal-body">
                <p>您确定要删除该权限么？注意该操作无法被逆转！</p>
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn default">取消</button>
                <button type="button" data-dismiss="modal" id="confirm" class="btn green">是的删除</button>
            </div>
        </div>
    </div>
</div>


<!-- 页面尾端include  -->
<%@include file="../template/template_page_footer.jsp" %>
<!-- 页面尾端include 结束  -->
</body>
<!-- Js核心脚本 -->
<%@include file="../template/template_page_javascript.jsp" %>
<script type="text/javascript" src="admin_assets/js/base/roleconf.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        RoleTable.init();
        $("#adminLi").attr("class", "active");
    });
</script>
<!-- Js核心脚本结束 -->
</html>
