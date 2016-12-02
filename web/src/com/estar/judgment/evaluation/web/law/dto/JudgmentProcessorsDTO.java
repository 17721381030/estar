package com.estar.judgment.evaluation.web.law.dto;

import java.util.List;

import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorInfo;

public class JudgmentProcessorsDTO  {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String isValidCount;
	private String isNotValidCount;
	private List<JudgmentProcessorInfo> processorList;
	
	public JudgmentProcessorsDTO(){
	}
	
	public JudgmentProcessorsDTO( String name,String isValidCount,String isNotValidCount,List<JudgmentProcessorInfo> processorList){
		this.name = name;
		this.isValidCount = isValidCount;
		this.isNotValidCount = isNotValidCount;
		this.processorList = processorList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsValidCount() {
		return isValidCount;
	}
	public void setIsValidCount(String isValidCount) {
		this.isValidCount = isValidCount;
	}
	public String getIsNotValidCount() {
		return isNotValidCount;
	}
	public void setIsNotValidCount(String isNotValidCount) {
		this.isNotValidCount = isNotValidCount;
	}
	public List<JudgmentProcessorInfo> getProcessorList() {
		return processorList;
	}
	public void setProcessorList(List<JudgmentProcessorInfo> processorList) {
		this.processorList = processorList;
	}
	
	
	
	

}