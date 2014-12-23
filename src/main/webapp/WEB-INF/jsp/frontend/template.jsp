<%@ page language="java"  pageEncoding="UTF-8" %>
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
    <jsp:include page="template/template_head.jsp"/>
</head>
<body>
<jsp:include page="template/template_header.jsp"/>
<!--
    内容 -->
<!--
     内容结束 -->
<jsp:include page="template/template_footer.jsp"/>
</body>
<jsp:include page="template/template_script.jsp"/>
</html>
