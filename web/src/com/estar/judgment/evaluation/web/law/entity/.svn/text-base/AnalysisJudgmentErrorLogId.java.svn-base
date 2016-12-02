package com.estar.judgment.evaluation.web.law.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class AnalysisJudgmentErrorLogId implements Serializable{
	
	private Integer id;
	private Integer subId;
	
	public AnalysisJudgmentErrorLogId(){}
	
	public AnalysisJudgmentErrorLogId(Integer id, Integer subId) {
		super();
		this.id = id;
		this.subId = subId;
	}

	@Column(name = "ID")
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AnalysisJudgmentErrorLogId){
			AnalysisJudgmentErrorLogId key = (AnalysisJudgmentErrorLogId)obj;
			if(this.id.equals(key.getId()) && this.subId.equals(key.getSubId())){
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.subId.hashCode();
	}
}
