//所属题目编号
var subjectId=0;

//所属编号
var topicType=1;



$(function(){
	
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
				
				subjectId= node.id;
				
				var params ={  
						subjectId: node.id,
				        topicType: $.trim($('#filterTopicType').combobox('getValue'))
					};
				
				
				//刷新grid
				reloadgrid(params);
				
				//启用接口管理按钮
				//disableToolbar(false);
			}
		}
	});
	
	
	
	
	
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		//url:'goeTopicClass/list.htm',
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
					    {title:'所属科目',field: 'subjectId',width:100,hidden:true},   
					    {title:'名称',field: 'title',width:100 },   
					    {title:'备注',field: 'memo',width:100 },   
					    {title:'类别',field: 'topicType',width:100 ,
					    	formatter:function(value,rowData,rowIndex){
					    		if(value==1)
					    		{
					    			return '章节重点';
					    		}else if(value==2)
					    		{
					    			return '章节练习';
					    		}else if(value==3)
					    		{
					    			return '全真模拟';
					    		}else if(value==4)
					    		{
					    			return '课后作业';
					    		}else{
					    			return '未知';
					    		}
						    	
						    }
					     },   
					    {title:'状态',field: 'status',width:100,
						    	formatter:function(value,rowData,rowIndex){
						    		return stateFormat(value);
						    	} 
						},
					    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
					    {title:'操作时间',field: 'operateDate',width:100,formatter:function(value,rowData,rowIndex){
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
        title: $.trim($('#filterParam').val()),
        subjectId:subjectId,
        topicType: $.trim($('#filterTopicType').combobox('getValue'))
	};
	
	reloadgrid(params);
}

/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	var urlStr='goeTopicClass/list.htm';
	if(params!=null){
		urlStr=urlStr+'?'+ Json2GetStr(params);
	}
	
	$('#projectStageConfig').datagrid({
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
		href:'jsp/subject/goeTopicClass_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeTopicClass/create.htm',
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
						reloadgrid({subjectId:subjectId,topicType: $.trim($('#filterTopicType').combobox('getValue'))});
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
		href:'jsp/subject/goeTopicClass_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeTopicClass/update.htm',  
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
						reloadgrid({subjectId:subjectId,topicType: $.trim($('#filterTopicType').combobox('getValue'))});
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
 				url:'goeTopicClass/delete.htm',
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