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
@Table(name = "aq_logs")
public class AqLogs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String logsId;
	private Long logTime;
	private String description;
	
	
	public AqLogs() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "LOGS_ID", unique = true, nullable = false)
	public String getLogsId() {
		return logsId;
	}

	public void setLogsId(String logsId) {
		this.logsId = logsId;
	}

	@Column(name = "LOG_TIME")
	public Long getLogTime() {
		return logTime;
	}

	public void setLogTime(Long logTime) {
		this.logTime = logTime;
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