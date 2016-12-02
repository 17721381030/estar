<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta http-equiv="cache-control" content="private" />
		<link id="bs-css" href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" />
		<script type="text/javascript">
			setTimeout(function() {
			    window.top.location.href = "<%=path%>/login.jsp";
			}, 3000);
		</script>
  </head>
  <body>
  <div>
  		<div class="span12" style="text-align:center;padding-top:30px">
			<h1>CODE：500</h1>
			<h2>会话超时，需要重新登录</h2>
			<div >
				<h3>会话超时</h3>
				<p>
					您的登录会话已超时，三秒钟后会跳转到登录页面重新登录。<br/>
					 <a id="goto" target='_top' href="<%=path%>/login.jsp">[回到登入页面]</a>
				</p>
			</div>
		</div>
	</div>	
  	
  </body>
</html>
