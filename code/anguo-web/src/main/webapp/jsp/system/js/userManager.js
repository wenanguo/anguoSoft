var moduleId=0;

$(function(){
	
	
	
	/**
	 * 设置datagrid
	 */
	$('#userList').datagrid({
		url : 'commonSysUser/list.htm',
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
				field:'userName',
				title:'用户名',
				width:100
			},{
				field:'realName',
				title:'真实姓名',
				width:100
			},
			{
				field:'birthday',
				title:'出生年月',
				width:140
			},{
				field:'email',
				title:'电子邮件',
				width:140
			},{
				field:'phone',
				title:'手机',
				width:140,
				hidden:true
			},
			{
				field:'status',
				title:'状态',
				width:90,
				formatter:function(value,rowData,rowIndex){
					   return stateFormat(value);
					}
			},
			{
				field:'operateUserId',
				hidden:true
			},
			{
				field:'operateUserName',
				title:'操作人',
				width:90,
				hidden:true
			},
			{
				field:'operateDt',
				title:'操作时间',
				width:90,
				hidden:true
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
	
	$('#userList').datagrid('load', params);
	
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
		href:'jsp/system/userManager-edit.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#editForm').form('submit',{
					url:'commonSysUser/create.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						
						$("#roleIds").val(getCheckTreeIds());						
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
			
			/**
			 * 初始化菜单树
			 */
			$('#roleTree').tree({
				url:'commonSysRole/roleTree.htm?id=0',
				method:'get',
				animate:true,
				checkbox:true,
				onClick: function(node){
					
					//判断是否叶子节点
					//if($(this).tree('isLeaf',node.target))
					{
						moduleId=node.id;
						//刷新grid
						var params = {
								webNewsTypeId : moduleId
								};
								
						reloadgrid(params);
					}
				}
			});
			
			
		}
	
	});
}

/**
 * 取得角色选择
 * @returns {String}
 */
function getCheckTreeIds()
{

    var nodes = $('#roleTree').tree('getChecked');
    
    var s = '';
    for(var i=0; i<nodes.length; i++){
        if (s != '') s += ',';
        s += nodes[i].id;
    }
    
    return s;
}

/**
 * 修改方法
 */
function doEdit(){
	
	//获得选择行
	var rows = $('#userList').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/system/userManager-edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'commonSysUser/update.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						$("#roleIds").val(getCheckTreeIds());
						
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
			$('#editForm').form('load', rows[0]);
			
			/**
			 * 初始化菜单树
			 */
			$('#roleTree').tree({
				url:'commonSysRole/roleTree.htm?id='+rows[0].id,
				method:'get',
				animate:true,
				checkbox:true,
				onClick: function(node){
					
					//判断是否叶子节点
					//if($(this).tree('isLeaf',node.target))
					{
						moduleId=node.id;
						//刷新grid
						var params = {
								webNewsTypeId : moduleId
								};
								
						reloadgrid(params);
					}
				}
			});
			
			
		}
	
	});
}


/**
 * 删除方法
 */
function doDel() {
	var data = $('#userList').datagrid('getChecked');
	if (!data.length == 1) {
		$.messager.alert('提示', '请选择一条数据再进行删除', 'error');
		return;
	}

	
	$.messager.confirm('提示', '确认删除吗？', function(r) {
					if (r) {
						var rows = $('#userList').datagrid('getChecked');
						
						$.ajax({
									url : 'commonSysUser/delete.htm',
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


