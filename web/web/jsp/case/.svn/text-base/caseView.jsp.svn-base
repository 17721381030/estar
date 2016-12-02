<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<base target="_self" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/js/jquery/jquery-ui.css" rel="stylesheet" />
		<style type="text/css">
			
		</style>
	</head>
	<body>
		
		
		<table class="query">
			<tbody>
				<tr>
					<td style="width:20%">
						<select class="select" id="case_cause"></select>
					</td>
					<td style="width:20%">
						<select class="select" id="case_keywords">
						</select>
					</td>
					<td style="width:20%">
						<input type="text" id="case_lawArticle" name="lawArticle" class="text" style ="height:28px;"/>
					</td>
					<td style="width:40%">
						<span class="btn btn_search" style= "background: #13A844 none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;">查询</span>
					</td>
				</tr>
			
			</tbody>
		<tfoot>
		</tfoot>						
		</table>
				
		<table class="list" style ="width:94%;margin-left:14px;">
			<thead>
				<tr>
					<th style="text-align:center">#</th>
					<th>相关法条</th>
					<th style="text-align:right;padding-right:4px;">相关值</th>
					<th>引用次数</th>
				</tr>
			</thead>
			<tbody id = "appealBody">
				<tr><td colspan="3">请选择</td></tr>
			</tbody>
		</table>
		<form id="right" method="post">
			<input type="hidden" name = "d.lawArticle" />
			<input type="hidden" name = "d.appealKey" />
			<input type="hidden" name = "d.causeName" />
			<input type="hidden" name = "d.causeId" />
			<input type="hidden" name = "d.appealKeyId" />
			<input type="hidden" name = "d.lawArticleId" />
		</form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
			var sysPath = '<%=path%>';
		</script>
		<script type="text/javascript" src="<%=path%>/js/case.js"></script>
		<script type="text/javascript" src="<%=path%>/js/caseRelate.js"></script>
	</body>
</html>