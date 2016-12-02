package com.estar.judgment.evaluation.web.law.dto;


import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.AllJudgmentError;
import com.estar.judgment.evaluation.web.law.entity.AllJudgmentInfo;
public class AllJudgmentInfoDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String court;
	private String title;
	private String validFlag;
	private String caseNumber;
	private Integer caseNumberYear;
	private String causeId;
	private String cause;
	private String trialGroup;
	private Integer errorCount;
	private Integer warningCount;
	private String courtroomAbbr;
	private String judgmentDate;
	private String errorContent;
	private String errorMessage;
	private String errorType;
	private String counter_claim_flag;
	private String trial_procedure;
	private String dismiss_flag;
	
	public AllJudgmentInfoDTO(AllJudgmentInfo t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public AllJudgmentInfoDTO(AllJudgmentInfo t,AllJudgmentError e) {
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
	
	public AllJudgmentInfoDTO() {
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
	public String getCauseId() {
		return causeId;
	}

	public void setCauseId(String causeId) {
		this.causeId = causeId;
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

	public String getJudgmentDate() {
		return judgmentDate;
	}

	public void setJudgmentDate(String judgmentDate) {
		this.judgmentDate = judgmentDate;
	}

	public String getCourtroomAbbr() {
		return courtroomAbbr;
	}

	public void setCourtroomAbbr(String courtroomAbbr) {
		this.courtroomAbbr = courtroomAbbr;
	}

	public String getCounter_claim_flag() {
		return counter_claim_flag;
	}

	public void setCounter_claim_flag(String counter_claim_flag) {
		this.counter_claim_flag = counter_claim_flag;
	}

	public String getTrial_procedure() {
		return trial_procedure;
	}

	public void setTrial_procedure(String trial_procedure) {
		this.trial_procedure = trial_procedure;
	}

	public String getDismiss_flag() {
		return dismiss_flag;
	}

	public void setDismiss_flag(String dismiss_flag) {
		this.dismiss_flag = dismiss_flag;
	}
	
	
}