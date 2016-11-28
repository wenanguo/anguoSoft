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

<script type="text/javascript" src="resources/js/Highcharts-2.2.0/js/highcharts.js"></script>
<script type="text/javascript" src="resources/js/Highcharts-2.2.0/js/modules/exporting.js"></script>

<script type="text/javascript" src="jsp/report/js/pieManager.js"></script>
<script type="text/javascript">
			
		
var tool_btns = {'0' : ['-',
{id:"btn_add",text:"新增",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_del",text:"删除",iconCls:"book_delete",disabled:false,handler:function(){doDel();}},'-'
]};
		</script>

</head>
<body class="easyui-layout" data-options="fit:true">

  	
    	<div data-options="region:'center',border:false">
    	<input id='basePath' style="display:none;" value="<%=basePath%>" />
	    	<table id="roleList"></table>
	    	<div id="add" title="新增" style="width:600px;height:360px;"></div>
			<div id="edit" title="修改" style="display:none;width:100px;height:360px;"></div>
	    </div>
	     <div data-options="region:'east',split:true" title="折线图" style="width:610px;">
	     <div id="container" style="width: 600px; height: 400px; margin: 0 auto"></div>
	     </div>

</body>
</html>