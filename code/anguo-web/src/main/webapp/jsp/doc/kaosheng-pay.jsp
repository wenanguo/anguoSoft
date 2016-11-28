<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>8、微信支付类接口</h2>
			<br/>
			<h3>8.1、微信下单<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}unifiedorder.app</h4>
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
			 		<td>subjectId</td>
			 		<td>科目编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberType</td>
			 		<td>支付类型.1免费  2本校科目+视频  3外校科目  4外校科目+视频</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
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
			 		<td>appid</td>
			 		<td>公众账号ID</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>partnerid</td>
			 		<td>商户号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>prepayid</td>
			 		<td>预支付交易会话ID</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>noncestr</td>
			 		<td>随机字符串</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>timestamp</td>
			 		<td>时间戳</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sign</td>
			 		<td>签名</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	
			 	
			 	
			</table>
			
			
			
			
			
		
			