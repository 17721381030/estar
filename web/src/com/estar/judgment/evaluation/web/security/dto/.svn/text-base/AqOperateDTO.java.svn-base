package com.estar.judgment.evaluation.web.security.dto;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.security.entity.AqOperate;




public class AqOperateDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String operateId;
	private String moduleId;
	private String name;
	private String url;
	private String type;
	private String delFlag;
	private Date createdate;
	private String createby;
	private Date updatedate;
	private String updateby;
	private Integer ord;
	@SuppressWarnings("unchecked")
	private List moduleList;
	
	@SuppressWarnings("unchecked")
	public List getModuleList() {
		return moduleList;
	}

	@SuppressWarnings("unchecked")
	public void setModuleList(List moduleList) {
		this.moduleList = moduleList;
	}

	public AqOperateDTO() {
	}

	public AqOperateDTO(AqOperate t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public String getOperateId() {
		return operateId;
	}

	public void setOperateId(String operateId) {
		this.operateId = operateId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}
}