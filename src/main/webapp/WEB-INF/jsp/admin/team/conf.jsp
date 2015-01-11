<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- head的include区 -->
    <%@include file="../template/template_page_head.jsp" %>
    <title>项目组维护</title>
    <!-- head的include区 结束  -->
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
                    项目组维护
                    <small>Team Config</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="team/toAddTeam.hopedo"><i
                                    class="icon-edit"></i>创建项目组</a></li>
                            <li><a href="javascript:;" id="reloadTeamTable"><i
                                    class="icon-refresh"></i>刷新项目组信息</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">项目组维护</a></li>
                </ul>

            </div>
        </div>

        <div class="row">
            <div class="col-md-12">

                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-globe"></i>Team Configration
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
                                <th>项目组名</th>
                                <th>项目组详细信息</th>
                                <th>项目创建日期</th>
                                <th>项目组状态</th>
                                <th>项目组类型</th>
                                <th>编辑项目组信息</th>
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
</div>

<%@include file="../template/template_page_footer.jsp" %>

</body>

<%@include file="../template/template_page_javascript.jsp" %>
<script type="text/javascript" src="admin_assets/js/team/teamconf.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        TeamTable.init();
        $("#teamLi").attr("class", "active");
    });
</script>

</html>
