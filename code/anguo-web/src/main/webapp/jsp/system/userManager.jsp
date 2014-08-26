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
<script type="text/javascript">
			
var tool_btns = {'0' : ['-',
{id:"btn_add",text:"新增",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_del",text:"删除",iconCls:"book_delete",disabled:false,handler:function(){doDel();}},'-'
]};
		</script>

</head>
<body class="easyui-layout" data-options="fit:true">

  	<input id='basePath' style="display:none;" value="<%=basePath%>" />
    	<div data-options="region:'center',border:false">
	    	<table id="userList"></table>
	    	<div id="add" title="新增" style="width:600px;height:360px;"></div>
			<div id="edit" title="修改" style="display:none;width:600px;height:360px;"></div>
	    </div>

</body>
</html>