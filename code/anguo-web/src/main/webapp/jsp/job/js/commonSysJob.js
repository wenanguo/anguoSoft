$(function(){
	
	
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'commonSysJob/list.htm',
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
					    {title:'任务名称',field: 'jobName',width:100 },   
					    {title:'任务分组',field: 'jobGroup',width:100 },   
					    {title:'作业类',field: 'jobClass',width:200 },   
					    {title:'任务运行表达式',field: 'cronExpression',width:100 },   
					    {title:'任务描述',field: 'memo',width:100 },   
					    {title:'状态',field: 'status',width:50,formatter:stateFormat  },   
					    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
					    {title:'操作时间',field: 'operateDate',width:100 ,hidden:true,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
						{title:'操作人',field: 'realName',width:100,hidden:true }
		
			
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		onClickRow:function(rowIndex, rowData){
			disableToolbar(rowData.status);
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
 * 是否禁用工具条
 */
function disableToolbar(status)
{
	if(status===AnguoStatusUtil.BASE_STOP){
		//停用状态
		
		//禁用按钮
		$('#btn_pause,#btn_resume,#btn_stop').linkbutton({
			disabled:true
		});
		//启用按钮
		$('#btn_edit,#btn_start').linkbutton({
			disabled:false
		});
	}else if(status===AnguoStatusUtil.BASE_START){
		//启动状态
		
		//禁用按钮
		$('#btn_edit,#btn_start,#btn_resume').linkbutton({
			disabled:true
		});
		//启用按钮
		$('#btn_pause,#btn_stop').linkbutton({
			disabled:false
		});
	}else if(status===AnguoStatusUtil.BASE_PAUSE){
		//暂停状态
		
		//禁用按钮
		$('#btn_edit,#btn_start,#btn_pause').linkbutton({
			disabled:true
		});
		//启用按钮
		$('#btn_resume,#btn_stop').linkbutton({
			disabled:false
		});
	}else{
		
		//其余状态，禁用全部按钮
		$('#btn_edit,#btn_start,#btn_pause,#btn_resume,#btn_stop,#btn_add,#btn_trigger').linkbutton({
			disabled:true
		});
	}
	
	
}

/**
 * 新增方法
 */
function doAdd(){
	$('#add').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/job/commonSysJob_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'commonSysJob/create.htm',
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
		}]
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
		href:'jsp/job/commonSysJob_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'commonSysJob/update.htm',  
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
 				url:'commonSysJob/delete.htm',
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
  * 启动方法
  */
  function doStart(){
  	var data = $('#projectStageConfig').datagrid('getChecked');
  	if(data.length == 0){
  		$.messager.alert('提示','请选择一条数据再进行操作','error');
  		return;
  	}
  	$.messager.confirm('提示','确认启动当前作业吗？',function(r){
  		if(r){
  			var rows = $('#projectStageConfig').datagrid('getChecked');
  			
  			$.ajax({
  				url:'commonSysJob/startJob.htm',
  				data :rows[0],
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
  * 暂停方法
  */
  function doPause(){
  	var data = $('#projectStageConfig').datagrid('getChecked');
  	if(data.length == 0){
  		$.messager.alert('提示','请选择一条数据再进行操作','error');
  		return;
  	}
  	$.messager.confirm('提示','确认暂停当前作业吗？',function(r){
  		if(r){
  			var rows = $('#projectStageConfig').datagrid('getChecked');
  			
  			$.ajax({
  				url:'commonSysJob/pauseJob.htm',
  				data :rows[0],
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
   * 恢复方法
   */
   function doResume(){
   	var data = $('#projectStageConfig').datagrid('getChecked');
   	if(data.length == 0){
   		$.messager.alert('提示','请选择一条数据再进行操作','error');
   		return;
   	}
   	$.messager.confirm('提示','确认恢复当前作业吗？',function(r){
   		if(r){
   			var rows = $('#projectStageConfig').datagrid('getChecked');
   			
   			$.ajax({
   				url:'commonSysJob/resumeJob.htm',
   				data :rows[0],
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
    * 停用方法
    */
    function doStop(){
    	var data = $('#projectStageConfig').datagrid('getChecked');
    	if(data.length == 0){
    		$.messager.alert('提示','请选择一条数据再进行操作','error');
    		return;
    	}
    	$.messager.confirm('提示','确认停用当前作业吗？',function(r){
    		if(r){
    			var rows = $('#projectStageConfig').datagrid('getChecked');
    			
    			$.ajax({
    				url:'commonSysJob/stopJob.htm',
    				data :rows[0],
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
    * 立即运行方法
    */
    function doTrigger(){
    	var data = $('#projectStageConfig').datagrid('getChecked');
    	if(data.length == 0){
    		$.messager.alert('提示','请选择一条数据再进行操作','error');
    		return;
    	}
    	$.messager.confirm('提示','确认立即运行一次当前作业吗？',function(r){
    		if(r){
    			var rows = $('#projectStageConfig').datagrid('getChecked');
    			
    			$.ajax({
    				url:'commonSysJob/triggerJob.htm',
    				data :rows[0],
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