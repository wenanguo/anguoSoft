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
	<script type="text/javascript" src="jsp/subject/js/goeTopicClass.js"></script>
	<script type="text/javascript">
			
var tool_btns = {'0' : ['-',
{id:"btn_add",text:"新增",iconCls:"book_add",disabled:false,handler:function(){doAdd();}},'-',
{id:"btn_edit",text:"修改",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_del",text:"删除",iconCls:"book_delete",disabled:false,handler:function(){doDel();}},'-'
]};
		</script>
  </head>
  <body>
  	<div id="cc" class="easyui-layout" data-options="fit:true">
  	
  	<div data-options="region:'west',split:true" title="模块" style="width:200px;">
	   <ul class="easyui-tree" style="padding:10px;fit:true;border:0px" id="subjectTree" ></ul>
	   </div>
  	
	    <div data-options="region:'north',title:'过滤条件',border:false" style="background:#efefef;border:1px solid #ccc;height:70px;">
	    	<div id="tb" style="padding:3px">
		    	<span>名称:</span>
		    	<input id="filterParam" style="border:1px solid #ccc;" onkeydown="setTrack(event)">
		    	<span>类别:</span>
		    	<select class="easyui-combobox" id="filterTopicType" name="filterTopicType" style="width:80px;">
		    	                <option value="1">章节重点</option>
						        <option value="2">章节练习</option>
						        <option value="3">全真模拟</option>
						        <option value="4">课后作业</option>
				</select>
		    	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'webcam'" onclick="doSearch()">查询</a>
		    	
		    	<span style="color:red"></span>
		    </div>
	    </div>
	    <div data-options="region:'center',border:false" style="background:#eee;">
	    	<table id="projectStageConfig"></table>
	    	<div id="add" title="新增" style="width:600px;height:360px;"></div>
			<div id="edit" title="修改" style="display:none;width:600px;height:360px;"></div>
	    </div>
	</div>
  </body>
</html>