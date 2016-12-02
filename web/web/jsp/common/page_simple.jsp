<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<meta http-equiv="content-type" content="text/html;charset=gb2312"/>

  </head>
<body>
	<input type="hidden" name= "pageNo" value='<s:text name="pageNo"/>' />
	<input type="hidden" name= "pageTotal" value='<s:text name="pageTotal"/>' />
	<input type="hidden" name = "recTotal" value = '<s:text name="recTotal"/>' />
	<input type="hidden" name = "pageSize" value = '<s:text name="pageSize"/>' />
    <table style="margin-top:5px;width:92%">
    	<tbody>
		<tr>
            <td style="width:15%;vertical-align: middle;"><s:text name="pageNo"/>/<s:text name="pageTotal"/>&nbsp;页&nbsp;<br/>总记录数&nbsp;<s:text name="recTotal"/></td>
           	<td style="width:80%;text-align:right;vertical-align: middle;">
			 	<input type="text" name="gotoPage" size="3" value='<s:text name="pageNo"/>'  class="text" style="text-align:center;height:20px;line-height:20px;width:30px;padding:0px;margin-right:10px;"/>页 
			 	<span class="btn" onclick="goPage()" style="margin-left:10px;text-align:center;" >跳转</span>
			 	<span class="btn prePage" style="text-align:center;">上一页</span>
			 	<span class="btn nextPage" style="text-align:center;">下一页</span>
        	</td>
     	</tr>
     	</tbody>
	</table>
	
	<br/>
</body>
<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	var pagesize = $("input[name=pageSize]")[0];//document.getElementsByName("pageSize")[0];
	var gotopage = $("input[name=gotoPage]")[0];//document.getElementsByName("gotoPage")[0];
	var pageno = $("input[name=pageNo]")[0];//document.getElementsByName("pageNo")[0];
	$(function () {
		$(".prePage").click(function(){
			doPrePage();
		});
		$(".nextPage").click(function(){
			donextPage();
		});
	});
	function doPage(page) {
	    if (page < 1) {
	        alert("已是第一页！");
	        return;
	    }
	    if (page > <s:text name="pageTotal"/>) {
	        alert("已是最后一页！");
	        return;
	    }
	    if (!integerCheck(pagesize, "只能输入整型！")) {
	        return;
	    }
	    pageno.value = page;
	    document.forms[0].submit();
	}
	
	function goPage() {
	    var goPageNumber = document.getElementsByName("gotoPage")[0].value;
	    if (!integerCheck(gotopage, "只能输入整型！")) {
	        return;
	    }
	    if (goPageNumber < 1 || goPageNumber > <s:text name="pageTotal"/>) {
	        alert("请输入合法范围！");
	        return;
	    }
	    doPage(goPageNumber);
	}
	
	function validCheck(reg, obj, msg) {
	    if (!msg) {
	        return obj.match(reg);
	    }
	    var r = validCheck(reg, obj.value);
	    if (!r) hello(obj, msg);
	    return r;
	}
	
	function hello(obj, msg) {
	    alert(msg);
	    obj.focus();
	}
	
	//检查 只能输入整数值
	function integerCheck(obj, msg) {
	    var reg = /^([0-9])+$/;
	    return validCheck(reg, obj, msg);
	}
	
	function setPageSize() {
	    if (pagesize.value > 500) {
	        alert("最多只可以查询500条记录!");
	        return false;
	    }
	    doPage(1);
	}
	
	function doPrePage() {
	    var page = pageno.value;
	    doPage(page - 1);
	}
	
	function donextPage() {
	    var page = pageno.value;
	    doPage(Number(page) + 1);
	}
</script>
</html>
