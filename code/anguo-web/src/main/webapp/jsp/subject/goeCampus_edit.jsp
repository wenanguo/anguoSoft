<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeCampus</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/subject/js/goeCampus.js"></script>
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
						<td style="text-align:left;font-size:12px;">地址:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="address" name="address"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">logo:<span style="color:red">*</span></td>
						<td>
							
							 <img id="logo_img" name="logo_img" src="" width="120" height="40" >
							<input id="logo_url" name="logo_url" type="file" />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">联系人:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="contactMan" name="contactMan"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">联系电话:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="contactPhone" name="contactPhone"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">备注:<span style="color:red">*</span></td>
						<td>
							<textarea class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="memo" name="memo"></textarea>
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