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
 	<script type="text/javascript" src="resources/js/uploader/jquery.uploadify.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/js/uploader/uploadify.css" />
	
<title>Insert title here</title>
</head>
<body>
<input id='basePath' style="display:none;" value="<%=basePath%>" />

<div id="progress" name="progress"></div>

<input id="file" name="file" type="file" />


</body>
<script type="text/javascript">
	
	/**
	 * 文件上传完成后回调方法
	 * 
	 * @param event
	 * @param ID
	 * @param fileObj
	 * @param response
	 * @param data
	 *            {"client":"实际文件名","server":"存在服务器的文件名"}
	 */
	function onFileComplete(file, data, response) {

	

	}
	 
	$(function(){
		
		// 新增彩信图片上传
		//createFileUpload("file", $("#basePath").val(),onFileComplete, "*.mp4; *.jpg; *.png;", "彩信图片", '100024KB');
		
		var rootPath=$("#basePath").val();
		
		$("#file").uploadify({
			'langFile' : rootPath + 'resources/js/uploader/chlang.js',
			'swf' : rootPath + 'resources/js/uploader/uploadify.swf',
			'uploader' : rootPath + 'toFileUpload/goe/toMultiUpload.htm',
			'buttonImage' : rootPath + 'resources/js/uploader/file.png',
			'cancelImg' : rootPath + 'resources/js/uploader/cancel.png',
			'debug' : true,
			'height' : 23,
			'width' : 76,
			'removeCompleted' : true,
			'requeueErrors' : true,
			'itemTemplate' : '</r>',
			// 'fileSizeLimit' : fileSizeLimit,
			'fileTypeDesc' : "彩信图片",
			'fileTypeExts' : "*.mp4; *.jpg; *.png;",
			'onCancel' : function(file) {
				// alert('The file ' + file.name + ' was cancelled.');
			},
			'onClearQueue' : function(queueItemCount) {
				// alert(queueItemCount + ' file(s) were removed from the queue');
			},
			'onDestroy' : function() {
				// alert('I am getting destroyed!');
			},
			'onDialogClose' : function(queueData) {
				// alert(queueData.filesQueued + ' files were queued of ' +
				// queueData.filesSelected + ' selected files. There are ' +
				// queueData.queueLength + ' total files in the queue.');
			},
			'onDialogOpen' : function() {
				// $('#message_box').html('The file dialog box was opened...');
			},
			'onDisable' : function() {
				// alert('You have disabled Uploadify!');
			},
			'onEnable' : function() {
				// alert('You can use Uploadify again.');
			},
			'onFallback' : function() {
				// alert('Flash was not detected.');
			},
			'onInit' : function(instance) {
				// alert('The queue ID is ' + instance.settings.queueID);
			},
			'onQueueComplete' : function(queueData) {
				// alert(queueData.uploadsSuccessful + ' files were successfully
				// uploaded.');
			},
			'onSelect' : function(file) {
				// alert('The file ' + file.name + ' was added to the queue.');
			},
			'onSelectError' : function() {
				// alert('The file ' + file.name + ' returned an error and was not
				// added to the queue.');
			},
			'onSWFReady' : function() {
				// alert('The Flash file is ready to go.');
			},
			'onUploadComplete' : function(file) {
				// alert('The file ' + file.name + ' finished processing.');
			},
			'onUploadError' : function(file, errorCode, errorMsg, errorString) {
				// alert('The file ' + file.name + ' could not be uploaded: ' +
				// errorString);
			},
			'onUploadProgress' : function(file, bytesUploaded, bytesTotal,
					totalBytesUploaded, totalBytesTotal) {
				 $('#progress').html(totalBytesUploaded + ' bytes uploaded of ' +
				 totalBytesTotal + ' bytes.');
			},
			'onUploadStart' : function(file) {
				// alert('Starting to upload ' + file.name);
			},
			'onUploadSuccess' : onFileComplete,

			'onUploadStart' : function(file) {
				if ((file.size / 1024) > '100024KB'.substring(0,
						'100024KB'.length - 2)) {
					$.messager.show({
								title : '提示',
								msg : '文件大小不可以超过：' + '100024KB',
								showType : 'slide'
							});
					$("#file").uploadify('cancel');
				}

			}
		});
		
		
		
	});
	
	
	</script>
</html>