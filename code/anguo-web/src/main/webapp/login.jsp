<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
<jsp:include page="resources/page/inc.jsp"></jsp:include>
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
<title>黔聚软件</title>
</head>
<body>

<div id="login">
	
	     <div id="top">
		      <div id="top_left"><img src="resources/images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 <form id="loginfrom" action="j_spring_security_check" method="post">
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div style="margin-left:20px; margin-top:15px; height:25px;">用户名：
			         <input type="text" id="j_username" name="j_username" style="width:120px;"/>
			       </div>
				   <div style="margin-left:20px; margin-top:15px; height:25px;">密&nbsp;&nbsp;&nbsp;码：
				     <input type="password" id="j_password" name="j_password" style="width:120px;"/>
				   </div>
				   <div style="margin-left:20px; margin-top:15px; height:25px;">验证码：
				     <input type="text" id="j_verifyCode" name="j_verifyCode" style="width:60px;" />
				     <img onclick="reloadRandomCode()" width="70" style="margin-top:0px;margin-bottom:10px; height:25px;" height="21" id="rcode" src="randomcode.jpg" />
				   </div>
				   <div id="btn">
					   <a href="javascript:submitFrom();">登录</a>
					   <a href="#">清空</a>
				   </div>
			  
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 </form>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">黔聚软件   版权所有 2013 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>

</body>
</html>