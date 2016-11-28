<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>贵州锦越和能源</title>
<meta name="Keywords" content="贵阳锦越和能公司">
<jsp:include page="inc.jsp"></jsp:include>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div align="center">
		<table width="980" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="5" colspan="3"></td>
			</tr>
			<tr>
				<td width="250" valign="top"><table width="250" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td height="49" width="250"
								background="web/images/right-common-title.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								菜单导航</td>
						</tr>
						<tr>
							<td height="30">
								<div align="center">

									<c:forEach var="webNewsType" items="${webNewsTypeList}">

										<c:if test="${webNewsType.parentId == currWebNewsType.id}">
											<table width="240" border="0" align="center" cellpadding="0"
												cellspacing="0" background="web/images/right_2.jpg">
												<tr>
													<td width="51" height="30"></td>
													<td width="189"><a href=""><font color="#575352"><strong>${webNewsType.title}</strong>
														</font>
													</a>
													</td>
												</tr>
											</table>

											<c:forEach var="webNewsTypeSub" items="${webNewsTypeList}">

												<c:if test="${webNewsTypeSub.parentId == webNewsType.id }">
													<table width="240" border="0" align="center"
														cellpadding="0" cellspacing="0"
														background="web/images/right_3.jpg">
														<tr>
															<td width="77" height="30"></td>
															<td width="163"><a href="web/productdetail.htm">
																	<font color="#575352">${webNewsTypeSub.title}</font> </a></td>
														</tr>
													</table>
												</c:if>
											</c:forEach>
										</c:if>
									</c:forEach>


								</div></td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>
						<tr>
							<td height="30" align="center">
								<table width="240" height="199" border="0" cellpadding="0"
									cellspacing="0" background="web/images/r2.png">
									<tr>
										<td valign="top"><table width="240" border="0"
												cellspacing="0" cellpadding="0">

												<tr>
													<td height="120" colspan="2">&nbsp;</td>
												</tr>
												<tr>
													<td width="10" height="25"></td>
													<td width="230">地址:贵阳市南明区宝山南路520、522号</td>
												</tr>
												<tr>
													<td width="10" height="25"></td>
													<td width="230">电话:0851-xxxxxxx,0851-xxxxxxx</td>
												</tr>
												<tr>
													<td width="10" height="25"></td>
													<td width="230">E-mail:xxxxxxx@163.com</td>
												</tr>


											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
				<td width="20">&nbsp;</td>
				<td width="710" valign="top"><table width="710" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td height="4"></td>
						</tr>
						<tr>
							<td height="39" background="web/images/left_.png"><table
									width="710" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46">&nbsp;</td>
										<td width="429">全能系列</td>
										<td width="235">首页 &gt;&gt; 产品与应用 &gt;&gt; 全能系列</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td height="600" valign="top" bgcolor="#FFFFFF">
								<div align="center">
									<table width="650" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td>

												<table width="650" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>
															<table width="650" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td>

																		<table width="680" border="0" align="center"
																			cellpadding="0" cellspacing="0">
																			<tr>
																				<td><br>
																					<div align="center">
																						<table width="162" height="142" border="0"
																							align="center" cellpadding="0" cellspacing="0">

																							<c:forEach var="news" items="${newsList}"
																								varStatus="vs">

																								<c:if test="${vs.count % 2 !=0}">
																									<tr>
																								</c:if>

																								<td width="162" height="142" align="center">
																									<table width="310" height="235" border="0"
																										align="center" cellpadding="0" cellspacing="0">
																										<tr>
																											<td align="center">
																												<table width="290" border="0"
																													cellspacing="0" cellpadding="0" class="ta2"
																													height="215">
																													<tr>
																														<td align="center"><a
																															href="web/newsdetail.htm?id=${news.id}">
																																<img
																																src="<c:out value="web/images/upload/${news.previewImg}"/>"
																																width="280" height="185" border="0">
																														</a> <br /> <font color="#141414"> <c:out
																																	value="${news.mainTitle}" /> </font></td>
																													</tr>
																												</table></td>
																										</tr>
																									</table>
																									</td>

																								<c:if test="${vs.count % 2 ==0}">
																									</tr>
																								</c:if>


																							</c:forEach>

																						</table>
																					</div>
																					<form method=Post action="">
																						<table width=100% border=0 cellpadding=0
																							cellspacing=0>
																							<tr>
																								<td align=center><font color='#141414'>首页
																										上一页</font> <font color='#141414'>下一页 末页</font> <font
																									color='#141414'>页次：1/1页</font> <font
																									color='#141414'>共有4条记录 </font> <font
																									color='#141414'>转到：<input type='text'
																										name='page' size=2 maxlength=10 value=1>
																								</font>&nbsp;<input type='submit' value='GO'
																									name='cndok'>
																								</td>
																							</tr>
																						</table>
																					</form></td>
																			</tr>
																		</table></td>
																</tr>
															</table>
														</td>
													</tr>
												</table></td>
										</tr>

									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td height="3"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>