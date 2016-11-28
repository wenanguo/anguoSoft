<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>7、师生互动类接口</h2>
			<br/>
			<h3>7.1、获得热门留言列表<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryHotGoeInteractionList.app</h4>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
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
			 		<td>留言编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>留言唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>留言会员编号</td>
			 	</tr>
			 	<tr >
			 		<td>empId</td>
			 		<td>回复用户编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>message</td>
			 		<td>留言内容</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>replyMessage</td>
			 		<td>回复内容</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>messageTime</td>
			 		<td>留言时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>replyMessageTime</td>
			 		<td>回复时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>optCount</td>
			 		<td>点赞数量</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>goeOrder</td>
			 		<td>排序</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>recommend</td>
			 		<td>推荐</td>
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
			
			
			<br/>
			<h3>7.2、获得我的留言<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryMyGoeInteractionList.app</h4>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
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
			 		<td>留言编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>留言唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>留言会员编号</td>
			 	</tr>
			 	<tr >
			 		<td>empId</td>
			 		<td>回复用户编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>message</td>
			 		<td>留言内容</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>replyMessage</td>
			 		<td>回复内容</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>messageTime</td>
			 		<td>留言时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>replyMessageTime</td>
			 		<td>回复时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>optCount</td>
			 		<td>点赞数量</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>goeOrder</td>
			 		<td>排序</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>recommend</td>
			 		<td>推荐</td>
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
			
			
			<br/>
			<h3>7.3、新增留言<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}addGoeInteraction.app</h4>
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
			 		<td>message</td>
			 		<td>留言内容</td>
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
			 	
			 	
			</table>
			
			<br/>
			<h3>7.4、招生上报<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}addGoeAdmission.app</h4>
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
			 		<td>name</td>
			 		<td>姓名</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>phone</td>
			 		<td>手机号码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>subjectIds</td>
			 		<td>科目编号数组</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>需注册科目编号数组，多个科目编号用#号分割，如"1#2#3"</td>
			 	</tr>
			 	<tr >
			 		<td>price</td>
			 		<td>费用</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>上报人员</td>
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
			 	
			 	
			</table>
			
			
			
		
			