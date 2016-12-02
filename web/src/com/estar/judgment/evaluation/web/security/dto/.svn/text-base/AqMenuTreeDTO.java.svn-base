package com.estar.judgment.evaluation.web.security.dto;

import org.apache.struts2.json.annotations.JSON;

public class AqMenuTreeDTO {
	private String id;
	private String pId;
	private String name;
	private String url;
	public AqMenuTreeDTO() {
		super();
	}
	
	public AqMenuTreeDTO(String id, String pId, String name, String url) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.url = url;
	}
	
	public AqMenuTreeDTO(String id, String name) {
		super();
		this.id = id;
		this.pId = "";
		this.name = name;
		this.url = "#";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
