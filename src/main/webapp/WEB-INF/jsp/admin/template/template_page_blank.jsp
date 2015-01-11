<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    request.getRequestDispatcher(
            "../admin_welcome.jsp").forward(request,
            response);
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- head的include区 -->
    <jsp:include page="template_page_head.jsp" flush="true"/>
    <title>hope6537</title>
    <!-- head的include区 结束  -->
</head>
<body class="page-header-fixed page-footer-fixed">

<jsp:include page="template_page_header.jsp" flush="true"/>

<div class="page-container">

    <jsp:include page="template_page_sidebar.jsp" flush="true"/>

    <!--========================页面开始处======================== -->
    <div class="page-content">
        <jsp:include page="template_page_modal.jsp" flush="true"/>
        <jsp:include page="template_page_style.jsp" flush="true"/>

        <div class="row">
            <div class="col-md-12">

                <h3 class="page-title">
                    办公中心
                    <small>Office Center</small>
                </h3>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>菜单动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="#">解雇</a></li>
                            <li><a href="#">招募</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="index.html">主页</a> <i
                            class="icon-angle-right"></i></li>
                    <li><a href="#">办公处</a> <i class="icon-angle-right"></i></li>
                    <li><a href="#">办公中心</a></li>
                </ul>

            </div>
        </div>

        <div class="row"></div>
        <!-- 页面正文结束-->
    </div>
    <!-- ======================== 页面结束处======================== -->
</div>
<%@include file="template_page_footer.jsp" %>

</body>

<%@include file="template_page_javascript.jsp" %>

</html>
