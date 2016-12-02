
$(function () {
	initRelateInfoEvent();
});

var relateInfoSetting = {
	addElementRowObj: 	 $(".addElementRow"),
	addRelateLawRowObj:  $(".addRelateLawRow"),
	lawElementObj:		 $("#lawElement"),
	relatelawObj:		 $("#relatelaw"),
	addLawElementUrl:	 sysPath+"/case_addCaseElement.do",
	addRelatelawUrl:	 sysPath+"/case_addRelateLaw.do",
	delLawElementUrl:	 sysPath+"/case_delCaseElement.do",
	delRelatelawUrl:	 sysPath+"/case_delRelateLaw.do"
};

function initRelateInfoEvent(){
	relateInfoSetting.addElementRowObj.click(function(){
		addTableRow(relateInfoSetting.lawElementObj,1);
	});
	
	relateInfoSetting.addRelateLawRowObj.click(function(){
		addTableRow(relateInfoSetting.relatelawObj,2);
	});
}

function addTableRow(obj,type){
	if(pageSettings.selectTrId !== "" && pageSettings.selectTrId){
		var index = obj.find("tr").length;
		var txtHtml = "<tr><td><input type='hidden' name='id' value=''/>"+(index+1)+"</td><td><input type='text' class='text' name='content' /></td><td><a href='javascript:void(0)' onclick='javascript:saveTableRow(this,"+type+")' >保存</a>&nbsp;&nbsp;<a href='javascript:void(0)' onclick='javascript:deleteTableRow(this,"+type+")'>删除</a></td></tr>";
		obj.append(txtHtml);
	}else{
		$.message("warn","没有选中法条数据！");
	}
	
}

function saveTableRow(objTr,objSubInfo){
	var id 		= $(objTr).parentsUntil("tr").parent().find("input[name='id']").val();
	var content = $(objTr).parentsUntil("tr").parent().find("input[name='content']").val();
	var url = "";
	if(objSubInfo === 1){
		url = relateInfoSetting.addLawElementUrl;
	}else if(objSubInfo === 2){
		url = relateInfoSetting.addRelatelawUrl;
	}
	if(pageSettings.selectTrId !== "" && pageSettings.selectTrId){
		$.ajax({
	        url: url,
	        data:{"d.id":id,"d.content":content,"d.appealLawId":pageSettings.selectTrId},
	        type: "POST", dataType: "json",
	        error:function(a,b,c){
	        	$.message("warn","保存失败！");
	        },
	        success: function(msg) {
	        	$(objTr).parentsUntil("tr").parent().find("input[name='id']").val(msg.d.id)
	        	$.message("warn","保存成功！");
	        }
		});
	}else{
		$.message("warn","没有选中法条数据！");
	}
}

function deleteTableRow(objTr,objSubInfo){
	$.dialog({
		title: "删除",
		content: '确定要删除?',			
		width: 470,
		modal: true,
		ok: "确&nbsp;&nbsp;定",
		cancel: "取&nbsp;&nbsp;消",
		onOk: function() {
			deleteObjExecute(objTr,objSubInfo);
		}
	});
}

function deleteObjExecute(objTr,objSubInfo){
	var id 		= $(objTr).parentsUntil("tr").parent().find("input[name='id']").val();
	
	if(id === ""){
		$(objTr).parentsUntil("tr").parent().remove();
		return;
	}
	var content = $(objTr).parentsUntil("tr").parent().find("input[name='content']").val();
	var url = "";
	if(objSubInfo === 1){
		url = relateInfoSetting.delLawElementUrl;
	}else if(objSubInfo === 2){
		url = relateInfoSetting.delRelatelawUrl;
	}
	if(pageSettings.selectTrId !== "" && pageSettings.selectTrId){
		$.ajax({
	        url: url,
	        data:{"d.id":id,"d.content":content},
	        type: "POST", dataType: "json",
	        error:function(a,b,c){
	        	$.message("warn","删除失败！");
	        },
	        success: function(msg) {
	        	$.message("warn","删除成功！");
	        	$(objTr).parentsUntil("tr").parent().remove();
	        }
		});
	}else{
		$.message("warn","没有选中法条数据！");
	}
}