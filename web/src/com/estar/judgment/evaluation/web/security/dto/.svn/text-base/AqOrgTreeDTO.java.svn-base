package com.estar.judgment.evaluation.web.security.dto;

import org.apache.struts2.json.annotations.JSON;

import com.estar.judgment.evaluation.web.security.entity.AqOrg;


public class AqOrgTreeDTO {
	private String id;
	private String pId;
	private String name;
	private Boolean isParent = true;
	public AqOrgTreeDTO() {
		super();
	}
	
	public AqOrgTreeDTO(AqOrg t) {
		super();
		String id = t.getOrgId();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < (id.length()-1); i++){
			sb.append("-");
		}
		this.id = t.getOrgId();
		this.name = sb.toString()+t.getName();
	}
	
	public AqOrgTreeDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		if(id.length() > 1){
			this.pId = id.substring(0,id.length()-3);
		}else{
			pId = "";
		}
	}
	
	

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JSON(name="pId")
	public String getPId() {
		return pId;
	}
	public void setPId(String id) {
		pId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
