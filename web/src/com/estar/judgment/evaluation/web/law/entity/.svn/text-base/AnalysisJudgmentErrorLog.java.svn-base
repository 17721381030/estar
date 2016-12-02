package com.estar.judgment.evaluation.web.law.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "a_judgmentError_log")
public class AnalysisJudgmentErrorLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private AnalysisJudgmentErrorLogId id;
	private String 	errorContent;
	private String 	errorDetailContent;
	private Integer errorContentId;
	private String 	errorMessage;
	private String 	errorType;
	private String  userDefinedType;
	private String  modifyFlag;
	
	public AnalysisJudgmentErrorLog(){
		
	}
	
	public AnalysisJudgmentErrorLog(AnalysisJudgmentErrorLogId id, String errorContent,
			String errorDetailContent, Integer errorContentId,
			String errorMessage, String errorType,String userDefinedType,String modifyFlag ) {
		super();
		this.id = id;
		this.errorContent = errorContent;
		this.errorDetailContent = errorDetailContent;
		this.errorContentId = errorContentId;
		this.errorMessage = errorMessage;
		this.errorType = errorType;
		this.userDefinedType = userDefinedType;
		this.modifyFlag = modifyFlag;
	}

	@Id
	public AnalysisJudgmentErrorLogId getId() {
		return id;
	}

	public void setId(AnalysisJudgmentErrorLogId id) {
		this.id = id;
	}

	@Column(name = "ERROR_CONTENT")
	public String getErrorContent() {
		return errorContent;
	}

	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}

	@Column(name = "ERROR_DETAIL_CONTENT")
	public String getErrorDetailContent() {
		return errorDetailContent;
	}

	public void setErrorDetailContent(String errorDetailContent) {
		this.errorDetailContent = errorDetailContent;
	}
	
	@Column(name = "ERROR_CONTENT_ID")
	public Integer getErrorContentId() {
		return errorContentId;
	}

	public void setErrorContentId(Integer errorContentId) {
		this.errorContentId = errorContentId;
	}

	@Column(name = "ERROR_MESSAGE")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Column(name = "ERROR_TYPE")
	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	@Column(name = "USER_DEFINED_ERROR_TYPE")
	public String getUserDefinedType() {
		return userDefinedType;
	}

	public void setUserDefinedType(String userDefinedType) {
		this.userDefinedType = userDefinedType;
	}
	
	@Column(name = "MODIFY_FLAG")
	public String getModifyFlag() {
		return modifyFlag;
	}

	public void setModifyFlag(String modifyFlag) {
		this.modifyFlag = modifyFlag;
	}
	
}
