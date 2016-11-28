<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
body{ padding:0; margin:0; font-family:"Arial Black", Gadget, sans-serif; background:url(resources/images/login-bg.jpg); text-align:center}
ul,li{ padding:0; margin:0; list-style:none}
.login_page{ width:1000px; margin:0 auto}
.login_header{ background:url(resources/images/login-logo.jpg) no-repeat; float:left; height:100px; width:100%}
.login_content{ overflow:hidden; height:455px; padding:50px 0 0 0; width:100%}
.login_banner{ float:left; width:700px; background:url(resources/images/login-banner.jpg) no-repeat; height:455px;}
.login_form{ float:left; width:300px; overflow:hidden; height:400px; margin-top:100px}
.login_form_title{ background:url(resources/images/login_form_line.png) repeat-x left bottom; height:40px; line-height:40px; vertical-align:middle; color:#0081cc; font-size:18px; text-align:left}
.login_form_content{ overflow:hidden; height:400px}
.login_form_content ul li{ float:left; width:100%; margin-top:10px; text-align:left}
.login_form_content ul li label{ float:left; width:50px; line-height:40px; vertical-align:middle; padding:0 10px}
.login_form_content ul li span{ margin-left:10px;}
input:focus{ outline:none;}
.text{border-radius:5px;border:1px solid #aaa;-webkit-transition: box-shadow 0.30s ease-in-out;-moz-transition:  box-shadow 0.30s ease-in-out; height:30px; padding:5px 10px; font-size:16px; background:#f9f9f9}
.user{ width:200px;}
.code{width:100px}
.text:focus{outline:none;border:#87C6F9 1px solid;box-shadow: 0 0 8px rgba(103, 166, 217, 1); background:#FFF}
.button, .button:visited {
	display: inline-block;
	color: #fff;
	text-decoration: none;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	-moz-box-shadow: 0 1px 3px rgba(0,0,0,0.6);
	-webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.6);
	text-shadow: 0 -1px 1px rgba(0,0,0,0.25);
	border-bottom: 1px solid rgba(0,0,0,0.25);
	position: relative;
	cursor: pointer;
	border:0;
}
.button:hover {background-color: #111;color: #fff;}
.button:active {top: 1px;}
.large.button, .large.button:visited {font-size: 14px;padding: 8px 0 9px;width:220px; margin-top:20px}
.blue.button, .blue.button:visited {background-color: #fcbb17;}
.blue.button:hover {background-color: #f0b41d;}
.footer{ position:absolute; bottom:0; height:90px; background:#fcbb17;width:100%; color:#FFF;}
.footer p{ margin:0; padding:0; float:left; text-align:center; width:50%; height:90px; line-height:90px; vertical-align:middle; font-size:12px}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript">

<c:if test="${param.error==true}" >
alert('用户名或者密码错误，请重新输入');
</c:if>

	//注册键盘事件
	$(document).keydown(function(event){ 
           if(event.keyCode==13){
           	
           		submitFrom();
           }
      });

	/**
	*  提交表单
	*/
    function submitFrom()
    {
    	if(validateForm())
    	{
			 $('#loginfrom').submit();  	
    	}
    }
	
	/**
	*  验证表单
	*/
	function validateForm() {
		var regRequired = /^\S+$/;
		var loginname = $("#j_username").val();
		var password = $("#j_password").val();
		var randomcode = $("#j_verifyCode").val();
		
		// 验证账号
		if(!regRequired.test(loginname)) {
			alert("账号不能为空！");
			return false;
		}
		
		// 验证密码
		if(!regRequired.test(password)) {
			alert("密码不能为空！");
			return false;
		}
		
		  
		// 验证码
		if(!regRequired.test(randomcode)) {
			alert("验证码不能为空！");
			return false;
		}
	
		return true;
	}
</script>
<title>考神后台管理系统—登录</title>
</head>
<body>





<div class="login_page">
	<div class="login_header"></div>
    <div class="login_content">
    	<div class="login_banner"></div>
        <div class="login_form">
        	<div class="login_form_title">用户登录</div>
        	<form id="loginfrom" action="j_spring_security_check" method="post">
            <div class="login_form_content">
            	<ul>
                	<li><label>用户名</label><input type="text" id="j_username" name="j_username" class="text user" /></li>
                    <li><label>密码</label><input type="password" id="j_password" name="j_password" class="text user"/></li>
                    <li><label>验证码</label><input type="text" id="j_verifyCode" name="j_verifyCode" class="text code" />
				     <img onclick="reloadRandomCode()" width="70" id="rcode" src="randomcode.jpg" /></li>
                    <li><label>&nbsp;</label><input type="button" value="登  录" onclick="submitFrom();" class="large button blue"/></li>
                </ul>
            </div>
            </form>
        </div>
    </div>
</div>
<div class="footer">
	<p>客户端浏览器: IE7.0及以上浏览器(推荐Chrome、Firefox浏览器)</p>
    <p>技术支持 ? 贵州敏捷开发团队</p>
</div>


</body>
</html>