var swfu;
var settings = {
	flash_url : sysPath+"/swfupload/swfupload.swf",
	upload_url: sysPath+"/analysis_analysisDocArticle.do",	
	post_params: {"PHPSESSID" : "11"},
	file_size_limit : "10MB",
	file_types : "*.*",
	file_types_description : "All Files",
	file_upload_limit : 1,  //配置上传个数
	file_queue_limit : 1,
	custom_settings : {
		progressTarget : "fsUploadProgress",
		cancelButtonId : "btnCancel"
	},
	debug: false,

	button_image_url: sysPath+"/images/TestImageNoText_65x291.png",
	button_width: "69",
	button_height: "29",
	button_placeholder_id: "spanButtonPlaceHolder",
	button_text: '<span id="btn" class="theFont" style="margin-top: 3px;text-align: center;">上传文书</span>',
	button_text_style: ".theFont { font-size:14px;font-family: 微软雅黑;}",
	button_text_left_padding: 3,
	button_text_top_padding: 2,
	button_cursor : SWFUpload.CURSOR.HAND,
	
	file_queued_handler : fileQueued,
	file_queue_error_handler : fileQueueError,
	file_dialog_complete_handler : fileDialogComplete,
	upload_start_handler : uploadStart,
	upload_progress_handler : uploadProgress,
	upload_error_handler : uploadError,
	upload_success_handler : uploadSuccess,
	upload_complete_handler : uploadComplete,
	queue_complete_handler : queueComplete	
};
var $myTab;
var $strutsTab;

function docAnalysisArticleResize(){
	var w = $(window).width(); 
	var h = $(window).height(); 
	$("#article_content").width(w-260);
	$("#article_menu").width(200);
	//$("#article_menu").height(Math.round(h*0.72));
	var article_split_title = $("#article_split_title");
	var article_split_content = $("#article_split_content");
	var articleText = $("#articleText");
	var editorDiv = $(".ke-container");
	if(article_split_title.length > 0){
		$("#article_split_title").width(Math.round(w-267));
	}
	if(article_split_content.length > 0){
		$("#article_split_content").width(Math.round(w-267));
		$("#article_split_content").height(Math.round(h*0.58));
	}
	if(articleText.length > 0){
		$("#articleText").height(Math.round(h*0.75));
		$("#articleText").width(w-267);
	}
	if(editorDiv.length > 0){
		$(".ke-container").width(w-267);
	}
}


var setting = {
	view: {
		showIcon: false
	},data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick
	},
	view: {
		fontCss: getFontCss,
		showLine:true,
		showIcon:false,
	}
};

function getFontCss(treeId, treeNode) {
	return (!!treeNode.highlight) ? {color:"#000000", "font-weight":"bold","background":"#A7CDF1"} : {color:"#000000", "font-weight":"normal","background":"#ffffff"};
}

var nodeList = [];
function searchNode(obj) {
	var value = $(obj).attr("id");
	var zTree = $.fn.zTree.getZTreeObj("articleStruts");
	updateNodes(false);
	var node = zTree.getNodeByParam("tag", value);
	if (node === null) {
		nodeList = [];
	} else {
		nodeList = [node];
	}
	updateNodes(true);
}

function updateNodes(highlight) {
	var zTree = $.fn.zTree.getZTreeObj("articleStruts");
	for( var i=0, l = nodeList.length;  i< l; i++) {
		nodeList[i].highlight = highlight;
		zTree.updateNode(nodeList[i]);
	}
}


function onClick(event, treeId, treeNode, clickFlag) {
	updateNodes(false);
	$myTab.tabs("option","active",1);
	$(".txtAlert").removeClass("txtAlert");
	$("#"+treeNode.tag).addClass("txtAlert");
	var p = $("#"+treeNode.tag);
	var offset = p.offset();
	//$("html").animate({ scrollTop: offset.top-50 }, 300);
	$("#article_split_content").animate({ scrollTop: offset.top-50}, 300);
}	
	
	
function setColor(tag) {
	$myTab.tabs("option","active",2);
	var p = $("#"+tag);
	var offset = p.offset();
	//$("html").animate({ scrollTop: offset.top-50 }, 300);
	$("#tabs-3").animate({ scrollTop: offset.top-50 }, 300);
	$(".txtAlert").removeClass("txtAlert");
	$("#"+tag).addClass("txtAlert");
	setTimeout(function() {
		$(".txtAlert").removeClass("txtAlert");
	}, 1000);
}	

