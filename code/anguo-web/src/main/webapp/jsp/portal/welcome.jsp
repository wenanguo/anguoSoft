<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

%>
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
<script type="text/javascript">


	

</script>
</head>
<body>
	<div style="padding: 10px;">
        <ul>
            <li><img alt="" class="avatar s30" src="resources/images/qqjia_094[1].jpg" width="30px" height="30px" /></li>
            	<br>
            <li><div id="wrealName" name="wrealName" ></div></li>
            
        </ul>
	</div>
</body>
</html>