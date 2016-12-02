package com.estar.judgment.evaluation.web.law.dto;


import com.estar.judgment.appealjudgment.JudgmentCheckError;
import com.estar.judgment.appliedlaw.AppliedLawException;
import com.estar.judgment.util.exception.InvalidJudgmentReportException;
import com.estar.judgment.util.message.MessageType;


public class ArticleReportDTO {

	private static final long serialVersionUID = 1L;
	private String type;
	private String content;
	private String msg;
	private String detailContent;
	
	private String tableType;
	private String rowId;
	private String standardErrors;
	private String appraisalsPerson;
	private String appraisalsStatus;
	private String appraisalsCause;
	private String operatePerson;
	private String operateDate;
	
	public ArticleReportDTO() {
	}

	public ArticleReportDTO(InvalidJudgmentReportException e) {
		super();
		if(MessageType.INFORMATION != e.getUserDefinedType()){
			this.msg = e.getMessage();
		}else{
			this.msg = "";
		}
		this.content = e.getErrorContent().getName();
		this.detailContent = e.getErrorContent().getName();
		this.type = e.getUserDefinedType().getId();
	}
	
	public ArticleReportDTO(JudgmentCheckError e) {
		super();
		if(MessageType.INFORMATION != e.getUserDefinedType()){
			this.msg = e.getMessage();
		}else{
			this.msg = "";
		}
		this.content = e.getErrorContent().getName();
		this.type = e.getUserDefinedType().getId();
		this.detailContent = e.getErrorContent().getName();
		
		this.tableType = "x_aj";
//		this.rowId = e.getRowId();
//		this.standardErrors = e.getStandardErrors();
//		this.appraisalsPerson = e.getAppraisalsPerson();
//		this.appraisalsStatus = e.getAppraisalsStatus();
//		this.appraisalsCause = e.getAppraisalsCause();
//		this.operatePerson = e.getOperatePerson();
//		this.operateDate = e.getOperateDate();
		
	}
	
	public ArticleReportDTO(AppliedLawException e) {
		super();
		if(MessageType.INFORMATION != e.getUserDefinedType()){
			this.msg = e.getMessage();
		}else{
			this.msg = "";
		}
		this.content = e.getErrorContent().getName();
		this.type = e.getUserDefinedType().getId();
		this.detailContent = e.getErrorContent().getName();
		
		this.tableType = "x_aj_law";
//		this.rowId = e.getRowId();
//		this.standardErrors = e.getStandardErrors();
//		this.appraisalsPerson = e.getAppraisalsPerson();
//		this.appraisalsStatus = e.getAppraisalsStatus();
//		this.appraisalsCause = e.getAppraisalsCause();
//		this.operatePerson = e.getOperatePerson();
//		this.operateDate = e.getOperateDate();
	}

	public String getDetailContent() {
		return detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getStandardErrors() {
		return standardErrors;
	}

	public void setStandardErrors(String standardErrors) {
		this.standardErrors = standardErrors;
	}

	public String getAppraisalsPerson() {
		return appraisalsPerson;
	}

	public void setAppraisalsPerson(String appraisalsPerson) {
		this.appraisalsPerson = appraisalsPerson;
	}

	public String getAppraisalsStatus() {
		return appraisalsStatus==null?"":appraisalsStatus;
	}

	public void setAppraisalsStatus(String appraisalsStatus) {
		this.appraisalsStatus = appraisalsStatus;
	}

	public String getAppraisalsCause() {
		return appraisalsCause==null?"":appraisalsCause;
	}

	public void setAppraisalsCause(String appraisalsCause) {
		this.appraisalsCause = appraisalsCause;
	}

	public String getOperatePerson() {
		return operatePerson;
	}

	public void setOperatePerson(String operatePerson) {
		this.operatePerson = operatePerson;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

}