function openUploadDialog(){
	$.dialog({
		title: "提交文本或上传附件", 
		content: '<div class="fieldset flash" id="fsUploadProgress"><span class="legend">上传进度</span></div><div id="divStatus">0 个文件已上传</div><div><span id="spanButtonPlaceHolder"></span><input id="btnCancel" type="button" value="取消上传" onclick="swfu.cancelQueue();" disabled="disabled" style="background:#B7B0B0;border-radius: 5px;font-size:14px;color:#fff;font-family:微软雅黑;width: 69px;height: 29px;text-align: center;border:none;margin-left: 12px;margin-top: 2px;" /></div>',			
		width: 430,
		modal: true,
		ok: null,
		cancel: "关&nbsp;&nbsp;闭"
	});
	
	swfu = new SWFUpload(settings);
}

function setArticleContent(obj){
	if(obj.d.articleContent){
		$(".textarea").val(obj.d.articleContent);
	}
}
var BLOCK_NAME = {"COURT":"COURT",
				"TYPE":"TYPE",
				"CASE_NUMBER":"CASE_NUMBER",
				"PLAINTIFF":"PLAINTIFF",
				"DEFENDANT":"DEFENDANT",
				"THIRD_PARTY":"THIRD_PARTY",
				//"CAUSE":"CAUSE",
				"CAUSE_CONTENT":"CAUSE_CONTENT",
				"PLAINTIFF_CLAIMS":"PLAINTIFF_CLAIMS",
				"APPEAL":"APPEAL",
				"PLAINTIFF_QUOTE":"PLAINTIFF_QUOTE",
				"ANSWER":"ANSWER",
				"REASON":"REASON",
				"LAW_ARTICLE":"LAW_ARTICLE",
				"JUDGMENT_DESCRIPTION":"JUDGMENT_DESCRIPTION",
				"JUDGMENT_CONTENT":"JUDGMENT_CONTENT",
				"RIGHTS_OBLIGATIONS":"RIGHTS_OBLIGATIONS",
				"TRIAL_GROUP_DATE":"TRIAL_GROUP_DATE",
				"APPENDIX_LAW_ARTICLE":"APPENDIX_LAW_ARTICLE",
				"APPEAL_CHECK":"APPEAL_CHECK",
				"LAW_ARTICLE_CHECK":"LAW_ARTICLE_CHECK",
				"JUDGMENT_CHECK":"JUDGMENT_CHECK"
				};
