//所属章节编号
var topicClassId=0;

//所属题目编号
var topicId=0;

$(function(){
	
	/**
	 * 初始化菜单树
	 */
	$('#subjectTree').tree({
		url:'goeSubject/treeList.htm?topicType='+topicType,
		method:'get',
		animate:true,
		onClick: function(node){
			//判断是否叶子节点
			if($(this).tree('isLeaf',node.target)&&!(node.attributes.isSub==true))
			{
				topicClassId=node.id;
				//刷新grid
				reloadgrid(topicClassId);
				
				//启用接口管理按钮
				disableToolbar(false);
			}else{
				//禁用接口管理按钮
				disableToolbar(true);
			}
		}
	});

	
	/**
	 * 设置datagrid
	 */
	$('#topicGrid').datagrid({
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
					    {title:'题目编号',field: 'topicId',width:100 },   
					    {title:'所属章节编号',field: 'topicClassId',width:100,hidden:true},   
					    {title:'标题',field: 'title',width:100,hidden:true },   
					    {title:'题目类型',field: 'topicType',width:100,
							formatter:function(value,rowData,rowIndex){
								if(value == 1){
									return '单选';
								}else if(value == 2){
									return '多选';
								}else if(value == 3){
									return '判断';
								}else{
									return '未知';
								}
							}	
					    },   
					    {title:'正确答案',field: 'rightAnswer',width:100 },   
					    {title:'答案解析',field: 'analysis',width:100 },   
					    {title:'题型类别',field: 'topicClass',width:100,hidden:true},   
					    {title:'审核人',field: 'auditor',width:100 ,hidden:true},   
					    {title:'审核时间',field: 'auditDatetime',width:100 ,formatter:function(value,rowData,rowIndex){
					    	return formatTime(value, 'MM-dd hh:mm');
					    },hidden:true},
					    {title:'审核意见',field: 'auditOpinion',width:100 ,hidden:true},   
					    {title:'分值',field: 'value',width:100 },   
					    {title:'点赞数',field: 'optCount',width:100 ,hidden:true},   
					    {title:'做题数',field: 'workCount',width:100 ,hidden:true},   
					    {title:'状态',field: 'status',width:100,formatter:stateFormat },   
					    {title:'操作时间',field: 'operateDate',width:100 ,formatter:function(value,rowData,rowIndex){
					    	return formatTime(value, 'MM-dd hh:mm');
					    }},
						{title:'操作人',field: 'realName',width:100 }
		
					    
			
		]],
		onClickRow : function(rowIndex, rowData) {
			
			topicId=rowData.id;
			reloadTopicAnswerGrid(topicId);
			
		},
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
	
	
	/**
	 * 设置datagrid
	 */
	$('#topicAnswerGrid').datagrid({
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, // 允许分页
		pageSize : 20, // 重写每页显示的记录条数，默认为10
		pageList : [10,20,50,100], // 设置每页记录条数的列表
		nowrap : true,
		toolbar : tool_btns[1],
	    columns:[[
			
					    {title:'编号',field: 'id',width:100,checkbox:true },   
					    {title:'题目编号',field: 'topicId',width:100,hidden:true},   
					    {title:'选项',field: 'topicOption',width:60},   
					    {title:'选项值',field: 'optionValue',width:300 },   
					    {title:'状态',field: 'status',width:60 },   
					    {title:'操作时间',field: 'operateDate',width:60 ,formatter:function(value,rowData,rowIndex){
					    	return formatTime(value, 'MM-dd hh:mm');
					    }},   
						{title:'操作人',field: 'realName',width:60 }
		
			
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
	
	disableToolbar(true);
	disableAnswerToolbar(true);
});


/**
 * 是否禁用工具条
 */
function disableToolbar(flag)
{
	$('#btn_add,#btn_edit,#btn_del,#btn_excel').linkbutton({
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
 * 初始化百度编辑器
 */
function initUEditor(title)
{
	
	var ue = new baidu.editor.ui.Editor();
	ue.render("title"); //这里填写要改变为编辑器的控件id

	
	if($.trim($(title).val())!=""){
	  ue.setContent(title, false);
	}
	
	 
}


/**
 * 初始化文件上传
 */
function logoFileUploadInit(){
	
	
	//初始化上传控件
	var rootPath=$("#basePath").val();
	
	$("#excel_url").uploadify({
		'langFile' : rootPath + 'resources/js/uploadify/chlang.js',
		'swf' : rootPath + 'resources/js/uploadify/uploadify.swf',
		'uploader' : rootPath + 'toFileUpload/goeExcel/toMultiUpload.htm',
		//'buttonImage' : rootPath + 'resources/js/uploader/file.png',
		//'cancelImg' : rootPath + 'resources/js/uploader/cancel.png',
		'debug' : false,
		'height' : 23,
		'width' : 76,
		'removeCompleted' : true,
		'requeueErrors' : true,
		//'itemTemplate' : '</r>',
		'buttonText':'excel文件',
		// 'fileSizeLimit' : fileSizeLimit,
		'fileTypeDesc' : "表格文件",
		'fileTypeExts' : "*.xlsx",
		'onCancel' : function(file) {
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
			$('#url').attr('value', picFileName);
			
			//$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + $('#url').val()+"\">上传文件</a>");

			//$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + picFileName+"\">点击播放</a>");
			//设置预览图片
			//$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+picFileName});
			
				$('#editForm').form('submit',{
					url:'goeTopic/importExcel.htm',
					onSubmit: function(){
						
						openProgress();
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						
						closeProgress();
						var obj = eval('('+ data +')');
						$('#excelImport').dialog('close');
						showRMsg(obj.msg);
						reloadgrid({});
					}  
				});
			
			
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
//	if($.trim($('#logo').val())==""){
//		
//	}else{
//		//$('#url_div').html("<a target=\"_blank\" href=\""+$("#basePath").val() + "resources/images/" + $('#url').val()+"\">点击播放</a>");
//		
//		$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+$('#logo').val()});
//		
//	}
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
	
	var urlStr='goeTopic/list.htm';
	if(siType!=null){
		urlStr=urlStr+'?topicClassId='+ topicClassId;
	}
	
	$('#topicGrid').datagrid({
		url : urlStr
	});

	
}


/**
 * 通过条件刷新答案grid
 */
function reloadTopicAnswerGrid(topicId) {
	
	var urlStr='goeTopicAnswer/list.htm';
	if(topicId!=null){
		urlStr=urlStr+'?topicId='+ topicId;
	}
	
	$('#topicAnswerGrid').datagrid({
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
		href:'jsp/subject/goeTopic_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeTopic/create.htm',
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
						reloadgrid({});
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
			$('#editForm').form('load', {topicClassId:topicClassId});
			
			initUEditor();
		}
	});
	$('#editForm').form('reset');
}


/**
 * 导入excel方法
 */
function doExcelImport(){
	
	
	$('#excelImport').show().dialog({
		modal:true,
		title:'导入excel',
		href:'jsp/subject/goeTopic_excel.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeTopic/importExcel.htm',
					onSubmit: function(){
						
						openProgress();
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						
						closeProgress();
						var obj = eval('('+ data +')');
						$('#excelImport').dialog('close');
						showRMsg(obj.msg);
						reloadgrid({});
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				closeProgress();
				$('#excelImport').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editForm').form('load', {topicClassId:topicClassId});
			
			logoFileUploadInit();
		}
	});
	$('#editForm').form('reset');
}



/**
 * 新增答案方法
 */
function doAnswerAdd(){
	$('#addAnswer').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/subject/goeTopicAnswer_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editAnswerForm').form('submit',{
					url:'goeTopicAnswer/create.htm',
					onSubmit: function(){
						var isValid = $('#editAnswerForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#addAnswer').dialog('close');
						showRMsg(obj.msg);
						reloadTopicAnswerGrid(topicId);
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#addAnswer').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editAnswerForm').form('load', {topicId:topicId});
		}
	});
	$('#editAnswerForm').form('reset');
}

/**
 * 修改方法
 */
function doEdit(){
	
	
	//获得选择行
	var rows = $('#topicGrid').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/subject/goeTopic_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeTopic/update.htm',  
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
						$('#topicGrid').datagrid('load',{});
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
			$('#editForm').form('load', rows[0]);
			
			initUEditor(rows[0].title);
		}
	});
	
}

/**
 * 修改答案方法
 */
function doAnswerEdit(){
	
	
	//获得选择行
	var rows = $('#topicAnswerGrid').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	$('#editAnswer').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/subject/goeTopicAnswer_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editAnswerForm').form('submit',{
					url:'goeTopicAnswer/update.htm',  
					onSubmit: function(){
						var isValid = $('#editAnswerForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#editAnswer').dialog('close');
						$.messager.show({
							title:'提示',  
							msg:obj.msg
						});
						$('#topicAnswerGrid').datagrid('load',{});
					}  
				});
			}
		},{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#editAnswer').dialog('close');
			}
		}],
		onLoad:function(){
			$('#editAnswerForm').form('load', rows[0]);
		}
	});
	
}

