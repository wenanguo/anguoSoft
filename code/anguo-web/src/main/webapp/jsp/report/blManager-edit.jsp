<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>黔聚软件</title>
<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
<script type="text/javascript" src="jsp/system/js/userManager.js"></script>

    <title>编辑</title>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
					<tr>
						<td style="text-align:left;font-size:12px;">地区名称:<span style="color:red">*</span></td>
						<td colspan="3">
							<input id="name" name="name" class="easyui-validatebox" style="width:240px;" validType="length[0,25]" required="required" />
						</td>
						
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">一月:<span style="color:red">*</span></td>
						<td>
							<input id="m1" name="m1" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">二月:<span style="color:red">*</span></td>
						<td>
							<input id="m2" name="m2" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">三月:<span style="color:red">*</span></td>
						<td>
							<input id="m3" name="m3" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">四月:<span style="color:red">*</span></td>
						<td>
							<input id="m4" name="m4" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">五月:<span style="color:red">*</span></td>
						<td>
							<input id="m5" name="m5" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">六月:<span style="color:red">*</span></td>
						<td>
							<input id="m6" name="m6" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">七月:<span style="color:red">*</span></td>
						<td>
							<input id="m7" name="m7" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">八月:<span style="color:red">*</span></td>
						<td>
							<input id="m8" name="m8" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">九月:<span style="color:red">*</span></td>
						<td>
							<input id="m9" name="m9" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">十月:<span style="color:red">*</span></td>
						<td>
							<input id="m10" name="m10" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
					</tr>
					<tr>
						<td style="text-align:left;font-size:12px;">十一月:<span style="color:red">*</span></td>
						<td>
							<input id="m11" name="m11" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
						</td>
						<td style="text-align:left;font-size:12px;">十二月:<span style="color:red">*</span></td>
						<td>
							<input id="m12" name="m12" class="easyui-numberspinner" style="width:140px;" data-options="min:-100,max:100,required:true"  />
							<input type="hidden" id="id" name="id" value="">
						</td>
					</tr>
					</table>
			</form>
			
		</div>
		
	</div>
</body>