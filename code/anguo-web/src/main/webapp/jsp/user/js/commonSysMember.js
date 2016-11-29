$(function(){
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'commonSysMember/list.htm',
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
					    {title:'所属校区',field: 'campusId',width:100,hidden:true },   
					    {title:'用户名',field: 'memberName',width:100 },   
					    {title:'密码',field: 'password',width:100,hidden:true },   
					    {title:'电话',field: 'phone',width:100 },   
					    {title:'imei',field: 'imei',width:100,hidden:true },   
					    {title:'imsi',field: 'imsi',width:100,hidden:true },   
					    {title:'昵称',field: 'nickName',width:100 },   
					    {title:'头像',field: 'photo',width:100,hidden:true },   
					    {title:'信鸽token',field: 'xgToken',width:100},
					    {title:'性别',field: 'sex',width:100 ,formatter:function(value,rowData,rowIndex){
					    	
					    	   if(value==1){
					    		   return "男";
					    	   }else{
					    		   return "女"
					    	   }
					    	   
						} },   
					    {title:'出生日期',field: 'birthday',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
					    {title:'其他联系方式',field: 'contact',width:100 },   
					    {title:'积分',field: 'credits',width:100,hidden:true },   
					    {title:'邮箱',field: 'email',width:100 },   
					    {title:'用户类别',field: 'memberClass',width:100 },   
					    {title:'状态',field: 'status',width:100,formatter:stateFormat },   
					    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
					    {title:'操作时间',field: 'operateDate',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					} },   
						{title:'操作人',field: 'realName',width:100,hidden:true }
		
			
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
        memberName: $.trim($('#filterParam').val())
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
		href:'jsp/user/commonSysMember_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'commonSysMember/create.htm',
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
		href:'jsp/user/commonSysMember_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'commonSysMember/update.htm',  
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
 				url:'commonSysMember/delete.htm',
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