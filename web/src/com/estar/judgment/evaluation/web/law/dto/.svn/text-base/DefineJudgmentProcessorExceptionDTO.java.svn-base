package com.estar.judgment.evaluation.web.law.dto;


import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;


public class DefineJudgmentProcessorExceptionDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String judgment_processor;
	private String exception;
	private String type;

	public DefineJudgmentProcessorExceptionDTO() {
	}
	
	public DefineJudgmentProcessorExceptionDTO( String judgment_processor,String exception,String type){
		this.judgment_processor = judgment_processor;
		this.exception = exception;
		this.type = type;
	}

	public String getJudgment_processor() {
		return judgment_processor;
	}

	public void setJudgment_processor(String judgment_processor) {
		this.judgment_processor = judgment_processor;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj )return true;
		if(obj == null) return false;
		if(!(obj instanceof DefineJudgmentProcessorExceptionDTO)) return false;
		DefineJudgmentProcessorExceptionDTO dpeD = (DefineJudgmentProcessorExceptionDTO)obj;
		if(judgment_processor.equalsIgnoreCase(dpeD.judgment_processor) &&
				exception.equalsIgnoreCase(dpeD.exception)&&
				type.equalsIgnoreCase(dpeD.type)){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result =1;
		result = PRIME*result+(judgment_processor == null?0:judgment_processor.hashCode());
		result = PRIME*result+(exception == null?0:exception.hashCode());
		result = PRIME*result+(type == null?0:type.hashCode());
		return result;
	}
}