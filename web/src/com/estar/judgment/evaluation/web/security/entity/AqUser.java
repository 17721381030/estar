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
@Table(name = "aq_user")
public class AqUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userCode;
	private String passwd;
	private String userName;
	private String userType;
	private String phone;
	private String description;
	private String isValid;
	private String orgId;
	
	private Date effectB;
	private Date effectE;
	private String effect;
	public AqUser() {
	}

	@Id
	@GeneratedValue(generator = "pg")
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "USER_ID", unique = true, nullable = false)
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Column(name = "USER_CODE", length = 50)
	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	@Column(name = "PASSWD",  length = 50)
	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Column(name = "USER_NAME",  length = 32)
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_TYPE",  length = 1)
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Column(name = "PHONE",  length = 100)
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name = "DESCRIPTION",  length = 500)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name = "IS_VALID",  length = 1)
	public String getIsValid() {
		return isValid;
	}


	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	@Column(name = "ORG_ID",  length = 60)
	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}



	@Column(name = "EFFECT_B")
	public Date getEffectB() {
		return effectB;
	}

	public void setEffectB(Date effectB) {
		this.effectB = effectB;
	}

	@Column(name = "EFFECT_E")
	public Date getEffectE() {
		return effectE;
	}

	public void setEffectE(Date effectE) {
		this.effectE = effectE;
	}

	@Column(name = "EFFECT")
	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDATE")
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


}