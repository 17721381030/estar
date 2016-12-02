package com.estar.judgment.evaluation.web.law.dto;

import org.apache.struts2.json.annotations.JSON;

public class ArticleTreeDTO  {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pId;
	private String name;
	private boolean open;
	private String tag;
	
	public ArticleTreeDTO() {
		
	}

	
	public ArticleTreeDTO(String id, String id2, String name, boolean open,String tag) {
		super();
		this.id = id;
		this.pId = id2;
		this.name = name;
		this.open = open;
		this.tag = tag;
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

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	

}