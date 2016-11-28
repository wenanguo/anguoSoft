<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>黔聚软件</title>
    <title>新增内容</title>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editCurrentUserPwdForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
					<tr>
						<td style="text-align:left;font-size:12px;">新密码:<span style="color:red">*</span></td>
						<td>
							<input type="password" id="password" name="password" class="easyui-validatebox" style="width:240px;" validType="length[6,25]" required="required" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">确认密码:<span style="color:red">*</span></td>
						<td>
							<input type="password" id="repassword" name="repassword" class="easyui-validatebox" style="width:240px;"  validType="length[6,25]" required="required" />
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
						</td>
					</tr>
					
					</table>
			</form>
		</div>
	</div>
</body>