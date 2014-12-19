<%@ page language="java" pageEncoding="UTF-8" %>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<script src="frontend_assets/plugins/jquery-1.10.2.min.js"
        type="text/javascript"></script>
<script src="frontend_assets/plugins/jquery-migrate-1.2.1.min.js"
        type="text/javascript"></script>
<script src="frontend_assets/plugins/bootstrap/js/bootstrap.min.js"
        type="text/javascript"></script>
<script type="text/javascript"
        src="frontend_assets/plugins/back-to-top.js"></script>

<script type="text/javascript"
        src="frontend_assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<script type="text/javascript"
        src="frontend_assets/plugins/hover-dropdown.js"></script>
<script type="text/javascript"
        src="frontend_assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
<script type="text/javascript"
        src="frontend_assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<!--[if lt IE 9]>
<script src="frontend_assets/plugins/respond.min.js"></script>
<![endif]-->
<!-- END CORE PLUGINS -->
<script type="text/javascript"
        src="frontend_assets/plugins/bxslider/jquery.bxslider.js"></script>
<script src="frontend_assets/scripts/app.js"></script>
<script src="frontend_assets/scripts/index.js"></script>
<script src="frontend_assets/plugins/jquery.mixitup.min.js"></script>
<script src="frontend_assets/scripts/portfolio.js"></script>
<script src="admin_assets/scripts/js/blogconf.js"></script>
<script src="admin_assets/plugins/bootstrap-toastr/toastr.min.js"></script>
<script src="admin_assets/scripts/toast.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function () {
        App.init();
        App.initBxSlider();
        Portfolio.init();
        Index.initRevolutionSlider();
        BlogTable.frontInit();
    });
</script>

<!-- END JAVASCRIPTS -->