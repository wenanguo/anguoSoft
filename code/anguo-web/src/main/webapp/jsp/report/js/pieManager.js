var moduleId=0;
var chart;
$(function(){
	
	
	refreshChart();

	
	
	
	/**
	 * 设置datagrid
	 */
	$('#roleList').datagrid({
		url : 'reportPie/list.htm',
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
				field:'name',
				title:'名称',
				width:240
			},{
				field:'y',
				title:'占比',
				width:100,
				formatter:function(value,rowData,rowIndex){
					
					return '<span style="color:#006000">'+value+'</span>';
					
				}
			}
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit(1,rowIndex,rowData);
		},
		pagination:false,
		loadMsg:'正在加载...'
	});
});



function refreshChart()
{
	$.ajax({
		url : 'reportPie/list.htm',
		dataType : 'json',
		async:false,
		success : function(d) {

		     createChart(d.rows)
		}
	});

	
}

function createChart(pieData)
{

	
	 chart = new Highcharts.Chart({
	 		chart: {
	 			renderTo: 'container',
	 			plotBackgroundColor: null,
	 			plotBorderWidth: null,
	 			plotShadow: false
	 		},
	 		title: {
	 			text: '浏览器使用情况统计图, 2014'
	 		},
	 		tooltip: {
	 			formatter: function() {
	 				return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
	 			}
	 		},credits : {
	             enabled:false//不显示highCharts版权信息
	         },
	 		plotOptions: {
	 			pie: {
	 				allowPointSelect: true,
	 				cursor: 'pointer',
	 				dataLabels: {
	 					enabled: true,
	 					color: '#000000',
	 					connectorColor: '#000000',
	 					formatter: function() {
	 						return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
	 					}
	 				}
	 			}
	 		},
	 		series: [{
	 			type: 'pie',
	 			name: 'Browser share',
	 			data: pieData
	 		}]
	 	});
	     
	
	
	
}

/**
 * 通过条件刷新grid
 */
function reloadgrid(params) {
	
	$('#roleList').datagrid('load', params);
	
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
		href:'jsp/report/pieManager-edit.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#editForm').form('submit',{
					url:'reportPie/create.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						
					},
					success:function(data){
						var obj = eval('('+ data +')');
						
						$('#add').dialog('close');
						
						refreshChart();
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
 * 修改方法
 */
function doEdit(){
	
	//获得选择行
	var rows = $('#roleList').datagrid('getSelections');

	if (rows.length != 1) {
		$.messager.alert('提示', '请选择一条数据再进行修改', 'error');
		return false;
	}
	
	
	
	$('#add').show().dialog({
		modal:true,
		title:'修改',
		href:'jsp/report/pieManager-edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'reportPie/update.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#add').dialog('close');
						
						
						refreshChart();

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
			
		}
	
	});
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
									url : 'reportPie/delete.htm',
									data :{id:rows[0].id},
									dataType : 'json',
									success : function(d) {

										//刷新grid
										var params = {
												webNewsTypeId : moduleId
												};
												
										reloadgrid(params);
										
									}
								});
						
						refreshChart();

					}
				});
	
}


