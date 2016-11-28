var moduleId=0;

$(function(){
	
	/**
	 * 初始化菜单树
	 */
	$('#menuTree').tree({
		url:'commonSysAuthority/roleTree.htm',
		method:'get',
		animate:true,
		checkbox:true,
		onClick: function(node){
			//判断是否叶子节点
			if($(this).tree('isLeaf',node.target))
			{
				
//				subjectId= node.id;
//				
//				var params ={  
//						subjectId: node.id,
//				        topicType: $.trim($('#filterTopicType').combobox('getValue'))
//					};
//				
//				
//				//刷新grid
//				reloadgrid(params);
				
				//启用接口管理按钮
				//disableToolbar(false);
			}
		}
	});
	
	/**
	 * 设置datagrid
	 */
	$('#roleList').datagrid({
		url : 'commonSysRole/list.htm',
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
	    	{field:'id',hidden:true},
			{
				field:'name',
				title:'角色名称',
				width:240
			},{
				field:'eName',
				title:'真实名称',
				width:100,
				hidden:true
			},
			{
				field:'status',
				title:'状态',
				width:90,
				formatter:function(value,rowData,rowIndex){
					if(value == 100){
						return '<span style="color:#006000">已启用</span>';
					}else if(value == 104){
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
				width:90
			}
		]],
		onClickRow:function(rowIndex, rowData){
			
			//更新树
			reloadTree({id:rowData.id});
			
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
});


/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	$('#roleList').datagrid('load', params);
	
}


/**
 * 通过条件刷新tree
 */
function reloadTree(params) {
	
	
	
	
	
	var urlStr='commonSysAuthority/roleTree.htm';
	if(params!=null){
		urlStr=urlStr+'?'+ Json2GetStr(params);
	}
	
	$('#menuTree').tree({
		url : urlStr
	});
	
	
	
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
		href:'jsp/system/roleManager-edit.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#editForm').form('submit',{
					url:'commonSysRole/create.htm',
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
			
			
		}
	
	});
}


/**
 * 设置权限方法
 */
function doUpdateAuthority(){
	
	//获得选择行
	var rows = $('#roleList').datagrid('getSelections');
	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条角色再进行权限设置', 'error');
		return false;
	}
	
	
	
	 var nodes = $('#menuTree').tree('getChecked');
     var s = '';
     for(var i=0; i<nodes.length; i++){
         if (s != '') s += ',';
         s += nodes[i].id;
     }
   
     
     $.post("commonSysAuthority/update.htm", 
    		 { 
    	 		"authorityStr": s,
    	 		"id": rows[0].id
    	     },
    		   function(data){
    		     showRMsg(data.msg);
    		   }, "json");
	
	
//	$('#add').show().dialog({
//		modal:true,
//		title:'修改',
//		href:'jsp/system/roleManager-edit.jsp',
//		cache:false,
//		toolbar:[{  
//			text:'提交',  
//			iconCls:'tick',  
//			handler:function(){
//				$('#editForm').form('submit',{
//					url:'commonSysRole/update.htm',
//					onSubmit: function(){
//						var isValid = $('#editForm').form('validate');
//						if (!isValid){
//							return false;	
//						}
//						
//						
//					},
//					success:function(data){
//						var obj = eval('('+ data +')');
//						$('#add').dialog('close');
//						
//						showRMsg(obj.msg);
//
//						//刷新grid
//						var params = {};
//								
//						reloadgrid(params);
//						
//					}  
//				});
//			}
//		},'-',{
//			text:'关闭',
//			iconCls:'cancel',  
//			handler:function(){
//				$('#add').dialog('close');
//				
//			}
//		}],
//		onLoad:function(){
//			$('#editForm').form('load', rows[0]);
//			
//		}
//	
//	});
}


/**
 * 删除方法
 */
function doDel() {
	var data = $('#roleList').datagrid('getChecked');
	if (!data.length == 1) {
		$.messager.alert('提示', '请选择一条数据再进行删除', 'error');
		return;
	}

	
	$.messager.confirm('提示', '确认删除吗？', function(r) {
					if (r) {
						var rows = $('#roleList').datagrid('getChecked');
						
						$.ajax({
									url : 'commonSysRole/delete.htm',
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


