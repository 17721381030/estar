var Case;
var pageSettings = {
	caseCauseSelectUrl: 	 sysPath+"/case_loadCaseCause.do",
	caseAppealKeyUrl: 		 sysPath+"/case_loadCaseAppealKey.do",
	caseAppealLawUrl: 		 sysPath+"/case_loadCaseAppealLaw.do",
	refreshAppealLawListUrl: sysPath+"/case_refreshAppealLawList.do",
	relateInfoUrl: 			 sysPath+"/case_loadCaseElementAndRelateLaw.do",
	caseCauseSelectObj: 	 $("#case_cause"),
	caseKeywordsObj: 		 $("#case_keywords"),
	caseAppealLawBody: 		 $("#appealBody"),
	listSubmitObj:			 $("#listSubmit"),
	lawElementObj:			 $("#lawElement"),
	relatelawObj:			 $("#relatelaw"),
	selectTrId:""
};

if (Case === undefined) {
	Case = function () {
		this.init(pageSettings);
		this.bindEvent();
		this.setCaseCauseSelect();
	};
}

Case.prototype.init = function(settings){
	Case.settings = settings;
};

Case.prototype.bindEvent = function(){
	Case.settings.caseCauseSelectObj.change(function(){
		setCaseAppealKeySelect();
	});
	
	Case.settings.caseKeywordsObj.change(function(){
		setCaseAppealLawList();
	});
	
	Case.settings.listSubmitObj.click(function(){
		listSubmitOnClick();
	});
	
};

Case.prototype.setCaseCauseSelect = function(){
	$.ajax({
        url: Case.settings.caseCauseSelectUrl,
        type: "POST", dataType: "json",
        error:function(a,b,c){
        	$.message("warn","加载案由下拉框失败！");
        },
        success: function(msg) {
        	if(msg && msg.d && msg.d.causeList){
				var txtHtml = "<option value = ''>==请选择案由==</option>";
				for(var i = 0; i < msg.d.causeList.length; i++){
					var obj = msg.d.causeList[i];
					txtHtml += "<option value = '"+obj.id+"'>"+obj.cause+"</option>";
				}
				Case.settings.caseCauseSelectObj.html(txtHtml);
			}else{
				$.message("warn","没有找到对应数据！");
			}
        }
	});
};


var setCaseAppealKeySelect = function(){
	$.ajax({
        url: Case.settings.caseAppealKeyUrl,
        data:{"d.causeId":Case.settings.caseCauseSelectObj.val()},
        type: "POST", dataType: "json",
        error:function(a,b,c){
        	$.message("warn","加载诉求关键字下拉框失败！");
        },
        success: function(msg) {
        	if(msg && msg.d && msg.d.appealKeyList){
				var txtHtml = "<option value = ''>==请选择诉求分类==</option>";
				for(var i = 0; i < msg.d.appealKeyList.length; i++){
					var obj = msg.d.appealKeyList[i];
					txtHtml += "<option value = '"+obj.id+"'>"+obj.keyWords+"("+obj.appearCount+")"+"</option>";
				}
				Case.settings.caseKeywordsObj.html(txtHtml);
			}else{
				$.message("warn","没有找到对应数据！");
			}
        }
	});
};


var setCaseAppealLawList = function(){
	$.ajax({
        url: Case.settings.caseAppealLawUrl,
        data:{"d.lawArticle":$("#case_lawArticle").val(),"d.appealKeyId":Case.settings.caseKeywordsObj.val()},
        type: "POST", dataType: "json",
        error:function(a,b,c){
        	$.message("warn","加载法条列表失败！");
        },
        success: function(msg) {
        	Case.settings.caseAppealLawBody.empty();
			if(msg && msg.d && msg.d.appealLawList){
				for(var i = 0; i < msg.d.appealLawList.length; i++){
					var obj = msg.d.appealLawList[i];
					var txtHtml = "<tr class='menu'><td id = \"articleId\" style=\"text-align:center\">"+(i+1)+"</td>"+
					"<td><a class='law_article' href='javascript:void(0)' title='"+obj.lawContent+"' onclick='javascript:trOnClick(this,\""+obj.id+"\")'>"+obj.relateLaw+"</a></td>"+
					"<td style=\"text-align:right;padding-right:4px;\"><a href='javascript:void(0)' onclick='showRelateDialog(\""+obj.affirmRelate+"\",\""+obj.lawRelateDegree+"\",\""+obj.id+"\",\""+obj.remark+"\")' >"+obj.relateValue+"</a></td>"+
					"<td><a href='javascript:void(0)' onclick='javascript:refreshCaseList(this)'>"+obj.quoteCount+"</a></td>"+
					"</tr><tr class = 'child-menu' ><td></td><td>"+obj.lawContent+"</td><td></td><td></td></tr>";
					Case.settings.caseAppealLawBody.append(txtHtml);
				}
			}else{
				$.message("warn","没有找到对应数据！");
			}
			hideAllTable();
			$("#appealBody").tooltip();
        }
	});
};

