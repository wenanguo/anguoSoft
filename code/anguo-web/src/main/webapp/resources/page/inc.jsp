<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/extBrowser.js" charset="utf-8"></script>

<!-- 引入my97日期时间控件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker4.8b3/My97DatePicker/WdatePicker.js" charset="utf-8"></script>

<!-- 引入kindEditor插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.7/themes/default/default.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>

<!-- 引入jQuery 
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<!-- 引入bootstrap样式 -->
<link href="${pageContext.request.contextPath}/resources/js/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- <script charset="utf-8" src="${pageContext.request.contextPath}/resources/js/bootstrap-2.3.1/js/bootstrap.min.js" charset="utf-8"></script> -->

<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.3.3/themes/<c:out value="${cookie.easyuiThemeName.value}" default="bootstrap"/>/easyui.css" type="text/css">
<!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.3.3/themes/icon.css" type="text/css"> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 修复EasyUI1.3.3中layout组件的BUG -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.3.3/plugins/jquery.layout.js" charset="utf-8"></script>

<!-- 引入EasyUI Portal插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/extEasyUI.js?v=201305241044" charset="utf-8"></script>

<!-- 扩展EasyUI Icon -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/extEasyUIIcon.css?v=201305232126" type="text/css">

<!-- 扩展jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/extJquery.js?v=201305232145" charset="utf-8"></script>

<!-- jQuery表单函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.form.js" charset="utf-8"></script>

<!--自定义函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/customjs/common.js" charset="utf-8"></script>

<!-- 百度编辑器 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ueditor1_3_6/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ueditor1_3_6/ueditor.all.js"></script>
<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ueditor1_3_6/lang/zh-cn/zh-cn.js"></script>

