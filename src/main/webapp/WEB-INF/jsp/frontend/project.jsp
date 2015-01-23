<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>工程展示</title>
    <base href="<%=basePath%>">
    <jsp:include page="template/template_head.jsp"/>
</head>
<body>
<jsp:include page="template/template_header.jsp"/>
<!-- 内容 -->
<div class="page-container">

    <!-- BEGIN BREADCRUMBS -->
    <div class="container">
        <div class="col-md-4 col-sm-4">
            <h1>工程展示</h1>
        </div>
        <div class="col-md-8 col-sm-8">
            <ul class="pull-right breadcrumb">
                <li><a href="index.html">首页</a></li>
                <li class="active">工程展示</li>
            </ul>
        </div>
    </div>
</div>
<div class="row">
    <div class="container min-hight portfolio-page margin-bottom-40">
        <div class="filter-v1 margin-top-10">
            <ul class="mix-filter" id="teamTypeList">
                <li class="filter" data-filter="all">查看全部</li>
            </ul>
            <div class="row mix-grid thumbnails" id="teamList">

            </div>
        </div>
    </div>
</div>
</div>
<!-- 内容结束 -->
<jsp:include page="template/template_footer.jsp"/>
</body>
<jsp:include page="template/template_script.jsp"/>
<script src="frontend_assets/scripts/team.js"></script>
<script>
    $(document).ready(function () {
        FrontTeam.init();
    });
</script>
</html>
