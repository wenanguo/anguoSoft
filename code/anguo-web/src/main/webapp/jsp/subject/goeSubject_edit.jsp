<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeSubject</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goeSubject.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
					<tr>
						<td style="text-align:left;font-size:12px;">标题:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:true" style="width:240px;" id="title" name="title"/>
						</td>
					</tr>

					
					<tr>
						<td style="text-align:left;font-size:12px;">考试时间:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:true" style="width:240px;" id="examTime" name="examTime"/>

						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">普通会员单价:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-numberbox" data-options="required:true" style="width:240px;" id="generalMemberPrice" name="generalMemberPrice"/> 分
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">全套视频单价:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-numberbox" data-options="required:true" style="width:240px;" id="allVideoPrice" name="allVideoPrice"/>分
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">备注:</td>
						<td>
							<textarea class="input easyui-validatebox" data-options="required:false" style="width:240px;height:60px" id="memo" name="memo"></textarea>
							
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="parentId" name="parentId" value="">
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		