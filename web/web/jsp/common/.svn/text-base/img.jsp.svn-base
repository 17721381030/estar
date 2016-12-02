<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
  		<title>图片</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta http-equiv="cache-control" content="private" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/jquery.lightbox-0.5.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/swfupload-default.css"  />
		<link type="text/css" href="<%=path%>/css/styles.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />		
		<style type="text/css">
			
		</style>
  </head>
  <body style="text-align:center;">
  <br/>
  <input type="button" value = "添加照片" class="button" onclick="javascript:picLoad();" />
  <s:form id="mainForm">
  	<s:hidden name="d.id" />
  	<s:hidden name="s.pageType" />
  </s:form>
	<div id="gallery" style="margin-left: auto;margin-right: auto;">
	    <ul>
	    	<s:iterator id="dto" value="d.imgList" status="s">
	    		<li style="float:left;padding:3px">
	    			<div style="width:75px"><div style="width:75px">
	    			<input type = "hidden" name="id" value="<s:property value="#dto.id" />" /> 
		            <a href='<%=path%>/common_getImage.do?type=1&id=<s:property value="#dto.id" />' title='<s:property value="#dto.remark" />'>
		                <img src="<%=path%>/common_getImage.do?small=y&type=1&id=<s:property value="#dto.id" />" width="75px" height="75px" alt="" />
		            </a></div>
		            <div style="width:75px"><input type="button" class="button" onclick="remarkOclick(this);" value="备注"/></div></div>
		        </li>
	    	</s:iterator>
	    </ul>
	</div>
	<div id="dialog-form" class="hidden" title="图片备注"><textarea id="notionTxt" rows="8" cols="41"></textarea></div>
  </body>
  <script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/jquery/jquery.lightbox-0.5.pack.js"></script>
  <script type="text/javascript" src="<%=path%>/js/swfupload.js"></script>
  <script type="text/javascript" src="<%=path%>/js/handlers.js"></script>
  <script type="text/javascript" src="<%=path%>/js/app.js"></script>
  <script type="text/javascript">
 	var sysPath = '<%=path%>';
    $(function() {
        $('#gallery a').lightBox();
    });

    function picLoad(){
		var inputId = $("input[name='d.id']").val();
		var url=sysPath+"/file_upload.do"; //处理上传的servlet
		var sizeLimit="1 MB";// 文件的大小  注意: 中间要有空格
		var types="*.jpg;*.jpeg;*.gif;"; //注意是 " ; " 分割 
		var typesdesc="web iamge file"; //这里可以自定义
		var uploadLimit=20;  //上传文件的 个数
		initSwfupload(inputId,"1",url,sizeLimit,types,typesdesc,uploadLimit);
	}

	function refresh_pic(){
		refreshImg();
	}

	function refreshImg(){
		$("#mainForm").attr("action", "lpEval_imgView.do");
		$("#mainForm").submit();
	}
    </script>
</html>
