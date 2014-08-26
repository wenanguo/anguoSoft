<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	// 登陆页面参数定义
	String login_window_width = "900px";// 登陆窗口宽度
	String login_window_height = "349px";// 登陆窗口高度
	String input_window_top_margin_height = "5px";// 登陆窗口高度
	String login_window_bgimage = "login_bg.png";// 登陆窗口背景图片

	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目名称</title>
<script charset="utf-8" src="resources/js/md5.js"></script>
<script type="text/javascript">
			
			
			
			
			function validateForm() {
				var regRequired = /^\S+$/;
				var loginname = document.getElementsByName('j_username')[0].value;
				var password2 = document.getElementsByName('j_password')[0].value;
				var randomcode = document.getElementsByName('randomcode')[0].value;
				// 验证账号
				if(!regRequired.test(loginname)) {
					document.getElementById('msg').innerHTML = "账号不能为空！";
					return false;
				}
				// 验证密码
				if(!regRequired.test(password2)) {
					document.getElementById('msg').innerHTML = "密码不能为空！";
					return false;
				}
				
				//var md5value = hex_md5(password2);
				//var password = document.getElementsByName('password')[0];
				//password.value = md5value;
				
				return true;
			}
			
			
			function reloadRandomCode() {
				document.getElementById('rcode').src = 'randomcode.jpg?'+new Date();
			}
		</script>

<style type="text/css">
body {
	background-color: #ffffff;
	color: black;
	font-weight: bold;
	font-size: 12px;
	padding: 0px;
	margin: 0px;
	margin: 0px;
}

.table_center {
	background-color: #0000ff;
	border: 1px solid #222222;
}

.table_left {
	background-color: #ff0000;
	border: 1px solid #222222;
}

.input {
	width: 150px;
}

A:link {
	font-size: 12px;
	TEXT-DECORATION: none;
	color: blue;
}

A:visited {
	font-size: 12px;
	TEXT-DECORATION: none;
	color: blue;
}

A:hover {
	font-size: 12px;
	TEXT-DECORATION: none;
	color: blue;
}

A:active {
	font-size: 12px;
	TEXT-DECORATION: none;
	color: blue;
}

.artInfo {
	line-height: 22px;
	font-size: 14px;
	border-bottom: solid 1px #CCC;
	color: #999;
	padding: 5px 0;
	position: relative;
}

.p3 {
	line-height: 24px;
	font-size: 13px;
	color: #7b7b7b;
}
</style>

</head>
<body>

	<table id="screentTable" width="100%" height="100%" cellSpacing="0"
		cellPadding="0">
		<tr height="63px">
			<td align="left" colspan="3"></td>
		</tr>
		<tr>
			<td align="center" valign="top" colspan="3">
				<form action="j_spring_security_check" method="post" onsubmit="return validateForm();">
					<table width="<%=login_window_width%>px"
						height="<%=login_window_height%>px" cellSpacing="0"
						cellPadding="0"
						style="background:no-repeat url('resources/images/<%=login_window_bgimage%>');font-size:12px;">
						<tr height="110">
							<td width="68%" rowspan="8">&nbsp;</td>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr height="8">
							<td align="right" width="7%">账<span> </span>号:&nbsp;</td>
							<td colspan="3">
							<input id="j_username" name="j_username" class="input"  value="" /></td>
						</tr>
						<tr height="8">
							<td align="right">密<span> </span>码:&nbsp;</td>
							<td colspan="3">
							<input class="input" type="password" id="j_password" name="j_password"  value="" /> 
							<input class="input" type="hidden" id="password" name="password" value="" /> 
							<input class="input" type="hidden" name="index" value="0" /></td>
						</tr>
						<tr>
							<td align="right">验证码:&nbsp;</td>
							<td style="width:80px;"><input style="width:75px;"
								type="text" name="randomcode" value="" /></td>
							<td width="60">
								<img onclick="reloadRandomCode()" width="70" height="21" id="rcode" src="randomcode.jpg" /></td>
							<td>&nbsp;<a href="javascript:reloadRandomCode()">看不清?</a></td>
						</tr>
						<tr height="5">
							<td colspan="4" align="center">&nbsp;</td>
						</tr>
						<tr height="5">
							<td align="right">&nbsp;</td>
							<td colspan="3">
							<input type="image" src="resources/images/login_btn.png" style="width:80px;" value="登陆" /></td>
						</tr>
						<tr height="5">
							<td colspan="4" align="center">&nbsp;</td>
						</tr>
						<tr height="5">
							<td align="right">&nbsp;</td>
							<td colspan="3" id="msg" style="color: red;font-size: 12px;">
								&nbsp;&nbsp;<%=null == request.getAttribute("errorMsg") ? "" : request
					.getAttribute("errorMsg")%></td>
						</tr>
						<tr height="97">
							<td colspan="5">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="5">
								<table width="100%">
									<tr>
										<td width="50%">
											<div class="artInfo">
												<strong><font color="#376F6F">客户机要求</font> </strong>
											</div></td>
										<td>
											<div class="artInfo">
												<strong><font color="#376F6F">软件下载</font> </strong>
											</div></td>
									</tr>
									<tr>
										<td valign="top">
											<div class='p3'>
												&#8226;&nbsp;<b>浏览器</b>:&nbsp;IE8.0及以上浏览器<a target="_blank"
													href="http://chrome.360.cn" style="color:red;">(推荐360极速浏览器)</a>
											</div>
											<div class='p3'>
												&#8226;&nbsp;<b>分辨率</b>:&nbsp;1024*768及以上分辨率
											</div></td>
										<td>
											<div class='p3'>
												&#8226;&nbsp;&nbsp;<a style="color:#7b7b7b;" target="_blank"
													href="http://chrome.360.cn">360极速浏览器</a>
											</div>
											<div class='p3'>
												&#8226;&nbsp;&nbsp;<a style="color:#7b7b7b;" target="_blank"
													href="http://www.microsoft.com/zh-cn/download/details.aspx?id=43">IE8(32位简体中文)</a>
											</div></td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td colspan="5" valign="top" align="center">
								<div id='footer-content'
									style='height:18px;margin:0px 2px 0px 2px;padding-top:5px; background-color:#f1eded;font-size:12px;'
									align='center'>© 2013 xx公司 版权所有  当前版本1.1.1</div></td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
</body>
</html>