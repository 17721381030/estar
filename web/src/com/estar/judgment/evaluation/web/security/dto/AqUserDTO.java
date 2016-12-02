package com.estar.judgment.evaluation.web.security.dto;


import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.security.entity.AqOrg;
import com.estar.judgment.evaluation.web.security.entity.AqUser;



public class AqUserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userCode;
	private String passwd;
	private String newPasswd;
	private String userName;
	private String userType;
	private String phone;
	private String description;
	private String isValid;
	private String orgId;
	private String orgCode;
	private String orgName;
	private String orgPId;
	private String orgPCode;
	private String orgPName;
	private String delFlag;
	private Date createdate;
	private String createby;
	private Date updatedate;
	private String updateby;
	private String searchChildren;
	private String strModule;
	private String loginStatus;
	private Date effectB;
	private Date effectE;
	private String effect;
	@SuppressWarnings("unchecked")
	private List orgList;
	
	@SuppressWarnings("unchecked")
	public List getOrgList() {
		return orgList;
	}


	@SuppressWarnings("unchecked")
	public void setOrgList(List orgList) {
		this.orgList = orgList;
	}


	public AqUserDTO() {
	}
	
	public AqUserDTO(AqUser t,AqOrg o) {
		BeanUtils.copyProperties(t, this);
		this.orgId = o.getOrgId();
		this.orgCode = o.getCode();
		this.orgName = o.getName();
		
	}
	public String getLoginStatus() {
		return loginStatus;
	}





	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}





	public String getStrModule() {
		return strModule;
	}





	public void setStrModule(String strModule) {
		this.strModule = strModule;
	}





	public String getSearchChildren() {
		return searchChildren;
	}




	public void setSearchChildren(String searchChildren) {
		this.searchChildren = searchChildren;
	}




	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIsValid() {
		return isValid;
	}


	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}


	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}


	public String getOrgCode() {
		return orgCode;
	}


	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getOrgPId() {
		return orgPId;
	}


	public void setOrgPId(String orgPId) {
		this.orgPId = orgPId;
	}


	public String getOrgPCode() {
		return orgPCode;
	}


	public void setOrgPCode(String orgPCode) {
		this.orgPCode = orgPCode;
	}


	public String getOrgPName() {
		return orgPName;
	}


	public void setOrgPName(String orgPName) {
		this.orgPName = orgPName;
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


	public String getNewPasswd() {
		return newPasswd;
	}


	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}


	public Date getEffectB() {
		return effectB;
	}


	public void setEffectB(Date effectB) {
		this.effectB = effectB;
	}


	public Date getEffectE() {
		return effectE;
	}


	public void setEffectE(Date effectE) {
		this.effectE = effectE;
	}


	public String getEffect() {
		return effect;
	}


	public void setEffect(String effect) {
		this.effect = effect;
	}

	



}