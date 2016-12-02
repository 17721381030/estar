var swfu;
var settings = {
	flash_url : sysPath+"/swfupload/swfupload.swf",
	upload_url: sysPath+"/analysis_analysisDocArticle.do",	
	post_params: {"PHPSESSID" : "11"},
	file_size_limit : "10 MB",
	file_types : "*.*",
	file_types_description : "All Files",
	file_upload_limit : 10,  //配置上传个数
	file_queue_limit : 1,
	custom_settings : {
		progressTarget : "fsUploadProgress",
		cancelButtonId : "btnCancel"
	},
	debug: false,

	button_image_url: sysPath+"/images/TestImageNoText_65x29.png",
	button_width: "65",
	button_height: "29",
	button_placeholder_id: "spanButtonPlaceHolder",
	button_text: '<span id="btn" class="btn" style="margin:10px">选择文件</span>',
	button_text_style: ".theFont { font-size: 16; }",
	button_text_left_padding: 12,
	button_text_top_padding: 3,
	
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


function docResize(){
	var w = $(window).width(); 
	var h = $(window).height(); 
	$("#article_content").width(w-260);
	$("#article_menu").width(200);
	$("#article_menu").height(h);
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

	$("html").animate({ scrollTop: offset.top-50 }, 300);
	
}	
	
	
function setColor(tag) {
	$myTab.tabs("option","active",2);
	var p = $("#"+tag);
	var offset = p.offset();
	$("html").animate({ scrollTop: offset.top-50 }, 300);
	$(".txtAlert").removeClass("txtAlert");
	$("#"+tag).addClass("txtAlert");
	setTimeout(function() {
		$(".txtAlert").removeClass("txtAlert");
	}, 1000);
}	

function openUploadDialog(){
	$.dialog({
		title: "提交文本或上传附件", 
		content: '<div class="fieldset flash" id="fsUploadProgress"><span class="legend">上传进度</span></div><div id="divStatus">0 个文件已上传</div><div><span id="spanButtonPlaceHolder"></span><input id="btnCancel" type="button" value="取消所有上传" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px;font-size: 8pt; height: 29px;" /></div>',			
		width: 430,
		modal: true,
		ok: null,
		cancel: "关&nbsp;&nbsp;闭"
	});
	
	swfu = new SWFUpload(settings);
}

var BLOCK_NAME = {"COURT":"COURT",
				"TYPE":"TYPE",
				"CASE_NUMBER":"CASE_NUMBER",
				"PLAINTIFF":"PLAINTIFF",
				"DEFENDANT":"DEFENDANT",
				"THIRD_PARTY":"THIRD_PARTY",
				"CAUSE":"CAUSE",
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
function initPage(obj){
	$article = $("#article_split_detail");
	if($article.html()){
		if(obj.d.articleContent){
			$(".textarea").val(obj.d.articleContent);
		}
		$article.empty();
		if(obj.d.court !== txtSplit)
		$article.append(obj.d.court.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.COURT+"\">"+obj.d.court.split(txtSplit)[1]+"</span>");
		if(obj.d.type !== txtSplit)
		$article.append(obj.d.type.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.TYPE+"\">"+obj.d.type.split(txtSplit)[1]+"</span>");
		if(obj.d.case_number !== txtSplit)
		$article.append(obj.d.case_number.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.CASE_NUMBER+"\">"+obj.d.case_number.split(txtSplit)[1]+"</span>");
		if(obj.d.plaintiff !== txtSplit)
		$article.append(obj.d.plaintiff.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF+"\">"+obj.d.plaintiff.split(txtSplit)[1]+"</span>");
		if(obj.d.defendant !== txtSplit)
		$article.append(obj.d.defendant.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.DEFENDANT+"\">"+obj.d.defendant.split(txtSplit)[1]+"</span>");
		if(obj.d.third_party !== txtSplit)
		$article.append(obj.d.third_party.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.THIRD_PARTY+"\">"+obj.d.third_party.split(txtSplit)[1]+"</span>");
		if(obj.d.cause !== txtSplit)
		$article.append(obj.d.cause.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.CAUSE+"\">"+obj.d.cause.split(txtSplit)[1]+"</span>");
		if(obj.d.cause_content !== txtSplit)
		$article.append(obj.d.cause_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.CAUSE_CONTENT+"\">"+obj.d.cause_content.split(txtSplit)[1]+"</span>");
		if(obj.d.plaintiff_claims !== txtSplit)
		$article.append(obj.d.plaintiff_claims.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_CLAIMS+"\">"+obj.d.plaintiff_claims.split(txtSplit)[1]+"</span>");
		if(obj.d.appeal !== txtSplit)
		$article.append("<span id=\""+BLOCK_NAME.APPEAL_CHECK+"\"></span>"+obj.d.appeal.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPEAL+"\">"+obj.d.appeal.split(txtSplit)[1]+"</span>");
		if(obj.d.plaintiff_quote !== txtSplit)
		$article.append(obj.d.plaintiff_quote.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.PLAINTIFF_QUOTE+"\">"+obj.d.plaintiff_quote.split(txtSplit)[1]+"</span>");
		if(obj.d.answer !== txtSplit)
		$article.append(obj.d.answer.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.ANSWER+"\">"+obj.d.answer.split(txtSplit)[1]+"</span>");
		if(obj.d.reason !== txtSplit)
		$article.append(obj.d.reason.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.REASON+"\">"+obj.d.reason.split(txtSplit)[1]+"</span>");
		if(obj.d.law_article !== txtSplit)
		$article.append("<span id=\""+BLOCK_NAME.LAW_ARTICLE_CHECK+"\"></span>"+obj.d.law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.LAW_ARTICLE+"\">"+obj.d.law_article.split(txtSplit)[1]+"</span>");
		if(obj.d.judgment_description !== txtSplit)
		$article.append(obj.d.judgment_description.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_DESCRIPTION+"\">"+obj.d.judgment_description.split(txtSplit)[1]+"</span>");
		if(obj.d.judgment_content !== txtSplit)
		$article.append("<span id=\""+BLOCK_NAME.JUDGMENT_CHECK+"\"></span>"+obj.d.judgment_content.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.JUDGMENT_CONTENT+"\">"+obj.d.judgment_content.split(txtSplit)[1]+"</span>");
		if(obj.d.rights_obligations !== txtSplit)
		$article.append(obj.d.rights_obligations.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.RIGHTS_OBLIGATIONS+"\">"+obj.d.rights_obligations.split(txtSplit)[1]+"</span>");
		if(obj.d.trial_group !== txtSplit)
		$article.append(obj.d.trial_group.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.TRIAL_GROUP_DATE+"\">"+obj.d.trial_group.split(txtSplit)[1]+"</span>");
		if(obj.d.appendix_law_article !== txtSplit)
		$article.append(obj.d.appendix_law_article.split(txtSplit)[0]+"<span id=\""+BLOCK_NAME.APPENDIX_LAW_ARTICLE+"\">"+obj.d.appendix_law_article.split(txtSplit)[1]+"</span>");
		
		$.fn.zTree.init($("#articleStruts"), setting, obj.d.articleTreeDTOList);
		$myTab.tabs("option","active",1);
		$("#article_split_detail span").mousemove(
			function () {
				$("span").removeClass("txtAlert");
				$(this).addClass("txtAlert");
				$strutsTab.tabs("option","active",0);
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
	
	createReportHtml(obj.d.analysisArticleReportDTO);
	if($article.html()){
		$article.tooltip();
	}
}

var index = 0;
function createReportHtml(o){
	if(o){
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
		randerReportUnit(BLOCK_NAME.CAUSE,report_list,report_base,o.cause,o.cause_name,true);
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
		randerReportUnit(BLOCK_NAME.TRIAL_GROUP,report_list,report_base,o.trial_group,o.trial_group_name,true);
		randerReportUnit(BLOCK_NAME.APPENDIX_LAW_ARTICLE,report_list,report_base,o.appendix_law_article,o.appendix_law_article_name,true);
	}
}
var ICON_TYPE = {"W":"W","E":"E","I":"I"};

function randerReportUnit(blockId,report_list,report_detail,nodeData,nodeName,showTitle){
	if(nodeData && nodeData.length > 0){
		report_list.append("<tr><td class='reportTdMenu'><a href=\"javascript:setColor('c_report_"+index+"')\">&nbsp;"+(index+1)+"、"+nodeData[0].content+"</a></td></tr>");
		var errorMsg = "";
		var errotType = ICON_TYPE.W;
		var trMsg = "";
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
			trMsg += "<img class='img_format' style='padding-top:1px;' src='"+getImgUrl4Report(r.type)+"' />&nbsp;&nbsp;"+(i+1)+"、"+r.msg+"<br/>";
		}
		
		if(showTitle === true){
			report_detail.append("<tr id=\"c_report_"+index+"\" ><td style='width:30%;vertical-align: top;' class='reportTdLine'><b>"+title+"</b></td><td class='reportTdLine' colspan='2' style='color:#000000;vertical-align: middle;'>"+trMsg+"</td></tr>");
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