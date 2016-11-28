<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>6、广告类接口</h2>
			<br/>
			<h3>6.1、获得广告列表<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeAdList.app</h4>
			<table class="table table-bordered">
			 	<tr>
			 		<td colspan="5" align="center">入参 </td>
			 	</tr>
			 	<tr class="success">
			 		<td width="20%">参数名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td>否</td>
			 		<td></td>
			 	</tr>
			 	<tr>
			 		<td colspan="5" align="center">出参 </td>
			 	</tr>
			 	<tr class="info">
			 		<td width="20%">参数名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>id</td>
			 		<td>广告编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>广告唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>logo</td>
			 		<td>logo图片地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>url</td>
			 		<td>链接地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>location</td>
			 		<td>广告位置</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>adOrder</td>
			 		<td>排序</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>isAd</td>
			 		<td>是否广告</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1新闻，2推广</td>
			 	</tr>
			 	<tr >
			 		<td>adType</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>类别.1内部广告，2外部广告</td>
			 	</tr>
			 	<tr >
			 		<td>auditor</td>
			 		<td>审核人</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>auditDatetime</td>
			 		<td>审核时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>auditOpinion</td>
			 		<td>审核意见</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>startDate</td>
			 		<td>开始时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>endDate</td>
			 		<td>结束时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>status</td>
			 		<td>状态</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>operateUserName</td>
			 		<td>操作人</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>operateDate</td>
			 		<td>操作时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	
			 	
			</table>
			
