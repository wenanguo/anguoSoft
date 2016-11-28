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
		<p style="font-size:14px">本平台使用技术框架介绍：</p>
        <ul>
            
<li>1、Services相关</li>

* Core Framework：Spring Framework 3.1.0.RELEASE。
* Security Framework：spring.security 3.1.0.RELEASE。
* Workflow Engine：Activit 5.12。
<br>
<li>2、Web相关</li>

* MVC Framework：SpringMVC 3.1.0.RELEASE。
* JavaScript Library：JQuery 1.9。
* CSS Framework：Twitter Bootstrap 2.3.1。
* JavaScript/CSS Compressor：YUI Compressor 2.4。
<br>
<li>3、Database相关</li>

* ORM Framework：Spring-Data-JPA 1.3、Mybatis 3.2.2。

<br>
<li>4、Tools 相关</li>

* Commons：Apache Commons
* JSON Mapper：Jackson 2.1
* Log Manager：Log4j 1.2
* report： Highcharts 2.2.0
<br>
        </ul>
	</div>
</body>
</html>