function refreshCaseList(obj){
	var keyWord = $("#case_keywords option:selected").html();
	var cause = $("#case_cause option:selected").html();
	var idx = keyWord.indexOf("(");
	keyWord = keyWord.substr(0,idx);
	var lawArticle = $(obj).parentsUntil("tr").parent().find(".law_article").html();
	var lawArticleId = $(obj).parentsUntil("tr").parent().find("#articleId").html();
	$("input[name='d.lawArticle']").val(lawArticle);
	$("input[name='d.appealKey']").val(keyWord);
	$("input[name='d.causeName']").val(cause);
	$("input[name='d.causeId']").val(Case.settings.caseCauseSelectObj.val());
	$("input[name='d.appealKeyId']").val(Case.settings.caseKeywordsObj.val());
	$("input[name='d.lawArticleId']").val(lawArticleId);
	$("#right").attr("target","caseRightFrame").attr("action", "case_caseByAppealKeyAndLawArticle.do");
	$("#right").submit();
	var frameset = parent.document.getElementById("caseMainFrame");
	frameset.cols = "0%,100%";
}

function showRelateDialog(OaffirmRelate,OlawRelateDegree,Oid,Oremark){
	$.ajax({
        url: sysPath+"/case_loadCaseAppealLawObject.do?d.id="+Oid,
        type: "POST", dataType: "json",
        error:function(a,b,c){
        	$.message("warn","取数据失败！");
        },
        success: function(msg) {
        	OaffirmRelate = msg.d.caseAppealLaw.affirmRelate;
        	OlawRelateDegree = msg.d.caseAppealLaw.lawRelateDegree;
        	Oremark = msg.d.caseAppealLaw.remark;
        	var affirmRelate = OaffirmRelate==="1"?"checked=\"checked\"":"";
			var remarkShow = OaffirmRelate==="1"?"":"class=\"hidden\"";
			
			var vHtml = "<form id='findForm'><table><tr><td>不相关联:<input type='hidden' name='d.appealLawList[0].id' value='"+Oid+"'/><input type = 'checkbox' name='d.appealLawList[0].affirmRelate' "+affirmRelate+" onclick='degreeShow();' value='1' /></td></tr>";
			vHtml += "<tr id='tr_remark'" + remarkShow + "><td>备注:<input type = 'text' class='text' name = 'd.appealLawList[0].remark'  value = '"+Oremark+"' /></td>";
			vHtml += "</tr></table></form>";
			$.dialog({
				title: "维护关联度",
				content: vHtml,			
				width: 250,
				modal: true,
				ok: "确&nbsp;&nbsp;定",
				cancel: "取&nbsp;&nbsp;消",
				onOk: function() {
					listSubmitOnClick();
				}
			});
        }
	});


	
}

var listSubmitOnClick = function(){
	$.ajax({
        url: Case.settings.refreshAppealLawListUrl,
        data:$("#findForm").serialize(),
        type: "POST", dataType: "json",
        error:function(a,b,c){
        	$.message("warn","保存失败！");
        },
        success: function(msg) {
        	$.message("warn","保存成功！");
        }
	});
};

var trOnClick = function(obj,id){
	if($(obj).parent().parent().hasClass("menu")){
		$(obj).parent().parent().nextUntil(".menu").toggle(200);
	}
};


function hideAllTable(){
	var tableArray = $(".list");
	for(var j = 0 ;j < tableArray.length;j++){
		var obj = tableArray[j];
		if(!$(obj).children().children().is(":hidden")){
			if($(obj).children().children().hasClass("menu")){
				$(obj).children().children().nextUntil(".menu").toggle(0);
			}
		}
	}
}

function degreeShow(){
	var obj = $("#findForm").find("input[type='checkbox']");
	if(obj.attr("checked") === "checked"){
		$("#tr_remark").show();
	}else{
		$("#tr_remark").hide();
	}
}



$(function () {
	var c = new Case();
	
	$(".btn_search").click(function(){
		setCaseAppealLawList();
	});
	
	
});