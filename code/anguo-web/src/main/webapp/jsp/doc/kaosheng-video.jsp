<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>5、视频类接口</h2>
			<br/>
			<h3>5.1、获得视频列表<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeVideoList.app</h4>
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
			 		<td>category</td>
			 		<td>视频类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1上课视频，2上级模拟视频</td>
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
			 		<td>视频编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>题目类型唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>name</td>
			 		<td>视频名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>subjectId</td>
			 		<td>所属科目编号</td>
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
			 		<td>url</td>
			 		<td>视频地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>lecturer</td>
			 		<td>讲师</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>duration</td>
			 		<td>时长</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>category</td>
			 		<td>视频类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1上课视频，2上级模拟视频</td>
			 	</tr>
			 	<tr >
			 		<td>chargeCategories</td>
			 		<td>收费类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>收费类别.1免费，2付费，3在校学员</td>
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
			 		<td>price</td>
			 		<td>价格</td>
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
			 		<td>optCount</td>
			 		<td>点赞数</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>browseCount</td>
			 		<td>观看数</td>
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
			<h3>5.2、获得热门视频<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryHotGoeVideoList.app</h4>
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
			 		<td>视频编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>题目类型唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>name</td>
			 		<td>视频名称</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>subjectId</td>
			 		<td>所属科目编号</td>
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
			 		<td>url</td>
			 		<td>视频地址</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>lecturer</td>
			 		<td>讲师</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>duration</td>
			 		<td>时长</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>category</td>
			 		<td>视频类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1上课视频，2上级模拟视频</td>
			 	</tr>
			 	<tr >
			 		<td>chargeCategories</td>
			 		<td>收费类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>收费类别.1免费，2付费，3在校学员</td>
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
			 		<td>price</td>
			 		<td>价格</td>
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
			 		<td>optCount</td>
			 		<td>点赞数</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>browseCount</td>
			 		<td>观看数</td>
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
			<h3>5.3、获得观看进度<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}getReading.app</h4>
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
			 		<td>affiliationId</td>
			 		<td>所属视频或者章节编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>readType</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1视频，2知识点</td>
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
			 		<td>进度编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>所属会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>readType</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>sequence</td>
			 		<td>流水号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>请求视频播放流水号</td>
			 	</tr>
			 	<tr >
			 		<td>affiliationId</td>
			 		<td>标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>视频或者章节编号</td>
			 	</tr>
			 	<tr >
			 		<td>progress</td>
			 		<td>进度</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>时间为播放时间秒数，知识点进度为页数</td>
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
			<h3>5.4、保存观看进度<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}saveReading.app</h4>
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
			 		<td>affiliationId</td>
			 		<td>所属视频或者章节编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>readType</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1视频，2知识点</td>
			 	</tr>
			 	<tr >
			 		<td>progress</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>视频就传时间秒数，知识点就传页数</td>
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
			 		<td>进度编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>所属会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>readType</td>
			 		<td>类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>affiliationId</td>
			 		<td>标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>视频或者章节编号</td>
			 	</tr>
			 	<tr >
			 		<td>progress</td>
			 		<td>进度</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>时间为播放时间秒数，知识点进度为页数</td>
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
			<h3>5.5、增加视频浏览量<small></small></h3>
			<h4>地址：${url}addVideoBrowseCount.app</h4>
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
			 		<td>id</td>
			 		<td>所属视频编号</td>
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
			
			<br/>
			<h3>5.5、增加视频点赞量<small></small></h3>
			<h4>地址：${url}addVideoOptCount.app</h4>
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
			 		<td>id</td>
			 		<td>所属视频编号</td>
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
			
			
		
			