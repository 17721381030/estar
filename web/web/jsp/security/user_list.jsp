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
	</head>
<body>
        <s:form action="user_list">
		<s:token />
		<input type="hidden" name="d.userId" />
		<input type="hidden" name="d.versionNo" />
		<%--查询条件div--%>
			<table class="query">
				<colgroup>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:20%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:20%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>
							工号:
						</th>
						<td>
							<s:textfield name="s.userCode" cssClass="text" />
						</td>
						<th>
							姓名:
						</th>
						<td>
							<s:textfield name="s.userName" cssClass="text" />
						</td>
						<th>
							机构
						</th>
						<td>
							<s:select list="s.orgList" cssClass="select" name="s.orgId" listKey="id" listValue="name" />
						</td>
						<td style="width:100px">
							<s:checkbox name="s.searchChildren" checked="true"></s:checkbox>(包含下级)
						</td>
						
					</tr>
				</tbody>
				<tfoot>
				<tr>
					<td colspan="7">
						<span class="btn add" >新增</span>
						<span class="btn clear" >清空</span>
						<span class="btn btnSearch" >查找</span>
					</td>
				</tr>
				</tfoot>
			</table>
			<table >
			<tr>
			<td style="vertical-align:top;width:80%">
				<table class="list">
					<colgroup>
						<col style="width:10%"/>
						<col style="width:30%"/>
						<col style="width:20%"/>
						<col style="width:30%"/>
						<col style="width:10%"/>
					</colgroup>
					<thead>
						<tr>
							<th style="width:30px">#</th>
							<th>所属公司</th>
							<th>工号</th>
							<th>姓名</th>
							<th style="width:50px">权限</th>
						</tr>
					</thead>
					<tbody>
						<s:if test="d.listResult == 2">
							<s:iterator id="dto" value="d.list" status="s">
								<tr>
									<input type="hidden" name="id" value='<s:property value="#dto.userId" />' />
									<td>
										<s:property value="(#s.index+1)" />
									</td>
									<td>
										<a href="#" onclick="openDeail('<s:property value="#dto.versionNo" />','<s:property value="#dto.userId" />')"><s:property value="#dto.orgName" /></a>
									</td>
									
									<td>
										<s:property value="#dto.userCode" />
									</td>
									<td>
										<s:property value="#dto.userName" />
									</td>
									<td >
										<span type="button" class="btn button a_opr" >权限</span>
									</td>
								</tr>
							</s:iterator>
						</s:if>
						<s:elseif test="d.listResult == 1">
							<tr>
								<td colspan="5" style="text-align: left; height: 20px;">
									<s:text name="page_not_fund_date" />
								</td>
							</tr>
						</s:elseif>
						<s:else>
							<tr>
								<td colspan="5" style="text-align: left; height: 20px;">
									<s:text name="page_wait_search" />
								</td>
							</tr>
						</s:else>
					</tbody>
				</table>
				<s:include value="/jsp/common/page.jsp"></s:include>
			</td>
			<td style="vertical-align:top;width:20%">
				<table class="list">
					<colgroup>
						<col style="width:20%"/>
						<col style="width:20%"/>
						<col style="width:60%"/>
					</colgroup>
					<thead>
						<tr>
							<th style="width:30px">选择</th>
							<th style="width:30px">#</th>
							<th>系统模块</th>
						</tr>
					</thead>
					<tbody id="qx">
					<tr><td colspan="3">&nbsp;</td></tr>
					</tbody>
					<tfoot>
						<tr><td colspan="3" style="text-align:center;padding:5px;"><span class="btn" id="qx_btn">保存</span></td></tr>
					</tfoot>
				</table>
			</td>
			</tr>
			</table>
			
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript">
		$(function () {
			$(".btnSearch").click(function() {
				$(".btnSearch").attr('disabled', "true");
				$("form:first").submit();
			});
			
			$(".clear").click(function() {
				clearSearch();
			});
			
			$(".add").click(function() {
				$("form:first").attr("action", "user_edit.do");
				$(".btn_add").attr('disabled', "true");
				$("form:first").submit();
			});
			
			$(".a_opr").click(function(){
				var id = $(this).parent().parent().find("input[name=id]").val();
				$.ajax({
			        url: "./user_user_module.do?id="+id, type: "POST", dataType: "json",
			        success: function(msg) {
			            createQxHtml(msg,id);
			        }
			    });
			});
			
			$("#qx_btn").click(function(){
				var userId = $("#qx input[name=userId]").val();
				var moduleId = "";
				$("#qx").find("input:checked").each(function(){
					moduleId = moduleId+ "&ids="+this.value;
				});
				var url = "userId="+userId+moduleId;
				$.ajax({
			        url: "./user_module_save.do?"+url, type: "POST", dataType: "json",
			        success: function(msg) {
			        	if(msg.addModulestatus == "1"){
			        		$.message("warn","成功");
			        	}
			        },error:function(a,b,c){alert(b);}
			    });
			});

			
		});

		function openDeail(versionNo,id){
			$("input[name='d.userId']").val(id);
			$("input[name='d.versionNo']").val(versionNo);
			$("form:first").attr("action", "user_edit.do");
			$("form:first").submit();
		}
		
		function createQxHtml(msg,id){
			$("#qx").empty();
			$("#qx").append("<input type = 'hidden' name='userId' value='"+id+"'/>");
			if(msg.userModulList.length > 0){
				for (var i = 0; i < msg.userModulList.length; i++) {
					var moduleId = msg.userModulList[i].moduleId;
					var moduleName = msg.userModulList[i].moduleName;
					var status = msg.userModulList[i].status;
					var checkstr = "";
					if("1"===status){
						checkstr = "checked='checked'";
					}
					var strTr = "<tr><td><input type='checkbox' "+ checkstr +" name='moduleIds' value='"+moduleId+"'/></td><td>"+(i+1)+"</td><td colspan='2'>"+moduleName+"</td></tr>";
					$("#qx").append(strTr);
				}
			}
		}
	</script>
	<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>
