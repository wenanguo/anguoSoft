<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeAd</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goeAd.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
					<tr>
						<td style="text-align:left;font-size:12px;">标题:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="title" name="title"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">类别:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="adType" name="adType" style="width:240px;">
						        <option value="1">内容</option>
						        <option value="2">链接</option>
						    </select>
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">logo:<span style="color:red">*</span></td>
						<td>
							<span><img id="logo_img" name="logo_img" src="" width="120" height="40" ></span>
							
							<span><input id="logo_url" name="logo_url" type="file" /></span>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">连接地址:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="url" name="url"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">位置:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="location" name="location" style="width:240px;">
						        <option value="1">跑马灯</option>
						        <option value="2">工具栏</option>
						        <option value="3">底部</option>
						    </select>
							
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">所属校区:<span style="color:red">*</span></td>
						<td>
							<input class="easyui-combobox" 
							data-options="
							url:'goeCampus/listAll.htm',
                    		method:'get',
                    		valueField:'id',
                    		textField:'name',
                    		panelHeight:'auto'"
							
							 style="width:240px;" id="campusId" name="campusId"/></input>
						</td>
					</tr>
					
					
					<tr>
						<td style="text-align:left;font-size:12px;">排序:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="adOrder" name="adOrder"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">推广:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="isAd" name="isAd" style="width:240px;">
						        <option value="1">正常内容</option>
						        <option value="2">推广广告</option>
						    </select>
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">开始时间:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:false" style="width:240px;" id="startDate" name="startDate"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">结束时间:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:false" style="width:240px;" id="endDate" name="endDate"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">内容:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="content" name="content"/>
						</td>
					</tr>
				
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="logo" name="logo" value="">
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		