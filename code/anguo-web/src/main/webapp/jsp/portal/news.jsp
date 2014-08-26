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
	    <p style="font-size:14px">大数据.</p>
        <ul>
            <li><a target="_blank" href="http://www.36dsj.com/archives/7249">从百度视频看大数据与人工智能</a></li>
            <li><a target="_blank" href="http://www.36dsj.com/archives/7236">马航M370航班失联搜救中的统计数据分析</a></li>
            <li><a target="_blank" href="http://www.36dsj.com/archives/7262">继Cloudera之后，MapR宣布对Spark的完全支持</a></li>
            
        </ul>
	</div>
</body>
</html>