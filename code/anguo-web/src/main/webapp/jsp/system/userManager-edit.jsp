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
<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
<script type="text/javascript" src="jsp/system/js/userManager.js"></script>

    <title>编辑</title>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
					<tr>
						<td style="text-align:left;font-size:12px;">用户名:<span style="color:red">*</span></td>
						<td>
							<input id="userName" name="userName" class="easyui-validatebox" style="width:240px;" validType="length[0,25]" required="required" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">真实姓名:<span style="color:red">*</span></td>
						<td>
							<input id="realName" name="realName" class="easyui-validatebox" style="width:240px;"  validType="length[0,25]" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">出生年月:<span style="color:red">*</span></td>
						<td>
							<input id="birthday" name="birthday" class="input easyui-datetimebox"  data-options="required:true" type="text" style="border:1px #A4BED4;width:240px;" />
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">电子邮件:<span style="color:red">*</span></td>
						<td>
							<input id="email" name="email" class="easyui-validatebox" style="width:240px;" data-options="required:true,validType:'email'" />
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">手机:<span style="color:red">*</span></td>
						<td>
							<input id="phone" name="phone" class="easyui-validatebox" style="width:240px;" data-options="required:true" />
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">状态:<span style="color:red">*</span></td>
						<td>
							<input type="radio" name="status" value="100" checked="checked"/>启用
							<input type="radio" name="status" value="104" />停用
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="roleIds" name="roleIds" value="">
						</td>
					</tr>
					
					</table>
			</form>
			
		</div>
		<div data-options="region:'east'" title="所属角色" style="width:200px;">
		
		<ul class="easyui-tree" style="fit:true;border:0px" id="roleTree" ></ul>
		
		
		</div>
		
	</div>
</body>