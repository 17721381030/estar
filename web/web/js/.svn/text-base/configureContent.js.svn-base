var ICON_TYPE = {"WARNING":"WARNING","ERROR":"ERROR","INFORMATION":"INFORMATION"};
function initPage(obj){
	$configureContent = $("#configure_content");
	$configureDetailContent = $("#configure_detail_content");
	$configureContent.empty();
	$configureDetailContent.empty();
	var allContent = "";
	if(null != obj.d.allIsvalidCount && null != obj.d.allIsNotValidCount ){
		allContent = "<table width='100%'  border='0' cellpadding='0' cellspacing='1' bgcolor='#e6e6e6' class='ketable'><tr><td class='kep1'><span class = 'kep1_span'><a href ='#' id ='hidetable' onclick='javascript:hideAllTable()'>隐藏所有问题</a><a id = 'showtable' href ='#' onclick='javascript:showAllTable()' style ='display:none'>显示所有问题</a></span><span id = 'allisValidCount' value ='"+obj.d.allIsvalidCount+","+obj.d.allIsNotValidCount+"'>有效："+obj.d.allIsvalidCount+"&nbsp;&nbsp;&nbsp;无效："+obj.d.allIsNotValidCount+"</span></td></tr></table>";
	}
	var detailContent ="";
	var detail_title_temp ="";
	var detail_content_temp ="";
	var detail_content_info ="";
	if(null != obj.d.proList){
		for(var i = 0; i < obj.d.proList.length; i++){
			detail_title_temp ="";
			detail_content_temp ="<tr class = 'child-menu'>";
			detail_content_info ="";
			var r = obj.d.proList[i];
			if(r){
				detail_title_temp ="<table id ='table_menu' width='100%' border='0' cellpadding='0' cellspacing='1' bgcolor='#e6e6e6' class='ketable2'>";
				detail_title_temp = detail_title_temp+"<tr class='menu'><td onclick='javascript:refreshConfigureList(this)' unselectable='on' onselectstart='return false;' colspan='2' style='text-indent:0px;'><img src='"+path+"/images/configure_icon3.png'"+"style='margin-top:13px; float:left; margin-right:10px;'/>";
				detail_title_temp = detail_title_temp+"<span id ='detailIsValidCount_"+i+"' value = '"+r.name+","+r.isValidCount+","+r.isNotValidCount+"'>"+r.name+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效："+r.isValidCount+"&nbsp;&nbsp;&nbsp;无效："+r.isNotValidCount+"</span>";
				detail_title_temp = detail_title_temp+"<span class = 'ketable2_span'><a><img  src='"+path+"/images/configure_icon1.png'style=' margin-top:16px; float:right;' /></a></span></td></tr>";
				var intCount = 0;
				if(r.processorList){
					 for(var n = 0; n< r.processorList.length;n++){
					 	var m = r.processorList[n];
					 	if(m && m.exceptionInfos){
					 		for(var j = 0 ;j < m.exceptionInfos.length;j++){
					 			var exceptionObj = m.exceptionInfos[j];
					 			if(exceptionObj.enabled == true){
					 				if(intCount ==2){
					 					intCount = 0;
					 					detail_content_temp = detail_content_temp +"</tr><tr  class = 'child-menu'>"
					 					detail_content_temp = detail_content_temp +"<td unselectable='on' onselectstart='return false;' style='background:#fff;' class='pei2a'><span><a href='javascript:void(0)' title = '"+exceptionObj.sample+"' style='color:#948f8f; font-size:13px;' onclick = 'javascript:trOnClick(this,1)'>说明</a><a href ='#' onclick='javascript:configureProType(this,detailIsValidCount_"+i+")' style='margin-right:0px;' value ='"+m.id+","+exceptionObj.exceptionId+","+exceptionObj.userDefinedMessageType+","+getExceptionInfoDes(exceptionObj.description)+","+exceptionObj.sample+"'>变更类型&nbsp;&nbsp;</a></span>";
					 					detail_content_temp = detail_content_temp +"<img src='"+getImgUrl(exceptionObj.userDefinedMessageType)+"'/>&nbsp;&nbsp;"+getMessageTypeText(exceptionObj.userDefinedMessageType)+"&nbsp;&nbsp;&nbsp;&nbsp;"+getExceptionInfoDes(exceptionObj.description)+"</td>";
					 					intCount++;
					 				}else{
					 					detail_content_temp = detail_content_temp +"<td unselectable='on' onselectstart='return false;' style='background:#fff;' class='pei2a'><span><a href='javascript:void(0)' title = '"+exceptionObj.sample+"' style='color:#948f8f; font-size:13px;' onclick = 'javascript:trOnClick(this,1)'>说明</a><a href ='#' onclick='javascript:configureProType(this,detailIsValidCount_"+i+")' style='margin-right:0px;' value ='"+m.id+","+exceptionObj.exceptionId+","+exceptionObj.userDefinedMessageType+","+getExceptionInfoDes(exceptionObj.description)+","+exceptionObj.sample+"'>变更类型&nbsp;&nbsp;</a></span>";
					 					detail_content_temp = detail_content_temp +"<img src='"+getImgUrl(exceptionObj.userDefinedMessageType)+"'/>&nbsp;&nbsp;"+getMessageTypeText(exceptionObj.userDefinedMessageType)+"&nbsp;&nbsp;&nbsp;&nbsp;"+getExceptionInfoDes(exceptionObj.description)+"</td>";
					 					intCount++;
					 				}
					 			}
					 		}
					 	}
					}
				}
				detail_content_info = detail_content_info +detail_content_temp+ "</tr>";
			}
			detailContent = detailContent + detail_title_temp + detail_content_info+"</table>";
		}
	}
	$configureContent.append(allContent);
	$configureDetailContent.append(detailContent);
}


