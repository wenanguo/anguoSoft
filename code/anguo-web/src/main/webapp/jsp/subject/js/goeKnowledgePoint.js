//所属章节编号
var siClassidId=0;


$(function(){
	/**
	 * 设置datagrid
	 */
	$('#browgrid').datagrid({
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, // 允许分页
		pageSize : 30, // 重写每页显示的记录条数，默认为10
		pageList : [10,30,50,100], // 设置每页记录条数的列表
		nowrap : true,
		toolbar : tool_btns[0],
	    columns:[[
					    {title:'编号',field: 'id',width:100,checkbox:true },
					    {title:'科目id',field: 'subjectId',width:70,hidden:true },
					    {title:'章节ID',field: 'topicClassId',width:70,hidden:true },
					    {title:'内容',field: 'content',width:100,formatter:function(value,rowData,rowIndex){
					    		return limit(value, 20);
					    	}
					    },
					    {title:'WAP-URL',field: 'url',width:100 },
					    {title:'操作员',field: 'realName',width:50 },   
					    {title:'操作日期',field: 'operateDate',width:100 ,formatter:function(value,rowData,rowIndex){
					   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					    } }
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
	
	
	/**
	 * 初始化菜单树
	 */
	$('#subjectTree').tree({
		url:'goeSubject/treeList.htm?topicType=1',
		method:'get',
		animate:true,
		onClick: function(node){
			//判断是否叶子节点
			if($(this).tree('isLeaf',node.target)&&!(node.attributes.isSub==true))
			{
				siClassidId=node.id;
				//刷新grid
				reloadgrid({topicClassId:node.id});
				
				//启用工具条按钮
				disableToolbar(false);
			}else{
				//禁用工具条按钮
				disableToolbar(true);
			}
		}
	});
	
	
	//禁用工具条按钮
	disableToolbar(true);
	
	
});



/**
 * 是否禁用工具条
 */
function disableToolbar(flag)
{
	$('#btn_add,#btn_edit,#btn_del').linkbutton({
		disabled:flag
	});
	
}


/**
 * 初始化百度编辑器
 */
function initUEditor(title)
{
	
	var ue = new baidu.editor.ui.Editor();
	ue.render("content"); //这里填写要改变为编辑器的控件id

	
	if($.trim($(title).val())!=""){
	  ue.setContent(title, false);
	}
	
	 
}

/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	var urlStr='goeKnowledgePoint/list.htm';
	if(params!=null){
		urlStr=urlStr+'?'+ Json2GetStr(params);
	}
	
	$('#browgrid').datagrid({
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
		href:'jsp/subject/goeKnowledgePoint_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交', 
			iconCls:'tick',  
			handler:function(){  
				$('#editForm').form('submit',{
					url:'goeKnowledgePoint/create.htm',
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
						reloadgrid({topicClassId:siClassidId});
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
			$('#editForm').form('load', {topicClassId:siClassidId});
			
			initUEditor();
		}
	});
	$('#editForm').form('reset');
}




	
	

/**
 * 修改方法
 */
function doEdit(){
	//获得选择行
	var rows = $('#browgrid').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/subject/goeKnowledgePoint_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goeKnowledgePoint/update.htm',  
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
			
			initUEditor(rows[0].content);
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
 				url:'goeTopic/delete.htm',
 				data :{id:rows[0].id},
 				dataType : 'json',
				success : function(obj) {
					
					$('#projectStageConfig').datagrid('unselectAll');
					showRMsg(obj.msg);
					reloadgrid(siClassidId);
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