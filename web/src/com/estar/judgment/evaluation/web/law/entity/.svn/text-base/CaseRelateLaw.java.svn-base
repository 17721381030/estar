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
@Table(name = "t_case_relate_law")
public class CaseRelateLaw implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String appealLawId;
	private String relateLaw;
	
	private String delFlag;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;

	public CaseRelateLaw() {
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
	
	@Column(name = "APPEAL_LAW_ID")
	public String getAppealLawId() {
		return appealLawId;
	}

	public void setAppealLawId(String appealLawId) {
		this.appealLawId = appealLawId;
	}

	
	@Column(name = "RELATE_LAW")
	public String getRelateLaw() {
		return relateLaw;
	}

	public void setRelateLaw(String relateLaw) {
		this.relateLaw = relateLaw;
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
	
}