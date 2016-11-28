<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>CommonSysJob</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/commonSysJob.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	<tr>
						<td style="text-align:left;font-size:12px;">任务名称:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="jobName" name="jobName"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">任务分组:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="jobGroup" name="jobGroup"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">作业类:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="jobClass" name="jobClass"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">任务运行表达式:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="cronExpression" name="cronExpression"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">任务描述:<span style="color:red">*</span></td>
						<td>
							<textarea id="memo" name="memo"  style="width:240px; height:100px" type="text"></textarea>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		