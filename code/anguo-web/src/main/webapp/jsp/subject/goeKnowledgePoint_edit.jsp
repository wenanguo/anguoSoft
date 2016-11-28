<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>章节重点输入口</title>
<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
</head>
<body>

	<script type="text/javascript"
		src="jsp/subject/js/goeKnowledgePoint_edit.js"></script>
	<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset"
			data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0'
					cellpadding='1'>

					<tr>
						<td style="text-align:left;font-size:12px;"><span
							style="color:red"></span>
						</td>
						<td>
						<textarea style="width:700px;height:200px;" type="text"
								id="content" name="content"></textarea> 
								
					    </td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value="">
						<input type="hidden" id="topicClassId" name="topicClassId" value="">
						<input type="hidden" id="url" name="url" value="">

						</td>
					</tr>

				</table>
			</form>

		</div>

	</div>


</body>

</html>
