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
	<script type="text/javascript" src="jsp/interaction/js/goeInteraction.js"></script>
	<script type="text/javascript">
			
var tool_btns = {'0' : ['-',
{id:"btn_edit",text:"回复",iconCls:"book_edit",disabled:false,handler:function(){doEdit();}},'-',
{id:"btn_recommend",text:"推荐",iconCls:"book_delete",disabled:false,handler:function(){doRecommend();}},'-',
{id:"btn_not_recommend",text:"不推荐",iconCls:"book_delete",disabled:false,handler:function(){doNotRecommend();}},'-'
]};
		</script>
  </head>
  <body>
  	<div id="cc" class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'north',title:'过滤条件',border:false" style="background:#efefef;border:1px solid #ccc;height:70px;">
	    	<div id="tb" style="padding:3px">
		    	<span>留言内容:</span>
		    	<input id="filterParam" style="line-height:26px;border:1px solid #ccc" onkeydown="setTrack(event)">
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