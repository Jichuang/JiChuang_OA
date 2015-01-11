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
    <base href="<%=basePath%>">
    <title>联系我们 | 集创团队</title>
    <jsp:include page="template/template_head.jsp"/>
</head>
<body>
<jsp:include page="template/template_header.jsp"/>
<!--
    内容 -->
<div class="page-container">
    <!-- BEGIN BREADCRUMBS -->
    <div class="row breadcrumbs">
        <div class="container">
            <div class="col-md-4 col-sm-4">
                <h1>联系我们</h1>
            </div>
            <div class="col-md-8 col-sm-8">
                <ul class="pull-right breadcrumb">
                    <li><a href="index.html">集创首页</a></li>
                    <li class="active">联系我们</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <div class="row">
        <div id="map" class="gmaps margin-bottom-40" style="height:400px;"></div>
    </div>

    <!-- BEGIN CONTAINER -->
    <div class="container min-hight">
        <div class="row">
            <div class="col-md-9">
                <h2>Contact us!</h2>

                <p>如果您想和我们攻克难题、或是要和我们分享知识，又或是对我们提出宝贵建议和意见.</p>

                <div class="space20"></div>
                <!-- BEGIN FORM-->
                <form action="#" class="horizontal-form margin-bottom-40"
                      role="form">
                    <div class="form-group">
                        <label class="control-label">您的姓名</label>

                        <div class="col-lg-12">
                            <input type="text" class="form-control" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">您的邮箱 <span class="color-red">*</span></label>

                        <div class="col-lg-12">
                            <input type="text" class="form-control" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">反馈内容</label>

                        <div class="col-lg-12">
                            <textarea class="form-control" rows="8" required="required"></textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default theme-btn">
                        <i class="icon-ok"></i> 提交信息
                    </button>
                    <button type="button" class="btn btn-default">取消发送</button>
                </form>
                <!-- END FORM-->
            </div>

            <div class="col-md-3">
                <h2>联系方式</h2>
                <address>
                    <strong>集创团队 JiChuang Organization </strong><br>
                    长春市卫星路6543号长春大学综合楼D区<br>
                </address>
                <address>
                    <strong>Email</strong><br> <a href="mailto:#">hope6537@qq.com</a><br>
                    <a href="mailto:#">jichuang@ccu.edu.cn</a>
                </address>
                <ul class="social-icons margin-bottom-10">
                    <li><a href="#" data-original-title="github"
                           class="social_github"></a></li>
                    <li><a href="#" data-original-title="rss" class="social_rss"></a></li>
                </ul>

                <div class="clearfix margin-bottom-30"></div>

            </div>
        </div>
    </div>
    <!-- END CONTAINER -->

</div>
<!--
     内容结束 -->
<jsp:include page="template/template_footer.jsp"/>
</body>
<jsp:include page="template/template_script.jsp"/>
<script type="text/javascript"
        src="frontend_assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<script src="frontend_assets/scripts/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function () {
        App.init();
    });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
</html>
