<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title></title>

</head>
<body>
	<div style="padding: 10px;">
		<p style="font-size:14px">考神--敏捷开发团队.</p>
        <ul>
            <li>我们致力于企业软件设计，架构，开发以及后期维护.</li>
        </ul>
	</div>
</body>
</html>