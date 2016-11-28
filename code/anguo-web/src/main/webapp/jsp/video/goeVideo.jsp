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
 	<script type="text/javascript" src="jsp/video/js/goeVideo.js"></script> 
 	<script type="text/javascript" src="resources/js/uploadify/jquery.uploadify.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/js/uploadify/uploadify.css" />
 	
	<script type="text/javascript">
			
	
	
var tool_btns = {
'0' : ['-',
{id:"btn_add",text:"新增",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_del",text:"删除",iconCls:"book_delete",disabled:false,handler:function(){doDel();}},'-'
]
};

</script>
  </head>
  <body>
  
  	<div id="cc" class="easyui-layout" data-options="fit:true">
  	
  	<input id='basePath' style="display:none;" value="<%=basePath%>" />
  	<div data-options="region:'west',split:true" title="模块" style="width:200px;">
	   <ul class="easyui-tree" style="padding:10px;fit:true;border:0px" id="subjectTree" ></ul>
	   </div>
	   
	    <div data-options="region:'center',border:false" style="background:#eee;">
		    		<table id="videoGrid"></table>
			    	<div id="add" title="新增" style="width:600px;height:450px;"></div>
			    	<div id="edit" title="修改" style="width:600px;height:450px;"></div>
		    	
	    </div>
	    
	    
	    
	</div>
  </body>
</html>