var $article;
var txtSplit = "____";
function initAnalysisArticlePage(obj){
	$article = $("#article_split_detail");
	$articleTitle = $("#article_split_title");
	$articleContent = $("#article_split_content");
	if($article.html()){
		if(obj.d.articleContent){
			$(".textarea").val(obj.d.articleContent);
		}
		$articleTitle.empty();
		$articleContent.empty();
		var courtTitle ="";		
		if(null != obj.d.court && obj.d.court !== txtSplit){	
			var courtTitle = courtTitle+obj.d.court.split(txtSplit)[0]+'<span id='+BLOCK_NAME.COURT+' style =" text-align:center; display:block;font-family:微软雅黑;height:10px;_height:10px;font-size:19px;font-weight:bold; ">'+obj.d.court.split(txtSplit)[1]+'</span>';
		}	
		if(null != obj.d.type && obj.d.type !== txtSplit){	
			var courtTitle = courtTitle + obj.d.type.split(txtSplit)[0]+'<span id='+BLOCK_NAME.TYPE+' style ="text-align:center;display:block;font-family:微软雅黑; font-size:19px;font-weight:bold; ">'+obj.d.type.split(txtSplit)[1]+'</span>';
		}	
		if(null != obj.d.case_number && obj.d.case_number !== txtSplit){	
			var courtTitle = courtTitle +obj.d.case_number.split(txtSplit)[0]+'<span id='+BLOCK_NAME.CASE_NUMBER+' style ="display:block; height:30px;color:#737373; font-size:14px;text-align:right; border-bottom:1px solid #dedede;">'+obj.d.case_number.split(txtSplit)[1]+'</span>';
		}	
		$articleTitle.append("<div id='courtTitle' style =''>"+courtTitle+"</div>");	
		var courtContent = "";	
		if(null != obj.d.plaintiff && obj.d.plaintiff !== txtSplit){	
			var courtContent = courtContent+obj.d.plaintiff.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF+"\" >"+obj.d.plaintiff.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.defendant && obj.d.defendant !== txtSplit){	
			var courtContent = courtContent+ obj.d.defendant.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.DEFENDANT+"\">"+obj.d.defendant.split(txtSplit)[1]+"</span>";
		}	
		if(null != obj.d.third_party && obj.d.third_party !== txtSplit){	
			var courtContent = courtContent+ obj.d.third_party.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.THIRD_PARTY+"\">"+obj.d.third_party.split(txtSplit)[1]+"</span>";
		}
		if(null != obj.d.cause_content && obj.d.cause_content !== txtSplit){	
			var courtContent = courtContent+ obj.d.cause_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.CAUSE_CONTENT+"\">"+obj.d.cause_content.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.plaintiff_claims && obj.d.plaintiff_claims !== txtSplit){	
			var courtContent = courtContent+ obj.d.plaintiff_claims.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_CLAIMS+"\">"+obj.d.plaintiff_claims.split(txtSplit)[1]+"</span>";
		}	
		if(null != obj.d.appeal && obj.d.appeal !== txtSplit){	
			var courtContent = courtContent+  "<span id=\""+BLOCK_NAME.APPEAL_CHECK+"\"></span>"+obj.d.appeal.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPEAL+"\">"+obj.d.appeal.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.plaintiff_quote && obj.d.plaintiff_quote !== txtSplit){	
			var courtContent = courtContent+ obj.d.plaintiff_quote.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_QUOTE+"\">"+obj.d.plaintiff_quote.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.answer && obj.d.answer !== txtSplit){	
			var courtContent = courtContent+ obj.d.answer.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.ANSWER+"\">"+obj.d.answer.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.reason && obj.d.reason !== txtSplit){	
			var courtContent = courtContent+ obj.d.reason.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.REASON+"\">"+obj.d.reason.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.law_article && obj.d.law_article !== txtSplit){	
			var courtContent = courtContent+  "<span id=\""+BLOCK_NAME.LAW_ARTICLE_CHECK+"\"></span>"+obj.d.law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.LAW_ARTICLE+"\">"+obj.d.law_article.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.judgment_description && obj.d.judgment_description !== txtSplit){	
			var courtContent = courtContent+  obj.d.judgment_description.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_DESCRIPTION+"\">"+obj.d.judgment_description.split(txtSplit)[1]+"</span>";
		}	
			
		if(null != obj.d.judgment_content && obj.d.judgment_content !== txtSplit){	
			var courtContent = courtContent+ "<span id=\""+BLOCK_NAME.JUDGMENT_CHECK+"\"></span>"+obj.d.judgment_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_CONTENT+"\">"+obj.d.judgment_content.split(txtSplit)[1]+"</span>";
		}	
		if(null != obj.d.rights_obligations && obj.d.rights_obligations !== txtSplit){	
			var courtContent = courtContent+  obj.d.rights_obligations.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.RIGHTS_OBLIGATIONS+"\">"+obj.d.rights_obligations.split(txtSplit)[1]+"</span>";
		}	
		if(null != obj.d.trial_group && obj.d.trial_group !== txtSplit){	
			var courtContent = courtContent+ obj.d.trial_group.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.TRIAL_GROUP_DATE+"\">"+obj.d.trial_group.split(txtSplit)[1]+"</span>";
		}	
		if(null != obj.d.appendix_law_article && obj.d.appendix_law_article !== txtSplit){	
			var courtContent =  courtContent+ obj.d.appendix_law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPENDIX_LAW_ARTICLE+"\">"+obj.d.appendix_law_article.split(txtSplit)[1]+"</span>";
		}	
		$articleContent.append("<div id='courtContent'><div id= 'spanContent' style = 'font-size:14px;line-height:2;font-family:微软雅黑;'>"+courtContent+"</div></div>");	

		
		$.fn.zTree.init($("#articleStruts"), setting, obj.d.articleTreeDTOList);
		$myTab.tabs("option","active",1);
		$("#article_split_detail span").mousemove(
			function () {
				$("span").removeClass("txtAlert");
				$(this).addClass("txtAlert");
				//$strutsTab.tabs("option","active",0);
				searchNode(this);
			}
		);
		$("#article_menu").height($(document).height()+50);
	
		$("#article_split_detail span").mouseout(
			function () {
				$("span").removeClass("txtAlert");
				updateNodes(false);
			}
		);
		
		if(obj.d.appealList){
			for(var i = 0; i < obj.d.appealList.length; i++){
				var r = obj.d.appealList[i];
				var appealHtml = $("#"+BLOCK_NAME.APPEAL).html();
				var strIndex = appealHtml.lastIndexOf(r.content);
				var replaceTxt = "<a href='javascript:void(0)' title='对应判决:"+r.dyContent+"'><u><span id='"+BLOCK_NAME.APPEAL+"_"+i+"'>"+r.content+"</span></u></a>";
				var firstSeg = appealHtml.substr(0,strIndex);
				var lastSeg = appealHtml.substr(strIndex + r.content.length);
				$("#"+BLOCK_NAME.APPEAL).html(firstSeg+replaceTxt+lastSeg);
			}
		}
		
		if(obj.d.judgmentList){
			for(var i = 0; i < obj.d.judgmentList.length; i++){
				var r = obj.d.judgmentList[i];
				var judgmentHtml = $("#"+BLOCK_NAME.JUDGMENT_CONTENT).html();
				var strIndex = judgmentHtml.lastIndexOf(r.content);
				var replaceTxt = "<a href='javascript:void(0)' title='对应诉求:"+r.dyContent+"'><u><span id='"+BLOCK_NAME.JUDGMENT_CONTENT+"_"+i+"'>"+r.content+"</span></u></a>";
				var firstSeg = judgmentHtml.substr(0,strIndex);
				var lastSeg = judgmentHtml.substr(strIndex + r.content.length);
				$("#"+BLOCK_NAME.JUDGMENT_CONTENT).html(firstSeg+replaceTxt+lastSeg);
			}
		}
		
		if(obj.d.lawArticleList){
			for(var i = 0; i < obj.d.lawArticleList.length; i++){
				var r = obj.d.lawArticleList[i];
				$("#"+BLOCK_NAME.LAW_ARTICLE).html($("#"+BLOCK_NAME.LAW_ARTICLE).html().replace(r,"<span id='"+BLOCK_NAME.LAW_ARTICLE+"_"+i+"'>"+r+"</span>"));
			}
		}
	}
	
	createAnalisysReportHtml(obj.d.analysisArticleReportDTO);
	if($article.html()){
		$article.tooltip();
	}
}
var saveEditor = null;
function initEditorArtitle(obj,editor){
	var courtTitle ="";	
	if(null != obj.d.court && obj.d.court !== txtSplit){	
		var courtTitle = courtTitle+obj.d.court.split(txtSplit)[0]+'<span id='+BLOCK_NAME.COURT+' style =" text-align:center; display:block;font-family:微软雅黑;height:10px;_height:10px;font-size:19px;font-weight:bold; ">'+obj.d.court.split(txtSplit)[1]+'</span>';
	}	
	if(null != obj.d.type && obj.d.type !== txtSplit){	
		var courtTitle = courtTitle + obj.d.type.split(txtSplit)[0]+'<span id='+BLOCK_NAME.TYPE+' style ="text-align:center;display:block;font-family:微软雅黑; font-size:19px;font-weight:bold; ">'+obj.d.type.split(txtSplit)[1]+'</span>';
	}	
	if(null != obj.d.case_number && obj.d.case_number !== txtSplit){	
		var courtTitle = courtTitle +obj.d.case_number.split(txtSplit)[0]+'<span id='+BLOCK_NAME.CASE_NUMBER+' style ="display:block; height:30px;color:#737373; font-size:14px;text-align:right; border-bottom:1px solid #dedede;">'+obj.d.case_number.split(txtSplit)[1]+'</span>';
	}	
	var courtContent = "";	
	if(null != obj.d.plaintiff && obj.d.plaintiff !== txtSplit){	
		var courtContent = courtContent+obj.d.plaintiff.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF+"\" >"+obj.d.plaintiff.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.defendant && obj.d.defendant !== txtSplit){	
		var courtContent = courtContent+ obj.d.defendant.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.DEFENDANT+"\">"+obj.d.defendant.split(txtSplit)[1]+"</span>";
	}	
	if(null != obj.d.third_party && obj.d.third_party !== txtSplit){	
		var courtContent = courtContent+ obj.d.third_party.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.THIRD_PARTY+"\">"+obj.d.third_party.split(txtSplit)[1]+"</span>";
	}
	if(null != obj.d.cause_content && obj.d.cause_content !== txtSplit){	
		var courtContent = courtContent+ obj.d.cause_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.CAUSE_CONTENT+"\">"+obj.d.cause_content.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.plaintiff_claims && obj.d.plaintiff_claims !== txtSplit){	
		var courtContent = courtContent+ obj.d.plaintiff_claims.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_CLAIMS+"\">"+obj.d.plaintiff_claims.split(txtSplit)[1]+"</span>";
	}	
	if(null != obj.d.appeal && obj.d.appeal !== txtSplit){	
		var courtContent = courtContent+  "<span id=\""+BLOCK_NAME.APPEAL_CHECK+"\"></span>"+obj.d.appeal.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPEAL+"\">"+obj.d.appeal.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.plaintiff_quote && obj.d.plaintiff_quote !== txtSplit){	
		var courtContent = courtContent+ obj.d.plaintiff_quote.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_QUOTE+"\">"+obj.d.plaintiff_quote.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.answer && obj.d.answer !== txtSplit){	
		var courtContent = courtContent+ obj.d.answer.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.ANSWER+"\">"+obj.d.answer.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.reason && obj.d.reason !== txtSplit){	
		var courtContent = courtContent+ obj.d.reason.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.REASON+"\">"+obj.d.reason.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.law_article && obj.d.law_article !== txtSplit){	
		var courtContent = courtContent+  "<span id=\""+BLOCK_NAME.LAW_ARTICLE_CHECK+"\"></span>"+obj.d.law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.LAW_ARTICLE+"\">"+obj.d.law_article.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.judgment_description && obj.d.judgment_description !== txtSplit){	
		var courtContent = courtContent+  obj.d.judgment_description.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_DESCRIPTION+"\">"+obj.d.judgment_description.split(txtSplit)[1]+"</span>";
	}	
		
	if(null != obj.d.judgment_content && obj.d.judgment_content !== txtSplit){	
		var courtContent = courtContent+ "<span id=\""+BLOCK_NAME.JUDGMENT_CHECK+"\"></span>"+obj.d.judgment_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_CONTENT+"\">"+obj.d.judgment_content.split(txtSplit)[1]+"</span>";
	}	
	if(null != obj.d.rights_obligations && obj.d.rights_obligations !== txtSplit){	
		var courtContent = courtContent+  obj.d.rights_obligations.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.RIGHTS_OBLIGATIONS+"\">"+obj.d.rights_obligations.split(txtSplit)[1]+"</span>";
	}	
	if(null != obj.d.trial_group && obj.d.trial_group !== txtSplit){	
		var courtContent = courtContent+ obj.d.trial_group.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.TRIAL_GROUP_DATE+"\">"+obj.d.trial_group.split(txtSplit)[1]+"</span>";
	}	
	if(null != obj.d.appendix_law_article && obj.d.appendix_law_article !== txtSplit){	
		var courtContent =  courtContent+ obj.d.appendix_law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPENDIX_LAW_ARTICLE+"\">"+obj.d.appendix_law_article.split(txtSplit)[1]+"</span>";
	}
	editor.html(courtTitle+courtContent);
	saveEditor = editor;
}
var index = 0;
function createAnalisysReportHtml(o){
	if(o){
		index = 0;
		var report_list = $("#report_list");
		var report_appeal = $("#report_appeal");
		var report_law = $("#report_law");
		var report_judgment = $("#report_judgment");
		var report_base = $("#report_base");
		report_list.empty();
		report_appeal.empty();
		report_law.empty();
		report_judgment.empty();
		report_base.empty();
		randerReportUnit(BLOCK_NAME.APPEAL_CHECK,report_list,report_appeal,o.appeal_check,false);
		randerReportUnit(BLOCK_NAME.LAW_ARTICLE_CHECK,report_list,report_law,o.law_article_check,false);
		randerReportUnit(BLOCK_NAME.JUDGMENT_CHECK,report_list,report_judgment,o.judgment_check,false);
		randerReportUnit(BLOCK_NAME.COURT,report_list,report_base,o.court,o.court_name,true);
		randerReportUnit(BLOCK_NAME.TYPE,report_list,report_base,o.type,o.type_name,true);
		
		randerReportUnit(BLOCK_NAME.CASE_NUMBER,report_list,report_base,o.case_number,o.case_number_name,true);
		randerReportUnit(BLOCK_NAME.PLAINTIFF,report_list,report_base,o.plaintiff,o.plaintiff_name,true);
		randerReportUnit(BLOCK_NAME.DEFENDANT,report_list,report_base,o.defendant,o.defendant_name,true);
		randerReportUnit(BLOCK_NAME.THIRD_PARTY,report_list,report_base,o.third_party,o.third_party_name,true);
		//randerReportUnit(BLOCK_NAME.CAUSE,report_list,report_base,o.cause,o.cause_name,true);
		randerReportUnit(BLOCK_NAME.CAUSE_CONTENT,report_list,report_base,o.cause_content,o.cause_content_name,true);
		randerReportUnit(BLOCK_NAME.PLAINTIFF_CLAIMS,report_list,report_base,o.plaintiff_claims,o.plaintiff_claims_name,true);
		randerReportUnit(BLOCK_NAME.APPEAL,report_list,report_base,o.appeal,o.appeal_name,true);
		randerReportUnit(BLOCK_NAME.PLAINTIFF_QUOTE,report_list,report_base,o.plaintiff_quote,o.plaintiff_quote_name,true);
		randerReportUnit(BLOCK_NAME.ANSWER,report_list,report_base,o.answer,o.answer_name,true);
		randerReportUnit(BLOCK_NAME.REASON,report_list,report_base,o.reason,o.reason_name,true);
		randerReportUnit(BLOCK_NAME.LAW_ARTICLE,report_list,report_base,o.law_article,o.law_article_name,true);
		randerReportUnit(BLOCK_NAME.JUDGMENT_DESCRIPTION,report_list,report_base,o.judgment_description,o.judgment_description_name,true);
		randerReportUnit(BLOCK_NAME.JUDGMENT_CONTENT,report_list,report_base,o.judgment_content,o.judgment_content_name,true);
		randerReportUnit(BLOCK_NAME.RIGHTS_OBLIGATIONS,report_list,report_base,o.rights_obligations,o.rights_obligations_name,true);
		randerReportUnit(BLOCK_NAME.TRIAL_GROUP_DATE,report_list,report_base,o.trial_group,o.trial_group_name,true);
		randerReportUnit(BLOCK_NAME.APPENDIX_LAW_ARTICLE,report_list,report_base,o.appendix_law_article,o.appendix_law_article_name,true);
	}
}
var ICON_TYPE = {"W":"W","E":"E","I":"I"};
function randerReportUnit(blockId,report_list,report_detail,nodeData,nodeName,showTitle){
	if(nodeData && nodeData.length > 0){
		//var report = "<tr><td class='reportTdMenu'><a href=\"javascript:setColor('c_report_"+index+"')\">&nbsp;"+(index+1)+"、"+nodeData[0].content+"</a></td></tr>";
		report_list.append("<tr><td class='reportTdMenu'><a href=\"javascript:setColor('c_report_"+index+"')\">&nbsp;"+(index+1)+"、"+nodeData[0].content+"</a></td></tr>");
		//report_list.append("<tr><td class='reportTdMenu'><a href=\"javascript:setColor('c_report_"+index+"')\">&nbsp;"+(index+1)+"、"+nodeData[0].content+"</a></td>");
		//detailReport_list.append('<tr><td class="reportTdMenu"><span>'+(index+1)+'、'+nodeData[0].content+'</span></td></tr>');
		var errorMsg = "";
		var errotType = ICON_TYPE.W;
		var trMsg = "";
		var errorMsg_ReportList = "";
		for(var i = 0; i < nodeData.length; i++){
			var r = nodeData[i];
			var title = "";
			if(showTitle === true){
				title = r.content;
			}
			if(errotType === ICON_TYPE.E){
			}else if(r.type === ICON_TYPE.E){
				errotType = ICON_TYPE.E;
			}
			errorMsg += (i+1)+"、"+r.msg+"";
			//errorMsg_ReportList +="&nbsp;&nbsp;&nbsp;&nbsp;<span>["+(i+1)+"]"+ r.msg +"</span><br>"
			trMsg += "<tr style='height:20px'><td style='font-size:14px;'>&nbsp;&nbsp;&nbsp;&nbsp;"+ nodeData[i].detailContent +"</td><td colspan='2' style='font-size:14px;'><img class='img_format' style='padding-top:1px;' src='"+getImgUrl4Report(r.type)+"' />&nbsp;&nbsp;"+(i+1)+"、"+r.msg+"<br/></td></tr>";
			errorMsg_ReportList = errorMsg_ReportList +"&nbsp;&nbsp;&nbsp;&nbsp;<span style='text-decoration: none; font-size: 12px; color: red;line-height:30px;'>"+(i+1)+"、"+r.msg+"</span><img src='"+sysPath+"/images/menu/icon_06.png' style ='width: 13px;cursor: pointer;' onclick='showReasonDialog(\""+r.msg+"\");'/> <br/>";
			//report_list.append("<td class='reportTdMenu'>&nbsp;&nbsp;"+(i+1)+"、"+r.msg+"<br/></td>");
		}
		var errorMsgBox = "<tr><td class='rpt-error-item'>"+ errorMsg_ReportList +"</td></tr>";
		report_list.append(errorMsgBox);
		//report_list.append("</tr>");
		
		//var errorMsgBox = "<tr><td class='rpt-error-item'>"+ errorMsg_ReportList +"</td></tr>";
		//detailReport_list.append(errorMsgBox);
		if(showTitle === true){
			report_detail.append("<tr id=\"c_report_"+index+"\" style='height:20px'><td style='width:30%;vertical-align: top;' ><b>"+title+"</b></td><td colspan='2' style='color:#000000;vertical-align: middle;'>"+trMsg+"</td></tr>");
			report_detail.append("<tr><td style='line-height:0px;border-bottom: 1px dotted #50b7c1;' colspan='3'></td></tr>");
		}else{
			report_detail.append(trMsg);
		}
		
		if($article.html()){
			$("<a class='apop' title='"+errorMsg+"'><img class='img_format' style='padding-right:1px;' src='"+getImgUrl4Report(errotType)+"' /></a>").prependTo("#"+blockId);
			$("#"+blockId).addClass("error_alert");
		}
		
		index++;
		
	}else{
		if(showTitle === true){
			report_detail.append("<tr><td class='reportTdLine' style='width:30%'><b>"+nodeName+"</b></td><td class='reportTdLine'><img class='img_format' style='padding-top:5px;' src='"+getImgUrl4Report(ICON_TYPE.I)+"' /></td><td class='reportTdLine'>&nbsp;</td></tr>");
		}else{
			report_detail.append("<img width='15px' height='15px' style='padding-top:5px;' src='"+getImgUrl4Report(ICON_TYPE.I)+"' style='padding:6px;' />");
		}
	}
}

