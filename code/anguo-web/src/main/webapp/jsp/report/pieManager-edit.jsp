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
						<td style="text-align:left;font-size:12px;">浏览器名称:<span style="color:red">*</span></td>
						<td>
							<input id="name" name="name" class="easyui-validatebox" style="width:240px;" validType="length[0,25]" required="required" />
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">占比:<span style="color:red">*</span></td>
						<td>
							<input id="y" name="y" class="easyui-numberspinner" style="width:240px;" data-options="min:10,max:100,required:true"  />
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="eName" name="eName" value="">
						</td>
					</tr>
					
					</table>
			</form>
			
		</div>
		
	</div>
</body>