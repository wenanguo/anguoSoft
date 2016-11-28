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
						<td style="text-align:left;font-size:12px;">主标题:<span style="color:red">*</span></td>
						<td>
							<input id="mainTitle" name="mainTitle" class="easyui-validatebox" style="width:240px;" validType="length[0,25]" required="required" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">副标题:<span style="color:red">*</span></td>
						<td>
							<input id="subTitle" name="subTitle" class="easyui-validatebox" style="width:240px;"  validType="length[0,25]" />
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">标红:<span style="color:red">*</span></td>
						<td>
							<input type="radio" name="isRed" value="2" checked="checked"/>是
							<input type="radio" name="isRed" value="1" />否
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">显示图片:<span style="color:red">*</span></td>
						<td>
							<input type="radio" id="isDisplayPreviewImg" name="isDisplayPreviewImg"  value="1" />都显示
							<input type="radio" id="isDisplayPreviewImg" name="isDisplayPreviewImg"  value="2" />概要显示
							<input type="radio" id="isDisplayPreviewImg" name="isDisplayPreviewImg"  value="3" />内容显示
							<input type="radio" id="isDisplayPreviewImg" name="isDisplayPreviewImg"  value="4" checked="checked"/>都不显示
						</td>
					</tr>
					
					<tr id="previewImg_table" name="previewImg_table">
						<td style="text-align:left;font-size:12px;">图片:</span></td>
						<td>
							 <img id="previewImg_img" src="" width="120" height="40" onclick="triggerFile();">
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
						<input type="hidden" id="webNewsTypeId" name="webNewsTypeId" value="">
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="previewImg" name="previewImg" value="">
						<input type="hidden" id="contentType" name="contentType" value="1">
						 
						</td>
					</tr>
					
					</table>
			</form>
			    <table class="table" style="display:none" width="100%" border='0' cellspacing='0' cellpadding='1'>
					<tr>
						<td style="text-align:left;font-size:12px;">   </td>
						<td>
							 <form id="previewImg_form" action="toFileUpload/toMultiUpload.htm" method="post" enctype="multipart/form-data">
								<input type="file" id="file" name="file" onchange="uploadSuccess('previewImg')">
							</form>
						</td>
					</tr>
				</table>
			
			
		</div>
	</div>
</body>