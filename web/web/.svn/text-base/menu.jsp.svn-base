<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="cache-control" content="private" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/main.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form id="f" target="mainFrame"></form>
		<table id="table_menu">
			
		</table>
		
		<script src="js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			var path = '<%=path%>';
			$(function() {
				menuInit();
				
			});

			function menuInit(){
				$.ajax({
					url: path+"/module_userMenu.do",
			        type: "POST", dataType: "json",error:function(a,b,c){
					},
			        success: function(msg) {
						if(msg && msg.moduleList){
							for(var i = 0; i < msg.moduleList.length; i++){
								var menuObj = msg.moduleList[i];
								var htmlText = "<tr class=\"menu\">";
								htmlText += "<td  unselectable=\"on\" onselectstart=\"return false;\">";
								htmlText += "<img src=\"images/menu/"+menuObj.icon+"\" />"+menuObj.name;
								htmlText += "</td></tr>";

								var optList = menuObj.operateList;
								if(optList && optList.length > 0){
									for(var j = 0; j < optList.length; j++){
									    var optObj = optList[j];
									    var reg = new RegExp("[a-zA-Z]+://[^\\s]*");
									    if(optObj.url.match(reg) != null){
											htmlText += "<tr class=\"child-menu\">";
											htmlText += "<td unselectable='on' onselectstart='return false;'>";
											htmlText += "<a target='mainFrame' href=\""+optObj.url+"\">";
											htmlText += optObj.name;
											htmlText += "</a></td></tr>";
									    }else{
									    	htmlText += "<tr class=\"child-menu\">";
											htmlText += "<td abbr=\""+optObj.url+"\" unselectable=\"on\" onselectstart=\"return false;\">";
											htmlText += optObj.name;
											htmlText += "</td>";
											htmlText += "</tr>";
									    }
									}
								}
								$("#table_menu").append(htmlText);
							}
							<%-- 待删除 
								$("#table_menu").append("<tr id='demoMenu' class='menu'><td><img src='images/menu/icon_03.png'/><a href='http://172.16.45.136:88/' target='_blank'>批量评价报表</a></td></tr>");
							--%>
						}
						$(".child-menu").hide();
						$("#table_menu td").click(function(){
							if($(this).parent().hasClass("menu")){
								$(this).parent().nextUntil(".menu").toggle(200);
								<%-- 下面一行待删除 
								$("#demoMenu td").show(); 
								--%>
							}else{
								$("#table_menu tr").removeClass("menuTrSelected"); 
								$(this).parent().addClass("menuTrSelected");
								if($(this).attr("abbr")){
									$("#f").attr("action",path+"/"+$(this).attr("abbr")).submit();
								} 
							}
						});
						
						<%-- 下面一行待删除 --%>
						$("#demoMenu td").click(function(){})
						

						$("tr:first td").click();
			        }
			    });
			}
		</script>
  	</body>
</html>
