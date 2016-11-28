<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String sequence=String.valueOf(System.currentTimeMillis());
request.setAttribute("sequence", sequence);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>GoePay</title>
    	<jsp:include page="../../resources/page/inc.jsp"></jsp:include>
		<script type="text/javascript" src="jsp/js/goePay.js"></script>
  	</head>
  	<body>
  		
		<div class="easyui-layout" data-options="fit:true">
		<div class="contactFieldset" data-options="region:'center',border:false">
			<form id="editForm" method="post">
				<table class="table" width="100%" border='0' cellspacing='0' cellpadding='1'>
				
	<tr>
						<td style="text-align:left;font-size:12px;">流水号:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" style="width:240px;" id="sequence" name="sequence" readonly="true" value="${sequence}"/>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">支付渠道:<span style="color:red">*</span></td>
						<td>
							
							<select class="easyui-combobox" id="payChannel" name="payChannel" style="width:240px;">
						        <option value="1">现金</option>
						        <option value="2">支付宝</option>
						        <option value="3">积分</option>
						    </select>
						</td>
					</tr>
					
					<tr>
						<td style="text-align:left;font-size:12px;">支付类别:<span style="color:red">*</span></td>
						<td>
							
							<select class="easyui-combobox" id="payType"  name="payType" data-options="onChange:changePayChannel" style="width:240px;">
						        <option value="1">科目支付</option>
						        <option value="2">全套视频支付</option>
						    </select>
						</td>
					</tr>
	<tr>
						<td style="text-align:left;font-size:12px;">支付金额:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-numberbox" data-options="required:false" style="width:240px;" max="99999" min="0" id="payMoney" name="payMoney"/>元
						</td>
					</tr>
	
	<tr>
						<td style="text-align:left;font-size:12px;">付款人:<span style="color:red">*</span></td>
						<td>
							<input  class="input easyui-validatebox" data-options="required:false" 
							 style="width:240px;" id="payer" name="payer"/>
						</td>
					</tr>
	
				
					<tr>
						<td></td>
						<td>
						<input type="hidden" id="id" name="id" value=""> 
						<input type="hidden" id="sourceId" name="sourceId" value=""/>
						<input type="hidden" id="datetime" name="datetime" value=""/>
						<input type="hidden" id="source" name="source" value=""/>
						<input type="hidden" id="payCredits" name="payCredits" value=""/>
						<input type="hidden" id="status" name="status" value=""/>
						<input type="hidden" id="operateUserId" name="operateUserId" value=""/>
						<input type="hidden" id="operateDate" name="operateDate" value=""/>
						<input type="hidden" id="payee" name="payee"/>
						
						<input type="hidden" id="generalMemberPrice" name="generalMemberPrice"/>
						<input type="hidden" id="allVideoPrice" name="allVideoPrice"/>
						
						</td>
					</tr>
					
				</table>
			</form>
			
		</div>
		
		</div>
		
			
	</body>
	
</html>		