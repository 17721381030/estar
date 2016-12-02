package com.estar.judgment.evaluation.web.law.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "u_feedback")
public class UserFeedBack implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String judgmentContent;
	private String errorMessage;
	private String userSuggest;
	private Date createDate;
	
	public UserFeedBack(String judgmentContent,String errorMessage,String userSuggest) {
		this.judgmentContent = judgmentContent;
		this.errorMessage = errorMessage;
		this.userSuggest = userSuggest;
		this.createDate = new Date();
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "judgment_content")
	public String getJudgmentContent() {
		return judgmentContent;
	}

	public void setJudgmentContent(String judgmentContent) {
		this.judgmentContent = judgmentContent;
	}

	@Column(name = "error_message")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Column(name = "user_suggest")
	public String getUserSuggest() {
		return userSuggest;
	}

	public void setUserSuggest(String userSuggest) {
		this.userSuggest = userSuggest;
	}

	@Column(name = "createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