function getMessageTypeText(flag){
	var messageType = "";
	if(flag === ICON_TYPE.INFORMATION){
		messageType = "忽略"
	}else if(flag === ICON_TYPE.ERROR){
		messageType = "错误"
	}else if(flag === ICON_TYPE.WARNING){
		messageType = "警告"
	} 
	return messageType;
}

function getImgUrl(r){
	var imgUrl = "";
	if(r === ICON_TYPE.INFORMATION){
		imgUrl = path+"/images/configure_icon4.png";
	}else if(r === ICON_TYPE.WARNING || r === ICON_TYPE.ERROR ){
		imgUrl = path+"/images/configure_icon2.png";
	} 
	return imgUrl;
}

var trOnClick = function(obj,id){
	
};


function getExceptionInfoDes(text){
	var description = "";
	if(typeof text == "string" && text.constructor == String){
		if( null != text && "" != text){
			if(text.indexOf("(") != -1){
				description = text.split("(")[0];
			}else{
				description = text;
			}
		}
	}
	return description;
}

function refreshConfigureList(obj){
	if($(obj).parent().hasClass("menu")){
		$(obj).parent().nextUntil(".menu").toggle(200);
	}
}


function hideAllTable(){
	var tableArray = $(".ketable2");
	for(var j = 0 ;j < tableArray.length;j++){
		var obj = tableArray[j];
		if(!$(obj).children().children().is(":hidden")){
			if($(obj).children().children().hasClass("menu")){
				$(obj).children().children().nextUntil(".menu").toggle(200);
			}
		}
	}
	$("#hidetable").hide();
	$("#showtable").show();
}

function showAllTable(){
	var tableArray = $(".ketable2");
	for(var j = 0 ;j < tableArray.length;j++){
		var obj = tableArray[j];
		if($(obj).children().children().is(":hidden")){
			if($(obj).children().children().hasClass("menu")){
				$(obj).children().children().nextUntil(".menu").toggle(200);
			}
		}
	}
	$("#showtable").hide();
	$("#hidetable").show();
}

