<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//获得分页URL
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>
<c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.title' }">
        	${webConfig.content}
        	</c:if>
</c:forEach>
</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/web/images/2.ico"/>
<meta name="Keywords" content="贵阳锦越和能公司">
<jsp:include page="inc.jsp"></jsp:include>
  </head>
  <body>
  
<%@ include file="header.jsp"%>

<div align="center">
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="10" colspan="3"></td>
    </tr>
  <tr>
    <td width="240">
<table width="240" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="39" background="web/images/gg.png" align="center"><a href="web/index.htm"><font color="#575352"><strong>在线公告</strong></font></a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="220" valign="top" bgcolor="#FFFFFF">
	<div align="center">
	<table width="220" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td height="8"></td>
      </tr>
 	  
      <tr>
        <td>
		<marquee direction="up" scrollamount="2" onmouseout="start()" onmouseover="stop()">
		
		<c:forEach var="news" items="${orderNoticeList}" varStatus="vs">
              <c:if test="${vs.count ==1}">
              	${news.content}
			  </c:if>
		</c:forEach>
		</marquee>
		</td>
      </tr>
 
    </table>
	</div>
	</td>
  </tr>
</table>
</td>
    <td width="20" valign="top">&nbsp;</td>
    <td width="720" valign="top"><table width="720" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="39" background="web/images/jj.png"><table width="720" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="49">&nbsp;</td>
            <td width="592"><font color="#575352"><strong>公司简介</strong></font></td>
            <td width="79"><a href="web/newsdetail.htm?id=38"><font color="#575352">查看全文...</font></a></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="3"></td>
      </tr>
      <tr>
        <td height="217" valign="top" bgcolor="#FFFFFF">
		<div align="center">
		<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8" colspan="3"></td>
          </tr>
          <tr>
            <td width="192"><table width="190" border="0" cellpadding="0" cellspacing="0" class="tab1">
              <tr>
                <td height="198"><img src="web/images/gsjj.jpg" width="190" height="198" /></td>
              </tr>
            </table></td>
            <td width="10"></td>
 	  
            <td width="498" valign="top">
            
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(companyProfile.content, 0, 350)}...
            
            </td>
 
          </tr>
        </table>
		</div>
		</td>
      </tr>
    </table></td>
  </tr>
</table>
</div>

<div align="center">
<table width="980" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="10"></td>
  </tr>
  <tr>
    <td height="39" background="web/images/cpzs.png"><table width="980" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="47">&nbsp;</td>
        <td width="859"><font color="#575352"><strong>产品展示</strong></font></td>
        <td width="74"><a href="web/newslist.htm?webNewsTypeId=4">更多...</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
  <tr>
    <td height="180" valign="top" bgcolor="#FFFFFF">

<script type="text/javascript"> 
document.write('<table align=center width="980" border=0 cellpadding=0 cellspacing=0 style=BORDER-LEFT: #cccccc 1px solid;BORDER-RIGHT: #cccccc 1px solid>'); 
document.write(' <tr> '); 
document.write(' <td width=980 height=150 align=center class=border01 bgcolor=#FFFFFF>'); 
document.write(' <div id=demo style=overflow:hidden;width:980;align=center>'); 
document.write(' <table border=0 align=center cellpadding=1 cellspacing=1 cellspace=0 >'); 
document.write(' <tr>'); 
document.write(' <td valign=top bgcolor=ffffff id=marquePic3> '); 
document.write(' <table width=100% border=0 cellspacing=0 cellpadding=0>'); 
document.write(' <tr align=center> '); 



<c:forEach var="news" items="${rollNewsList}"
	varStatus="vs">

	<c:if test="${vs.count <10}">
	document.write('   <td bgcolor="#F9F9F9" ><a href="web/newsdetail.htm?id=${news.id}"><div style="height:150px;width:227px;"  ><img src="web/images/upload/${news.previewImg}" border="0" /></div></a>&nbsp;&nbsp;<br>${news.mainTitle}</td>');
	</c:if>
	</c:forEach>
	
 

document.write(' </table>'); 
document.write(' </td>'); 
document.write(' <td id=marquePic4 valign=top></td>'); 
document.write(' </tr>'); 
document.write(' </table>'); 
document.write(' </div>'); 
document.write(' </td>'); 
document.write(' </tr>'); 
document.write(' </table>'); 
var speed="30"
marquePic4.innerHTML=marquePic3.innerHTML 
function Marquee(){ 
if(demo.scrollLeft>=marquePic3.scrollWidth){ 
demo.scrollLeft=0
}else{ 
demo.scrollLeft++ 
} 
} 
var MyMar=setInterval(Marquee,speed) 
demo.onmouseover=function() {clearInterval(MyMar)} 
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)} 

              </script>	
	</td>
  </tr>
</table>
</div>

<div align="center">
<table width="980" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="10"></td>
  </tr>
  <tr>
    <td height="157"><img src="web/images/lxwm.jpg" width="980" height="157" border="0" usemap="#Map" /></td>
  </tr>
</table>
</div>


<map name="Map" id="Map"><area shape="rect" coords="5,9,296,152" href="web/newslist.htm?webNewsTypeId=9" />
<area shape="rect" coords="345,10,639,153" href="web/newslist.htm?webNewsTypeId=6" />
<area shape="rect" coords="682,7,970,153" href="web/newslist.htm?webNewsTypeId=5" />
</map>

   
   <%@ include file="footer.jsp"%>
  </body>
</html>