$(document).ready(function(){
	var zIndex = 100;
	var $message;
	var messageTimer;
	tableColor();
	
	$("#all_chk").click(function(){
		$(":checkbox[name='d.ids']").attr("checked", this.checked);
	});
	
	$(".not_null").each(function(i,n){
		$(n).prepend('<b>*</b>');
	});
	
	String.prototype.trim = function() {
		return this.replace(/(^\s*)|(\s*$)/g, "").replace(/[\u3000]/g, "");
	}
	
	
	$.message = function() {
		var message = {};
		if ($.isPlainObject(arguments[0])) {
			message = arguments[0];
		} else if (typeof arguments[0] === "string" && typeof arguments[1] === "string") {
			message.type = arguments[0];
			message.content = arguments[1];
		} else {
			return false;
		}
		
		if (message.type == null || message.content == null) {
			return false;
		}
		
		if ($message == null) {
			$message = $('<div class="xxMessage"><div class="messageContent message' + message.type + 'Icon"><\/div><\/div>');
			if (!window.XMLHttpRequest) {
				$message.append('<iframe class="messageIframe"><\/iframe>');
			}
			$message.appendTo("body");
		}
		
		$message.children("div").removeClass("messagewarnIcon messageerrorIcon messagesuccessIcon").addClass("message" + message.type + "Icon").html(message.content);
		$message.css({"margin-left": - parseInt($message.outerWidth() / 2), "z-index": zIndex ++}).show();
		
		clearTimeout(messageTimer);
		messageTimer = setTimeout(function() {
			$message.hide();
		}, 1000);
		return $message;
	}


	var msg = $("#pageMsg").text();
	if(msg !== ""){
		$.message("warn",msg);
	}
	// 对话框
	$.dialog = function(options) {
		var settings = {
			width: 320,
			height: "auto",
			modal: true,
			ok: message("admin.dialog.ok"),
			cancel: message("admin.dialog.cancel"),
			onShow: null,
			onClose: null,
			onOk: null,
			onCancel: null
		};
		$.extend(settings, options);
		
		if (settings.content == null) {
			return false;
		}
		
		var $dialog = $('<div class="xxDialog"><\/div>');
		var $dialogTitle;
		var $dialogClose = $('<div class="dialogClose"><\/div>').appendTo($dialog);
		var $dialogContent;
		var $dialogBottom;
		var $dialogOk;
		var $dialogCancel;
		var $dialogOverlay;
		if (settings.title != null) {
			$dialogTitle = $('<div class="dialogTitle"><\/div>').appendTo($dialog);
		}
		if (settings.type != null) {
			$dialogContent = $('<div class="dialogContent dialog' + settings.type + 'Icon"><\/div>').appendTo($dialog);
		} else {
			$dialogContent = $('<div class="dialogContent"><\/div>').appendTo($dialog);
		}
		if (settings.ok != null || settings.cancel != null) {
			$dialogBottom = $('<div class="dialogBottom"><\/div>').appendTo($dialog);
		}
		if (settings.ok != null) {
			$dialogOk = $('<span class="btn" >' + settings.ok + '</span>').appendTo($dialogBottom);
		}
		if (settings.cancel != null) {
			$dialogCancel = $('<span class="btn"  >' + settings.cancel + '</span>').appendTo($dialogBottom);
		}
		if (!window.XMLHttpRequest) {
			$dialog.append('<iframe class="dialogIframe"><\/iframe>');
		}
		$dialog.appendTo("body");
		if (settings.modal) {
			$dialogOverlay = $('<div class="dialogOverlay"><\/div>').insertAfter($dialog);
		}
		
		var dialogX;
		var dialogY;
		if (settings.title != null) {
			$dialogTitle.text(settings.title);
		}
		$dialogContent.html(settings.content);
		$dialog.css({"width": settings.width, "height": settings.height, "margin-left": - parseInt(settings.width / 2), "z-index": zIndex ++});
		dialogShow();
		
		if ($dialogTitle != null) {
			$dialogTitle.mousedown(function(event) {
				$dialog.css({"z-index": zIndex ++});
				var offset = $(this).offset();
				if (!window.XMLHttpRequest) {
					dialogX = event.clientX - offset.left;
					dialogY = event.clientY - offset.top;
				} else {
					dialogX = event.pageX - offset.left;
					dialogY = event.pageY - offset.top;
				}
				$("body").bind("mousemove", function(event) {
					$dialog.css({"top": event.clientY - dialogY, "left": event.clientX - dialogX, "margin": 0});
				});
				return false;
			}).mouseup(function() {
				$("body").unbind("mousemove");
				return false;
			});
		}
		
		if ($dialogClose != null) {
			$dialogClose.click(function() {
				dialogClose();
				return false;
			});
		}
		
		if ($dialogOk != null) {
			$dialogOk.click(function() {
				if (settings.onOk && typeof settings.onOk == "function") {
					if (settings.onOk($dialog) != false) {
						dialogClose();
					}
				} else {
					dialogClose();
				}
				return false;
			});
		}
		
		if ($dialogCancel != null) {
			$dialogCancel.click(function() {
				if (settings.onCancel && typeof settings.onCancel == "function") {
					if (settings.onCancel($dialog) != false) {
						dialogClose();
					}
				} else {
					dialogClose();
				}
				return false;
			});
		}
		
		function dialogShow() {
			if (settings.onShow && typeof settings.onShow == "function") {
				if (settings.onShow($dialog) != false) {
					$dialog.show();
					$dialogOverlay.show();
				}
			} else {
				$dialog.show();
				$dialogOverlay.show();
			}
		}
		function dialogClose() {
			if (settings.onClose && typeof settings.onClose == "function") {
				if (settings.onClose($dialog) != false) {
					$dialogOverlay.remove();
					$dialog.remove();
				}
			} else {
				$dialogOverlay.remove();
				$dialog.remove();
			}
		}
		return $dialog;
	}
});


