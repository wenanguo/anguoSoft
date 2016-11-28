$(function(){
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'goeAd/list.htm',
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, // 允许分页
		pageSize : 20, // 重写每页显示的记录条数，默认为10
		pageList : [10,20,50,100], // 设置每页记录条数的列表
		nowrap : true,
		toolbar : tool_btns[0],
	    columns:[[
			
					    {title:'编号',field: 'id',width:100,checkbox:true },
					    {title:'所属校区',field: 'campusName',width:100 },
					    {title:'所属校区编号',field: 'campusId',width:100,hidden:true },
					    {title:'标题',field: 'title',width:100 },   
					    {title:'内容',field: 'content',width:100 },   
					    {title:'logo',field: 'logo',width:100,formatter:function(value,rowData,rowIndex){
					    	
					    	
					        	value = $.trim(value); // 用jQuery的trim方法删除前后空格
						        if (value == '') {// 判断是否是空字符串，而不是null
						            return "<font style=\"color:red\">未上传预览图</font>";
						        }else{
									return "<img src=\""+$("#basePath").val() + "resources/images/" + value+"\" width=\"60\" height=\"20\" >";
								}
							}
					    	
					    },   
					    {title:'连接地址',field: 'url',width:100 },   
					    {title:'位置',field: 'location',width:100,
					    	formatter:function(value,rowData,rowIndex){
						    	 if(value==1){
						    		   return '跑马灯';
						    	   }else if(value==2)
						    	   {
						    		   return '工具栏';
						    	   }else if(value==3)
						    	   {
						    		   return '底部';
						    	   }
						    	   else{
						    		   return '其他';
						    	   }
								} 
					    },   
					    {title:'排序',field: 'adOrder',width:100 },   
					    {title:'推广',field: 'isAd',width:100 ,
					    	 formatter:function(value,rowData,rowIndex){
						    	 if(value==1){
						    		   return '正常内容';
						    	   }else if(value==2)
						    	   {
						    		   return '推广广告';
						    	   }else{
						    		   return '其他';
						    	   }
								} 
					    },   
					    {title:'类别',field: 'adType',width:100,
					    formatter:function(value,rowData,rowIndex){
					    	 if(value==1){
					    		   return '内容';
					    	   }else if(value==2)
					    	   {
					    		   return '链接';
					    	   }else{
					    		   return '其他';
					    	   }
							} 
					    },   
					    {title:'审核人',field: 'auditor',width:100,hidden:true },   
					    {title:'审核时间',field: 'auditDatetime',width:100,hidden:true ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'审核意见',field: 'auditOpinion',width:100,hidden:true },   
					    {title:'开始时间',field: 'startDate',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'结束时间',field: 'endDate',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'状态',field: 'status',width:100,
				    	formatter:function(value,rowData,rowIndex){
							   return stateFormat(value);
							} 
					},   
					    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
					    {title:'操作时间',field: 'operateDate',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
						{title:'操作人',field: 'realName',width:100 }
		
			
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
});


/**
 * 查询方法
 */
function doSearch(){

	var params ={  
        title: $.trim($('#filterParam').val())
	};
	
	reloadgrid(params);
}

/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	$('#projectStageConfig').datagrid('load', params);
	
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
		$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+$('#logo').val()});
		
	}
}

/**
 * 新增方法
 */
function doAdd(){
	$('#edit').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/ad/goeAd_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeAd/create.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#edit').dialog('close');
						showRMsg(obj.msg);
						reloadgrid({});
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#edit').dialog('close');
			}
		}],
		onLoad:function(){
			logoFileUploadInit();
		}
	});
	$('#editForm').form('reset');
}
/**
 * 修改方法
 */
function doEdit(){
	
	
	//获得选择行
	var rows = $('#projectStageConfig').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	$('#edit').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/ad/goeAd_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeAd/update.htm',  
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#edit').dialog('close');
						$.messager.show({
							title:'提示',  
							msg:obj.msg
						});
						$('#projectStageConfig').datagrid('load',{});
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#edit').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editForm').form('load', rows[0]);
			logoFileUploadInit();
		}
	});
	
}
/**
 * 删除方法
 */
 function doDel(){
 	var data = $('#projectStageConfig').datagrid('getChecked');
 	if(data.length == 0){
 		$.messager.alert('提示','请选择一条数据再进行删除','error');
 		return;
 	}
 	$.messager.confirm('提示','确认删除吗？',function(r){
 		if(r){
 			var rows = $('#projectStageConfig').datagrid('getChecked');
 			
 			$.ajax({
 				url:'goeAd/delete.htm',
 				data :{id:rows[0].id},
 				dataType : 'json',
				success : function(obj) {
					
					$('#projectStageConfig').datagrid('unselectAll');
					showRMsg(obj.msg);
					reloadgrid({});
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