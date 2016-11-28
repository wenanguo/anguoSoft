//根路径
var basePath="";

$(function(){
	
	basePath=$('#basePath').val();
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'goeCampus/list.htm',
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
					    {title:'名称',field: 'name',width:100 },   
					    {title:'地址',field: 'address',width:100 },   
					    {title:'logo',field: 'logo',width:100 ,formatter:function(value,rowData,rowIndex){
					    	
					    	
					        if ($.trim(value) == '') {
					            return "<font style=\"color:red\">未上传预览图</font>";
					        }else{
								return "<img src=\""+$("#basePath").val() + "resources/images/" + value+"\" width=\"60\" height=\"20\" >";
							}
						}
					    	
					    },   
					    {title:'备注',field: 'memo',width:100 },   
					    {title:'联系人',field: 'contactMan',width:100 },   
					    {title:'联系电话',field: 'contactPhone',width:100 },   
					    {title:'状态',field: 'status',width:100,formatter:stateFormat  },   
					    {title:'操作人',field: 'realName',width:100 },   
					    {title:'操作时间',field: 'operateDate',width:100,
					    	formatter:function(value,rowData,rowIndex){
					    		
					    	return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
						} 
								
					    },   
						{}
		
			
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
        stagename: $.trim($('#filterParam').val())
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
		'itemTemplate' : '</r>',
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
		$('#logo_img').attr({src:$("#basePath").val()+"resources/images/"+$('#logo').val()});
		
	}
}

/**
 * 新增方法
 */
function doAdd(){
	$('#add').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/subject/goeCampus_edit.jsp',
		cache:true,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				
				$('#editForm').form('submit',{
					url:'goeCampus/create.htm',
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
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/subject/goeCampus_edit.jsp',
		cache:true,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#editForm').form('submit',{
					url:'goeCampus/update.htm',  
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
						$('#projectStageConfig').datagrid('load',{});
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
 				url:'goeCampus/delete.htm',
 				data :{id:rows[0].id},
 				dataType : 'json',
				success : function(d) {
					
					$('#projectStageConfig').datagrid('unselectAll');
					showRMsg(d.msg);
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


/**
 * 触发文件选择
 */
function triggerFile()
{
	$('#file').trigger("click");
}
/**
 * 上传图片文件
 * @param fileId 
 */
function uploadSuccess(fileId)
{
	var options = { 
		    success:function(data) { 
		        var obj = jQuery.parseJSON(data);
		        
		        console.log(obj);
		        //设置显示图片
		        console.log($('#'+fileId+"_img").attr({src:$("#basePath").val()+"resources/images/"+obj[0].server }));
		        alert($("#basePath").val()+"resources/images/"+obj[0].server);
		        //设置隐藏控件
		        $('#'+fileId).val(obj[0].server);
		    } 
		}; 
	//上传文件
	$('#'+fileId+"_form").ajaxSubmit(options);
	
}