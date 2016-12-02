package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "judgment")
public class AllJudgment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String judgmentContent;
	
	public AllJudgment() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "JUDGMENT_CONTENT")
	public String getJudgmentContent() {
		return judgmentContent;
	}

	public void setJudgmentContent(String judgmentContent) {
		this.judgmentContent = judgmentContent;
	}
	
	
	
}