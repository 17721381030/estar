package com.estar.judgment.evaluation.web.law.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_case_appeal_law")
public class CaseAppealLaw implements java.io.Serializable {

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
	public CaseAppealLaw() {
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

	@Column(name = "APPEAL_KEY_ID")
	public String getAppealKeyId() {
		return appealKeyId;
	}

	public void setAppealKeyId(String appealKeyId) {
		this.appealKeyId = appealKeyId;
	}

	@Column(name = "RELATE_LAW")
	public String getRelateLaw() {
		return relateLaw;
	}

	public void setRelateLaw(String relateLaw) {
		this.relateLaw = relateLaw;
	}

	@Column(name = "RELATE_VALUE")
	public Integer getRelateValue() {
		return relateValue;
	}

	public void setRelateValue(Integer relateValue) {
		this.relateValue = relateValue;
	}

	@Column(name = "AFFIRM_RELATE")
	public String getAffirmRelate() {
		return affirmRelate;
	}

	public void setAffirmRelate(String affirmRelate) {
		this.affirmRelate = affirmRelate;
	}

	@Column(name = "LAW_RELATE_DEGREE")
	public String getLawRelateDegree() {
		return lawRelateDegree;
	}

	public void setLawRelateDegree(String lawRelateDegree) {
		this.lawRelateDegree = lawRelateDegree;
	}

	@Column(name = "DEL_FLAG", length = 1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_BY")
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "ISSUE")
	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark==null?"":remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "QUOTE_COUNT")
	public Integer getQuoteCount() {
		return quoteCount;
	}

	public void setQuoteCount(Integer quoteCount) {
		this.quoteCount = quoteCount;
	}

	@Column(name = "LAW_CONTENT")
	public String getLawContent() {
		return lawContent;
	}

	public void setLawContent(String lawContent) {
		this.lawContent = lawContent;
	}
	
	
}