
//所属题目编号
var subjectId=0;
//根路径
var basePath="";

$(function(){
	
	
	basePath=$('#basePath').val();
	/**
	 * 初始化菜单树
	 */
	$('#subjectTree').tree({
		url:'goeSubject/comboxlist.htm',
		method:'get',
		animate:true,
		onClick: function(node){
			//判断是否叶子节点
			if($(this).tree('isLeaf',node.target))
			{
				subjectId=node.id;
				//刷新grid
				reloadgrid(subjectId);
				
				//启用接口管理按钮
				//disableToolbar(false);
			}
		}
	});

	
	/**
	 * 设置datagrid
	 */
	$('#videoGrid').datagrid({
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, //允许分页
		pageSize : 20, //重写每页显示的记录条数，默认为10
		pageList : [10,20,50,100], //设置每页记录条数的列表
		nowrap : true,
		toolbar : tool_btns[0],
	    columns:[[
	              		
					    {title:'编号',field: 'id',width:100,checkbox:true },   
					    {title:'名称',field: 'name',width:100 },   
					    {title:'所属科目编号',field: 'subjectId',width:100,hidden:true},   
					    {title:'视频文件',field: 'url',width:100,formatter:function(value,rowData,rowIndex){
					    	
					    	
						        value = $.trim(value); // 用jQuery的trim方法删除前后空格
						        if (value == '') {// 判断是否是空字符串，而不是null
						            return "<font style=\"color:red\">未上传视频</font>";
						        }else{
									return "<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + value+"\">点击播放</a>";
						        	//return "<a target=\"_blank\" href=\"" + value+"\">点击播放</a>";
								}
							}
					    },   
					    {title:'预览图',field: 'logo',width:100 ,formatter:function(value,rowData,rowIndex){
						    	
						    	
						        value = $.trim(value); // 用jQuery的trim方法删除前后空格
						        if (value == '') {// 判断是否是空字符串，而不是null
						            return "<font style=\"color:red\">未上传预览图</font>";
						        }else{
									return "<img src=\""+$("#basePath").val() + "resources/images/" + value+"\" width=\"60\" height=\"20\" >";
								}
							}
					    	
					    },
					    {title:'讲师',field: 'lecturer',width:100 },
					    {title:'时长',field: 'duration',width:100 },
					    {title:'视频类别',field: 'category',width:100,
							formatter:function(value,rowData,rowIndex){
								if(value == 1){
									return '上课视频';
								}else if(value == 2){
									return '上机模拟视频';
								}else{
									return '未知';
								}
							}	
					    },
					    {title:'收费类别',field: 'chargeCategories',width:100,
							formatter:function(value,rowData,rowIndex){
								if(value == 1){
									return '免费';
								}else if(value == 2){
									return '付费';
								}else if(value == 3){
									return '在校学员';
								}else{
									return '其他';
								}
							}	
					    },
					    {title:'审核人',field: 'auditor',width:100 ,hidden:true},   
					    {title:'审核时间',field: 'auditDatetime',width:100 ,formatter:function(value,rowData,rowIndex){
					    	return formatTime(value, 'MM-dd hh:mm');
					    },hidden:true},
					    {title:'审核意见',field: 'auditOpinion',width:100 ,hidden:true},
					    {title:'价格',field: 'price',width:100 },
					    {title:'排序',field: 'goeOrder',width:100 },
					    {title:'点赞数',field: 'optCount',width:100 ,hidden:true},
					    {title:'观看数',field: 'browseCount',width:100 },
					    {title:'状态',field: 'status',width:100,formatter:stateFormat },   
					    {title:'操作时间',field: 'operateDate',width:100 ,formatter:function(value,rowData,rowIndex){
					    	return formatTime(value, 'MM-dd hh:mm');
					    }},
						{title:'操作人',field: 'realName',width:100 }
		
					    
			
		]],
		onClickRow : function(rowIndex, rowData) {
			
			//topicId=rowData.id;
			//reloadTopicAnswerGrid(topicId);
			
		},
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
	
	
	disableToolbar(true);
	disableAnswerToolbar(true);
	
	
	//初始化上传控件
	
	
	
	
	
});





/**
 * 初始化视频文件上传
 */
function FileUploadInit(){
	
	
	//初始化上传控件
	var rootPath=$("#basePath").val();
	
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
		'fileTypeExts' : "*.mp4;",
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

			var obj = eval('(' + data + ')');
			
			// 图片对应的文件名
			picFileName = obj[0].server;

			// 显示当前上传视频
			$('#url').attr('value', picFileName);

			$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + picFileName+"\">点击播放</a>");
			
			$("#progress").css('display','none'); 
		},

		'onUploadStart' : function(file) {
			
			//显示进度条
			$("#progress").css('display','block'); 
			$('#progress').progressbar('setValue', 0);
			
			//判断大小
			if ((file.size / 1024) > '100024KB'.substring(0,
					'100024KB'.length - 2)) {
				$.messager.show({
							title : '提示',
							msg : '文件大小不可以超过：' + '100024KB',
							showType : 'slide'
						});
				$("#file_url").uploadify('cancel');
			}

		}
		
		
		
		}
	
	
	
	
	);
	

	//载入原有视频路径
	if($.trim($('#url').val())==""){
		
	}else{
		$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + $('#url').val()+"\">点击播放</a>");
		
	}
}



