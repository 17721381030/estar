package com.estar.judgment.evaluation.web.law.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.CaseAppealKey;



public class CaseAppealKeyDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String causeId;
	private String keyWords;
	private String delFlag;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private Integer appearCount;
	public CaseAppealKeyDTO() {
	}
	
	public CaseAppealKeyDTO(CaseAppealKey t) {
		BeanUtils.copyProperties(t, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCauseId() {
		return causeId;
	}

	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
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

	public Integer getAppearCount() {
		return appearCount==null?0:appearCount;
	}

	public void setAppearCount(Integer appearCount) {
		this.appearCount = appearCount;
	}
	
	
}