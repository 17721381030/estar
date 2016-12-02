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
<s:form id="mainForm">
		
		<s:hidden name="d.moduleId"/>
		<s:hidden name="d.versionNo"/>
		
		<s:hidden name="s.name" />
		
		<s:token />
		<table class="edit">
			<colgroup>
				<col style="width:20%"/><col style="width:80%"/>
			</colgroup>
			<thead>
			<tr >
				<th colspan="2">操作维护表</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="not_null">
					名称:
				</td>
				<td>
					<s:textfield cssClass="text"  name="d.name"/>
				</td>
			</tr>			
			<tr>
				<td class="not_null">
					排序:
				</td>
				<td>
					<s:textfield cssClass="text"  name="d.ord" />
				</td>
			</tr>
			<tr>							
				<td class="not_null">
					图标:
				</td>
				<td>
					<s:textfield cssClass="text"  name="d.icon"/>
				</td>
			</tr>
			<tr>							
				<td>
					描述:
				</td>
				<td>
					<s:textfield cssClass="text" name="d.description"/>
				</td>
			</tr>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="2">
					<span type="button" class="btn btn_tolist" >返回</span>				
					<s:if test="d.moduleId!= null&& d.moduleId!=''">
						<span type="button" class="btn btn_add" >新增下一个</span>
						<span type="button" class="btn btn_del" >删除</span>
					</s:if>
					<span type="button" class="btn btn_save" >保存</span>
				</td>
				</tr>
			</tfoot>
		</table>
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".btn_save").click(function() {
					if(check() == true){
						$("#mainForm").attr("action", "module_save.do");
						$(".btn_save").attr('disabled',"true");
						$("#mainForm").submit();
					}
				});
		
				$(".btn_del").click(function() {
					var id = $("input[name ='d.moduleId']").val();
					if (id == "") {
						alert("当前字典未保存！不能删除");
						return false;
					}
					if (confirm("是否确定删除?")) {
						$("#mainForm").attr("action", "module_delete.do");
						$(".btn_del").attr('disabled',"true");
						$("#mainForm").submit();
					}
				});
		
				$(".btn_tolist").click(function() {			
					$("#mainForm").attr("action", "module_list.do");
					$("#mainForm").submit();
				});
		
				$(".btn_add").click(function() {
					clearEdit();
					$("#mainForm").attr("action", "module_edit.do");
					$(".btn_add").attr('disabled',"true");
					$("#mainForm").submit();
				});
			});
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
