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
@Table(name = "aq_ip_prohibit")
public class AqIpProhibit implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String prohibitId;
	private String description;
	private String ipS;
	private String ipE;

	
	public AqIpProhibit() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "PROHIBIT_ID", unique = true, nullable = false)
	
	public String getProhibitId() {
		return prohibitId;
	}

	public void setProhibitId(String prohibitId) {
		this.prohibitId = prohibitId;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IP_S")
	public String getIpS() {
		return ipS;
	}

	public void setIpS(String ipS) {
		this.ipS = ipS;
	}

	@Column(name = "IP_E")
	public String getIpE() {
		return ipE;
	}

	public void setIpE(String ipE) {
		this.ipE = ipE;
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