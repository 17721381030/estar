<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="cache-control" content="no-cache" />
		<link  href="<%=path%>/css/bootstrap.css" rel="stylesheet" />
		<link  href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />
		<style type="text/css">
		</style>
	</head>
	<body>
	<div class="container-fluid">
		<s:form action="user_changePasswd">
			<s:token />
			<div class="row-fluid" style="padding-top:5px">
				<div class="span4"></div>
				<div class="span4">
					<table class="table-search table table-bordered" style="width:300px">
						<tbody>
							<tr>
							<td class="t">当前密码</td>
							<td class="v"><s:password name="dto.passwd" value="" /></td>
							</tr>
							<tr>
							<td class="t">新密码</td>
							<td class="v"><s:password name="dto.newPasswd" value="" /></td>
							</tr>
							<tr>
							<td class="t">重复新密码</td>
							<td class="v"><s:password name="dto.newPasswd2" value="" /></td>
							</tr>
							<tr>
								<td class="v" style="text-align:center" colspan="2">
									<button type="button" class="btn btn-primary" style="margin-right:25px">
										保存
									</button>
									<button class="btn btncancle">
										放弃
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="span4"></div>
			</div>
		</s:form>
	</div>
	<div id="msg" style="display:none"><s:actionmessage/></div>	
	<script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
	<script src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
	<script src="<%=path%>/js/app.js"></script>
	<script type="text/javascript">
		var sys_url = "<%=path%>";
		$(function () {
			$(".btn-primary").click(function(){
				if($("input[name='dto.newPasswd']").val()==="" 
				|| $("input[name='dto.newPasswd']").val().length < 6
				|| $("input[name='dto.passwd']").val()==="" 
				||  $("input[name='dto.newPasswd']").val() !== $("input[name='dto.newPasswd2']").val()){
				   notify("密码不能为空，并且两次新密码需相同!,新密码为6位以上。");
				}else{
					$("form:first").submit();
				}
			});
			
			$(".btncancle").click(function(){
				$("form:first").attr("action",sys_url+"/welcome.jsp").submit();
			});
			
		});
	</script>
</body>
</html>
