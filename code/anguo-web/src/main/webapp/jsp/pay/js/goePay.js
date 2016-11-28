$(function(){
	/**
	 * 设置datagrid
	 */
	$('#projectStageConfig').datagrid({
		url:'goePay/list.htm',
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, //允许分页
		pageSize : 20, //重写每页显示的记录条数，默认为10
		pageList : [10,20,50,100], //设置每页记录条数的列表
		nowrap : true,
		toolbar : tool_btns[0],
	    columns:[[
			
					    {title:'编号',field: 'id',width:100,checkbox:true },   
					    {title:'流水号',field: 'sequence',width:100},   
					    {title:'支付渠道',field: 'payChannel',width:100,formatter:function(value,rowData,rowIndex){
					    	if(value==1){
					    		return "现金";
					    	}else if(value==2){
					    		return "支付宝";
					    	}else if(value==3){
					    		return '<font style="color:green">微信</font>';
					    	}else if(value==4){
					    		return "积分";
					    	}else{
					    		return "其他";
					    	}
					    	
				    		
					    }},    
					    {title:'应付价格',field: 'payMoney',width:100,formatter:function(value,rowData,rowIndex){
				    		return (value/100)+"  （元）";
					    }}, 
					    {title:'实付价格',field: 'actualMoney',width:100,formatter:function(value,rowData,rowIndex){
				    		return (value/100)+"  （元）";
					    }}, 
					    {title:'来源',field: 'source',width:100},   
					    
					    
					    {title:'下单时间',field: 'datetime',width:100 ,hidden:true ,formatter:function(value,rowData,rowIndex){
				    		return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					    }}, 
					    
					    {title:'付款人',field: 'payer',width:100},   
					    {title:'状态',field: 'status',width:100,
					    	formatter:function(value,rowData,rowIndex){
					    		if(value==201){
						    		return "未支付";
						    	}else if(value==202){
						    		return "支付中";
						    	}else if(value==203){
						    		return '<font style="color:green">支付成功</font>';
						    	}else if(value==204){
						    		return '<font style="color:red">支付失败</font>';
						    	}else{
						    		return "其他";
						    	}
								} 	
					    },   
					    
					    {title:'完成支付时间',field: 'operateDate',width:100 ,hidden:true ,formatter:function(value,rowData,rowIndex){
					    		return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
					    }}   
						
		
			
		]],
		onClickRow : function(rowIndex, rowData) {
			
			var params ={  
					sequence: rowData.sequence
				};
				
			reloadCommodityGrid(params);
			
		},
		onDblClickRow:function(rowIndex, rowData){
			//doEdit();
		},
		pagination:true,
		loadMsg:'正在加载...'
	});
	
	
	/**
	 * 设置datagrid
	 */
	$('#payGrid').datagrid({
		url:'goeCommodity/list.htm',
		fit : true,
		border : false,
		rownumbers : true,
		singleSelect:true,
		fitColumns : true,
		pagination : true, // 允许分页
		pageSize : 20, // 重写每页显示的记录条数，默认为10
		pageList : [10,20,50,100], // 设置每页记录条数的列表
		nowrap : true,
	    columns:[[
			
	              {title:'编号',field: 'id',width:100,checkbox:true },   
				    {title:'流水号',field: 'sequence',width:120 },   
				    {title:'商品名称',field: 'commodityName',width:100 ,hidden:true },   
				    {title:'商品编号',field: 'commodityId',width:100 ,hidden:true },   
				    {title:'展示价格',field: 'payMoney',width:100,hidden:true  },
				    {title:'实际价格',field: 'actualMoney',width:100},
				    {title:'支付积分',field: 'payCredits',width:100},   
				    {title:'来源',field: 'source',width:140},   
				    {title:'支付类别',field: 'payType',width:100},   
				    {title:'付款时间',field: 'datetime',width:150 ,formatter:function(value,rowData,rowIndex){
				    	return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
				    } },   
				    {title:'付款人',field: 'payer',width:100 },   
				    {title:'收款人',field: 'payee',width:100,hidden:true },   
				    {title:'状态',field: 'status',width:100 ,hidden:true,
				    	formatter:function(value,rowData,rowIndex){
							   return stateFormat(value);
							} 
				    	},   
				    {title:'操作人',field: 'operateUserId',width:100,hidden:true },   
				    {title:'操作时间',field: 'operateDate',width:100 ,hidden:true,formatter:function(value,rowData,rowIndex){
				   return formatTime(value, 'yyyy-MM-dd hh:mm:ss');
				} },   
					{title:'操作人',field: 'realName',width:100,hidden:true  }
	
		
			
		]],
		onDblClickRow:function(rowIndex, rowData){
			//doPay();
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
			payer: $.trim($('#filterParam1').val()),
			sequence: $.trim($('#filterParam2').val())
	};
	
	reloadgrid(params);
	reloadCommodityGrid(params);
	
}



/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	$('#projectStageConfig').datagrid('load', params);
	
}

/**
 * 通过条件刷新商品表grid
 */
function reloadCommodityGrid(params) {
	
	$('#payGrid').datagrid('load', params);
	
}


/**
 * 支付方法
 */
function doPay(){
	
	
	//获得选择行
	var rows = $('#projectStageConfig').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行付款', 'error');
		return false;
	}
	
	$('#edit').show().dialog({
		modal:true,
		title:'付款',
		href:'jsp/pay/goePay_edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'goePay/create.htm',  
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
						$('#payGrid').datagrid('load',{});
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
			$('#editForm').form('load', 
				{
				sourceId:rows[0].pid,
				status:202,
				payMoney:rows[0].generalMemberPrice,
				generalMemberPrice:rows[0].generalMemberPrice,
				allVideoPrice:rows[0].allVideoPrice	
				}
			);
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
 				url:'goeMemberSubject/delete.htm',
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