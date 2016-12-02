package com.estar.judgment.evaluation.web.security.dto;


import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.security.entity.AqModule;



public class AqModuleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String moduleId;
	private String name;
	private String description;
	private Integer ord;
	private String delFlag;
	private Date createdate;
	private String createby;
	private Date updatedate;
	private String updateby;
	private String icon;
	private List<AqOperateDTO> operateList;
	
	public AqModuleDTO() {
		
	}
	
	public AqModuleDTO(AqModule t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public List<AqOperateDTO> getOperateList() {
		return operateList;
	}
	
	public void setOperateList(List<AqOperateDTO> operateList) {
		this.operateList = operateList;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}


	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		return this;
	}
}