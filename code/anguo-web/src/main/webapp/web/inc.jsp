<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.shortcutIcon' }">
        	${webConfig.content}
        	</c:if>
        </c:forEach>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/info.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/css.css"  > 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/headstyle.css">
<script src="${pageContext.request.contextPath}/web/js/yu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/web/js/tb.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js" type="text/javascript"></script>
