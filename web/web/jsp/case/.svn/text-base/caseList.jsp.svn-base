<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<base target="_self" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
	</head>
<body>

<s:form action="case_caseByAppealKeyAndLawArticle">
		<s:token />
		<s:hidden name="d.lawArticle"></s:hidden>
		<s:hidden name="d.appealKey"></s:hidden>
		<s:hidden name="d.causeId"></s:hidden>
		<s:hidden name="d.causeName"></s:hidden>
		<s:hidden name="d.appealKeyId"></s:hidden>
		<s:hidden name="d.lawArticleId"></s:hidden>
		<div style = "padding: 5px 25px 0px;">
		<p style ="border-bottom: 1px solid #E5E5E5;margin-top: 20px;font: 15px Microsoft Yahei;"><a href="#" onclick='javascript:unitCaseView()' style ="text-decoration: none;color: #3F3C3F;border: 0px none;">
		<img src ="<%=path%>/images/caseList_back.png" style ="float: left;width: 22px;height: 22px;margin-right: 5px;"/>返回</a>
		<a href="#" onclick='javascript:unitCaseView()' style="text-decoration: none;color:#51d6f0;border: 0px none;">
		<s:property value="d.causeName" /><span style ="color:#98B426;">-></span><s:property value="d.appealKey" /><span style ="color:#98B426;">-></span>排第<s:property value="d.lawArticleId" />位的<s:property value="d.lawArticle" /></a></p>
		</div>
		<%--查询条件div--%>
			<table class="query">
				<colgroup>
					<col style="width:6%"/>
					<col style="width:20%"/>
					<col style="width:6%"/>
					<col style="width:20%"/>
					<col style="width:48%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>法院名称:</th><td ><s:textfield name="d.court" cssClass="text" /></td>
						<th>案&nbsp;&nbsp;&nbsp;&nbsp;号:</th><td ><s:textfield name="d.caseNumber" cssClass="text" /></td>
						<td>
							<span class="btn edit" style= "background: #B4AFAB none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;" >清空</span>
							<span class="btn btn_search" style= "background: #13A844 none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;">查询</span>
						</td>
					</tr>
				</tbody>

			</table>
			
			<table class="list" style ="width:94%;margin-left:16px;">
				<thead>
					<tr>
						<th style="width:244px">案号</th>
						<th>法院名称</th>
						<th>年度</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="d.listResult == 2">
						<s:iterator id="dto" value="d.list" status="s">
							<s:if test="#dto.errorCount > 0 || #dto.warningCount > 0 ">
							<tr class="error_tr">
							</s:if>
							<s:else>
							<tr>
							</s:else>
								<td>
									<a href="#" onclick="openDeail('<s:property value="#dto.id" />')"><s:property value="#dto.caseNumber" /></a>
								</td>
								<td><s:property value="#dto.court" /></td>
								<td><s:property value="#dto.caseNumberYear" /></td>
						</s:iterator>
					</s:if>
					<s:elseif test="dto.listResult == 1">
						<tr>
							<td colspan="3" style="text-align: left; height: 20px;">
								<s:text name="page_not_fund_date" />
							</td>
						</tr>
					</s:elseif>
					<s:else>
						<tr>
							<td colspan="4" style="text-align: left; height: 20px;">
								<s:text name="page_wait_search" />
							</td>
						</tr>
					</s:else>
				</tbody>
			</table>
        	<s:include value="/jsp/common/page_simple.jsp"></s:include>
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".btn_search").click(function() {
					$(".btn_search").attr('disabled', "true");
					$("form:first").submit();
				});
				
				
				$(".edit").click(function() {
					//clearSearch();
					//clearEdit();
					$("input[name='d.court'],input[name='d.caseNumber']").val("");
				});
				
			});
			function openDeail(id){
				searchModalDialog("batchAnalysis_edit2.do?d.id="+id);
			}
			function unitCaseView(){
				var frameset = parent.document.getElementById("caseMainFrame");
				frameset.cols = "100%,0%";
			}
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
