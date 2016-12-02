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
		
		
		<s:token />
		<table class="edit" style="width:500px">
			<thead>
			<tr >
				<th colspan="2">修改密码</th>
			</tr>
			</thead>
			<tbody>
			
			<tr>					
				<td class="not_null">
					当前密码:
				</td>
				<td>
					<s:password name="d.passwd" value="" cssClass="text"/>
				</td>
			</tr>
			<tr>
				<td class="not_null">
					新密码:
				</td>
				<td>
					<s:password name="d.pwd" value="" cssClass="text" />
				</td>
			</tr>
			<tr>
				<td class="not_null">
					确认新密码:
				</td>
				<td>
					<s:password name="d.newPasswd" value="" cssClass="text" />
				</td>
			</tr>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="2">
					<span class="btn btn_save" >保存</span>
				</td>
				</tr>
			</tfoot>
		</table>
		</s:form>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".btn_save").click(function() {
					if(checkpawd() == true){
						$("#mainForm").attr("action", "user_changePasswd.do");
						$(".btn_save").attr('disabled',"true");
						$("#mainForm").submit();
					}
				});
			});

			function checkpawd(){
				var oldPawd = $("input[name='d.passwd']").val();
				var pwd = $("input[name='d.pwd']").val();
				var newPasswd = $("input[name='d.newPasswd']").val();

				if(oldPawd.trim() === "" || pwd.trim() === ""  || newPasswd.trim() === ""){
					$.message("warn","输入框不能为空");
					return false;
				}

				$("input[name='d.passwd']").val(oldPawd.trim());
				$("input[name='d.pwd']").val(pwd.trim());
				$("input[name='d.newPasswd']").val(newPasswd.trim());
				
				if(pwd.trim() !== newPasswd.trim()){
					$.message("warn","两次新密码不一致!");
					return false;
				}

				return true;
			}
		</script>
</body>
</html>
