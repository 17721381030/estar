<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
	</head>
<body>
		<s:form action="operate_list">
		<s:token />
		<input type="hidden" name="d.operateId" />
		<input type="hidden" name="d.versionNo" />
		<%--查询条件div--%>
			<table class="query">
				<colgroup>
					<col style="width:20%"/><col style="width:30%"/><col style="width:20%"/><col style="width:30%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>
							所属模块
						</th>
						<td >
							<s:select list="s.moduleList" cssClass="select" name="s.moduleId" headerKey="" headerValue="请选择" listKey="moduleId" listValue="name" />
						</td>
						<th>
							操作名称:
						</th>
						<td >
							<s:textfield cssClass="text" name="s.name" />
						</td>
					</tr>
				</tbody>
				<tfoot>
				<tr>
					<td colspan="4">
						<span class="btn add" >新增</span>
						<span class="btn clear" >清空</span>
						<span class="btn btn_search" >查找</span>
					</td>
				</tr>
				</tfoot>
			</table>
			
			<table class="list">
				<thead>
					<tr>
						<th style="width:30px">#</th>
						<th>名称</th>
						<th>描述</th>
						<th>排序</th>
						<th>URL</th>
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
									<a href="#" onclick="openDeail('<s:property value="#dto.versionNo" />','<s:property value="#dto.operateId" />')"><s:property value="#dto.name" /></a>
								</td>
								
								<td>
									<s:property value="#dto.description" />
								</td>
								<td>
									<s:property value="#dto.ord" />
								</td>
								<td>
									<s:property value="#dto.url" />
								</td>
								
							</tr>
						</s:iterator>
					</s:if>
					<s:elseif test="dto.listResult == 1">
						<tr>
							<td colspan="5" style="text-align: left; height: 20px;">
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
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".btn_search").click(function() {
					$(".btn_search").attr('disabled', "true");
					$("form:first").submit();
				});

				$(".clear").click(function() {
					clearSearch();
				});
				
				$(".add").click(function() {
					$("form:first").attr("action", "operate_edit.do");
					$(".btn_add").attr('disabled', "true");
					$("form:first").submit();
				});
			});
			function openDeail(versionNo,id){
				$("input[name='d.operateId']").val(id);
				$("input[name='d.versionNo']").val(versionNo);
				$("form:first").attr("action", "operate_edit.do");
				$("form:first").submit();
			}
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
