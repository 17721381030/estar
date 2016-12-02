package com.estar.judgment.evaluation.web.law.dto;


public class AppealJudgmentUtilDTO {

	private static final long serialVersionUID = 1L;
	private String type;
	private String content;
	private int dyNum;
	private String dyContent;
	public AppealJudgmentUtilDTO() {
	}

	public AppealJudgmentUtilDTO(String type,String content,int dyNum,String dyContent) {
		this.type = type;
		this.content = content;
		this.dyNum = dyNum;
		this.dyContent = dyContent;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDyNum() {
		return dyNum;
	}

	public void setDyNum(int dyNum) {
		this.dyNum = dyNum;
	}

	public String getDyContent() {
		return dyContent;
	}

	public void setDyContent(String dyContent) {
		this.dyContent = dyContent;
	}
}