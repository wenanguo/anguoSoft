<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='http://static.polyv.net/file/polyvplayer_v2.0.min.js'></script>
<title>
</title>
</head>
<body>
	
	
<div id='plv_180c969814fd4c0f4e6f2517d5fbc8f7_1'></div>
<script>
var player = polyvObject('#plv_180c969814fd4c0f4e6f2517d5fbc8f7_1').videoPlayer({
	'width':'100%',
	'height':'100%',
	'vid' : '${goeVideo.url}'
});
</script>

</body>
</html>