<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>CommonSysMember</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/user/js/commonSysMember.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	
	<tr>
						<td style="text-align:left;font-size:12px;">用户名:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="memberName" name="memberName"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">密码:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="password" name="password"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">电话:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="phone" name="phone"/>
						</td>
					</tr>
	
	<tr>
						<td style="text-align:left;font-size:12px;">昵称:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="nickName" name="nickName"/>
						</td>
					</tr>

	<tr>
						<td style="text-align:left;font-size:12px;">性别:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="sex" name="sex" style="width:240px;">
						        <option value="1">男</option>
						        <option value="2">女</option>
						    </select>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">出生日期:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:false" style="width:240px;" id="birthday" name="birthday"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">其他联系方式:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="contact" name="contact"/>
						</td>
					</tr>
	
	<tr>
						<td style="text-align:left;font-size:12px;">邮箱:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="email" name="email"/>
						</td>
					</tr>
	
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						
						<input type="hidden" id="campusId" name="campusId" value="">
						<input type="hidden" id="credits" name="credits" value="">
						<input type="hidden" id="memberClass" name="memberClass" value="">
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		