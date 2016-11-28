<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title></title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
		
<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
<script type="text/javascript" src="jsp/subject/js/goeKnowledgePoint.js"></script>
	<script type="text/javascript">
			
var tool_btns = {'0' : ['-',
{id:"btn_add",text:"新增",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_del",text:"删除",iconCls:"book_delete",disabled:false,handler:function(){doDel();}},'-'
]};
</script>



</head>

<body>
<div id="dd" class="easyui-layout" data-options="fit:true">
 <div data-options="region:'west',split:true" title="科目" style="width:200px;">
	<ul class="easyui-tree" style="padding:10px;fit:true;border:0px" id="subjectTree" ></ul>
 </div>
  <div data-options="region:'center',title:'',iconCls:'icon-ok'">
  	<div id="cc" class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false" style="background:#eee;">
	    	<table id="browgrid"></table>
	    	<div id="add" title="新增" style="width:850px;height:500px;"></div>
	    </div>
	</div>
  </div>
</div>
  </body>
</html>
