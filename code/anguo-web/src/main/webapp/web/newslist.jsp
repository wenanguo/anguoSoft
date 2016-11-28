<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//获得分页URL
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>
<c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.title' }">
        	${webConfig.content}
        	</c:if>
</c:forEach>
</title>
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
						<c:if test="${fn:length(webNewsTypeList)>1}">
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
														<td width="189"><a
															href="web/newslist.htm?webNewsTypeId=${webNewsType.id}"><font
																color="#575352"><strong>${webNewsType.title}</strong>
															</font> </a>
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
																<td width="163"><a
																	href="web/newslist.htm?webNewsTypeId=${webNewsTypeSub.id}">
																		<font color="#575352">${webNewsTypeSub.title}</font> </a>
																</td>
															</tr>
														</table>
													</c:if>
												</c:forEach>
											</c:if>
										</c:forEach>
									</div>
								</td>
							</tr>
						</c:if>


						<tr>
							<td height="10"></td>
						</tr>
						<tr>
							<td height="30" align="center">
								<table width="240" height="199" border="0" cellpadding="0"
									cellspacing="0" background="web/images/r2.png">
									<tr>
										<td valign="top">

											 <c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.contactUs' }">
        	${webConfig.content}
        	</c:if>
     </c:forEach>
										</td>
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
							<td height="39" background="web/images/left_.png">
								<table width="710" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46">&nbsp;</td>
										<td width="429">${currWebNewsType.title} 
										
										</td>
										<td width="235"></td>
									</tr>
								</table></td>
						</tr>

						<tr>
							<td height="600" valign="top" bgcolor="#FFFFFF">
								<div align="center">
								
								<c:if test="${currWebNewsType.isPreviewImg==1}">
									<table style="margin-top: 0px;" valign="top">
										<tr>
											<c:forEach var="news" items="${newsList.rows}">
												<tr>
													<td width="297" height="28">· &nbsp;<a
														href="web/newsdetail.htm?id=${news.id}"><font
															color="#575352"><c:out value="${news.mainTitle}" />
														</font> </a>
														<c:if test="${news.isRed==2}">
													<img src="web/images/5-120601152049-50.gif" />
													</c:if>	
													</td>
													<td width="82"></td>
													<td width="250">发布时间： <fmt:formatDate
															value="${news.operateDate}" type="both"
															dateStyle="default" timeStyle="default" />
													</td>
												</tr>
																				  &nbsp;
															</c:forEach>
										</tr>
									</table>
									</c:if>
									<c:if test="${currWebNewsType.isPreviewImg==2}">
									<table width="162" height="142" border="0" align="center" cellpadding="0" cellspacing="0">

																							<c:forEach var="news" items="${newsList.rows}"
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
																																  border="0">
																														</a> <br /> <font color="#141414"> <c:out
																																	value="${news.mainTitle}" /> </font></td>
																													</tr>
																												</table>
																												</td>
																										</tr>
																									</table>
																									</td>

																								<c:if test="${vs.count % 2 ==0}">
																									</tr>
																								</c:if>


																							</c:forEach>

																						</table>
																						</c:if>
																						

									<table width="650" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<%
											int pagesize = 10;
										%>
										<pg:pager items="${newsList.total}" url="${url}"
											index="center" maxPageItems="<%=pagesize%>"
											maxIndexPages="10" isOffset="<%=false%>"
											export="pageOffset,currentPageNumber=pageNumber"
											scope="request">
											<pg:param name="webNewsTypeId" />
											<tr>
												<td colspan="3" height="3"></td>
											</tr>
											<tr>
												<td height="1" colspan="3"
													background="web/images/index_6.jpg"></td>
											</tr>

											<tr>
												<td height="30" colspan="3" align="center"><pg:index>
														<pg:first>
															<a
																href="${pageUrl}&page=<%=pageNumber%>&rows=<%=pagesize%>">&nbsp;首页&nbsp;</a>
														</pg:first>
														<pg:prev>
															<a
																href="${pageUrl}&page=<%=pageNumber%>&rows=<%=pagesize%>">&nbsp;上一页&nbsp;</a>
														</pg:prev>
														<pg:pages>
															<c:choose>
																<c:when test="${pageNumber eq currentPageNumber}">
																	<span><font color='#ff0000'>&nbsp;[<%=pageNumber%>]&nbsp;</font>
																	</span>
																</c:when>
																<c:otherwise>
																	<a
																		href="${pageUrl}&page=<%=pageNumber%>&rows=<%=pagesize%>">&nbsp;<%=pageNumber%>&nbsp;</a>
																</c:otherwise>
															</c:choose>
														</pg:pages>
														<pg:next>
															<a
																href="${pageUrl}&page=<%=pageNumber%>&rows=<%=pagesize%>">&nbsp;下一页&nbsp;</a>
														</pg:next>
														<pg:last>
															<a
																href="${pageUrl}&page=<%=pageNumber%>&rows=<%=pagesize%>">&nbsp;尾页&nbsp;</a>
														</pg:last>
													</pg:index></td>
											</tr>
										</pg:pager>
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