<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<jsp:include page="frontend/template/template_head.jsp" />
</head>
<body>
	<jsp:include page="frontend/template/template_header.jsp" />
	<!-- 
		内容 -->
	<!-- 
	 	内容结束 -->
	<jsp:include page="frontend/template/template_footer.jsp" />
</body>
<jsp:include page="frontend/template/template_script.jsp" />
</html>