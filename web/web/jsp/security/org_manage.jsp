<%@ page pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link type="text/css" href="<%=path%>/css/common.css" rel="stylesheet" />
		<link type="text/css" href="<%=path%>/css/tree/zTreeStyle.css" rel="stylesheet" />
	</head>
<body>
	<table>
		<tbody>
			<tr>
			<td style="width:400px;height:420px;vertical-align:top;">
				<table class="edit">
					<thead>
						<tr>
							<th>机构树</th><th style="text-align:right"><span class="btn btn_add">新增</span><span class="btn btn_refresh">刷新</span></th>
						</tr>
					</thead>
					<tbody>	
						<tr>
							<td colspan="2">
								<div style="margin-top:5px;height:400px;overflow:auto">
									<ul id="orgTree" class="ztree"></ul>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
			<td style="vertical-align:top">
				<form action="./org_modify.do" id="aq_field">
				<s:hidden name="fid"/>
				<s:hidden name="id"/>
				<s:hidden name="d.orgId" value="1"/>
				<table class="edit">
					<thead >
						<tr>
							<th colspan="6">节点详情</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="not_null">编码</td>
							<td><s:textfield cssClass="text" name="code"/></td>
							<td class="not_null">机构名</td>
							<td><s:textfield cssClass="text" name="name"/></td>
							<td>传真</td>
							<td><s:textfield cssClass="text" name="fax"/></td>
						</tr>
						<tr>
							<td>电话</td>
							<td><s:textfield cssClass="text" name="phone"/></td>
							<td>机构全名</td>
							<td colspan="3"><s:textfield cssClass="text" name="full_name"/></td>
						</tr>
						<tr>
							<td >机构类型</td>
							<td >
								<s:select  list="#{1:'保险公司',2:'修理厂',3:'客服'}" cssClass="select" listKey="key" listValue="value" name="org_type" listKey="key" listValue="value" />
							</td>
							<td >地址</td>
							<td  colspan="3"><s:textfield cssClass="text"  name="address"/></td>
						</tr>
						<tr>
							<td >描述</td>
							<td  colspan="5"><s:textfield cssClass="text"  name="description"/></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" style="text-align:center">
								<span class="btn btnoperate">保存</span>
								<span class="btn btn_del">删除</span>
							</td>
						</tr>
					</tfoot>
				</table>
				</form>
			</td>
			</tr>
		</tbody>
	</table>
	
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/app.js"></script>
	<script type="text/javascript">
		function onClick(event, treeId, treeNode, clickFlag) {
			$("input[name=fid]").val(treeNode.id);
			$.ajax({
		        url: "./org_edit.do?id="+treeNode.id,
		        type: "POST", dataType: "json",
		        error:function(a,b,c){alert(b);},
		        success: function(msg) {
		        	setElementValue(msg);
		        }
		    });
		}
	</script>
	<script type="text/javascript" src="<%=path%>/js/org.js"></script>
</body>
</html>
