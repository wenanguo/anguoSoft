<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
			<h2>4、题目类接口</h2>
			<br/>
			<h3>4.1、获得章节列表<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeTopicClassList.app</h4>
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
			 		<td>topicType</td>
			 		<td>题目类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1章节知识点，2章节习题，3全真模拟，4课后作业</td>
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
			 		<td>题目类型编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>题目类型唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>subjectId</td>
			 		<td>所属科目编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>科目类型标题</td>
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
			 		<td>topicType</td>
			 		<td>科目类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1章节知识点，2章节习题，3全真模拟，4课后作业</td>
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
			 		<td>topicCount</td>
			 		<td>当前章节包含题目数量</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>workCount</td>
			 		<td>做题数</td>
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
			<h3>4.2、获得题目列表（包含题目答案选项）<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeTopicList.app</h4>
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
			 		<td>topicClassId</td>
			 		<td>所属章节编号</td>
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
			 		<td>题目编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>题目唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>topicId</td>
			 		<td>题目序号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>当前章节内题目序号</td>
			 	</tr>
			 	<tr >
			 		<td>topicClassId</td>
			 		<td>所属章节编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>标题</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>topicType</td>
			 		<td>题目类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1 单选，2 多选，3 判断</td>
			 	</tr>
			 	<tr >
			 		<td>rightAnswer</td>
			 		<td>正确答案</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1章节知识点，2章节习题，3全真模拟，4课后作业</td>
			 	</tr>
			 	<tr >
			 		<td>analysis</td>
			 		<td>答案解析</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>rightAnswer</td>
			 		<td>正确答案</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>topicClass</td>
			 		<td>题型类别</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>(暂不用)1章节练习题，2真题模拟，3课后作业</td>
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
			 		<td>value</td>
			 		<td>分值</td>
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
			 		<td>workCount</td>
			 		<td>做题数</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr>
			 		<td>list</td>
			 		<td>答案对象列表</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>list对象列表,类名为【GoeTopicAnswer】</td>
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
			<h3>4.3、答题<small><font color="green">（已完成）</font><font color="red">【登录验证】</font></small></h3>
			<h4>地址：${url}saveGoeMemberAnswer.app</h4>
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
			 		<td>list.topicId</td>
			 		<td>答题编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>所做题目的唯一标示</td>
			 	</tr>
			 	<tr>
			 		<td>list.memberAnswer</td>
			 		<td>用户答案</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>提交数据为【GoeMemberAnswer】类队列</td>
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
			 		<td>此接口必须为已登录用户，并设置了用户参数</td>
			 	</tr>
			</table>
			
			
			<br/>
			<h3>4.4、获得知识点<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeKnowledgePointList.app</h4>
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
			 		<td>topicClassId</td>
			 		<td>所属章节编号</td>
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
			 		<td>知识点编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>知识点唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>knowledgeType</td>
			 		<td>类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>topicClassId</td>
			 		<td>所属章节编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>content</td>
			 		<td>内容</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>url</td>
			 		<td>连接地址</td>
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
			<h3>4.5、获得批注<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoePostilList.app</h4>
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
			 		<td>topicId</td>
			 		<td>所属题目编号</td>
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
			 		<td>批注编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>批注唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>所属会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>topicId</td>
			 		<td>所属题目编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>comment</td>
			 		<td>内容</td>
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
			<h3>4.6、获得收藏<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryGoeCollectList.app</h4>
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
			 		<td>topicId</td>
			 		<td>所属题目编号</td>
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
			 		<td>收藏编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>收藏唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>memberId</td>
			 		<td>所属会员编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>topicId</td>
			 		<td>所属题目编号</td>
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
			 	<tr>
			 		<td>level</td>
			 		<td>星级</td>
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
			<h3>4.7、获得热门章节<small><font color="green">（已完成）</font></small></h3>
			<h4>地址：${url}queryHotExercisesList.app</h4>
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
			 		<td>题目类型编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>题目类型唯一编号，不可重复</td>
			 	</tr>
			 	<tr >
			 		<td>subjectId</td>
			 		<td>所属科目编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td></td>
			 	</tr>
			 	<tr >
			 		<td>title</td>
			 		<td>科目类型标题</td>
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
			 		<td>topicType</td>
			 		<td>科目类型</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>1章节知识点，2章节习题，3全真模拟，4课后作业</td>
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
			 		<td>workCount</td>
			 		<td>做题数</td>
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
			<h3>4.8、增加章节浏览量<small><font color="green">（已完成）</font><font color="red">【登录验证】</font></small></h3>
			<h4>地址：${url}addTopicClassWorkCount.app</h4>
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
			 		<td>id</td>
			 		<td>章节编号</td>
			 		<td>String</td>
			 		<td><font color="red">是</font></td>
			 		<td>章节的唯一标示</td>
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
			 		<td>此接口必须为已登录用户，并设置了用户参数</td>
			 	</tr>
			</table>
			