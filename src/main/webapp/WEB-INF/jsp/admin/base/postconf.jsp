<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../template/template_page_head.jsp" flush="true"/>
    <title>职位维护</title>
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
                    职位维护
                    <small>Post Config</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="javascript:;" id="addNewPost"><i
                                    class="icon-edit"></i>创建新职位</a></li>
                            <li><a href="javascript:;" id="reloadPostTable"><i
                                    class="icon-refresh"></i>刷新职位信息</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">职位维护</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-globe"></i>Post Configration
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
                                <th style="width: 60px;">职位编号</th>
                                <th>职位名称</th>
                                <th>职位状态</th>
                                <th>职位操作</th>
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
    <div id="addNewPostModal" class="modal fade" tabindex="-1" style="height: 500px;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"><i class="icon-pencil"></i> 添加新职位</h4>
        </div>
        <div class="modal-body" style="height: 340px;">
            <p><font color="red"><h4><i class="glyphicon-warning-sign"></i> 注意：您正在进行管理操作</h4></font></p>
            <div class="form-group">
                <label class="control-label"><i class="icon-edit"></i> 输入新职位的名称</label>
                <input type="text" class="form-control" name="" id="addNewPostDes"/>
            </div>
            <label class="control-label"><i class="icon-search"></i> 请选择新职位所具有的权限</label>

            <div class="form-group">
                <div class="col-md-12" style="padding-left: 0px;padding-right: 0px;">
                    <select id="addNewPostRoles" class="form-control select2 select2-offscreen"
                            multiple=""
                            tabindex="-1">
                        <optgroup label="管理员权限" id="adminRoles">
                        </optgroup>
                        <optgroup label="读写权限" id="writeRoles">
                        </optgroup>
                        <optgroup label="只读权限" id="readRoles">
                        </optgroup>
                    </select>
                </div>
            </div>


        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" id="cancel" class="btn btn-default">取消</button>
            <button type="button" id="addNewPostButton" class="btn blue">添加新职位</button>
        </div>
    </div>

    <div id="updatePostModal" class="modal fade" style="height: auto; width: auto" tabindex="-1">

        <span hidden="hidden" id="editPostId"></span>

        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">编辑已有职位</h4>
        </div>

        <div class="modal-body" style="width: auto;height: auto">
            <p><font color="red"><h4>注意：您正在进行管理风险操作</h4></font></p>

            <div class="form-group">
                <label class="control-label">更改职位的名称</label>
                <input type="text" class="form-control" name="" id="updatePostDes"/>
            </div>
            <div class="form-group">
                <label class="control-label">更改职位的状态</label>
                <select id="updatePostStatus" class="form-control">
                    <option value="正常">正常</option>
                    <option value="不可用">不可用</option>
                </select>
            </div>
            <label class="control-label"><i class="icon-search"></i> 更改职位的权限
                <small>左侧是待添加权限，右侧是已有权限</small>
            </label>

            <div class="form-group">
                <select multiple="multiple" class="multi-select" id="updateRolePost" name="updateRolePost[]"
                        style="margin-bottom: 50px; margin-left: 25px;">
                    <optgroup id="_adminRoles">
                    </optgroup>
                    <optgroup id="_writeRoles">
                    </optgroup>
                    <optgroup id="_readRoles">
                    </optgroup>

                </select>
            </div>


        </div>
        <div class="modal-footer">
            <button type="button" id="updatePostButton" class="btn blue"><i class="icon-edit"></i>修改该职位信息</button>
            <button type="button" id="deletePostButton" class="btn red"><i class="icon-edit"></i>删除该职位信息</button>
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
                    <p>您确定要删除该职位么？注意该操作无法被逆转！</p>
                </div>
                <div class="modal-footer">
                    <button type="button" data-dismiss="modal" class="btn default">取消</button>
                    <button type="button" data-dismiss="modal" id="confirm" class="btn green">是的删除</button>
                </div>
            </div>
        </div>
    </div>


    <!-- ======================== 页面结束处======================== -->
</div>

<%@include file="../template/template_page_footer.jsp" %>

</body>

<%@include file="../template/template_page_javascript.jsp" %>
<script type="text/javascript" src="admin_assets/js/base/postconf.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        PostTable.init();
        $("#adminLi").attr("class", "active");
    });
</script>

</html>
