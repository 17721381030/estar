package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "m2_judgment_info")
public class M2JudgmentInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String court;
	private String validFlag;
	private String title;
	private String caseNumber;
	private Integer caseNumberYear;
	private String cause;
	private String trialGroup;
	private Integer errorCount;
	private Integer warningCount; 
	
	public M2JudgmentInfo() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "assigned")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "COURT")
	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CASE_NUMBER")
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	@Column(name = "CASE_NUMBER_YEAR")
	public Integer getCaseNumberYear() {
		return caseNumberYear;
	}

	public void setCaseNumberYear(Integer caseNumberYear) {
		this.caseNumberYear = caseNumberYear;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "TRIAL_GROUP")
	public String getTrialGroup() {
		return trialGroup;
	}

	public void setTrialGroup(String trialGroup) {
		this.trialGroup = trialGroup;
	}

	@Column(name = "ERROR_COUNT")
	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
	
	@Column(name = "WARNING_COUNT")
	public Integer getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(Integer warningCount) {
		this.warningCount = warningCount;
	}

	@Column(name = "VALID_FLAG")
	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}