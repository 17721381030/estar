package com.estar.judgment.evaluation.web.law.dto;

import java.util.List;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;

public class LawDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String type;
	private String lawName;
	
	private List<LawItemDTO> lawItemList;
	public LawDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLawName() {
		return lawName;
	}

	public void setLawName(String lawName) {
		this.lawName = lawName;
	}

	public List<LawItemDTO> getLawItemList() {
		return lawItemList;
	}

	public void setLawItemList(List<LawItemDTO> lawItemList) {
		this.lawItemList = lawItemList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}