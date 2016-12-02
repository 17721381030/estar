package com.estar.judgment.evaluation.web.law.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.entity.M2JudgmentInfo;
import com.estar.judgment.evaluation.web.law.entity.XajLaw;


public class XajLawDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	public XajLawDTO() {
	}

	public XajLawDTO(XajLaw t) {
		BeanUtils.copyProperties(t, this);
	}
	
	public XajLawDTO(XajLaw t,M2JudgmentInfo j) {
		BeanUtils.copyProperties(t, this);
		this.caseNumberYear = j.getCaseNumberYear();
	}
	
	private String id;
	private Integer caseId;
	private String caseNumber;
	private String standardErrors;
	private String laws;
	private String appraisalsPerson;
	private String appraisalsStatus;
	private String appraisalsCause;
	private String operatePerson;
	private Date operateDate;
	
	private Integer caseNumberYear;
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

	public String getStandardErrors() {
		return standardErrors;
	}

	public void setStandardErrors(String standardErrors) {
		this.standardErrors = standardErrors;
	}

	public String getLaws() {
		if(!StringUtils.nullOrBlank(laws)){
			laws = laws.replaceAll("\\s+", "\n");
		}
		return laws;
	}

	public void setLaws(String laws) {
		this.laws = laws;
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

	public Integer getCaseNumberYear() {
		return caseNumberYear;
	}

	public void setCaseNumberYear(Integer caseNumberYear) {
		this.caseNumberYear = caseNumberYear;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
}