/**
 * 初始化文件上传
 */
function logoFileUploadInit(){
	
	
	//初始化上传控件
	var rootPath=$("#basePath").val();
	
	$("#logo_url").uploadify({
		'langFile' : rootPath + 'resources/js/uploadify/chlang.js',
		'swf' : rootPath + 'resources/js/uploadify/uploadify.swf',
		'uploader' : rootPath + 'toFileUpload/goe/toMultiUpload.htm',
		//'buttonImage' : rootPath + 'resources/js/uploader/file.png',
		//'cancelImg' : rootPath + 'resources/js/uploader/cancel.png',
		'debug' : false,
		'height' : 23,
		'width' : 76,
		'removeCompleted' : true,
		'requeueErrors' : true,
		//'itemTemplate' : '</r>',
		'buttonText':'上传预览图',
		// 'fileSizeLimit' : fileSizeLimit,
		'fileTypeDesc' : "图片文件",
		'fileTypeExts' : "*.jpg;*.bmp;*.gif",
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
		'onUploadSuccess' : function(file, data, response) {

			var obj = eval('(' + data + ')');
			
			// 图片对应的文件名
			picFileName = obj[0].server;

			// 显示当前上传视频
			$('#logo').attr('value', picFileName);

			//$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + picFileName+"\">点击播放</a>");
			//设置预览图片
			$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+picFileName});
			
		},

		'onUploadStart' : function(file) {
			
			
			//判断大小
			if ((file.size / 1024) > '100024KB'.substring(0,
					'100024KB'.length - 2)) {
				$.messager.show({
							title : '提示',
							msg : '文件大小不可以超过：' + '100024KB',
							showType : 'slide'
						});
				$("#logo_url").uploadify('cancel');
			}

		}
		
		
		
		}
	
	
	
	
	);
	

	//载入原有图片路径
	if($.trim($('#logo').val())==""){
		
	}else{
		//$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + $('#url').val()+"\">点击播放</a>");
		
		$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+$('#logo').val()});
		
	}
}


/**
 * 是否禁用工具条
 */
function disableToolbar(flag)
{
	$('#btn_add,#btn_edit,#btn_del').linkbutton({
		disabled:flag
	});
	
}
/**
 * 是否禁用工具条
 */
function disableAnswerToolbar(flag)
{
	$('#btn_answer_add,#btn_answer_edit,#btn_answer_del').linkbutton({
		disabled:flag
	});
	
}


/**
 * 查询方法
 */
function doSearch(){

	var params ={  
        stagename: $.trim($('#filterParam').val())
	};
	
	reloadgrid(params);
}

/**
 * 通过条件刷新grid
 */
function reloadgrid(siType) {
	
	var urlStr='goeVideo/list.htm';
	if(siType!=null){
		urlStr=urlStr+'?subjectId='+ siType;
	}
	
	$('#videoGrid').datagrid({
		url : urlStr
	});

	
}





/**
 * 新增方法
 */
function doAdd(){
	$('#add').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/video/goeVideo_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeVideo/create.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#add').dialog('close');
						showRMsg(obj.msg);
						reloadgrid(subjectId);
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				
				$('#add').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editForm').form('load', {subjectId:subjectId});
			
			
			FileUploadInit();
			logoFileUploadInit();
			
			
		},
		onClose:function(){
			//fileDestroy();
		}
	});
	$('#editForm').form('reset');
}



/**
 * 修改方法
 */
function doEdit(){
	
	
	//获得选择行
	var rows = $('#videoGrid').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/video/goeVideo_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeVideo/update.htm',  
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#add').dialog('close');
						$.messager.show({
							title:'提示',  
							msg:obj.msg
						});
						reloadgrid(subjectId);
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				//$('#file_url').uploadify('destroy');
				$('#add').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editForm').form('load', rows[0]);
			
			FileUploadInit();
			logoFileUploadInit();
		},
		onClose:function(){
			//fileDestroy();
		}
	});
	
}



/**
 * 删除方法
 */
 function doDel(){
	 
	 
	 
 	var data = $('#videoGrid').datagrid('getChecked');
 	if(data.length == 0){
 		$.messager.alert('提示','请选择一条数据再进行删除','error');
 		return;
 	}
 	$.messager.confirm('提示','确认删除吗？',function(r){
 		if(r){
 			var rows = $('#videoGrid').datagrid('getChecked');
 			
 			$.ajax({
 				url:'goeVideo/delete.htm',
 				data :{id:rows[0].id},
 				dataType : 'json',
				success : function(obj) {
					
					$('#videoGrid').datagrid('unselectAll');
					showRMsg(obj.msg);
					
					reloadgrid(subjectId);
				}
 			});
 			
 		}
 	});
 }
 
 
   
 /**
  * 按回车触发查询事件
  */
function setTrack(event){
	var e = event?event:window.event;
	if(e.keyCode == 13){
		doSearch();
	}
}