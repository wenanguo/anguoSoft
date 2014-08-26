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
<script type="text/javascript" src="jsp/news/js/newsManager.js"></script>

    <title>新增内容</title>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="addForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
					<tr>
						<td style="text-align:left;font-size:12px;">代码:<span style="color:red">*</span></td>
						<td>
							<input id="code" name="code" class="easyui-validatebox" style="width:240px;" validType="length[0,25]" required="required" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">标题:<span style="color:red">*</span></td>
						<td>
							<input id="title" name="title" class="easyui-validatebox" style="width:240px;"  validType="length[0,25]" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">内容类别:<span style="color:red">*</span></td>
						<td>
							<input type="radio" name="radio" value="1" checked="checked"/>图文
							<input type="radio" name="radio" value="4" />连接
						</td>
					</tr>
					
					
					
					<tr>
						<td style="text-align:left;font-size:12px;">状态:<span style="color:red">*</span></td>
						<td>
							<input type="radio" name="state" value="100" checked="checked"/>启用
							<input type="radio" name="state" value="104" />停用
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:left;font-size:12px;width:100%;">
						<textarea  id="content" name="content" style="width:540px; height:200px" type="text">
						</textarea> 
						<script type="text/javascript">
								
								   ueAdd = UE.getEditor("content");
								
						</script>
						
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
						
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="contentType" name="contentType" value="1"> 
						</td>
					</tr>
					
					</table>
			</form>
			
		</div>
	</div>
</body>