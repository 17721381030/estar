<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<base target="_self" />
		<link type="text/css" href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
		<style type="text/css">
			
		</style>
	</head>
	<body>
		<s:form id="mainForm" >
		<div id="tabs" style="width:98%;height:100%;margin-left:auto;margin-right:auto;text-align:center;margin-top:10px">
			<ul>
				<li><a href="#tabs-1">文本提交</a></li>
				<li><a href="#tabs-2">附件提交</a></li>
			</ul>
			<div id="tabs-1">
				<table class="table_text" >
					<tr><td style="border:0"><textarea class="textarea" id="textarea" rows="" cols=""></textarea></td></tr>
					<tr>
						<td style="text-align:center;border:0;">
							<span id="submit" class="btn btn_clear" style="margin:10px">清空</span><span id="submit" class="btn btn_txt_save" style="margin:10px">提交</span>
						</td>
					</tr>
				</table>
			</div>
			<div id="tabs-2">
				<table style="border:0;height:200px;">
					<tr><td style="vertical-align: middle;"><input type="file" /></td></tr>
					<tr>
						<td style="text-align:center;border:0;">
							<span id="submit" class="btn btn_clear" style="margin:10px">清空</span><span id="submit" class="btn btn_doc_save" style="margin:10px">提交</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
		<script type="text/javascript">
			var sysPath = '<%=path%>';
			$(function() {
				$(document).resize(function(){
					docResize();
				});
				docResize();
				
				$(".btn_txt_save").click(function(){
					btnSubmit("analysis_analysisTxtArticle.do");
				});
				$(".btn_doc_save").click(function(){
					btnSubmit("analysis_analysisDocArticle.do");
				});
			});
			
			function btnSubmit(url){
				$("#mainForm").attr("action", url);
				$(".btn_txt_save,btn_doc_save").attr('disabled',"true");
				$("#mainForm").submit();
			}
			
			function docResize(){
				var h = $(document).height(); 
				var w = $(document).width(); 
				$("#tabs").height(h - 30);
				$("#tabs").tabs();
				$(".table_text").height($("#tabs").height()-80);
				$(".textarea").height($(".table_text").height()-30);
			}
		</script>
	</body>
</html>