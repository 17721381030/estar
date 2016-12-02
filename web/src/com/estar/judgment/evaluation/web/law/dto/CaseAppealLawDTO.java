package com.estar.judgment.evaluation.web.law.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.CaseAppealLaw;


public class CaseAppealLawDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String appealKeyId;
	private String relateLaw;
	private Integer relateValue;
	private String affirmRelate;
	private String lawRelateDegree;
	private String issue;
	private String remark;
	private String delFlag;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private Integer quoteCount;
	private String lawContent;
	public CaseAppealLawDTO() {
	}
	
	public CaseAppealLawDTO(CaseAppealLaw t) {
		BeanUtils.copyProperties(t, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getAppealKeyId() {
		return appealKeyId;
	}

	public void setAppealKeyId(String appealKeyId) {
		this.appealKeyId = appealKeyId;
	}

	public String getRelateLaw() {
		return relateLaw==null?"":relateLaw;
	}

	public void setRelateLaw(String relateLaw) {
		this.relateLaw = relateLaw;
	}

	public Integer getRelateValue() {
		return relateValue==null?0:relateValue;
	}

	public void setRelateValue(Integer relateValue) {
		this.relateValue = relateValue;
	}

	public String getAffirmRelate() {
		return affirmRelate==null?"":affirmRelate;
	}

	public void setAffirmRelate(String affirmRelate) {
		this.affirmRelate = affirmRelate;
	}

	public String getLawRelateDegree() {
		return lawRelateDegree==null?"":lawRelateDegree;
	}

	public void setLawRelateDegree(String lawRelateDegree) {
		this.lawRelateDegree = lawRelateDegree;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getIssue() {
		return issue==null?"":issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getRemark() {
		return remark==null?"":remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getQuoteCount() {
		return quoteCount==null?0:quoteCount;
	}

	public void setQuoteCount(Integer quoteCount) {
		this.quoteCount = quoteCount;
	}

	public String getLawContent() {
		return lawContent==null?"":lawContent;
	}

	public void setLawContent(String lawContent) {
		this.lawContent = lawContent;
	}
	
}