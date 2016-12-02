package com.estar.judgment.evaluation.web.law.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.Xaj;


public class XajDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	public XajDTO() {
	}

	public XajDTO(Xaj t) {
		BeanUtils.copyProperties(t, this);
	}
	
	private String id;
	private String type;
	private String appealType;
	private Integer caseId;
	private String caseNumber;
	private String errors;
	private String standardCaseNumber;
	private String tableType;
	private String standardErrors;
	private String appraisalsPerson;
	private String appraisalsStatus;
	private String appraisalsCause;
	private String operatePerson;
	private Date operateDate;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getStandardCaseNumber() {
		return standardCaseNumber;
	}

	public void setStandardCaseNumber(String standardCaseNumber) {
		this.standardCaseNumber = standardCaseNumber;
	}

	public String getStandardErrors() {
		return standardErrors;
	}

	public void setStandardErrors(String standardErrors) {
		this.standardErrors = standardErrors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppealType() {
		return appealType;
	}

	public void setAppealType(String appealType) {
		this.appealType = appealType;
	}

	public String getAppraisalsPerson() {
		return appraisalsPerson;
	}

	public void setAppraisalsPerson(String appraisalsPerson) {
		this.appraisalsPerson = appraisalsPerson;
	}

	public String getAppraisalsStatus() {
		return appraisalsStatus;
	}

	public void setAppraisalsStatus(String appraisalsStatus) {
		this.appraisalsStatus = appraisalsStatus;
	}

	public String getAppraisalsCause() {
		return appraisalsCause;
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

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
}