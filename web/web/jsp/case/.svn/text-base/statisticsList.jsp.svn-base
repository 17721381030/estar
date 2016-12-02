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
<s:form action="statistics_search">
		<s:token />
		<input type="hidden" name="d.id" />
		<%--查询条件div--%>
			<table class="query">
				<colgroup>
					<col style="width:20%"/><col style="width:30%"/>
					<col style="width:20%"/><col style="width:30%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>瑕疵分类:</th>
						<td>
							<s:radio name="s.type" list="#{'1':'判决','2':'引用法条'}" listKey="key" listValue="value" ></s:radio>						
						</td>
						<th>诉请分类:</th>
						<td>
							<s:select list="#{'利息':'利息(173)','偿付费用':'偿付费用(146)','违约金':'违约金(103)','货款':'货款(91)','受理费':'受理费(65)','欠款':'欠款(52)','赔偿金':'赔偿金(46)','承担连带责任':'承担连带责任(21)','定金':'定金(16)','解除合同':'解除合同(13)','偿付货币':'偿付货币(10)','产权归属':'产权归属(7)','合同无效':'合同无效(7)','继续履行合同':'继续履行合同(7)','权益':'权益(6)','滞纳金':'滞纳金(6)','清偿':'清偿(4)','预付款':'预付款(3)','保证金':'保证金(2)','返还货物':'返还货物(2)','履行义务':'履行义务(2)','终止合同':'终止合同(2)','合同有效':'合同有效(1)','交付物品':'交付物品(1)','质保金':'质保金(1)'}" headerKey="" headerValue="请选择"  cssClass="select" listKey="key" listValue="value" name="s.appealType" listKey="key" listValue="value" />
						</td>
						<td><span class="btn btn_search">查询</span></td>
					</tr>
				</tbody>
			</table>
			
			<table class="list">
				<thead>
					<tr>
						<th style="width:30px">#</th>
						<th style="width:250px">案号</th>
						<th style="width:100px">瑕疵</th>
						<th style="width:100px">点评状态</th>
						<th>法条</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="d.listResult == 2">
						<s:iterator id="dto" value="d.list" status="s">
							<tr>
								<td>
									<s:property value="(#s.index+1)" />
								</td>
								<td>
									<a href="#" onclick="openDeail('<s:property value="#dto.caseId" />')"><s:property value="#dto.caseNumber" /></a>
								</td>
								<td><s:property value="#dto.standardErrors" /></td>
								<s:if test="%{#dto.appraisalsStatus == 1}">
									<td>已确认不是瑕疵</td>
								</s:if>
								<s:elseif test="%{#dto.appraisalsStatus == 0}">
									<td>已确认瑕疵</td>
								</s:elseif>
								<s:else>
									<td>未点评</td>
								</s:else>
								
								
								<!--<td><s:property value="#dto.appraisalsStatus" /></td>
								--><td><s:property value="#dto.laws" /></td>
							</tr>
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
							<td colspan="5" style="text-align: left; height: 20px;">
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
				
			});
			
			function openDeail(id){
				searchModalDialog("statistics_edit.do?d.id="+id);
			}
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