function check(obj){
	clearAlert();
	var $tableObj = $(obj).parentsUntil("table").parent().find("tbody");
	var error = 0;
	$tableObj.find(".not_null,.not_null_blank").next().find("input[type=text],textarea,select").each(function(i,n){
		var $chk =$(n).parentsUntil("tr").parent().find("input[name='d.indexs']")
		if($chk.length === 1){
			if($chk.attr("checked") === "checked"){
				if($(this).val().trim() === ""){
					error = error+1;
					$(this).addClass("alert");
					$(this).parentsUntil("td").addClass("alert");
				}
			}
		}else{
			if($(this).val().trim() === ""){
				error = error+1;
				$(this).addClass("alert");
				$(this).parentsUntil("td").addClass("alert");
			}
		}
	});
	
	var sameBox = new Array();
	$tableObj.find(".not_null,.not_null_blank").next().find("input[type=checkbox]").each(function(i,n){
		var $chk =$(n).parentsUntil("tr").parent().find("input[name='d.indexs']")
		if($chk.length === 1){
			if($chk.attr("checked") === "checked"){
				if($(n).parent().find(":checkbox[checked='checked']").length == 0){
					error = error+1;
					$(n).parent().addClass("alert");
				}
			}
		}else{
			if($(n).parent().find(":checkbox[checked='checked']").length == 0){
				error = error+1;
				$(n).parent().addClass("alert");
			}
		}
	});
	
	$tableObj.find("td[abbr]").each(function(i,n){
	
		var reg = $(n).attr("abbr");
		$(n).next().find("input[type=text],textarea,select").each(function(i,n){
			if($(n).val() === ""){
				return;
			}
			if(reg === "time"){
				if(isTime($(this).val().trim()) === false){
					error = error+1;
					$(n).addClass("alert");
				}
			}else if(reg === "date"){
				if(isDate($(this).val().trim()) === false){
					error = error+1;
					$(n).addClass("alert");
				}
			}else if(reg === "dateTime"){
				if(isDateTime($(this).val().trim()) === false){
					error = error+1;
					$(n).addClass("alert");
				}
			}else{
				var r = eval("regexEnum."+reg);
				if(r){
					var isValid = (new RegExp(r)).test($(this).val().trim());
					if(isValid === false){
						error = error+1;
						$(n).addClass("alert");
					}
				}
			}
		});
	});
	
	if(error > 0){
		$.message("warn","红色部分不能为空或录入不规范!");
		return false;
	}
	return true;
}

function clearAlert(){
	$(".alert").removeClass("alert");
}

function clearSearch(){
	$("input[name^='a.'],select[name^='a.'],textarea[name^='a.']").val("");
}

function clearEdit(){
	$("input[name^='d.'],select[name^='d.'],textarea[name^='d.']").val("");
}


function tableColor(){
	$(".list tbody tr").each(function(i,n){
		if(i%2 === 1){
			$(this).addClass("trback");
		}
	});
}

function message(code) {
	if (code != null) {
		var content = messages[code] != null ? messages[code] : code;
		return content;
	}
}

var messages = {
	"admin.message.success": "操作成功",
	"admin.message.error": "操作错误",
	"admin.dialog.ok": "确&nbsp;&nbsp;定",
	"admin.dialog.cancel": "取&nbsp;&nbsp;消",
	"admin.dialog.deleteConfirm": "您确定要删除吗？",
	"admin.dialog.clearConfirm": "您确定要清空吗？",
	"admin.browser.title": "选择文件",
	"admin.browser.upload": "本地上传",
	"admin.browser.parent": "上级目录",
	"admin.browser.orderType": "排序方式",
	"admin.browser.name": "名称",
	"admin.browser.size": "大小",
	"admin.browser.type": "类型",
	"admin.browser.select": "选择文件",
	"admin.upload.sizeInvalid": "上传文件大小超出限制",
	"admin.upload.typeInvalid": "上传文件格式不正确",
	"admin.upload.invalid": "上传文件格式或大小不正确",
	"admin.validate.required": "必填",
	"admin.validate.email": "E-mail格式错误",
	"admin.validate.url": "网址格式错误",
	"admin.validate.date": "日期格式错误",
	"admin.validate.dateISO": "日期格式错误",
	"admin.validate.pointcard": "信用卡格式错误",
	"admin.validate.number": "只允许输入数字",
	"admin.validate.digits": "只允许输入零或正整数",
	"admin.validate.minlength": "长度不允许小于{0}",
	"admin.validate.maxlength": "长度不允许大于{0}",
	"admin.validate.rangelength": "长度必须在{0}-{1}之间",
	"admin.validate.min": "不允许小于{0}",
	"admin.validate.max": "不允许大于{0}",
	"admin.validate.range": "必须在{0}-{1}之间",
	"admin.validate.accept": "输入后缀错误",
	"admin.validate.equalTo": "两次输入不一致",
	"admin.validate.remote": "输入错误",
	"admin.validate.integer": "只允许输入整数",
	"admin.validate.positive": "只允许输入正数",
	"admin.validate.negative": "只允许输入负数",
	"admin.validate.decimal": "数值超出了允许范围",
	"admin.validate.pattern": "格式错误",
	"admin.validate.extension": "文件格式错误"
};

function searchModalDialog(url){
	window.returnValue = "";
	return window.showModalDialog(url, window,"dialogWidth=1000px; dialogHeight=550px; center=yes;");
}
