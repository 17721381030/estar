package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.law.dto.DefineJudgmentProcessorExceptionDTO;


@Entity
@Table(name = "define_judgment_processor_exception")
public class DefineJudgmentProcessorException implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private String judgment_processor;
	private String exception;
	private String type;
	
	public DefineJudgmentProcessorException() {
		
		
	}
	
	public DefineJudgmentProcessorException(DefineJudgmentProcessorExceptionDTO dpedto) {
		BeanUtils.copyProperties(dpedto, this);
	}
	@Id
	@Column(name = "judgment_processor")
	public String getJudgment_processor() {
		return judgment_processor;
	}

	public void setJudgment_processor(String judgment_processor) {
		this.judgment_processor = judgment_processor;
	}
	
	@Id
	@Column(name = "exception")
	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
}
