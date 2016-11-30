<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>    
    <title>upload test</title>
    <base href="<%=basePath%>">
	

  </head>
  
  <body>
  <form name="form1" METHOD="POST" ACTION="http://117.135.196.139:10032/crm/appcommon/file/upload.app" ENCTYPE="multipart/form-data">

	<input name="file" type="file" id="file" size="50" > 
	<input type="hidden" id="saveFilePath" name="saveFilePath" value="/crm/upload/">
	<input type="hidden" id="appCurName" name="appCurName" value="gzcrm">
	
	
<input name="ok" type= "submit" value="提交">
</form>

  </body>
</html>
