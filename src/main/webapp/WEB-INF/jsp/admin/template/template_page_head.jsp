<%@ page import="org.jichuang.hope6537.base.model.Member" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    Member member = (Member) session.getAttribute("loginMember");
    String isLoginPage = (String) request.getAttribute("isLoginPage");
    if (member == null) {
        if (isLoginPage == null) {
            response.sendRedirect("../page/login.hopedo");
        }
    }
%>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<meta name="MobileOptimized" content="320">
<!-- 登陆页 -->
<link href="admin_assets/css/pages/login-soft.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="admin_assets/js/base/global.js"></script>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="admin_assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-fileupload/bootstrap-fileupload.css"/>
<link href="admin_assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-toastr/toastr.min.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/select2/select2_metro.css"/>
<link rel="stylesheet" href="admin_assets/plugins/data-tables/DT_bootstrap.css"/>
<link href="admin_assets/css/pages/profile.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/clockface/css/clockface.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-colorpicker/css/colorpicker.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/jquery-multi-select/css/multi-select.css"/>
<link rel="stylesheet" type="text/css"
      href="admin_assets/plugins/bootstrap-switch/static/stylesheets/bootstrap-switch-metro.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/jquery-tags-input/jquery.tagsinput.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="admin_assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
<link href="admin_assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="admin_assets/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/select2/select2_metro.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-datepicker/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-timepicker/compiled/timepicker.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-datetimepicker/css/datetimepicker.css"/>
<link rel="stylesheet" type="text/css"
      href="admin_assets/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"/>
<link rel="stylesheet" type="text/css" href="admin_assets/plugins/bootstrap-editable/inputs-ext/address/address.css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
