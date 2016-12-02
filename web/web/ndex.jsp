<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>:::智能文书评价系统:::</title>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="-10"/>
<style type="text/css">
	html, body{padding: 0px;margin: 0px;border: 0px;outline: 0px;}
	html {_width: 100%; _height: 100%;}
	body {_width: 100%; _height: 100%;}
	.border_top_left {background:#F2F2F2 none repeat scroll 0% 0%;}
</style>
</head>
<%--.border_btm {border-bottom: 1px solid #A7CDF1;}
	.border_top_right {border-top: 1px solid #88accf;border-right: 1px solid #88accf;}
	.border_top_left {border-top: 1px solid #88accf;border-left: 1px solid #88accf;}--%>
<frameset rows="70,*" id="ndex" cols="*" frameborder="0" framespacing="0" >
	<noframes><body>你所使用的网页浏览器不支持frame框架页面，请尝试使用其它浏览器。</body></noframes>
    <frame src="top.jsp" name="topFrame" frameborder="0" class="border_btm"  scrolling="no" noresize="noresize"/>
    <frameset rows="*" cols="210,30,*" id="left-right"  frameborder="0" framespacing="0">
        <frame src="menu.jsp" name="leftFrame" class="border_top_right" frameborder="0" scrolling="no" noresize="noresize"/>
        <frame src="leftandright.htm" name="rightFrame" frameborder="0" scrolling="no" noresize="noresize"/>
        <frame src="welcome.htm" name="mainFrame" class="border_top_left" frameborder="0" scrolling="auto" noresize="noresize"/>
    </frameset>
</frameset>
</html>
