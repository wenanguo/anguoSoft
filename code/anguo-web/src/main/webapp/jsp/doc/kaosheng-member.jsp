<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>2、会员类接口</h2>
			<br/>
			<h3>2.1、登录<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}login.app</h4>
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
			 		<td>memberName</td>
			 		<td>登录名</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
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
			 		<td>id</td>
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>会员唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>uuid</td>
			 		<td>登录uuid</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>登录后的uuid，调用 鉴权接口必备，每次重新登录都会注销上一次登录</td>
			 	</tr>
			 	<tr >
			 		<td>memberName</td>
			 		<td>登录名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>goeCampus</td>
			 		<td>校区实体</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>参见【com.anguo.subject.db.domain.GoeCampus】类</td>
			 	</tr>
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>nickName</td>
			 		<td>昵称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册学员选择所属校区的编号</td>
			 	</tr>
			 	<tr >
			 		<td>photo</td>
			 		<td>头像地址</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sex</td>
			 		<td>性别</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>1为男，2为女</td>
			 	</tr>
			 	<tr >
			 		<td>birthday</td>
			 		<td>出生日期</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contact</td>
			 		<td>联系方式</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>email</td>
			 		<td>邮箱</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberClass</td>
			 		<td>是否招生人员</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>xgToken</td>
			 		<td>信鸽token</td>
			 		<td>String</td>
			 		<td><font color="red">否</font></td>
			 		<td></td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.2、注销<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}logout.app</h4>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 		<td>参考【公共参数-返回参数】</td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.3、新增会员<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}newMember.app</h4>
			<table class="table table-bordered">
			 	<tr class="success">
			 		<td width="20%">参数名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>memberName</td>
			 		<td>登录名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	
			 	<tr >
			 		<td>goeSubjectList</td>
			 		<td>注册科目</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册科目list对象，参见【com.anguo.subject.db.domain.GoeSubject】实体类</td>
			 	</tr>
			 	
			 	
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>nickName</td>
			 		<td>昵称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册学员选择所属校区的编号</td>
			 	</tr>
			 	<tr >
			 		<td>photo</td>
			 		<td>头像地址</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sex</td>
			 		<td>性别</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>1为男，2为女</td>
			 	</tr>
			 	<tr >
			 		<td>birthday</td>
			 		<td>出生日期</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contact</td>
			 		<td>联系方式</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>email</td>
			 		<td>邮箱</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberClass</td>
			 		<td>是否招生人员</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>xgToken</td>
			 		<td>信鸽token</td>
			 		<td>String</td>
			 		<td><font color="red">否</font></td>
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
			 		<td>会员唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>uuid</td>
			 		<td>登录uuid</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>登录后的uuid，调用 鉴权接口必备，每次重新登录都会注销上一次登录</td>
			 	</tr>
			 	<tr >
			 		<td>memberName</td>
			 		<td>登录名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>goeCampus</td>
			 		<td>校区实体</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>参见【com.anguo.subject.db.domain.GoeCampus】类</td>
			 	</tr>
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>nickName</td>
			 		<td>昵称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册学员选择所属校区的编号</td>
			 	</tr>
			 	<tr >
			 		<td>photo</td>
			 		<td>头像地址</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sex</td>
			 		<td>性别</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>1为男，2为女</td>
			 	</tr>
			 	<tr >
			 		<td>birthday</td>
			 		<td>出生日期</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contact</td>
			 		<td>联系方式</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>email</td>
			 		<td>邮箱</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberClass</td>
			 		<td>是否招生人员</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>xgToken</td>
			 		<td>信鸽token</td>
			 		<td>String</td>
			 		<td><font color="red">否</font></td>
			 		<td></td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.4、修改会员<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}updateMember.app</h4>
			<table class="table table-bordered">
			 	<tr class="success">
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
			 		<td>会员唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberName</td>
			 		<td>登录名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>nickName</td>
			 		<td>昵称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册学员选择所属校区的编号</td>
			 	</tr>
			 	<tr >
			 		<td>photo</td>
			 		<td>头像地址</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sex</td>
			 		<td>性别</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>1为男，2为女</td>
			 	</tr>
			 	<tr >
			 		<td>birthday</td>
			 		<td>出生日期</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contact</td>
			 		<td>联系方式</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>email</td>
			 		<td>邮箱</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberClass</td>
			 		<td>是否招生人员</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>xgToken</td>
			 		<td>信鸽token</td>
			 		<td>String</td>
			 		<td><font color="red">否</font></td>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 		<td>参考【公共参数-返回参数】</td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.5、修改密码<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}updatePassword.app</h4>
			<table class="table table-bordered">
			 	<tr class="success">
			 		<td width="20%">参数名称</td>
			 		<td width="10%">参数类型</td>
			 		<td width="10%">数据类型</td>
			 		<td width="10%">是否必填</td>
			 		<td width="50%">说明</td>
			 	</tr>
			 	<tr >
			 		<td>oldPassword</td>
			 		<td>原始密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>新密码</td>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 		<td>参考【公共参数-返回参数】</td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.6、头像上传<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}toFileUpload/goe/toMultiUpload.htm</h4>
			<table class="table table-bordered">
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
			 		<td>client</td>
			 		<td>原始文件名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>server</td>
			 		<td>服务器文件名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			</table>
			
			<br/>
			<h3>2.7、验证码登录<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}loginByVerificationCode.app</h4>
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
			 		<td>phone</td>
			 		<td>手机号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>code</td>
			 		<td>验证码</td>
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
			 		<td>id</td>
			 		<td>会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>会员唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>uuid</td>
			 		<td>登录uuid</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>登录后的uuid，调用 鉴权接口必备，每次重新登录都会注销上一次登录</td>
			 	</tr>
			 	<tr >
			 		<td>memberName</td>
			 		<td>登录名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>password</td>
			 		<td>登录密码</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>goeCampus</td>
			 		<td>校区实体</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>参见【com.anguo.subject.db.domain.GoeCampus】类</td>
			 	</tr>
			 	<tr >
			 		<td>imei</td>
			 		<td>手机imei</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>imsi</td>
			 		<td>手机imsi</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>nickName</td>
			 		<td>昵称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>campusId</td>
			 		<td>所属校区编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>注册学员选择所属校区的编号</td>
			 	</tr>
			 	<tr >
			 		<td>photo</td>
			 		<td>头像地址</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sex</td>
			 		<td>性别</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td>1为男，2为女</td>
			 	</tr>
			 	<tr >
			 		<td>birthday</td>
			 		<td>出生日期</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>contact</td>
			 		<td>联系方式</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>email</td>
			 		<td>邮箱</td>
			 		<td>String</td>
			 		<td><font color="green">否</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>memberClass</td>
			 		<td>是否招生人员</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>xgToken</td>
			 		<td>信鸽token</td>
			 		<td>String</td>
			 		<td><font color="red">否</font></td>
			 		<td></td>
			 	</tr>
			</table>
			
			
			<br/>
			<h3>2.8、验证码下发<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}sendVerificationCode.app</h4>
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
			 		<td>phone</td>
			 		<td>手机号</td>
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
			 		<td>无</td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 		<td></td>
			 	</tr>
			</table>
			