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
		<link type="text/css" href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
	</head>
<body>

<s:form id="mainForm">
		
		<s:hidden name="d.userId" />
		<s:hidden name="d.versionNo" />
		
		<s:hidden name="s.orgId" />
		<s:hidden name="s.userCode" />
		<s:hidden name="s.userName" />
		
		<s:token />
		<table class="edit">
			<colgroup>
				<col style="width:20%"/>
				<col style="width:80%"/>
			</colgroup>
			<thead>
			<tr >
				<th colspan="2">人员信息表</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<th class="not_null">
					所属机构:
				</th>
				<td>
					<s:select list="d.orgList" cssClass="select" name="d.orgId" headerKey="" headerValue="请选择" listKey="id" listValue="name" />				
				</td>
			</tr>
			<tr>					
				<th class="not_null">
					工号:
				</th>
				<td>
					<s:textfield cssClass="text" name="d.userCode" />
				</td>
			</tr>
			<tr>
				<th class="not_null">
					姓名:
				</th>
				<td>
					<s:textfield cssClass="text" name="d.userName" />
				</td>
			</tr>
			<tr>
				<th>
					密码:
				</th>
				<td>
					<s:password cssClass="text" name="d.newPasswd" />
				</td>
			</tr>
			<tr>
				<th class="not_null">
					用户分类:
				</th>
				<td>
					<s:select  list="#{1:'保险公司用户',2:'修理厂用户',3:'客服用户',4:'系统用户'}" cssClass="select" listKey="key" listValue="value"  name="d.userType"  listKey="key" listValue="value" />
				</td>
			</tr>
			<tr>
				<th class="not_null">
					电话:
				</th>
				<td>
					<s:textfield cssClass="text" name="d.phone" />
				</td>
			</tr>
			<tr>
				<th class="not_null">
					账号是否有效:
				</th>
				<td>
					<s:select  list="#{1:'是',0:'否'}" cssClass="select"  name="d.isValid"  listKey="key" listValue="value" />
				</td>
			</tr>
			<tr>
				<th>
					描述:
				</th>
				<td colspan="5">
					<s:textarea cssClass="textarea" name="d.description" />
				</td>
			</tr>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="2">
					<span class="btn btn_tolist">返回</span>					
					<s:if test="d.userId!= null&& d.userId!=''">
						<span class="btn btn_add" >新增下一个</span>	
						<span class="btn btn_del" >删除</span>
					</s:if>
					<span class="btn btn_save" >保存</span>
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
						$("#mainForm").attr("action", "user_save.do");
						$(".btn_save").attr('disabled',"true");
						$("#mainForm").submit();
					}
				});
		
				$(".btn_del").click(function() {
					var id = $("input[name ='d.userId']").val();
					if (id == "") {
						$.message("warn","当前字典未保存！不能删除");
						return false;
					}
					
					$.dialog({
						title: "删除",
						content: '是否确定删除?',			
						width: 470,
						modal: true,
						ok: "确&nbsp;&nbsp;定",
						cancel: "取&nbsp;&nbsp;消",
						onOk: function() {
							$("#mainForm").attr("action", "user_delete.do");
							$(".btn_del").attr('disabled',"true");
							$("#mainForm").submit();
						}
					});
				});
		
				$(".btn_tolist").click(function() {			
					$("#mainForm").attr("action", "user_list.do");
					$("#mainForm").submit();
				});
		
				$(".btn_add").click(function() {
					clearEdit();
					$("#mainForm").attr("action", "user_edit.do");
					$(".btn_add").attr('disabled',"true");
					$("#mainForm").submit();
				});
			});
		</script>
        <div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>

</body>
</html>
