package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "m2_judgment")
public class M2Judgment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String judgmentContent;
	
	public M2Judgment() {
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