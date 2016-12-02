package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_law_item")
public class LawItem implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String lawId;
	private String lawItem;
	
	public LawItem() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "LAW_ID")
	public String getLawId() {
		return lawId;
	}

	public void setLawId(String lawId) {
		this.lawId = lawId;
	}

	@Column(name = "LAW_ITEM")
	public String getLawItem() {
		return lawItem;
	}

	public void setLawItem(String lawItem) {
		this.lawItem = lawItem;
	}

}