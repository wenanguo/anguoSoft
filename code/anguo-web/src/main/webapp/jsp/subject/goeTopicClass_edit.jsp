<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoeTopicClass</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goeTopicClass.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	<tr>
						<td style="text-align:left;font-size:12px;">所属科目:<span style="color:red">*</span></td>
						<td>
							<input class="easyui-combobox" 
							data-options="
							url:'goeSubject/comboxlist.htm',
                    		method:'get',
                    		valueField:'id',
                    		textField:'text',
                    		panelHeight:'auto'"
							
							 style="width:240px;" id="subjectId" name="subjectId"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">名称:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="title" name="title"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">备注:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="memo" name="memo"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">类别:<span style="color:red">*</span></td>
						<td>
							<select class="easyui-combobox" id="topicType" name="topicType" style="width:240px;">
							    <option value="1">章节重点</option>
						        <option value="2">章节练习</option>
						        <option value="3">全真模拟</option>
						        <option value="4">课后作业</option>
				</select>
						</td>
					</tr>
					<!-- 
	<tr>
						<td style="text-align:left;font-size:12px;">状态:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="status" name="status"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">操作人:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-numberbox" data-options="required:false" style="width:240px;" id="operateUserId" name="operateUserId"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">操作时间:<span style="color:red">*</span></td>
						<td>
							<input class="input easyui-datetimebox" data-options="required:false" style="width:240px;" id="operateDate" name="operateDate"/>
						</td>
					</tr>
					-->
				
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