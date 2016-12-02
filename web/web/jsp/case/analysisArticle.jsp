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
		<link type="text/css" href="<%=path%>/css/analysisArticle.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/tree/zTreeStyle.css" rel="stylesheet" />
		<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		</style>
	</head>
	<body>
		<div class="asd" style="float:left; height:auto;">
		  <div class="conleft" style="float:left; height:auto;">
			<div id="article_content">
				<div id="tabs_article">
					<ul>
						<li id ="text_1"><a href="#tabs-1">原始文书</a></li>
						<li id ="analysis_2"><a href="#tabs-2">文书解析</a></li>
						<li id ="report_3"><a href="#tabs-3">质量报告</a></li>
					</ul>
					<div id="tabs-1">
						<table class="table_text" style="width:100%;padding-right:2px;">
							<tr><td style="border:0;"><textarea style="min-height:350px;" class="textarea yswf" id="textarea" name ="textarea" rows="10" cols="50"></textarea></td></tr>
							<tr>
								<td style="text-align:center;border:0;">
									<span id="submit" class="btn btn_clear" style="margin:5px">清空文本</span>
									<span id="submit" class="btn btn_txt_save" style="margin:5px">文本解析</span>
									<span id="submit" class="btn" onclick = "openUploadDialog();" style="margin:5px">上传文书</span>
								</td>
							</tr>
						</table>
					</div>
					<div id ="tabs23">
						<div id="tabs-2">
							<div id="article_split_detail" style="padding:4px;">&nbsp;
							<div id="article_split_title"></div>
							<div id="article_split_content" style ="overflow-y:auto;overflow-x:hidden;margin-right: -20px;"></div>
							</div>
						</div>
						<div id="tabs-3" style ="height:515px;overflow-y: auto;overflow-x: hidden;">
							<img style="padding-right:4px;" src='<%=path%>/images/bullets-black.png' /><span class="reportTitle">实质内容</span>
							<hr class="reportHr"/>
							<table style="padding:4px;">
								<tbody >
									<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>回应诉求</b></td><td colspan="2" class="reportTdLine" id="report_appeal"></td></tr>
								</tbody>
							</table>
							<table style="padding:4px;">
								<tbody >
									<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>法律适用</b></td><td colspan="2" class="reportTdLine" id="report_law"></td></tr>
								</tbody>
							</table>
							<table style="padding:4px;">
								<tbody >
									<tr><td class="reportTdLine" style="width:30%;vertical-align: top;"><b>判决内容</b></td><td colspan="2" class="reportTdLine" id="report_judgment"></td></tr>
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
			</div>
			<div id="article_menuas">
				<div id="tabs_splic">
					<ul>
						<li><a href="#tabs-3">文书解析</a></li>
						<li><a href="#tabs-4">质量报告</a></li>
					</ul>
					<div id="tabs-3">
						<ul id="articleStruts" class="ztree"></ul>
					</div>
					<div id="tabs-4" style ="height: 498px;overflow-x: hidden;overflow-y: auto;">
						<table id="report_list">
						</table>
					</div>
				</div>
			</div>
			<div id= "editor_content" style= "float:right;display:none;margin-top:15px;padding-left: 32px;padding-bottom: 20px;">
				<textarea id="articleText" name="articleText" style="border:1px solid blue;" class="textarea yswf"></textarea>
			</div>
			 </div>
			<div id ="bottom_button_content">
				<input id="textEditorButton" type="button" value="文本编辑"/> <input id="exportButton" type="button" value="导出文本"/> <input id="analysisButton" type="button" value="继续分析"/>
			</div>
		</div>
		<s:form id="mainForm" method = "post" >
			<input type="hidden" name = "d.articleContent" />
		</s:form>	
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
		<script type="text/javascript" src="<%=path%>/js/analysisArticle.js"></script>
		<script type="text/javascript" src="<%=path%>/js/plugins/kindeditor.js"></script>
		<script type="text/javascript" src="<%=path%>/js/plugins/lang/zh_CN.js"></script>
		<script type="text/javascript">
			$(function() {
				var editor = null ;
				$(window).resize(function(){
					docAnalysisArticleResize();
				});
				docAnalysisArticleResize();
				createText();
				$("#analysis_2").css({display:'none'});
				$("#report_3").css({display:'none'});
				$("#tabs23").css({display:'none'});
				$("#article_menuas").css({display:'none'});
				$strutsTab = $("#tabs_splic").tabs();
				$myTab = $("#tabs_article").tabs();
				/*$("#article_menu").pin({containerSelector:"#article_menu_content"});*/
				$("#textEditorButton").hide();
				$("#analysisButton").hide();
				$("#exportButton").hide();
				
				$(".btn_clear").click(function(){
					$("#textarea").val("");
				});
				function createText(){
					editor = KindEditor.create('textarea[name="articleText"]', { 
							resizeType : 1,
							allowPreviewEmoticons : false,
							allowImageUpload : false,
							items : [
								'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
								'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
								'insertunorderedlist']
					});
				}

				$(".btn_txt_save").click(function(){
					if($("#textarea").val() === ""){
						$.message("warn","没有文书信息!");
						return;
					}
					$.ajax({
				        url: sysPath+"/analysis_analysisTxtArticle.do",
				        data:{"d.articleContent":$("#textarea").val()},
				        type: "POST", dataType: "json",
				        error:function(a,b,c){
				        	$.message("warn","提交失败！");
				        },
				        success: function(msg) {
				        	initAnalysisArticlePage(msg);
							var editorTextarea = $("#textarea").val();
							initEditorArtitle(msg,editor);
				        	$("#text_1").css({display:'none'});
				        	$("#tabs-1").css({display:'none'});
				        	$("#analysis_2").show();
							$("#report_3").show();
							$("#tabs23").show();
							$("#article_menuas").show();
							$("#tabs_splic").width(200);
							$("#textEditorButton").show();
							$strutsTab = $("#tabs_splic").tabs();
		                	$strutsTab.tabs("option","active",1);
				        }
					});
				});
				$("#textEditorButton").click(function(){
						$("#article_content").hide(1000);
		                $("#article_menuas").css("float","left");
		                setTimeout(function(){
		                $("#editor_content").fadeIn(1000);
		                },1100);
		                docAnalysisArticleResize();
		                $("#textEditorButton").hide();
		                $("#analysisButton").show();
		                $("#exportButton").show();
		                $strutsTab = $("#tabs_splic").tabs();
		                $strutsTab.tabs("option","active",1);
				});
				
				$("#exportButton").click(function(){
					$("input[name='d.articleContent']").val(editor.html());
					$("#mainForm").attr("action", "analysis_export.do");
					$("#mainForm").submit();
				});
				
				$("#analysisButton").click(function(){
					if($("#articleText").val() === ""){
							$.message("warn","没有文书信息!");
							return;
						}
						$.ajax({
					        url: sysPath+"/analysis_analysisHTxtArticle.do",
					        data:{"d.articleContent":editor.html()},
					        type: "POST", dataType: "json",
					        error:function(a,b,c){
					        	$.message("warn","提交失败！");
					        },
					        success: function(msg) {
					        	initAnalysisArticlePage(msg);
								var editorTextarea = $("#textarea").val();
								initEditorArtitle(msg,editor);
					        	$("#text_1").css({display:'none'});
					        	$("#tabs-1").css({display:'none'});
					        	$("#analysis_2").show();
								$("#report_3").show();
								$("#tabs23").show();
								$("#article_menuas").show();
								$("#tabs_splic").width(200);
								$("#textEditorButton").show();
								$("#analysisButton").hide();
								$("#exportButton").hide();
								
								$("#editor_content").hide(1000);
				                $("#article_menuas").css("float","right");
				                setTimeout(function(){
				                $("#article_content").fadeIn(1000);
				                },1100);
				                docAnalysisArticleResize();
				                $strutsTab = $("#tabs_splic").tabs();
		                		$strutsTab.tabs("option","active",1);
					        }
					});
				});
			});
		</script>
	</body>
</html>