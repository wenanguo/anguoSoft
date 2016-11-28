<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
   <title><c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.title' }">
        	${webConfig.content}
        	</c:if>
        </c:forEach></title>
       <meta name="Keywords" content="贵阳锦越和能公司">
        <jsp:include page="inc.jsp"></jsp:include>
  </head>
  <body>
  <%@ include file="header.jsp"%>

<div align="center">
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="5" colspan="3"></td>
  </tr>
  <tr>
    <td width="250" valign="top">
    
    <table width="250" border="0" cellspacing="0" cellpadding="0">
     
     
     
      <tr>
        <td height="30" align="center">
<table width="240" height="199" border="0" cellpadding="0" cellspacing="0" background="web/images/r2.png">
  <tr>
    <td valign="top">
    
     <c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.contactUs' }">
        	${webConfig.content}
        	</c:if>
     </c:forEach>
    
    
    </td>
  </tr>
</table>
</td>
      </tr>
    </table>
    
    </td>
    <td width="20">&nbsp;</td>
    <td width="710" valign="top"><table width="710" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="4"></td>
      </tr>
      <tr>
        <td height="39" background="web/images/left_.png"><table width="710" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46">&nbsp;</td>
            <td width="429">${currWebNewsType.title}</td>
            <td width="235" align="right"><a href="javascript:history.go(-1);">返回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="5"></td>
      </tr>
      <tr>
        <td height="600" valign="top" bgcolor="#FFFFFF">
		<div align="center">
		<table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
       <tr>
            <td>

<table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
	    <tr>
          <td><table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="5"></td>
          </tr>
	    <tr>
          <td>
	
      <table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="0"></td>
        </tr>
      
	    <tr>
          <td height="28" align="center" class="f1">
          </br>
          <font color="#000000" size="6"><strong>${currWebNews.mainTitle}</strong></font>
          
           <c:if test="${(not empty currWebNews.subTitle)}">
            </br>
            </br>--
          	<font color="#000000" >${currWebNews.subTitle}</font>
          	</c:if>
          	</br>
          </br>
          </td>
        </tr>
	    <tr>
          <td height="20" align="right">发布时间：<fmt:formatDate value="${currWebNews.operateDate}" type="both" dateStyle="default" timeStyle="default"/></font></td>
        </tr>
	    <tr>
          <td height="1" bgcolor="#ff5b00"></td>
        </tr>
	    <tr>
          <td height="20"></td>
        </tr>
	    <tr>
          <td class="f2">
          
          <c:if test="${(currWebNews.isDisplayPreviewImg == 1)||(currWebNews.isDisplayPreviewImg == 3)}">
          	<img src="web/images/upload/${currWebNews.previewImg}" border="0"  />
          	</br>
          </c:if>
          
          ${currWebNews.content}
          

		
		</td>
        </tr>
		
		
			
		<tr>
          <td class="f1" align="right">&nbsp;&nbsp;&nbsp;您是第：${currWebNews.hits}&nbsp;位访客&nbsp;&nbsp;</td>
        </tr>
	    <tr>
          <td class="f1" align="right"><a href="javascript:scroll(0,0)"><font color="#FF0000">返回顶部</font></a>&nbsp;&nbsp;</td>
        </tr>
      </table>
	  
	  
</td>
        </tr>
        </table></td>
        </tr>
        </table>
		
			</td>
          </tr>

        </table></div></td>
      </tr>
      <tr>
        <td height="3"></td>
      </tr>
    </table></td>
  </tr>
</table>
</div>
<%@ include file="footer.jsp"%>
   
  </body>
</html>