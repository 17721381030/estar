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
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/themes/demo.css"/>
	</head>
<body style="background: #F2F2F2 none repeat scroll 0% 0%;">
<div id="cc" class="easyui-calendar"></div>
<s:form action="batchAnalysis_search">
		<s:token />
		<input type="hidden" name="d.id" />
		<%--查询条件div--%>
			<table class="query" style="background: #FAFAFA none repeat scroll 0% 0%;">
				<colgroup>
					<col style="width:8%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
					<col style="width:8%"/>
					<col style="width:15%"/>
					<col style="width:10%"/>
					<col style="width:15%"/>
				</colgroup>
				<tbody>
					<tr>
						<th>法院名称:</th><td ><s:textfield name="a.court" cssClass="text" /></td>
						<!-- <th>时&nbsp;&nbsp;&nbsp;&nbsp;间:</th><td ><s:textfield name="a.caseNumberYear" cssClass="text" /></td> -->
						<!-- <th>法&nbsp;&nbsp;&nbsp;&nbsp;庭:</th><td ><s:textfield name="a.courtroomAbbr" cssClass="text" /></td> -->
						<th>案&nbsp;&nbsp;&nbsp;&nbsp;号:</th><td ><s:textfield name="a.caseNumber" cssClass="text" /></td>
						<th>律师:</th><td ><s:textfield name="p.name" cssClass="text" /></td>
						<th>律所:</th><td ><s:textfield name="p.unit" cssClass="text" /></td>
					</tr>
					<tr>
						<th>案由:</th>
						<th>
							<select id="a.causeId" class="select" name="a.causeId">
								<option value="">----请选择案由----</option>
								<option value="ptelend">民间借贷纠纷</option>
								<option value="propservcont">物业服务合同纠纷</option>
								<option value="crcard">信用卡纠纷</option>
								<option value="finloancont">金融借款合同纠纷</option>
								<option value="teleservcont">电信服务合同纠纷</option>
								<option value="mototal">机动车交通事故责任纠纷</option>
								<option value="divoc">离婚纠纷</option>
								<option value="labocont">劳动合同纠纷</option>
								<option value="hosliscont">房屋租赁合同纠纷</option>
								<option value="bizcont">买卖合同纠纷</option>
							</select>
						</th>
						<th>审判人员:</th><td ><s:textfield name="a.trialGroup" cssClass="text" /></td>
						<th>
						审判日期:
						</th>
						<td>
						<input name="a.judgmentDate" id="startTime" value="<s:property value="startTime"/>" class="easyui-datebox" style ="height:27px; border: 1px solid #E1E1E1;" data-options="sharedCalendar:'#cc'"/>
						</td>
						<th>至</th>
						<td>
						<input name="a.judgmentDate" id="endTime" value="<s:property value="endTime"/>" class="easyui-datebox" style ="height:27px; border: 1px solid #E1E1E1;" data-options="sharedCalendar:'#cc'"/>
						</td>
						<th>&nbsp;</th>
					</tr>
					<tr id ="showTr" style ="display: none;">
						<th>审判程序:</th>
						<th>
							<select id="a.trial_procedure" class="select" name="a.trial_procedure">
								<option value="">全部</option>
								<option value="S">简易程序</option>
								<option value="G">普通程序</option>
							</select>
						</th>
						<th>反诉标识:</th>
						<th>
							<select id="a.counter_claim_flag" class="select" name="a.counter_claim_flag">
								<option value="">全部</option>
								<option value="Y">有反诉</option>
								<option value="N">无反诉</option>
							</select>
						</th>
						<th>驳回标识:</th>
						<th>
							<select id="a.dismiss_flag" class="select" name="a.dismiss_flag">
								<option value="">全部</option>
								<option value="A">全部驳回</option>
								<option value="P">部分驳回</option>
								<option value="N">全部支持</option>
							</select>
						</th>
					</tr>
					<tr style = "border-bottom: 1px dashed #E5E5E5;text-align: center;">
						<td colspan="10" style ="height:0px;">
							<a onclick='javascript:showAllTable()'><img id = "showImg" src ="<%=path%>/images/batchAnalysisList_down.png" /><img id = "hideImg" src ="<%=path%>/images/batchAnalysisList_up.png" style = "display: none;"/></a>
						</td>	
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="10" style ="padding-bottom: 12px; padding-top: 12px;">
							<span class="btn edit" style= "background: #B4AFAB none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;" >清空</span>
							<span class="btn btn_search" style= "background: #3DBDBD none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;">查询</span>
							<span class="btn btn_exp" style= "background: #ED7D2E none repeat scroll 0% 0%;color: #FFF;border-radius: 5px;border: medium none;" >导出</span>
						</td>
					</tr>
				</tfoot>
			</table>
		
			<table class="list" style = "margin-top:30px;">
				<thead>
					<tr>
						<th colspan="5">判决书总数:<s:text name="recTotal"/>篇&nbsp;&nbsp;/&nbsp;&nbsp;瑕疵判决书总数:<s:text name="judgmentDocNum"/>篇&nbsp;&nbsp;/&nbsp;&nbsp;瑕疵总数:<s:text name="judgmentDocErrorNum"/>个</th>
					</tr>
					<tr>
						<th style="width:300px">案号</th>
						<th>法院名称</th>
						<th>案由</th>
						<th>审判日期</th>
						<th>年度</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="d.listResult == 2">
						<s:iterator id="dto" value="d.list" status="s">
							<s:if test="#dto.errorCount > 0 || #dto.warningCount > 0 ">
							<tr class="error_tr">
							</s:if>
							<s:else>
							<tr>
							</s:else>
							<tr>
								<td>
									<a href="#" onclick="openDeail('<s:property value="#dto.id" />')"><s:property value="#dto.caseNumber" /></a>
								</td>
								<td><s:property value="#dto.court" /></td>
								<td><s:property value="#dto.cause" /></td>
								<td><s:property value="#dto.judgmentDate" /></td>
								<td><s:property value="#dto.caseNumberYear" /></td>
							</tr>
						</s:iterator>
					</s:if>
					<s:elseif test="dto.listResult == 1">
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
		</s:form>
		<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/app.js"></script>
		<script type="text/javascript" src="<%=path%>/js/themes/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/themes/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
			var path = '<%=path%>';
			$(function() {
				$(".btn_search").click(function() {
					var startTime=$("#startTime").datebox('getValue');
					var endTime=$("#endTime").datebox("getValue");
					if((!isNaN(startTime.replace("-","").replace("-","")))&&(!isNaN(endTime.replace("-","").replace("-","")))){
						if((startTime.length == 10 || startTime.length == 0) && (endTime.length == 10 || endTime.length == 0)){
							var start=new Date(startTime.replace("-", "/").replace("-", "/"));  
						    var end=new Date(endTime.replace("-", "/").replace("-", "/"));
						    if(end<start){
		        				alert("结束时间不能早于开始时间！");
		        				return;
		        			}
							$(".btn_search").attr('disabled', "true");
							$("form:first").submit();
						}else{
							alert("日期输入有误!");
							return;
						}
					}else{
						alert("日期输入有误!");
						return;
					}
					
				});
				
				$(".btn_exp").click(function() {
					var recTotal = $("input[name=recTotal]").val();
					if(!recTotal){
						$.message("warn","无数据导出!");
						return;
					}else if(recTotal === "0"){
						$.message("warn","无数据导出!");
						return;
					}else if(recTotal >= 5000){
						$.message("warn","查询结果数据量过大!");
						return;
					}
					
					$("form:first").attr("action","batchAnalysis_export.do");
					$(".btn_exp").attr('disabled', "true");
					$("form:first").submit();
					$("form:first").attr("action","batchAnalysis_search.do");
				});
				
				
				$(".edit").click(function() {
					clearSearch();
					$("#startTime").datebox('setValue',"");
					$("#endTime").datebox("setValue","");
				});
				$("#a\\.causeId").val("${a.causeId}");
				$("#a\\.trial_procedure").val("${a.trial_procedure}");
				$("#a\\.counter_claim_flag").val("${a.counter_claim_flag}");
				$("#a\\.dismiss_flag").val("${a.dismiss_flag}");
			});
			function openDeail(id){
				searchModalDialog("batchAnalysis_edit.do?d.id="+id);
			}
			
			function showAllTable(){
				if($("#showTr").is(":hidden")){
					$("#showTr").show(1000);
					$("#showImg").hide(1000);
					$("#hideImg").show(1000);
					
				}else{
					$("#showTr").hide(1000);
					$("#showImg").show(1000);
					$("#hideImg").hide(1000);
				}
				
			}
		</script>
		<div id="pageMsg" class="hidden"><s:if test='#request.msg!= null&&#request.msg!=""'>${msg}</s:if></div>
</body>
</html>