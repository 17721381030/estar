var zTree;
$(document).ready(function(){
	tree_init("");
	$(".btn_add").click(function(){
		if(selectNodes() == false){
   			$.message("warn","请在树结构中选择一个结点.");
   			return false;
		}
		emptyElementValue();
	});

	$(".btn_del").click(function(){
		if(selectNodes() == false){
   			$.message("warn","请在树结构中选择一个结点.");
   			return false;
		}
		
		$.dialog({
			title: "删除结点",
			content: '确定要删除结点?',			
			width: 470,
			modal: true,
			ok: "确&nbsp;&nbsp;定",
			cancel: "取&nbsp;&nbsp;消",
			onOk: function() {
				delOrg();
			}
		});
	});
	
	$(".btn_refresh").click(function(){
		tree_init("");
	});
	
	$(".btnoperate").click(function(){
		if($("input[name='code']").val() === "" || $("input[name='name']").val()==="" ){
			$.message("warn","编码或名称为空.");
   			return false
		}
		if(selectNodes()){
			var fid = selectNodes();
			$("input[name=fid]").val(fid);
			var str = $("#aq_field").serialize();
			$.ajax({
		        url: "./org_modify.do?"+str,
		        type: "POST", dataType: "json",
		        error:function(a,b,c){alert(b);},
		        success: function(msg) {
		        	if(msg.status === "1"){
			        	var nodeid = msg.aqOrg.orgId;
			        	tree_init(nodeid);
			        	$.message("warn","操作成功！");
			        	emptyElementValue();
		        	}else{
		        		$.message("warn","编码或机构名称有重复！");
		        	}
		        }
	   		});
   		}else{
   			$.message("warn","请在树结构中选择一个父结点.");
   		}
	});
	
});
		
function tree_init(displayOrgId){
	var rootOrg = $("input[name='d.orgId']").val();
	$.ajax({
        url: "./org_list.do?dto.orgId="+rootOrg,
        type: "POST", dataType: "json",
        success: function(msg) {
        	zTree = $.fn.zTree.init($("#orgTree"), setting, msg.orgtree);
        	if(displayOrgId && "" !== displayOrgId){
	        	var sNodes = zTree.getNodesByParam("id", displayOrgId);
	        	zTree.expandNode(sNodes[0],true,true,null,null);
        	}
        }
    });
}

var setting = {
	view: {
		selectedMulti: false,
		showIcon:false
	},
	edit: {
		enable: true,
		showRemoveBtn: false,
		showRenameBtn: false,
		drag:{isMove:false,isCopy:false}
	},
	data: {
		keep: {
			parent:true,
			leaf:true
		},
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick
	}
};

function delOrg(){
	var id = selectNodes();
	$.ajax({
        url: "./org_remove.do?id="+id,
        type: "POST", dataType: "json",
        error:function(a,b,c){alert(b);},
        success: function(msg) {
        	$.message("warn","操作成功！");
        	tree_init("");
        	emptyElementValue();
        }
	});
}
	


function setElementValue(msg){
	$("input[name=id]").val(msg.aqOrg.orgId);
	$("input[name=code]").val(msg.aqOrg.code);
	$("input[name=name]").val(msg.aqOrg.name);
	$("input[name=full_name]").val(msg.aqOrg.fullName);
	$("input[name=phone]").val(msg.aqOrg.phone);
	$("input[name=fax]").val(msg.aqOrg.fax);
	$("input[name=address]").val(msg.aqOrg.address);
	$("input[name=description]").val(msg.aqOrg.description);
	$("select[name=org_type]").val(msg.aqOrg.orgType);
}

function emptyElementValue(){
	$("#aq_field input[type!=button]").val("");
	$("select").val("");
}

function selectNodes(){
	nodes = zTree.getSelectedNodes();
	if (nodes.length == 0) {
		return false;
	}
	return nodes[0].id;
}