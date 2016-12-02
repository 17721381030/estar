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
		<link type="text/css" href="<%=path%>/css/configure_content.css" rel="stylesheet" />
	</head>
	<body style="background: #F2F2F2 none repeat scroll 0% 0%;">
	<div id="configure_content" class = "configure_content">
	</div>
	<div id="configure_detail_content" class = "configure_detail_content">
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery.pin.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/configureContent.js"></script>
	<script type="text/javascript" src="<%=path%>/js/app.js"></script>
	<script type="text/javascript">
		var path = '<%=path%>';
		$(function() {
			$.ajax({
					async:false,
					cache:false,
					url: path+"/modifyCheckerProcessors_userMenu.do",
			        type: "POST", dataType: "json",error:function(a,b,c){
					},
			        success: function(obj) {
						if(obj){
							initPage(obj);
			        	}
			        }
			    });
		});
		
		
	</script>
</body>
</html>
