package com.estar.judgment.evaluation.web.law.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "x_aj")
public class Xaj implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private Integer caseId;
	private String caseNumber;
	private String errors;
	private String standardCaseNumber;
	private String standardErrors;
	
	private String appraisalsPerson;
	private String appraisalsStatus;
	private String appraisalsCause;
	private String operatePerson;
	private Date operateDate;
	
	public Xaj() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CASE_ID")
	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	@Column(name = "CASE_NUMBER")
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	@Column(name = "ERRORS")
	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	@Column(name = "STANDARD_CASE_NUMBER")
	public String getStandardCaseNumber() {
		return standardCaseNumber;
	}

	public void setStandardCaseNumber(String standardCaseNumber) {
		this.standardCaseNumber = standardCaseNumber;
	}

	@Column(name = "STANDARD_ERRORS")
	public String getStandardErrors() {
		return standardErrors;
	}

	public void setStandardErrors(String standardErrors) {
		this.standardErrors = standardErrors;
	}

	@Column(name = "APPRAISALS_PERSON")
	public String getAppraisalsPerson() {
		return appraisalsPerson;
	}

	public void setAppraisalsPerson(String appraisalsPerson) {
		this.appraisalsPerson = appraisalsPerson;
	}

	@Column(name = "APPRAISALS_STATUS")
	public String getAppraisalsStatus() {
		return appraisalsStatus;
	}

	public void setAppraisalsStatus(String appraisalsStatus) {
		this.appraisalsStatus = appraisalsStatus;
	}

	@Column(name = "APPRAISALS_CAUSE")
	public String getAppraisalsCause() {
		return appraisalsCause;
	}

	public void setAppraisalsCause(String appraisalsCause) {
		this.appraisalsCause = appraisalsCause;
	}

	@Column(name = "OPERATE_PERSON")
	public String getOperatePerson() {
		return operatePerson;
	}

	public void setOperatePerson(String operatePerson) {
		this.operatePerson = operatePerson;
	}

	@Column(name = "OPERATE_DATE")
	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

}