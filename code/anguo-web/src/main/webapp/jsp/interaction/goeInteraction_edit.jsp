<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeInteraction</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/interaction/js/goeInteraction.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	
					<tr>
						<td style="text-align:left;font-size:12px;">留言内容:<span style="color:red">*</span></td>
						<td>
							<textarea  id="message" name="message" readonly="true" style="width:240px; height:100px" type="text"></textarea>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">回复内容:<span style="color:red">*</span></td>
						<td>
							<textarea  id="replyMessage" name="replyMessage"  style="width:240px; height:100px" type="text"></textarea>
						</td>
					</tr>
				
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="memberId" name="memberId" value="">
						<input type="hidden" id="recommend" name="recommend" value="">
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		