function showReasonDialog(msg){
	var divHtml = "<form id='findForm'><div id='reasonDialog' style='position: fixed;z-index: 1500;top: 0px;left: 0px;width: 100%;height: 726px;opacity: 12;background:rgba(113, 111, 111, 0.5) none repeat scroll 0% 0%;'>";
	divHtml += "<div id='title' style='z-index:2000;width:440px;height:auto;background:#F2F2F2;top:32%;left:35%;position:fixed;_position:absolute;border-radius: 5px;display:block;'>";
	divHtml +="<div style='height:a;font-family: 微软雅黑;font-size: 16px;float: left;margin-top:20px;display: inline;margin-left: 20px;'><span style='line-height:20px;color: rgb(54, 54, 54);font-size:16px;'>"+ msg +"</span><br><span style='line-height:20px;color: rgb(54, 54, 54);font-size:16px;' >关于上述疑似错误，您的建议：     </span><br></div>";
	divHtml +="<textarea id='reason' style='width:386px;height:80px;float: left;margin-left: 20px;display: inline;background: rgb(255, 255, 255) none repeat scroll 0% 0%;border: 1px solid rgb(222, 222, 222);overflow-y:hidden;'></textarea><br>";
	divHtml +="<div id='buttons' style='width: 426px;float: left;background: rgb(242, 242, 242) none repeat scroll 0% 0%;border-top: 1px solid rgb(189, 189, 189);margin-top: 10px;text-align: right;height: 70px;'><input type='button' style ='background:#ed7d2e;border-radius: 5px;font-size:14px;color:#fff;font-family:微软雅黑;width: 92px;height: 32px;text-align: center;border:none;margin: 18px 10px 10px 10px;cursor: pointer;' onclick='saveReasonDialog(\""+msg+"\");' value='确认' />&nbsp;&nbsp;<input type='button' style ='background:#36B0C8;border-radius: 5px;font-size:14px;color:#fff;font-family:微软雅黑;width: 92px;height: 32px;text-align: center;border:none;margin: 18px 10px 10px 10px;cursor: pointer;' onclick='closeReasonDialog();' value='返回'/></div>";
	divHtml +="</div></form>";
	$("body").append(divHtml);
	$("#reasonDialog #reason").focus();
}



