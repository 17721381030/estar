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
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/article.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/tree/zTreeStyle.css" rel="stylesheet" />
		<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			
		</style>
	</head>
	<body>
		<s:form id="mainForm">
			<s:hidden name="s.court"/>
			<s:hidden name="s.caseNumberYear"/>
			<s:hidden name="s.trialGroup"/>
			<s:hidden name="s.caseNumber"/>
			<s:hidden name = "pageSize" />
			<s:hidden name = "pageNo" />
		</s:form>
		<s:hidden id="articleId" name="d.id"></s:hidden>
		<div id="article_content">
			<div id="tabs_article">
				<ul>
					<li><a href="#tabs-3">质量报告</a></li>
				</ul>
				<div id="tabs-3">
					<img style="padding-right:4px;" src='<%=path%>/images/bullets-black.png' /><span class="reportTitle">实质内容</span>
					<hr class="reportHr"/>
					<table style="padding:4px;">
						<tbody >
							<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>回应诉求</b></td><td class="reportTdLine"  colspan="2" id="report_appeal"></td></tr>
						</tbody>
					</table>
					<table style="padding:4px;">
						<tbody >
							<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>法律适用</b></td><td class="reportTdLine" colspan="2" id="report_law"></td></tr>
						</tbody>
					</table>
					<table style="padding:4px;">
						<tbody >
							<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>判决内容</b></td><td class="reportTdLine" colspan="2" id="report_judgment"></td></tr>
						</tbody>
					</table>
					<br/>
					<img style="padding-right:4px;" src='<%=path%>/images/bullets-black.png' /><span class="reportTitle">形式内容</span>
					<hr class="reportHr"/>
					<table style="padding:4px;">
						<tbody id="report_base">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div id="article_menu">
			<div id="tabs_splic">
				<ul>
					<li><a href="#tabs-4">质量报告</a></li>
				</ul>
				<div id="tabs-4">
					<table id="report_list">
					</table>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			var sysPath = '<%=path%>';
		</script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery.pin.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.ztree.all-3.5.min.js"></script>
		<script type="text/javascript" src="<%=path%>/swfupload/swfupload.js"></script>
		<script type="text/javascript" src="<%=path%>/js/swfupload.queue.js"></script>
		<script type="text/javascript" src="<%=path%>/js/fileprogress.js"></script>
		<script type="text/javascript" src="<%=path%>/js/handlers.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript" src="<%=path%>/js/article.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$(window).resize(function(){
					docResize();
				});
				docResize();
				
				$strutsTab = $("#tabs_splic").tabs();
				$myTab = $("#tabs_article").tabs();
				$("#tabs_splic").pin({containerSelector:"#article_menu"});
				
				$(".btn_back").click(function(){
					$("#mainForm").attr("action", "batchEvaluate_search.do");
					$("#mainForm").submit();
				});
				
				$.ajax({
			        url: sysPath+"/analysis_analysisArticleFromDb.do",
			        data:{"d.id":$("#articleId").val()},
			        type: "POST", dataType: "json",
			        error:function(a,b,c){
			        	$.message("warn","提交失败！");
			        },
			        success: function(msg) {
			        	initPage(msg);
			        }
				});
			});
		</script>	
	</body>
</html>