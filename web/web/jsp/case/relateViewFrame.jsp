<%@ page contentType="text/html;charset=utf-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="-10"/>
<style type="text/css">
	html, body{padding: 0px;margin: 0px;border: 0px;outline: 0px;}
	html {_width: 100%; _height: 100%;}
	body {_width: 100%; _height: 100%;}
</style>
</head>
<frameset cols="100%,0%"  rows="*" frameborder="0" framespacing="0" id ="caseMainFrame" >
	<noframes><body>你所使用的网页浏览器不支持frame框架页面，请尝试使用其它浏览器。</body></noframes>
    <frame src="<%=path%>/jsp/case/caseView.jsp" name="caseLeftFrame" frameborder="0" scrolling="auto" noresize="noresize"/>
    <frame src="<%=path%>/case_caseByAppealKeyAndLawArticle.do" name="caseRightFrame" frameborder="0" scrolling="auto" noresize="noresize"/>
</frameset>
</html>
