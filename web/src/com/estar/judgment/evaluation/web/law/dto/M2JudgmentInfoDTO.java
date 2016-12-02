package com.estar.judgment.evaluation.web.law.dto;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.M2JudgmentError;
import com.estar.judgment.evaluation.web.law.entity.M2JudgmentInfo;
public class M2JudgmentInfoDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String court;
	private String title;
	private String validFlag;
	private String caseNumber;
	private Integer caseNumberYear;
	private String cause;
	private String trialGroup;
	private Integer errorCount;
	private Integer warningCount; 
	private String errorContent;
	private String errorMessage;
	private String errorType;
	
	public M2JudgmentInfoDTO(M2JudgmentInfo t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public M2JudgmentInfoDTO(M2JudgmentInfo t,M2JudgmentError e) {
		try {
			BeanUtils.copyProperties(this,t);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		this.errorContent = e.getErrorContent();
		this.errorMessage = e.getErrorMessage();
		this.errorType = e.getErrorType();
	}
	
	public M2JudgmentInfoDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Integer getCaseNumberYear() {
		return caseNumberYear;
	}

	public void setCaseNumberYear(Integer caseNumberYear) {
		this.caseNumberYear = caseNumberYear;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getTrialGroup() {
		return trialGroup;
	}

	public void setTrialGroup(String trialGroup) {
		this.trialGroup = trialGroup;
	}

	public String getErrorContent() {
		return errorContent;
	}

	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public Integer getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(Integer warningCount) {
		this.warningCount = warningCount;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	
	
}