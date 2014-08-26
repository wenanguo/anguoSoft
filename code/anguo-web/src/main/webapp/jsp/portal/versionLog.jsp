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
		<p style="font-size:14px">GitHub更新日志.</p>
        <ul>
        	<li>2014年4月16日. V1.1.2   加入报表功能界面</li>
        	<li>2014年4月03日. V1.1.1   加入安全框架spring security</li>
        	<li>2014年3月25日. V1.1.0  构建整体框架</li>
            <li>2014年3月20日. V1.0.0  初始化项目版本</li>
            <li>项目基于git版本库进行管理，托管于github.</li>
            
           
            
        </ul>
	</div>
</body>
</html>