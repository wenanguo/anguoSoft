<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeVideo</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goeVideo.js"></script>
		
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
					<tr>
						<td style="text-align:left;font-size:12px;">名称:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="name" name="name"/>
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">预览图:<span style="color:red">*</span></td>
						<td>
							
							<img id="logo_img" name="logo_img" src="" width="120" height="40" >
							<input id="logo_url" name="logo_url" type="file" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">url播放地址:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="url" name="url"/>
							
							<div id="url_div" name="url_div"></div>
							<input id="file_url" name="file_url" type="file" />
							<div id="progress" class="easyui-progressbar" style="width:200px;height:20px;display:none;"></div>
							
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">讲师:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="lecturer" name="lecturer"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">时长:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="duration" name="duration"/>（分钟）
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">视频类别:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="category" name="category" style="width:240px;">
						        <option value="1">上课视频</option>
						        <option value="2">上机模拟视频</option>
						    </select>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">收费类别:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="chargeCategories" name="chargeCategories" style="width:240px;">
						        <option value="1">免费</option>
						        <option value="2">付费</option>
						        <option value="3">在校学员</option>
						    </select>
						</td>
					</tr>
	
					<tr>
						<td style="text-align:left;font-size:12px;">价格:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="price" name="price"/>（元）
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">排序:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="goeOrder" name="goeOrder" value="1"/>
						</td>
					</tr>
				
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="subjectId" name="subjectId" value="">
						
						
						<input type="hidden" id="logo" name="logo" value="">
						
						<input type="hidden" id="optCount" name="optCount" value="">
						<input type="hidden" id="browseCount" name="browseCount" value="">
						
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		