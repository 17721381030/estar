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
			<div class="row-fluid" style="padding-top:5px">
				<div class="span4"></div>
				<div class="span4">
					<table class="table-search table table-bordered" style="width:300px">
						<tbody>
							<tr>
							<td class="t">用户账号:</td>
							<td class="v"><s:property value="dto.userCode"/></td>
							</tr>
							<tr>
							<td class="t">姓名:</td>
							<td class="v"><s:property value="dto.userName"/></td>
							</tr>
							<tr>
							<td class="t">电话:</td>
							<td class="v"><s:property value="dto.phone" /></td>
							</tr>
							<tr>
							<td class="t">所属机构:</td>
							<td class="v"><s:property value="dto.orgName" /></td>
							</tr>
							<tr>
								<td class="t" colspan="2"><button class="btn btncancle">关闭</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="span4"></div>
			</div>
		</div>
		<form action=""></form>
		<script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
		<script src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
		<script src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			var sys_path = '<%=path%>';
			$(function () {
				$(".btncancle").click(function(){
					$("form:first").attr("action",sys_path+"/welcome.jsp").submit();
				});
			});
		</script>
	</body>
</html>
