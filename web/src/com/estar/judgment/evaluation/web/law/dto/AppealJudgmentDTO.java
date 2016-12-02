package com.estar.judgment.evaluation.web.law.dto;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
public class AppealJudgmentDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String appeal;
	private String appealType;
	private String judgment;
	private String isRelate;
	
	public AppealJudgmentDTO() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppeal() {
		return appeal;
	}
	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}
	public String getJudgment() {
		return judgment;
	}
	public void setJudgment(String judgment) {
		this.judgment = judgment;
	}

	public String getIsRelate() {
		return isRelate;
	}

	public void setIsRelate(String isRelate) {
		this.isRelate = isRelate;
	}

	public String getAppealType() {
		return appealType;
	}

	public void setAppealType(String appealType) {
		this.appealType = appealType;
	}
	
}