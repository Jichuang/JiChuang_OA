<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="admin_assets/plugins/respond.min.js"></script>
<script src="admin_assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="admin_assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap/js/bootstrap2-typeahead.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="admin_assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="admin_assets/plugins/flot/jquery.flot.js" type="text/javascript"></script>
<script src="admin_assets/plugins/flot/jquery.flot.resize.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<script src="admin_assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
<script src="admin_assets/plugins/fullcalendar/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.js" type="text/javascript"></script>
<script src="admin_assets/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script type="text/javascript" src="admin_assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="admin_assets/plugins/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="admin_assets/plugins/data-tables/DT_bootstrap.js"></script>
<script type="text/javascript" src="admin_assets/plugins/ckeditor/ckeditor.js"></script>
<script src="admin_assets/plugins/jquery-validation/dist/jquery.validate.js" type="text/javascript"></script>
<script src="admin_assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="admin_assets/plugins/bootstrap-toastr/toastr.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="admin_assets/scripts/app.js" type="text/javascript"></script>
<script src="admin_assets/scripts/index.js" type="text/javascript"></script>
<script src="admin_assets/scripts/tasks.js" type="text/javascript"></script>
<script src="admin_assets/scripts/toast.js" type="text/javascript"></script>
<script type="text/javascript" src="admin_assets/scripts/datatable.js"></script>
<script src="admin_assets/scripts/table-advanced.js"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="admin_assets/plugins/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<!-- BEGIN PLUGINS USED BY X-EDITABLE -->
<script type="text/javascript" src="admin_assets/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="admin_assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
<script type="text/javascript" src="admin_assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
        src="admin_assets/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="admin_assets/plugins/moment.min.js"></script>
<script type="text/javascript" src="admin_assets/plugins/jquery.mockjax.js"></script>
<script type="text/javascript"
        src="admin_assets/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.min.js"></script>
<script type="text/javascript" src="admin_assets/plugins/bootstrap-editable/inputs-ext/address/address.js"></script>
<script type="text/javascript" src="admin_assets/plugins/bootstrap-editable/inputs-ext/wysihtml5/wysihtml5.js"></script>
<!-- END X-EDITABLE PLUGIN -->
<script type="text/javascript" src="admin_assets/js/blog/blogconf.js"></script>
<script type="text/javascript" src="admin_assets/js/member/memberconf.js"></script>
<script type="text/javascript" src="admin_assets/js/team/teamconf.js"></script>
<script src="admin_assets/scripts/form-editable.js"></script>
<script>
    jQuery(document).ready(function () {
        App.init(); // initlayout and core plugins
        FormEditable.init();
        Index.init();
        Index.initCalendar(); // init index page's custom scripts
        Index.initCharts(); // init index page's custom scripts
        Index.initChat();
        Index.initMiniCharts();
        Index.initDashboardDaterange();
        Tasks.initDashboardWidget();
    });
</script>