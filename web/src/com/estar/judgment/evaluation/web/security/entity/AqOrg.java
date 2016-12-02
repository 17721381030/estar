package com.estar.judgment.evaluation.web.security.entity;


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
@Table(name = "aq_org")
public class AqOrg implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String orgId;
	private String code;
	private String name;
	private String fullName;
	private String orgLevel;
	private String phone;
	private String fax;
	private String address;
	private String description;
	private String orgType;

	public AqOrg() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Column(name = "ORG_ID", unique = true, nullable = false, length = 60)
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "CODE", length = 60)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 60)
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "FULL_NAME", length = 200)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "ORG_LEVEL", length = 1)
	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	@Column(name = "PHONE", length = 100)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "FAX", length = 100)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	private String delFlag;
	private Date createdate;
	private String createby;
	private Date updatedate;
	private String updateby;
	@Column(name = "DEL_FLAG", length = 2)
	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE", length = 7)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "CREATEBY", length = 32)
	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDATE", length = 7)
	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Column(name = "UPDATEBY", length = 32)
	public String getUpdateby() {
		return this.updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	
	@Column(name = "ORG_TYPE")
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}