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
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
	</head>
<body>
<s:form action="batchEvaluate_search">
		<s:token />
		<input type="hidden" name="d.id" />
		<%--查询条件div--%>
			<table class="query">
				<colgroup>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>法院名称:</th><td ><s:textfield name="a.court" cssClass="text" /></td>
						<th>时&nbsp;&nbsp;&nbsp;&nbsp;间:</th><td ><s:textfield name="a.caseNumberYear" cssClass="text" /></td>
						<th>审判人员:</th><td ><s:textfield name="a.trialGroup" cssClass="text" /></td>
						<th>案&nbsp;&nbsp;&nbsp;&nbsp;号:</th><td ><s:textfield name="a.caseNumber" cssClass="text" /></td>
					</tr>
					<tr>
						<th>案由:</th>
						<th>
							<select id="a.causeId" class="select" name="a.causeId">
								<option value="">----请选择案由----</option>
								<option value="ptelend">民间借贷纠纷</option>
								<option value="propservcont">物业服务合同纠纷</option>
								<option value="crcard">信用卡纠纷</option>
								<option value="finloancont">金融借款合同纠纷</option>
								<option value="teleservcont">电信服务合同纠纷</option>
								<option value="mototal">机动车交通事故责任纠纷</option>
								<option value="divoc">离婚纠纷</option>
								<option value="labocont">劳动合同纠纷</option>
								<option value="hosliscont">房屋租赁合同纠纷</option>
								<option value="bizcont">买卖合同纠纷</option>
							</select>
						</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</tbody>
				<tfoot>
					<td colspan="8">
						<span class="btn edit" >清空</span>
						<span class="btn btn_search" >查询</span>
					</td>
				</tfoot>
			</table>
			
			<table class="list">
				<thead>
					<tr>
						<th colspan="5">判决书:<s:text name="recTotal"/>篇&nbsp;&nbsp;/&nbsp;&nbsp;瑕疵判决书:<s:text name="judgmentDocNum"/>篇 &nbsp;&nbsp;/&nbsp;&nbsp; 瑕疵:<s:text name="judgmentDocErrorNum"/>个</th>
					</tr>
					<tr>
						<th style="width:300px">案号</th>
						<th>法院名称</th>
						<th>案由</th>
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
								<td><s:property value="#dto.cause" /></td>
								<td><s:property value="#dto.caseNumberYear" /></td>
						</s:iterator>
					</s:if>
					<s:elseif test="dto.listResult == 1">
						<tr>
							<td colspan="4" style="text-align: left; height: 20px;">
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
        	<s:include value="/jsp/common/page.jsp"></s:include>
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
					clearSearch();
				});
				
				$("#a\\.causeId").val("${a.causeId}");
				
			});
			function openDeail(id){
				searchModalDialog("batchEvaluate_edit.do?d.id="+id);
			}
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
