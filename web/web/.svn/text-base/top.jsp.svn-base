<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=gb2312"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="-10"/>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/main.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<table class="top">
			<tr>
				<td class="td_left sys_name" >
					裁判文书智能分析系统
				</td>
				<td class="td_right">
					<div class="tools" style="width:60px;">
						<div class="quit">
							<div class="icon-quit"><img src="images/icon_quit.png" alert=""/></div><a href="javascript:winClose();" style="color: #FFF;">注销</a>
						</div>
					</div>
<%--					<div class="tools" style="width:10px;">--%>
<%--						<div class="line"><img src="images/line.png" alert=""/></div>--%>
<%--					</div>--%>
					<div class="tools" style="width:60px;">
						<div class="pswd">
							<div class="icon-pswd"><img src="images/icon_password.png" alert=""/></div><a href="javascript:modify();" style="color: #FFF;">密码</a>
						</div>
					</div>
<%--					<div class="tools" style="width:10px;">--%>
<%--						<div class="line"><img src="images/line.png" alert=""/></div>--%>
<%--					</div>--%>
					<div class="tools" style="width:60px;">
						<div class="home">
							<div class="icon-home"><img src="images/icon_home.png" alert=""/></div><a href="javascript:home();" style="color: #FFF;">主页</a>
						</div>
					</div>
<%--					<div class="tools" style="width:10px;">--%>
<%--						<div class="line"><img src="images/line.png" alert=""/></div>--%>
<%--					</div>--%>
					<div class="tools" style="width:250px;">
						<div class="user">
							<div class="icon-user"><img src="images/icon-user.png" alert=""/></div>
							<div class="link">机构：<s:property value="#session.evalUser.orgName"/></div>
							<div class="link">用户：<s:property value="#session.evalUser.userName"/></div>
						</div>
					</div>
					<div class="sys_name">
					</div>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
		var path = "<%=path%>";
		function modify(){
			parent.mainFrame.location = path+'/jsp/common/user_pawd.jsp';
		}

		function home() {
			parent.mainFrame.location = "welcome.jsp";
		}

		function winClose() {
		    try{
		    	top.location.href = path+"/login.jsp";
		    }catch(e){ 
		    }
		}
	</script>
</html>
