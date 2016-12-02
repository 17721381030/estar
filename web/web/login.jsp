<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String path = request.getContextPath(); %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>智能文书评价系统</title> 
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta name="author" content="" />
		<meta name="copyright" content="" />
		<link href="css/login.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="top"><span><img src="images/bg_login_01.png" /></span></div>
		<div class="login">
			<form action="<%=path%>/login" method="post">
				<table class="mainTable">
					<tr>
						<td class="content_rigth">
							<table class="fields">
								<tr>
									<td><div class="user"><img src="images/login_user.png" style ="float:left;"/><input type="text" name="username" style="margin-left:42px;color: #616161;font-size: 14px;" value="请输入用户名" onfocus="if(this.value ==defaultValue){this.value='';}" onblur="if(!value){value=defaultValue;}"/></div></td>
								</tr>
								<tr>
									<td><div class="user"><img src="images/login_password.png" style ="float:left;"/><input type="text" value="请输入密码" name="pwdPromt" id ="pwdPromt" style="margin-left:42px;color: #616161;font-size: 14px;"/><input type="password" value="" name="password" id ="password" style="margin-left:42px;color: #616161;font-size: 14px;"/></div></td>
								</tr>
								<tr>
									<td>
										<div class="user"><input type="text" value="请输入验证码" name="captcha" maxlength="4" style="color: #616161;font-size: 14px;" onfocus="if(this.value ==defaultValue){this.value='';}" onblur="if(!value){value=defaultValue;}"/>
											<image src="<%=path%>/securityCode.do?random=<%=Math.random()%>" class="captchaImage" id="Verify"  alt="换一张" />
										</div>
									</td>
								</tr>
								<tr><td><input type="submit" class="login_button" value="登&nbsp;&nbsp;&nbsp;&nbsp;录" /></td></tr>
							</table>
						</td>
					</tr>
				</table>
				<div class="powered">COPYRIGHT © 2005-2018 版权保留.</div>
			</form>
			<s:if test="#request.msg != null">
				<span id="msg" class="hidden"><s:property value = "#request.msg"/></span>
			</s:if>
		</div>
	</body>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery.tools.js"></script>
	<script type="text/javascript" src="<%=path%>/js/app.js"></script>
	<script type="text/javascript">
		var sysPath = "<%=path%>";
		$(function() {
			$("#Verify").click(function(){
		       $(this).attr("src",sysPath+"/securityCode.do?timestamp="+new Date().getTime());
			});
			if("" !== $("#msg").text()){
				$.message("warn", $("#msg").text());
			}
			var pwdTextObj = $("#pwdPromt");
			var pwdObj = $("#password");
			if(pwdObj.val() != null && pwdObj.val() != ''){
				pwdObj.val() == '';
				pwdTextObj.show();
				pwdObj.hide();
			}
			pwdTextObj.focus(function(){
					pwdTextObj.hide();
					pwdObj.show().focus();
				});
			pwdObj.blur(function(){
					if($(this).val() == ""){
						pwdTextObj.show();
						pwdObj.hide();
					}
			});
		});
	</script>
</html>