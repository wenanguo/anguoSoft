var moduleId=0;

$(function(){
	
	
	/**
	 * 初始化菜单树
	 */
	$('#webNewsTypeTree').tree({
		url:'webNewsType/tree.htm',
		method:'get',
		animate:true,
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
	
	
	
	
	/**
	 * 设置datagrid
	 */
	$('#webNewsList').datagrid({
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
				field:'mainTitle',
				title:'主标题',
				width:240
			},
			{
				field:'subTitle',
				title:'副标题',
				width:100
			},{
				field:'isRed',
				title:'是否标红',
				width:100,
				formatter:function(value,rowData,rowIndex){
					if(value == 2){
						return '<span style="color:#ff0000">是</span>';
					}else if(value == 1){
						return '<span style="color:#000000">否</span>';
					}
				}
			},{
				field:'isDisplayPreviewImg',
				title:'显示图片',
				width:140,
				formatter:function(value,rowData,rowIndex){
					if(value == 1){
						return '都显示';
					}else if(value == 2){
						return '概要显示';
					}else if(value == 3){
						return '内容显示';
					}else if(value == 4){
						return '都不显示';
					}
				}
			}
			,{
				field:'contentType',
				title:'内容类型',
				width:140,
				hidden:true
			},{
				field:'hits',
				title:'点击量',
				width:80
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
				},
				hidden:true
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
				formatter:function(value,rowData,rowIndex){
					return value?new Date(value).format('yyyy-MM-dd'):'<span style="color:#0A8B0A">- -</span>';
				},
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
	
	$('#webNewsList').datagrid({
		url : 'webNews/list.htm?webNewsTypeId='
				+ params.webNewsTypeId
	});

	
}


/**
 * 查询方法
 */
function doSearch(){
	$('#chartletList').datagrid('load',{  
		nickName:$.trim($('#filterParam1').val()),
		phone:$('#filterParam2').val(),
		state:$('#filterParam3').val()
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
		title:'新增贴图',
		href:'jsp/news/newsManager-add.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				//设置当前选中节点
				$("#webNewsTypeId").val(moduleId);
				
				$('#addForm').form('submit',{
					url:'webNews/create.htm',
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
						var params = {
								webNewsTypeId : moduleId
								};
								
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

			
			regRadioChange();
		
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
	var rows = $('#webNewsList').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	
	
	$('#add').show().dialog({
		modal:true,
		title:'修改贴图',
		href:'jsp/news/newsManager-add.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#addForm').form('submit',{
					url:'webNews/update.htm',
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
						var params = {
								webNewsTypeId : moduleId
								};
								
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
			//设置预览图片
			$('#previewImg_img').attr({src:$("#basePath").val()+"web/images/upload/"+rows[0].previewImg});
			
			regRadioChange(); 
			
			showOrHideImgUpload(rows[0].isDisplayPreviewImg);
		
		
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
	var data = $('#webNewsList').datagrid('getChecked');
	if (!data.length == 1) {
		$.messager.alert('提示', '请选择一条数据再进行删除', 'error');
		return;
	}

	
	$.messager.confirm('提示', '确认删除吗？', function(r) {
					if (r) {
						var rows = $('#webNewsList').datagrid('getChecked');
						var ids = [];

						for (var i = 0; i < rows.length; i++) {
							ids.push(rows[i].id);
						}
						$.ajax({
									url : 'webNews/delete.htm',

									data : {
										ids : ids.join(',')
									},
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


 /**
  * 按回车触发查询事件
  */
function setTrack(event){
	var e = event?event:window.event;
	if(e.keyCode == 13){
		doSearch();
	}
}

function regRadioChange()
{
	$(":radio[name='isDisplayPreviewImg']").change(function(node) { 
		
		showOrHideImgUpload(node.target.defaultValue);
		
	 }); 
	
}

function showOrHideImgUpload(value)
{
	if(value==4)
	{
		$('#previewImg_table').hide();

	}else
	{
		$('#previewImg_table').show();
		
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
		        //设置显示图片
		        $('#'+fileId+"_img").attr({src:$("#basePath").val()+"web/images/upload/"+obj[0].server });
		        //设置隐藏控件
		        $('#'+fileId).val(obj[0].server);
		    } 
		}; 
	//上传文件
	$('#'+fileId+"_form").ajaxSubmit(options);
	
}