function closeReasonDialog(){
	$("#reasonDialog").remove();
}

function saveReasonDialog(msg){
	var reason = $("#reason").val();
	reason = $.trim(reason);
	if(!reason){
		reason = '理由未填写';
	}
	$("#reasonDialog").remove();
	$.ajax({
		   url: sysPath+"/analysis_analysisSavesuggest.do",
		   data:{"d.articleContent":saveEditor.html(),"d.user_error_message":msg,"d.user_suggest":reason},
		   type: "POST", dataType: "json",
	       error:function(a,b,c){
	       	 $.message("warn","提交失败！");
	       },
	       success: function(msg) {
	       	 $.message("warn","提交成功！");
	       }
	});
}



function getImgUrl(r){
	var imgUrl = "";
	if(r.dyNum >= 0){
		imgUrl = sysPath+"/images/ok.jpg";
	}else if(r.dyNum === -1){
		imgUrl = sysPath+"/images/warning.jpg";
	}else if(r.dyNum === -2){
		imgUrl = sysPath+"/images/ok.jpg";
	}else if(r.dyNum === -3){
		imgUrl = sysPath+"/images/ok.jpg";
	}else if(r.dyNum === -4){
		imgUrl = sysPath+"/images/ok.jpg";
	}else {
		imgUrl = sysPath+"/images/icon-no.jpg";
	} 
	return imgUrl;
}

function getImgUrl4Report(flag){
	var imgUrl = "";
	if(flag === ICON_TYPE.I){
		imgUrl = sysPath+"/images/ok.jpg";
	}else if(flag === ICON_TYPE.E){
		imgUrl = sysPath+"/images/icon-no.jpg";
	}else if(flag === ICON_TYPE.W){
		imgUrl = sysPath+"/images/warning.jpg";
	} 
	return imgUrl;
}