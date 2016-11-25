<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


		<meta http-equiv="Content-Type">
		<meta content="text/html; charset=utf-8">
		<meta charset="utf-8">
		<title>ttt</title>		
		<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="format-detection" content="email=no">
		
		
<title>ttt</title>
</head>
<body>
授权显示页面<%=request.getParameter("openid") %>||
<%=request.getParameter("access_token") %>
<img alt="" src="<%=request.getParameter("headimgurl") %>" style="width:100%;height:auto;">

</body>
</html>