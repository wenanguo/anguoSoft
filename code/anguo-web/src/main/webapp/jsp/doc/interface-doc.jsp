<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	request.setAttribute("url", "http://121.42.41.17/kaosheng/");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>接口说明文档</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.2.0-dist/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<div align="center"><h1>考神接口说明文档</h1></div>
			<br/>
			<br/>
			<br/>
			<h2>1、公共参数</h2>
			<br/>
			<h3>1.1、用户参数</h3>
			<table class="table table-bordered">
			 	<tr>
			 		<td colspan="5" align="center">入参 </td>
			 	</tr>
			 	<tr class="success">
			 		<td width="20%">接口名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>sign</td>
			 		<td>用户参数</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>根据uuid和时间戳加密的签名。规则为：RSA(uuid&timestamp)</td>
			 	</tr>
			 	<tr >
			 		<td>timestamp</td>
			 		<td>时间戳</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>当前时间戳，与签名中时间戳一致</td>
			 	</tr>
			</table>
			
			<br/>
			<h3>1.2、系统参数</h3>
			<table class="table table-bordered">
			 	<tr class="success">
			 		<td width="20%">接口名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>phoneBrand</td>
			 		<td>手机品牌</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>channelFlag</td>
			 		<td>渠道编号</td>
			 		<td>int</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>appBetaFlag</td>
			 		<td>版本类别</td>
			 		<td>int</td>
			 		<td><font color="red">是</font></td>
			 		<td>1为内测版，2为正式版</td>
			 	</tr>
			 	<tr >
			 		<td>phoneDeviceId</td>
			 		<td>设备编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>innerVersion</td>
			 		<td>内部版本号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>externalVersion</td>
			 		<td>外部版本号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>osType</td>
			 		<td>手机操作系统</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>osVersion</td>
			 		<td>系统版本</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>phoneModel</td>
			 		<td>手机型号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>appCode</td>
			 		<td>手机appCode号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			</table>
			
			<br/>
			<h3>1.3、返回参数</h3>
			<table class="table table-bordered">
			 	<tr class="info">
			 		<td width="20%">接口名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>code</td>
			 		<td>状态代码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>接口调用状态代码，详见状态代码列表</td>
			 	</tr>
			 	<tr >
			 		<td>msg</td>
			 		<td>状态代码说明</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>接口调用状态代码说明，详见状态代码列表</td>
			 	</tr>
			 	<tr >
			 		<td>rows</td>
			 		<td>返回结果对象</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>可为空，也可为单个对象，也可为对象列表</td>
			 	</tr>
			</table>
			
			<jsp:include page="kaosheng-member.jsp"></jsp:include>
			<jsp:include page="kaosheng-subject.jsp"></jsp:include>
			<jsp:include page="kaosheng-topic.jsp"></jsp:include>
			<jsp:include page="kaosheng-video.jsp"></jsp:include>
			<jsp:include page="kaosheng-ad.jsp"></jsp:include>
			<jsp:include page="kaosheng-interaction.jsp"></jsp:include>
			<jsp:include page="kaosheng-pay.jsp"></jsp:include>
			
			
			</div>
		</div>
		
	</div>
</body>
</html>