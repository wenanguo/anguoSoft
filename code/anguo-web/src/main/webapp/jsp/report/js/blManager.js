var moduleId=0;
var chart;
$(function(){
	
	
	
	$.ajax({
		url : 'reportBl/list.htm',
		dataType : 'json',
		async:false,
		success : function(d) {

		     createChart(d.rows)
		}
	});
	
	
	
	/**
	 * 设置datagrid
	 */
	$('#roleList').datagrid({
		url : 'reportBl/list.htm',
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
			}
		]],
		onDblClickRow:function(rowIndex, rowData){
			doEdit(1,rowIndex,rowData);
		},
		pagination:false,
		loadMsg:'正在加载...'
	});
});


function createChart(bldata)
{

	chart = new Highcharts.Chart({
		chart: {
			renderTo: 'container',
			defaultSeriesType: 'line',
			marginRight: 130,
			marginBottom: 25
		},
		title: {
			text: '各城市天气情况表',
			x: -20 //center
		},credits : {
            enabled:false//不显示highCharts版权信息
        },
		subtitle: {
			text: '数据来源: 中国天气网',
			x: -20
		},
		xAxis: {
			categories: ['1月', '2月', '3月', '4月', '5月', '6月',
				'7月', '8月', '9月', '10月', '11月', '12月']
		},
		yAxis: {
			title: {
				text: '温度 (°C)'
			},
			plotLines: [{
				value: 0,
				width: 1,
				color: '#808080'
			}]
		},
		tooltip: {
			formatter: function() {
					return '<b>'+ this.series.name +'</b><br/>'+
					this.x +': '+ this.y +'°C';
			}
		},
		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'top',
			x: -10,
			y: 100,
			borderWidth: 0
		},
		series: bldata
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
		href:'jsp/report/blManager-edit.jsp',
		cache:false,
		toolbar:[{
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				
				$('#editForm').form('submit',{
					url:'reportBl/create.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						
					},
					success:function(data){
						var obj = eval('('+ data +')');
						
						$('#add').dialog('close');
						

						$.ajax({
							url : 'reportBl/list.htm',
							dataType : 'json',
							async:false,
							success : function(d) {

							     createChart(d.rows)
							}
						});
						
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
		href:'jsp/report/blManager-edit.jsp',
		cache:false,
		toolbar:[{  
			text:'提交',  
			iconCls:'tick',  
			handler:function(){
				$('#editForm').form('submit',{
					url:'reportBl/update.htm',
					onSubmit: function(){
						var isValid = $('#editForm').form('validate');
						if (!isValid){
							return false;	
						}
						
						
					},
					success:function(data){
						var obj = eval('('+ data +')');
						$('#add').dialog('close');
						

						$.ajax({
							url : 'reportBl/list.htm',
							dataType : 'json',
							async:false,
							success : function(d) {

							     createChart(d.rows)
							}
						});

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
									url : 'reportBl/delete.htm',
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
						
						

						$.ajax({
							url : 'reportBl/list.htm',
							dataType : 'json',
							async:false,
							success : function(d) {

							     createChart(d.rows)
							}
						});

					}
				});
	
}


