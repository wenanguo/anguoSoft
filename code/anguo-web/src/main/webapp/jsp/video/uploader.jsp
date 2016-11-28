<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(request.getServletPath());
%>
<html>
  <head>    
    <title>upload test</title>
    <base href="<%=basePath%>">
	

  </head>
  
  <body>
  <FORM name="form1" METHOD="POST" ACTION="abc/toMultiUpload.htm" ENCTYPE="multipart/form-data">

	<input name="file" type="file" id="file" size="50" > 
	
<input name="ok" type= "submit" value="提交">
</form>

  </body>
</html>
