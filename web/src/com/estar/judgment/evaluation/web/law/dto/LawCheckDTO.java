package com.estar.judgment.evaluation.web.law.dto;



import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;


public class LawCheckDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String law;
	private String isCheck;
	
	public LawCheckDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLaw() {
		return law;
	}

	public void setLaw(String law) {
		this.law = law;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	
}