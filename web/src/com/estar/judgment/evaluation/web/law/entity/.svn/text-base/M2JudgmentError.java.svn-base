package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "m2_judgment_error")
public class M2JudgmentError implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer subId;
	private String errorContent;
	private Integer errorContent_id;
	private String errorMessage;
	private String errorType;
	
	
	public M2JudgmentError() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "assigned")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "SUB_ID")
	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	@Column(name = "ERROR_CONTENT")
	public String getErrorContent() {
		return errorContent;
	}

	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}

	@Column(name = "ERROR_CONTENT_ID")
	public Integer getErrorContent_id() {
		return errorContent_id;
	}

	public void setErrorContent_id(Integer errorContent_id) {
		this.errorContent_id = errorContent_id;
	}

	@Column(name = "error_message")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Column(name = "error_type")
	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
}