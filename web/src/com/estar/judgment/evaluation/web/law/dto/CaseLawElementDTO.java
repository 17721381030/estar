package com.estar.judgment.evaluation.web.law.dto;


import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.CaseLawElement;


public class CaseLawElementDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String appealLawId;
	private String lawElement;
	
	private String delFlag;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;

	public CaseLawElementDTO() {
	}
	
	public CaseLawElementDTO(CaseLawElement t) {
		BeanUtils.copyProperties(t, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAppealLawId() {
		return appealLawId;
	}

	public void setAppealLawId(String appealLawId) {
		this.appealLawId = appealLawId;
	}

	public String getLawElement() {
		return lawElement==null?"":lawElement;
	}

	public void setLawElement(String lawElement) {
		this.lawElement = lawElement;
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
}