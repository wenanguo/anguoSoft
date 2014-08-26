<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div  align="center">
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="10" colspan="2"></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="6" colspan="2"></td>
  </tr>
  <tr>
    
    <td width="13" background="web/images/footerbg.jpg">&nbsp;</td>
    <td width="855" background="web/images/footerbg.jpg">
	    <table width="850" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="25">
	        
	        <c:forEach var="webConfig" items="${webConfigList}">
	        	<c:if test="${webConfig.code == 'config.linkBottom' }">
	        	${webConfig.content}
	        	</c:if>
	        </c:forEach>
	        </td>
	      </tr>
	      <tr>
	        <td height="25">
	        <c:forEach var="webConfig" items="${webConfigList}">
	        	<c:if test="${webConfig.code == 'config.copyright' }">
	        	${webConfig.content}
	        	</c:if>
	        </c:forEach>
	        <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_5875017'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/stat.php%3Fid%3D5875017%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));</script>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table><br />

</div>
   