function configureProType(obj,detailId){
	var parObj = $(obj).parent().parent();
	var param = $(obj).attr("value");
	var paramArray = param.split(",");
	var updateText = ""
	var flag = false;
	var type = ""
	var infoStr = "";
	var allValidObj = $("#allisValidCount").parent().children();
	var allValidArray = $("#allisValidCount").attr("value").split(",");
	var detailValidObj =$(detailId);
	var detailValidArray = $(detailId).attr("value").split(",");
	var addCount = 0;
	var deleteCount = 0;
	for(var j = 0 ;j < parObj.length;j++){
		var p = parObj[j];
		if(p.className == "pei2a"){
			if(paramArray[2] == ICON_TYPE.ERROR){
				updateText = updateText + "<span><a href='javascript:void(0)'title = '"+paramArray[4]+"' style='color:#948f8f; font-size:13px;' onclick = 'javascript:trOnClick(this,1)'>说明</a>";
				updateText = updateText +"<a href ='#' onclick='javascript:configureProType(this,"+detailValidObj[0].id+")' style='margin-right:0px;' value = '"+paramArray[0]+","+paramArray[1]+","+ICON_TYPE.WARNING+","+paramArray[3]+","+paramArray[4]+"'>变更类型&nbsp;&nbsp;</a></span>";
				updateText = updateText +"<img src='"+getImgUrl(ICON_TYPE.WARNING)+"'>&nbsp;&nbsp;"+getMessageTypeText(ICON_TYPE.WARNING)+"&nbsp;&nbsp;&nbsp;&nbsp;"+paramArray[3];
				p.innerHTML= updateText ;
				type = ICON_TYPE.WARNING;
				flag = true;
			}else if(paramArray[2] == ICON_TYPE.WARNING){
				updateText = updateText + "<span><a href='javascript:void(0)'title = '"+paramArray[4]+"' style='color:#948f8f; font-size:13px;' onclick = 'javascript:trOnClick(this,1)'>说明</a>";
				updateText = updateText +"<a href ='#' onclick='javascript:configureProType(this,"+detailValidObj[0].id+")' style='margin-right:0px;' value = '"+paramArray[0]+","+paramArray[1]+","+ICON_TYPE.INFORMATION+","+paramArray[3]+","+paramArray[4]+"'>变更类型&nbsp;&nbsp;</a></span>";
				updateText = updateText +"<img src='"+getImgUrl(ICON_TYPE.INFORMATION)+"'>&nbsp;&nbsp;"+getMessageTypeText(ICON_TYPE.INFORMATION)+"&nbsp;&nbsp;&nbsp;&nbsp;"+paramArray[3];
				p.innerHTML= updateText ;
				type = ICON_TYPE.INFORMATION;
				deleteCount++;
				flag = true;
			}else if(paramArray[2] == ICON_TYPE.INFORMATION){
				updateText = updateText + "<span><a href='javascript:void(0)'title = '"+paramArray[4]+"' style='color:#948f8f; font-size:13px;' onclick = 'javascript:trOnClick(this,1)'>说明</a>";
				updateText = updateText +"<a href ='#' onclick='javascript:configureProType(this,"+detailValidObj[0].id+")' style='margin-right:0px;' value = '"+paramArray[0]+","+paramArray[1]+","+ICON_TYPE.ERROR+","+paramArray[3]+","+paramArray[4]+"'>变更类型&nbsp;&nbsp;</a></span>";
				updateText = updateText +"<img src='"+getImgUrl(ICON_TYPE.ERROR)+"'>&nbsp;&nbsp;"+getMessageTypeText(ICON_TYPE.ERROR)+"&nbsp;&nbsp;&nbsp;&nbsp;"+paramArray[3];
				p.innerHTML= updateText ;
				type = ICON_TYPE.ERROR;
				addCount++;
				flag = true;
			}
		}
	
	}
	
	var allIsvalidCount = 0;
	var allIsNotValidCount = 0;
	for(var i = 0; i< allValidObj.length; i++ ){
		if( allValidObj[i].className != "kep1_span" ){
			if(addCount != 0){
				allIsvalidCount = parseInt(allValidArray[0])+addCount;
				allIsNotValidCount = parseInt(allValidArray[1])-addCount;
			}else if(deleteCount != 0){
				allIsvalidCount = parseInt(allValidArray[0])-deleteCount;
				allIsNotValidCount = parseInt(allValidArray[1])+deleteCount;
			}else{
				allIsvalidCount = parseInt(allValidArray[0]);
				allIsNotValidCount = parseInt(allValidArray[1]);
			}
			allValidObj[i].outerHTML = "<span id = 'allisValidCount' value ='"+allIsvalidCount.toString()+","+allIsNotValidCount.toString()+"'>有效："+allIsvalidCount.toString()+"&nbsp;&nbsp;&nbsp;无效："+allIsNotValidCount.toString()+"</span>";
		}
	}
	
	var detailIsvalidCount = 0;
	var detailIsNotValidCount = 0;
	if(addCount != 0){
		detailIsvalidCount = parseInt(detailValidArray[1])+addCount;
		detailIsNotValidCount = parseInt(detailValidArray[2])-addCount;
	}else if(deleteCount != 0){
		detailIsvalidCount = parseInt(detailValidArray[1])-deleteCount;
		detailIsNotValidCount = parseInt(detailValidArray[2])+deleteCount;
	}else{
		detailIsvalidCount = parseInt(detailValidArray[1]);
		detailIsNotValidCount = parseInt(detailValidArray[2]);
	}
	detailValidObj[0].outerHTML = "<span id='"+detailValidObj[0].id+"' value='"+detailValidArray[0]+","+detailIsvalidCount.toString()+","+detailIsNotValidCount.toString()+"'>"+detailValidArray[0]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效："+detailIsvalidCount.toString()+"&nbsp;&nbsp;&nbsp;无效："+detailIsNotValidCount.toString()+"</span>";
	
	
	infoStr = paramArray[0]+","+paramArray[1]+","+type+","+paramArray[3];
	if(flag){
		$.ajax({
		       url: path+"/modifyCheckerProcessors_setPro.do",
		       data:{"d.proInfo":infoStr},
		       type: "POST", dataType: "json",
		       error:function(a,b,c){
		       	$.message("warn","提交失败！");
		       },
		       success: function(msg) {
		       	$.message("warn","变更成功！");
		       }
		});
	}
}
