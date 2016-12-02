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
@Table(name = "aq_login_logs")
public class AqLoginLogs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String loginId;
	private String userId;
	private Long loginTime;
	private String ip;
	private String loginStatus;
	private String description;

	
	public AqLoginLogs() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "LOGIN_ID", unique = true, nullable = false)
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "LOGIN_TIME")
	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "IP")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "LOGIN_STATUS")
	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Column(name = "DESCRIPTION")
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

	

	
}