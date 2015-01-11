<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/template_page_head.jsp" flush="true"/>
    <title>团队成员维护</title>
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
                    团队成员维护
                    <small>Member Config</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="javascript:;" id="showAddMemberButton"><i
                                    class="icon-edit"></i>添加新成员</a></li>
                            <li><a href="javascript:;" id="refreshTableButton"><i
                                    class="icon-refresh"></i>刷新成员信息</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">团队成员维护</a></li>
                </ul>

            </div>
        </div>

        <div class="row">
            <div class="col-md-12">

                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-globe"></i>Member Configration
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
                                <th style="width: 100px;">成员姓名</th>
                                <th>成员邮箱</th>
                                <th>成员注册日期</th>
                                <th>成员状态</th>
                                <th>查看成员详细信息</th>
                                <th>团队成员操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- ======================== 页面结束处======================== -->

    <div id="addMemberModal" class="modal container fade in" tabindex="-1" style="height: auto;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="icon-pencil"></i> 管理员维护用户信息窗口</h4>
        </div>
        <span hidden="hidden" id="updateMemberId"></span>

        <div class="modal-body form" style="height: auto;">
            <form id="dialogForm" class="form-horizontal">
                <div class="form-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-md-4 control-label">登录名<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <input type="hidden" id="userId">
                                    <input type="text" class="form-control input-medium" placeholder="登录名"
                                           id="memberUsername">
                                    <span class="help-block">此名称用于登录</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group last">
                                <label class="col-md-4 control-label">用户姓名<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-medium" placeholder="用户姓名"
                                           id="memberName">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-md-4 control-label">登录密码<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <input type="password" class="form-control input-medium" placeholder="登录密码"
                                           id="memberPassword">
                                    <span class="help-block" id="passwordHelpBlock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group last">
                                <label class="col-md-4 control-label">确认密码<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <input type="password" class="form-control input-medium" placeholder="确认密码"
                                           id="confirmPassword">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-md-4 control-label">用户职位<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <select multiple="multiple" class="multi-select" id="memberPosts"
                                            name="memberPosts[]">
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group last">
                                <label class="col-md-4 control-label">用户其他信息<span class="required"> * </span></label>

                                <div class="col-md-8">
                                    <label class="control-label">更改用户的状态</label>
                                    <select id="updateMemberStatus" class="form-control input-medium">
                                        <option value="正常">正常</option>
                                        <option value="未认证">未认证</option>
                                        <option value="不可用">不可用</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" id="cancel" class="btn btn-default">取消</button>
            <button type="button" id="addMemberButton" class="btn blue">添加成员信息</button>
            <button type="button" id="updateMemberButton" class="btn blue">更新成员信息</button>
        </div>
    </div>
</div>

<%@include file="../template/template_page_footer.jsp" %>

</body>

<%@include file="../template/template_page_javascript.jsp" %>
<script type="text/javascript" src="admin_assets/js/base/memberconf.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        MemberTable.init();
        $("#adminLi").attr("class", "active");
    });
</script>

</html>
