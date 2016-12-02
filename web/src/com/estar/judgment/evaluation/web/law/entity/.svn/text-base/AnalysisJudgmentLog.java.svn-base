package com.estar.judgment.evaluation.web.law.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_judgment_log")
public class AnalysisJudgmentLog implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String judgmentContent;
	
	private String  court;
	
	private String caseNumber;
	
	private Date createDate;
	
	public AnalysisJudgmentLog(String judgmentContent,String court,String caseNumber) {
		this.judgmentContent = judgmentContent;
		this.court = court;
		this.caseNumber = caseNumber;
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
	
	@Column(name = "court")
	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	@Column(name = "case_number")
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	@Column(name = "createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	

}
