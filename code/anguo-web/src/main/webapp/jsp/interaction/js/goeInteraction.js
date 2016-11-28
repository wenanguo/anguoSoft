$(function(){
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'goeInteraction/list.htm',
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
					    {title:'会员编号',field: 'memberId',width:100,hidden:true },   
					    {title:'后台回复用户编号',field: 'empId',width:100,hidden:true },   
					    {title:'留言内容',field: 'message',width:100 },   
					    {title:'回复内容',field: 'replyMessage',width:100 },   
					    {title:'留言时间',field: 'messageTime',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'回复时间',field: 'replyMessageTime',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'点赞数',field: 'optCount',width:100 },   
					    {title:'排序',field: 'goeOrder',width:100 },   
					    {title:'推荐',field: 'recommend',width:100,
					    	formatter:function(value,rowData,rowIndex){
						    	 if(value==1){
						    		   return '<font style="color:green">不推荐</font>';
						    	   }else if(value==2)
						    	   {
						    		   return '<font style="color:red">推荐</font>';;
						    	   }else{
						    		   return '其他';
						    	   }
								} 
					    },   
					    {title:'状态',field: 'status',width:60,formatter:stateFormat,hidden:true  },   
					    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
					    {title:'操作时间',field: 'operateDate',width:150 ,formatter:function(value,rowData,rowIndex){
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
        message: $.trim($('#filterParam').val())
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
 * 新增方法
 */
function doAdd(){
	$('#add').show().dialog({
		modal:true,
		title:'新增',
		href:'jsp/interaction/goeInteraction_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeInteraction/create.htm',
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
		href:'jsp/interaction/goeInteraction_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeInteraction/update.htm',  
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
 * 推荐状态方法
 */
 function doRecommend(){
 	var data = $('#projectStageConfig').datagrid('getChecked');
 	if(data.length == 0){
 		$.messager.alert('提示','请选择一条数据再进行删除','error');
 		return;
 	}
 	$.messager.confirm('提示','确认推荐吗？',function(r){
 		if(r){
 			var rows = $('#projectStageConfig').datagrid('getChecked');
 			
 			$.ajax({
 				url:'goeInteraction/updateRecommendData.htm',
 				data :{id:rows[0].id,recommend:2},
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
  * 不推荐状态方法
  */
  function doNotRecommend(){
  	var data = $('#projectStageConfig').datagrid('getChecked');
  	if(data.length == 0){
  		$.messager.alert('提示','请选择一条数据再进行删除','error');
  		return;
  	}
  	$.messager.confirm('提示','确认不推荐吗？',function(r){
  		if(r){
  			var rows = $('#projectStageConfig').datagrid('getChecked');
  			
  			$.ajax({
  				url:'goeInteraction/updateRecommendData.htm',
  				data :{id:rows[0].id,recommend:1},
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