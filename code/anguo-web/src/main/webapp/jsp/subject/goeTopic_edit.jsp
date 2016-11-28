<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeTopic</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goeTopic.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	<tr>
						<td style="text-align:left;font-size:12px;">题目编号:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:true" style="width:240px;" id="topicId" name="topicId"/>
						</td>
					</tr>
	
					<tr>
						<td style="text-align:left;font-size:12px;">标题:<span style="color:red">*</span></td>
						<td>
							<textarea style="width:600px;height:200px;" type="text" id="title" name="title"></textarea>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">题目类型:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="topicType" name="topicType" style="width:240px;">
						        <option value="1">单选题</option>
						        <option value="2">多选题</option>
						        <option value="3">判断题</option>
						    </select>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">正确答案:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="rightAnswer" name="rightAnswer"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">分值:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="value" name="value"/>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">答案解析:<span style="color:red">*</span></td>
						<td>
							<textarea  id="analysis" name="analysis" style="width:240px; height:100px" type="text"></textarea> 
						</td>
					</tr>
					<!-- 
					<tr>
						<td style="text-align:left;font-size:12px;">题型类别:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="topicClass" name="topicClass"/>
						</td>
					</tr>
					
	<tr>
						<td style="text-align:left;font-size:12px;">审核人:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="auditor" name="auditor"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">审核时间:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:false" style="width:240px;" id="auditDatetime" name="auditDatetime"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">审核意见:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="auditOpinion" name="auditOpinion"/>
						</td>
					</tr>
					 -->
					
				
					<tr style="height:0px;">
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="topicClassId" name="topicClassId" value="">
						
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		