/**
 * 删除方法
 */
 function doDel(){
 	var data = $('#topicGrid').datagrid('getChecked');
 	if(data.length == 0){
 		$.messager.alert('提示','请选择一条数据再进行删除','error');
 		return;
 	}
 	$.messager.confirm('提示','确认删除吗？',function(r){
 		if(r){
 			var rows = $('#topicGrid').datagrid('getChecked');
 			
 			$.ajax({
 				url:'goeTopic/delete.htm',
 				data :{id:rows[0].id},
 				dataType : 'json',
				success : function(obj) {
					
					$('#topicGrid').datagrid('unselectAll');
					showRMsg(obj.msg);
					
					reloadgrid({});
				}
 			});
 			
 		}
 	});
 }
 
 /**
  * 删除方法
  */
  function doAnswerDel(){
  	var data = $('#topicAnswerGrid').datagrid('getChecked');
  	if(data.length == 0){
  		$.messager.alert('提示','请选择一条数据再进行删除','error');
  		return;
  	}
  	$.messager.confirm('提示','确认删除吗？',function(r){
  		if(r){
  			var rows = $('#topicAnswerGrid').datagrid('getChecked');
  			
  			$.ajax({
  				url:'goeTopicAnswer/delete.htm',
  				data :{id:rows[0].id},
  				dataType : 'json',
 				success : function(obj) {
 					
 					$('#topicAnswerGrid').datagrid('unselectAll');
 					showRMsg(obj.msg);
 					$('#topicAnswerGrid').datagrid('load',{});
 				}
  			});
  			
  		}
  	});
  } 
  
  
  //树操作
  /**
   * 增加节点
   */
  function doAddTree(){
	  
		var rows = $('#subjectTree').tree('getSelected');
		if(rows==null)
		{
			alert("请选择增加科目");
		}
		
		
		

  }
  
  
  /**
   * 编辑节点
   */
  function doEditTree(){
	  
  }
  
  /**
   * 删除节点
   */
  function doDeleteTree(){
	  
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