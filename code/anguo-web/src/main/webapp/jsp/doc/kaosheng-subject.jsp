<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>3、科目类接口</h2>
			<br/>
			<h3>3.1、获取所有科目<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}getAllSubjectList.app</h4>
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
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>科目唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>科目标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memo</td>
			 		<td>科目备注</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>examTime</td>
			 		<td>考试时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>generalMemberPrice</td>
			 		<td>会员单价</td>
			 		<td>money</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>allVideoPrice</td>
			 		<td>全套视频单价</td>
			 		<td>money</td>
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
			<h3>3.2、获取已注册科目<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}getRegSubjectList.app</h4>
			<table class="table table-bordered">
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
			 		<td>此接口必须为已登录用户，并设置了用户参数</td>
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
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>科目唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>科目标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>isReg</td>
			 		<td>是否注册</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>0为未注册，1为免费，2为本校科目+视频， 3为外校科目， 4为外校科目+视频</td>
			 	</tr>
			 	<tr >
			 		<td>memo</td>
			 		<td>科目备注</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>examTime</td>
			 		<td>考试时间</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>generalMemberPrice</td>
			 		<td>会员单价</td>
			 		<td>money</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>allVideoPrice</td>
			 		<td>全套视频单价</td>
			 		<td>money</td>
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
			<h3>3.3、注册新科目<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}regSubject.app</h4>
			<table class="table table-bordered">
			 	<tr class="success">
			 		<td width="20%">参数名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>subjectIds</td>
			 		<td>科目编号数组</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>需注册科目编号数组，多个科目编号用#号分割，如"1#2#3"</td>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 		<td>参考【公共参数-返回参数】</td>
			 	</tr>
			</table>
			
			<br/>
			<h3>3.4、获得校区列表<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryAppCampusList.app</h4>
			<table class="table table-bordered">
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
			 		<td>校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>name</td>
			 		<td>校区名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>address</td>
			 		<td>地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>logo</td>
			 		<td>图片地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memo</td>
			 		<td>备注</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contactMan</td>
			 		<td>联系人</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contactPhone</td>
			 		<td>联系电话</td>
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
			
			