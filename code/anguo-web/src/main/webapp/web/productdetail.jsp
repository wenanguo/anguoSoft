<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
    <title>锦越和能源网站</title>
		<meta name="Keywords" content="贵阳锦越和能公司">
        <jsp:include page="inc.jsp"></jsp:include>
  </head>
  <body>
<%@ include file="header.jsp"%>
<div align="center">
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="10"></td>
  </tr>
  <tr>
    <td height="39" background="web/images/cpzs.png"><table width="980" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="45">&nbsp;</td>
        <td width="719"><font size="+1">产品详细介绍</font></td>
        <td width="216">您现在的位置：<a href="index.asp">首页</a>&nbsp;&nbsp;>>&nbsp;&nbsp;产品与应用</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="8"></td>
  </tr>
 
  <tr>
    <td height="500" align="center" valign="top" bgcolor="#FFFFFF">
	<table width="980" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="8"></td>
      </tr>
      <tr>
        <td align="center">
   <P align=center>
	   <IMG border=0 src="admin/html/UploadFile/2013510215222161.jpg"><BR>
	   <IMG border=0 src="admin/html/UploadFile/2013510215231796.jpg"><BR>
	   <IMG border=0 src="admin/html/UploadFile/2013510215240397.jpg"><BR>
	   <IMG border=0 src="admin/html/UploadFile/2013510215248649.jpg"><BR>
	   <IMG border=0 src="admin/html/UploadFile/2013510215256127.jpg">
   </P>
	</td>
      </tr>
    </table>
	  </td>
  </tr>
    
</table>

</div>
<%@ include file="footer.jsp"%>
  </body>
</html>