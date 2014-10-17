<html>
<body>
	<h2>Hello World!</h2>
	 <%
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,
				response);
	%> 
	<input type="text" name="username" id="username" />
	<span id="tishi"></span>
</body>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
   <script src="assets/plugins/respond.min.js"></script>
   <script src="assets/plugins/excanvas.min.js"></script> 
   <![endif]-->
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-migrate-1.2.1.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery.blockui.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
<script src="assets/plugins/uniform/jquery.uniform.min.js"
	type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script>
<script
	src="assets/plugins/jquery-validation/dist/jquery.validate.js"
	type="text/javascript"></script>
<script src="assets/plugins/backstretch/jquery.backstretch.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="assets/plugins/select2/select2.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/scripts/app.js" type="text/javascript"></script>
<script src="assets/scripts/login-soft.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript">
	$('#username').change(function() {
		var username = $('#username').val();
		$.ajax({
			type : "get",
			url : "memberAjax/" + username + "/isMemberExist.hopedo",
			dataType : "json",
			success : function(msg) {
				if (msg == null) {
					$('#tishi').text("no User Accepted");
				} else {
					$('#tishi').text("has User Accpeted");
				}
			}
		});
	});
</script>
</html>
