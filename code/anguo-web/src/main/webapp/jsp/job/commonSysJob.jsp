<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title></title>
    <jsp:include page="../../resources/page/inc.jsp"></jsp:include>
	<script type="text/javascript" src="jsp/job/js/commonSysJob.js"></script>
	<script type="text/javascript">
			
var tool_btns = {'0' : ['-',
{id:"btn_add",text:"新增作业",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改作业",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_start",text:"启动",iconCls:"book_go",disabled:false,handler:function(){doStart();}},'-',
//{id:"btn_pause",text:"暂停",iconCls:"book_edit",disabled:false,handler:function(){doPause();}},'-',
//{id:"btn_resume",text:"恢复",iconCls:"book_edit",disabled:false,handler:function(){doResume();}},'-',
{id:"btn_stop",text:"停用",iconCls:"book_delete",disabled:false,handler:function(){doStop();}},'-',
{id:"btn_trigger",text:"立即运行一次",iconCls:"book_link",disabled:false,handler:function(){doTrigger();}},'-'

]};
		</script>
  </head>
  <body>
  	<div id="cc" class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false" style="background:#eee;">
	    	<table id="projectStageConfig"></table>
	    	<div id="add" title="新增" style="width:600px;height:460px;"></div>
			<div id="edit" title="修改" style="display:none;width:600px;height:460px;"></div>
	    </div>
	</div>
  </body>
</html>