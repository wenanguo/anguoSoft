var moduleId=0;

$(function(){
	
	
	
	
	
	
	/**
	 * 设置datagrid
	 */
	$('#newsConfigList').datagrid({
		url : 'webConfig/list.htm',
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
	    	{field:'id',checkbox:true},
			{
				field:'code',
				title:'代码',
				width:140
			},{
				field:'title',
				title:'标题',
				width:140
			},
			{
				field:'contentType',
				title:'内容类型',
				width:140,
				formatter:function(value,rowData,rowIndex){
					if(value == 1){
						return '<span style="color:#ff0000">图文</span>';
					}else if(value == 4){
						return '<span style="color:#000000">链接</span>';
					}
				}
			},{
				field:'contentClass',
				title:'内容类别',
				width:100,
				hidden:true
			},{
				field:'content',
				title:'内容',
				width:140,
				hidden:true
			},
			{
				field:'state',
				title:'状态',
				width:90,
				formatter:function(value,rowData,rowIndex){
					if(value == 1){
						return '<span style="color:#0000FF">已启用</span>';
					}else if(value == -1){
						return '<span style="color:red">已停用</span>';
					}
				}
			},
			{
				field:'operateUserId',
				hidden:true
			},
			{
				field:'operateUserName',
				title:'操作人',
				width:90
			},
			{
				field:'operateDt',
				title:'操作时间',
				width:90,
				formatter:function(value,rowData,rowIndex){
					return value?new Date(value).format('yyyy-MM-dd'):'<span style="color:#0A8B0A">- -</span>';
				}
			}
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit(1,rowIndex,rowData);
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
});


/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	$('#newsConfigList').datagrid('load', params);
	
}



/**
 * 清空过滤条件
 */
function doClear(){
	$('#filterParam1').val('');
	$('#filterParam2').val('');
	$('#filterParam3').val('');
}
/**
 * 新增方法
 */
function doAdd(){
	$('#add').show().dialog({
		modal:true,
		title:'新增配置',
		href:'jsp/news/newsConfigManager-add.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#addForm').form('submit',{
					url:'webConfig/create.htm',
					onSubmit: function(){
						var isValid = $('#addForm').form('validate');
						if (!isValid){
							return false;	
						}
						
					},
					success:function(data){
						var obj = eval('('+ data +')');
						console.log(obj);
						$('#add').dialog('close');
						showRMsg(obj.msg);
						
						//刷新grid
						var params = {};
								
						reloadgrid(params);
								
					}
				});
			}
		},'-',{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#add').dialog('close');
			}
		}],
		onLoad:function(){
			$('#addForm').form('reset');
		},
		onClose:function()
		{
			ueAdd.destroy();
		}
	
	});
}


/**
 * 修改方法
 */
function doEdit(){
	
	//获得选择行
	var rows = $('#newsConfigList').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/news/newsConfigManager-add.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#addForm').form('submit',{
					url:'webConfig/update.htm',
					onSubmit: function(){
						var isValid = $('#addForm').form('validate');
						if (!isValid){
							return false;	
						}
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#add').dialog('close');
						
						showRMsg(obj.msg);

						//刷新grid
						var params = {};
								
						reloadgrid(params);
						
					}  
				});
			}
		},'-',{
			text:'关闭',
			iconCls:'cancel',  
			handler:function(){
				$('#add').dialog('close');
				
			}
		}],
		onLoad:function(){
			$('#addForm').form('load', rows[0]);

			//设置富文本内容
			ueAdd.ready(function(){
				ueAdd.setContent(rows[0].content);
			})
			
		
		},
		onClose:function()
		{
			ueAdd.destroy();
		}
	
	});
}


/**
 * 删除方法
 */
function doDel() {
	var data = $('#newsConfigList').datagrid('getChecked');
	if (!data.length == 1) {
		$.messager.alert('提示', '请选择一条数据再进行删除', 'error');
		return;
	}

	
	$.messager.confirm('提示', '确认删除吗？', function(r) {
					if (r) {
						var rows = $('#newsConfigList').datagrid('getChecked');
						
						$.ajax({
									url : 'webConfig/delete.htm',

									data :{id:rows[0].id},
									dataType : 'json',
									success : function(d) {

										//刷新grid
										var params = {
												webNewsTypeId : moduleId
												};
												
										reloadgrid(params);
										
										$.messager.show({
											title:'提示',  
											msg:d.msg
										});
									}
								});

					}
				});
	
}


