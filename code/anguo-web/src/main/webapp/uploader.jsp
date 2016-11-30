<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>    
    <title>upload test</title>
    <base href="<%=basePath%>">
    
    <link rel="stylesheet" type="text/css" href="http://www.uploadify.com/wp-content/plugins/crayon-syntax-highlighter/themes/classic/classic.css" />
	<link rel="stylesheet" type="text/css" href="http://www.uploadify.com/wp-content/themes/uploadify/style.css">
	<script type="text/javascript" src="http://www.uploadify.com/wp-content/themes/uploadify/js/jquery.min.js"></script>
	<script type="text/javascript" src="http://www.uploadify.com/wp-content/themes/uploadify/js/jquery.uploadify.min.js"></script>
    
	<script type="text/javascript">
	
	$(function() {
		// ", '120KB'新增彩信图片上传
		//createFileUpload("file_upload", $("#basePath").val(),onFileComplete, "*.gif; *.jpg; *.png;", "彩信图片");
		
		
		$("#file_url").uploadify({
			'langFile' : rootPath + 'resources/js/uploadify/chlang.js',
			'swf' : rootPath + 'resources/js/uploadify/uploadify.swf',
			'uploader' : 'http://121.42.41.17/file-manager/toFileUpload/crm/toMultiUpload.htm',
			//'buttonImage' : rootPath + 'resources/js/uploader/file.png',
			//'cancelImg' : rootPath + 'resources/js/uploader/cancel.png',
			'debug' : false,
			'height' : 23,
			'width' : 76,
			'removeCompleted' : true,
			'requeueErrors' : true,
			'itemTemplate' : '</r>',
			'buttonText':'上传视频',
			// 'fileSizeLimit' : fileSizeLimit,
			'fileTypeDesc' : "视频文件",
			'fileTypeExts' : "*.jpg;",
		
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
				 
				var value; 
				value= Math.floor((bytesUploaded/totalBytesTotal)*100);
				
				$('#progress').progressbar('setValue', value);
				    
				    
			},
			'onUploadSuccess' : function(file, data, response) {

				alert("上传成功");
			},

			'onUploadStart' : function(file) {
				
				

			}
		});
		
			
			
			
			
		
		
	});
	
	</script>

  </head>
  
  <body>
  <FORM name="form1" METHOD="POST" ACTION="toFileUpload/goe/toMultiUpload.htm" ENCTYPE="multipart/form-data">

	<input name="file" type="file" id="file" size="50" > 

<input name="file_url" type="file" id="file_url" size="50" >	
<input name="ok" type= "submit" value="提交">

</form>

  </body>
</html>
